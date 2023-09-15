package manager.booking;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

public class BookingManagerEvt implements ActionListener {
	private BookingManagerTab bmt;
	
	public BookingManagerEvt(BookingManagerTab bmt) {
		this.bmt=bmt;
		reservationManageDesign();
		reservationManage();
	}
	//예약 신청관리창 셋팅
	public void reservationManageDesign() {
		bmt.getJbReservationManage().setVisible(true);
		bmt.getJbAccept().setVisible(true);
		bmt.getJbRefusal().setVisible(true);
		
		bmt.getJbReservation().setVisible(false);
		bmt.getJbSave().setVisible(false);
	}
	//예약 신청관리창 테이터 입력
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

		try {
			list = bmDAO.selectBooking(strDate, endDate);

			// JTable의 칼럼이 0개라면 칼럼명 추가
			if (bmt.getJtbOrderInfoTable().getColumnCount() == 0) {
				// JTable 칼럼명 설정
				String[] columnNames = { "예약번호", "예약시간", "모델명", "증상", "아이디", "이름", "수락/거절","사유","선택" };
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
	}//reservationManage
	
	//예약 사항창 셋팅
	public void reservationDesign() {
		bmt.getJbReservationManage().setVisible(false);
		bmt.getJbAccept().setVisible(false);
		bmt.getJbRefusal().setVisible(false);
		
		bmt.getJbReservation().setVisible(true);
		bmt.getJbSave().setVisible(true);
	}
	
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
			list = bmDAO.selectBooking(strDate, endDate);

			// JTable의 칼럼이 0개라면 칼럼명 추가
			if (bmt.getJtbOrderInfoTable().getColumnCount() == 0) {
				// JTable 칼럼명 설정
				String[] columnNames = { "예약번호", "예약시간", "모델명", "증상", "아이디", "이름", "수락/거절","사유","사유" };
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
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==bmt.getJbReservation()) {
			reservationManageDesign();
			reservationManage();
		}
		if(e.getSource()==bmt.getJbReservationManage()) {
			reservationDesign();
			reservation();
		}
	}

}
