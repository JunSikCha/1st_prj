package kr.co.sist.user.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

import kr.co.sist.user.dao.BookingCheckDAO;
import kr.co.sist.user.design.BookingCheckDesign;
import kr.co.sist.user.vo.BookingCheckVO;

public class BookingCheckEvt implements ActionListener {

	private BookingCheckDesign bcd;

	private LocalDate ldStart = LocalDate.now();
	private LocalDate ldEnd = LocalDate.now();
	private String startDate = ldStart.toString();
	private String endDate = ldEnd.toString();

	// 생성자: 이벤트 핸들러와 연결할 BookingCheckDesign 인스턴스를 받습니다.
	public BookingCheckEvt(BookingCheckDesign bcd) {
		this.bcd = bcd;

		// 날짜 기본값 세팅
		startDate = ldStart.minusYears(3).toString();
		bcd.getJtfStartDate().setText(startDate);
		bcd.getJtfEndDate().setText(endDate);
		
		// JTable의 칼럼이 0개라면 칼럼명을 추가합니다.
		if (bcd.getJtBookingCheckDesign().getColumnCount() == 0) {
			// JTable 칼럼명 설정
			String[] columnNames = { "번호", "예약일자", "예약시", "고장내역", "지점명", "상태", "반려사유" };
			for (int i = 0; i < columnNames.length; i++) {
				bcd.getDtmBookingCheckDesign().addColumn(columnNames[i]);
			}//end for
		}//end if
	}

	// 예약 조회 테이블 설정 메서드
	public void setBookInfoTable() {
		BookingCheckDAO bcDAO = BookingCheckDAO.getInstance();

		// 조회 시작 날짜와 종료 날짜 입력 값 가져오기
		String strDate = bcd.getJtfStartDate().getText().toString();
		String endDate = bcd.getJtfEndDate().getText().toString();
		List<BookingCheckVO> list = null;

		// YYYY-MM-DD 형식 정규식
		String regex = "\\d{4}-\\d{2}-\\d{2}";

		// 정규식 패턴을 컴파일합니다.
		Pattern pattern = Pattern.compile(regex);

		// 입력 문자열과 패턴을 매칭합니다
		Matcher strMatcher = pattern.matcher(strDate);
		Matcher endMatcher = pattern.matcher(endDate);

		// 정규식 패턴에 일치하지 않으면 ""으로 처리
		if (!strMatcher.matches() || !endMatcher.matches()) {
			strDate = "";
			endDate = "";
			JOptionPane.showMessageDialog(bcd, "날짜를 확인하세요");
		}

		try {
			// 예약 정보를 조회합니다.
			list = bcDAO.selectBooking(UserData.id, strDate, endDate);

			// JTable 데이터 삭제
			bcd.getDtmBookingCheckDesign().setRowCount(0);

			// JTable 행 정보 추가
			for (int i = 0; i < list.size(); i++) {
				String[] arrRow = new String[7];
				BookingCheckVO bcVO = list.get(i);
				arrRow[0] = String.valueOf(i+1);
				arrRow[1] = bcVO.getBdate();
				arrRow[2] = bcVO.getBtime();
				arrRow[3] = bcVO.getDetail();
				arrRow[4] = bcVO.getCenter();
				arrRow[5] = bcVO.getStatus();
				arrRow[6] = bcVO.getReason();
				bcd.getDtmBookingCheckDesign().addRow(arrRow);
			}

		} catch (Exception e) {
			e.printStackTrace(); // 예외 처리 추가 (예외를 콘솔에 출력)
		}
	}

	@Override
	public void actionPerformed(ActionEvent ae) {

		// 각 버튼 클릭 이벤트 처리
		if (ae.getSource() == bcd.getJbtToday()) { // "오늘" 버튼 클릭 시 처리
			startDate = ldStart.toString();
			bcd.getJtfStartDate().setText(startDate);
			bcd.getJtfEndDate().setText(endDate);
		}

		if (ae.getSource() == bcd.getJbt7days()) { // "7일" 버튼 클릭 시 처리
			startDate = ldStart.toString();
			endDate = ldStart.plusDays(7).toString();
			bcd.getJtfStartDate().setText(startDate);
			bcd.getJtfEndDate().setText(endDate);
		}

		if (ae.getSource() == bcd.getJbt1month()) { // "1개월" 버튼 클릭 시 처리
			startDate = ldStart.toString();
			endDate = ldStart.plusMonths(1).toString();
			bcd.getJtfStartDate().setText(startDate);
			bcd.getJtfEndDate().setText(endDate);
		}

		if (ae.getSource() == bcd.getJbt3month()) { // "3개월" 버튼 클릭 시 처리
			// 예제로 현재 날짜로부터 3개월 후의 날짜를 구해서 JTextField에 설정하는 코드를 추가합니다.
			startDate = ldStart.toString();
			endDate = ldStart.plusMonths(3).toString();
			bcd.getJtfStartDate().setText(startDate);
			bcd.getJtfEndDate().setText(endDate);
		}

		// "조회" 버튼 클릭 시 처리
		if (ae.getSource() == bcd.getJbtChk()) {
			setBookInfoTable();
		}

		if (ae.getSource() == bcd.getJbtMain()) {
			bcd.dispose();
		}
	}

}