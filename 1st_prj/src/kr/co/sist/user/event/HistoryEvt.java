package kr.co.sist.user.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

import kr.co.sist.user.dao.HistoryDAO;
import kr.co.sist.user.design.DetailHisDesign;
import kr.co.sist.user.design.HistoryDesign;
import kr.co.sist.user.vo.HistoryVO;

public class HistoryEvt extends WindowAdapter implements ActionListener {

	private HistoryDesign hd;

	private LocalDate ldStart = LocalDate.now();
	private LocalDate ldEnd = LocalDate.now();
	private String startDate = ldStart.toString();
	private String endDate = ldEnd.toString();

	public HistoryEvt(HistoryDesign hd) {
		this.hd = hd;

		// 날짜 기본값 세팅
		startDate = ldStart.minusYears(3).toString();
		hd.getJtfStartDate().setText(startDate);
		hd.getJtfEndDate().setText(endDate);

		// 테이블 컬럼명 설정
		if (hd.getJtHistoryDesign().getColumnCount() == 0) {
			String[] col = { "번호", "날짜", "정비내역", "비용", "정비번호" };
			for (int i = 0; i < col.length; i++) {
				hd.getDtmHistoryDesign().addColumn(col[i]);
			} // end for
		} // end if

	}// HistoryEvt

	// 정비 내역 테이블 항목 불러오는 메소드
	public void setHistoryTable() {
		HistoryDAO hDAO = HistoryDAO.getInstance();

		String strDate = hd.getJtfStartDate().getText().toString();
		String endDate = hd.getJtfEndDate().getText().toString();
		List<HistoryVO> hList = null;

		// "YYYY-MM-DD" 형식의 정규식
		String regex = "\\d{4}-\\d{2}-\\d{2}";

		// 정규식 패턴을 컴파일합니다.
		Pattern pattern = Pattern.compile(regex);

		// 입력 문자열과 패턴을 매칭합니다.
		Matcher strMatcher = pattern.matcher(strDate);
		Matcher endMatcher = pattern.matcher(endDate);

		// 정규식 패턴에 일치하지 않으면 ""으로 처리
		if (!strMatcher.matches() || !endMatcher.matches()) {
			strDate = "";
			endDate = "";
		} // end if

		try {
			hList = hDAO.selectHistory(UserData.id, strDate, endDate);

			// JTable 데이터 삭제
			hd.getDtmHistoryDesign().setRowCount(0);

			// JTable 행 정보 추가
			String[] addRow = new String[5];
			for (int i = 0; i < hList.size(); i++) {
				HistoryVO hVO = hList.get(i);
				addRow[0] = String.valueOf(i + 1);
				addRow[1] = hVO.getInbound();
				addRow[2] = hVO.getDetail();
				addRow[3] = String.valueOf(hVO.getPrice());
				addRow[4] = String.valueOf(hVO.getHistoryno());
				hd.getDtmHistoryDesign().addRow(addRow);
			} // end for

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void actionPerformed(ActionEvent ae) {

		// 각 버튼 클릭 이벤트 처리
		if (ae.getSource() == hd.getJbtToday()) { // "오늘" 버튼 클릭 시 처리
			startDate = ldStart.toString();
			hd.getJtfStartDate().setText(startDate);
			hd.getJtfEndDate().setText(endDate);
		}

		if (ae.getSource() == hd.getJbt7days()) { // "7일" 버튼 클릭 시 처리
			startDate = ldStart.minusDays(7).toString();
			endDate = ldStart.toString();
			hd.getJtfStartDate().setText(startDate);
			hd.getJtfEndDate().setText(endDate);
		}

		if (ae.getSource() == hd.getJbt1month()) { // "1개월" 버튼 클릭 시 처리
			startDate = ldStart.minusMonths(1).toString();
			endDate = ldStart.toString();
			hd.getJtfStartDate().setText(startDate);
			hd.getJtfEndDate().setText(endDate);
		}

		if (ae.getSource() == hd.getJbt3month()) { // "3개월" 버튼 클릭 시 처리
			// 예제로 현재 날짜로부터 3개월 후의 날짜를 구해서 JTextField에 설정하는 코드를 추가합니다.
			startDate = ldStart.minusMonths(3).toString();
			endDate = ldStart.toString();
			hd.getJtfStartDate().setText(startDate);
			hd.getJtfEndDate().setText(endDate);
		}
		
		if(ae.getSource() == hd.getJbtDetail()) { //상세보기 버튼
			String str="상세내역";
			try {
			new DetailHisDesign(hd, str);
			}catch(ArrayIndexOutOfBoundsException aie){
				JOptionPane.showMessageDialog(null, "조회할 내역을 선택하세요");
			}//end catch
		}//end if

		// 조회 버튼
		if (ae.getSource() == hd.getJbtChk()) {
			setHistoryTable();
		}

		if (ae.getSource() == hd.getJbtMain()) {
			hd.dispose();
		}

	}

}
