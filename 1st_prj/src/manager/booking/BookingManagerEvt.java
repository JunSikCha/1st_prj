package manager.booking;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

import manager.login.LoginVO;

public class BookingManagerEvt implements ActionListener {
	private BookingManagerTab bmt;
	private LoginVO lVO;

	public BookingManagerEvt(BookingManagerTab bmt, LoginVO lVO) {
		this.bmt = bmt;
		this.lVO = lVO;
		reservationManageDesign();
		reservationManage();
	}

	// 예약 신청관리창 셋팅
	public void reservationManageDesign() {
		bmt.getJlBMName().setText("예약 신청 관리");
		bmt.getJbReservationManage().setVisible(true);
		bmt.getJbAccept().setVisible(true);
		bmt.getJbRefusal().setVisible(true);

		bmt.getJbReservation().setVisible(false);
	}// reservationManageDesign

	// 예약 신청관리창 테이터 입력
	public void reservationManage() {
		BookingManagerDAO bmDAO = BookingManagerDAO.getInstance();

		String strDate = bmt.getJtfStartDate().getText();
		String endDate = bmt.getJtfEndDate().getText();
		List<BookingManagerVO> list = null;

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

		String certerNo = lVO.getCenterNo();
		String isnull = "";

		try {
			list = bmDAO.selectBooking(strDate, endDate, null, certerNo, isnull);

			// JTable의 칼럼이 0개라면 칼럼명 추가
			if (bmt.getJtbOrderInfoTable().getColumnCount() == 0) {
				// JTable 칼럼명 설정
				String[] columnNames = { "예약번호", "예약시간", "모델명", "증상", "아이디", "이름", "수락/거절", "사유", "선택" };
				for (int i = 0; i < columnNames.length; i++) {
					bmt.getDtm().addColumn(columnNames[i]);
				} // end for
			} // end if

			// JTable 데이터 삭제
			bmt.getDtm().setRowCount(0);

			// JTable 행 정보 추가
			String[] arrRow = new String[7];
			for (int i = 0; i < list.size(); i++) {
				BookingManagerVO bmVO = list.get(i);
				arrRow[0] = String.valueOf(bmVO.getBookingNo());
				arrRow[1] = bmVO.getBookingDate();
				arrRow[2] = bmVO.getCarName();
				arrRow[3] = bmVO.getFaultDetail();
				arrRow[4] = bmVO.getClientId();
				arrRow[5] = bmVO.getClientName();
				arrRow[6] = bmVO.getBookingBoolean();
				bmt.getDtm().addRow(arrRow);
			} // end for

			// 열 숨기기
			TableColumnModel columnModel = bmt.getJtbOrderInfoTable().getColumnModel();
			TableColumn column = columnModel.getColumn(7);
			column.setMinWidth(0);
			column.setMaxWidth(0);
			column.setPreferredWidth(0);

			// 열 활성화
			TableColumnModel columnModel1 = bmt.getJtbOrderInfoTable().getColumnModel();
			TableColumn column1 = columnModel1.getColumn(8);
			column1.setMinWidth(100);
			column1.setMaxWidth(100);
			column1.setPreferredWidth(100);

		} catch (SQLException e) {
			e.printStackTrace();
		} // end catch
	}// reservationManage

	// 예약 내역창 셋팅
	public void reservationDesign() {
		bmt.getJlBMName().setText("전체 예약 내역 관리");
		bmt.getJbReservationManage().setVisible(false);
		bmt.getJbAccept().setVisible(false);
		bmt.getJbRefusal().setVisible(false);

		bmt.getJbReservation().setVisible(true);
	}// reservationDesign

	public void reservation() {

		BookingManagerDAO bmDAO = BookingManagerDAO.getInstance();

		String strDate = bmt.getJtfStartDate().getText();
		String endDate = bmt.getJtfEndDate().getText();
		List<BookingManagerVO> list = null;

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

			String certerNo = lVO.getCenterNo();

			list = bmDAO.selectBooking(strDate, endDate, null, certerNo, null);

			// JTable의 칼럼이 0개라면 칼럼명 추가
			if (bmt.getJtbOrderInfoTable().getColumnCount() == 0) {
				// JTable 칼럼명 설정
				String[] columnNames = { "예약번호", "예약시간", "모델명", "증상", "아이디", "이름", "수락/거절", "사유", "사유" };
				for (int i = 0; i < columnNames.length; i++) {
					bmt.getDtm().addColumn(columnNames[i]);
				} // end for
			} // end if

			// JTable 데이터 삭제
			bmt.getDtm().setRowCount(0);

			// JTable 행 정보 추가
			String[] arrRow = new String[8];
			for (int i = 0; i < list.size(); i++) {
				BookingManagerVO bmVO = list.get(i);
				arrRow[0] = String.valueOf(bmVO.getBookingNo());
				arrRow[1] = bmVO.getBookingDate();
				arrRow[2] = bmVO.getCarName();
				arrRow[3] = bmVO.getFaultDetail();
				arrRow[4] = bmVO.getClientId();
				arrRow[5] = bmVO.getClientName();
				arrRow[6] = bmVO.getBookingBoolean();
				arrRow[7] = bmVO.getReasons();

				bmt.getDtm().addRow(arrRow);
			} // end for

			// 열 숨기기
			TableColumnModel columnModel = bmt.getJtbOrderInfoTable().getColumnModel();
			TableColumn column = columnModel.getColumn(8);
			column.setMinWidth(0);
			column.setMaxWidth(0);
			column.setPreferredWidth(0);

			// 열 숨기기
			TableColumnModel columnModel1 = bmt.getJtbOrderInfoTable().getColumnModel();
			TableColumn column1 = columnModel1.getColumn(7);
			column1.setMinWidth(100);
			column1.setMaxWidth(100);
			column1.setPreferredWidth(100);

		} catch (SQLException e) {
			e.printStackTrace();
		} // end catch
	}// reservation

	// DAO에 updateSuccess를 호출
	public void accept() {
		BookingManagerDAO bmDAO = BookingManagerDAO.getInstance();
		int cnt = 0;

		// JTable에서 해당 컬럼의 값 얻기
		JTable table = bmt.getJtbOrderInfoTable();

		List<String> bookingNo = new ArrayList<String>();
		Object obj = " ";

		// 부킹번호추출
		for (int i = 0; i < table.getRowCount(); i++) {
			obj = table.getValueAt(i, 8);
			if (obj != null) {
				bookingNo.add(table.getValueAt(i, 0).toString());
			}
		}

		try {
			cnt = bmDAO.updateAccept(bookingNo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		JOptionPane.showMessageDialog(bmt, cnt + " 건의 예약신청이 수락되었습니다.");
	}

	// DAO에 updateRefusal 을 호출
	public void refusal() {
		BookingManagerDAO bmDAO = BookingManagerDAO.getInstance();

		String reason = JOptionPane.showInputDialog("거절 사유를 입력해 주세요.");
		int cnt = 0;

		// JTable
		JTable table = bmt.getJtbOrderInfoTable();
		List<String> bookingNo = new ArrayList<String>();
		Object obj = " ";

		// 부킹번호추출
		for (int i = 0; i < table.getRowCount(); i++) {
			obj = table.getValueAt(i, 8);
			System.out.println(obj);
			if (obj != null) {
				bookingNo.add(table.getValueAt(i, 0).toString());
				System.out.println(table.getValueAt(i, 0).toString());
			}
		}

		try {
			cnt = bmDAO.updateRefusal(bookingNo, reason);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		JOptionPane.showMessageDialog(bmt, cnt + " 건의 예약신청이 거절되었습니다.");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == bmt.getJbReservation()) {
			reservationManageDesign();
			reservationManage();
		}
		if (e.getSource() == bmt.getJbReservationManage()) {
			reservationDesign();
			reservation();
		}

		// 수락버튼을 눌렸을때.
		if (e.getSource() == bmt.getJbAccept()) {
			accept();
		}
		// 거절버튼을 눌렀을때.
		if (e.getSource() == bmt.getJbRefusal()) {
			refusal();
		}

	}

}
