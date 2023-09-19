package manager.carmanager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

import manager.booking.BookingManagerDAO;
import manager.booking.BookingManagerVO;

public class CarManagerTabEvt implements ActionListener {
	private CarManagerTab cmt;

	public CarManagerTabEvt(CarManagerTab cmt) {
		this.cmt = cmt;
		setCarInfoTable();
		setAddCar();
		
		this.cmt.getJtbCarInfoTable().getColumn("정비번호").setPreferredWidth(80);
		this.cmt.getJtbCarInfoTable().getColumn("차량번호").setPreferredWidth(80);
		this.cmt.getJtbCarInfoTable().getColumn("모델명").setPreferredWidth(100);
		this.cmt.getJtbCarInfoTable().getColumn("수리 내역").setPreferredWidth(200);
		this.cmt.getJtbCarInfoTable().getColumn("입고일").setPreferredWidth(80);
		this.cmt.getJtbCarInfoTable().getColumn("출고일").setPreferredWidth(80);
		this.cmt.getJtbCarInfoTable().getColumn("비고").setPreferredWidth(200);
	}

	public void setCarInfoTable() {
		CarManagerDAO cmDAO = CarManagerDAO.getInstance();

		String strDate = cmt.getJtfStartDate().getText();
		String endDate = cmt.getJtfEndDate().getText();
		List<CarManagerVO> list = null;

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
			list = cmDAO.selectCarInfo(strDate, endDate);

			// JTable의 칼럼이 0개라면 칼럼명 추가
			if (cmt.getJtbCarInfoTable().getColumnCount() == 0) {
				// JTable 칼럼명 설정
				String[] columnNames = { "정비번호", "차량번호", "모델명", "수리 내역", "입고일", "출고일", "비고" };
				for (int i = 0; i < columnNames.length; i++) {
					cmt.getDtmCarInfo().addColumn(columnNames[i]);
				} // end for
			} // end if

			// JTable 데이터 삭제
			cmt.getDtmCarInfo().setRowCount(0);

			// JTable 행 정보 추가
			String[] arrRow = new String[7];
			for (int i = 0; i < list.size(); i++) {
				CarManagerVO cmVO = list.get(i);
				arrRow[0] = String.valueOf(cmVO.getHistoryNo());
				arrRow[1] = cmVO.getCarNo();
				arrRow[2] = cmVO.getCarName();
				arrRow[3] = cmVO.getMaintenanceDetail();
				arrRow[4] = cmVO.getReceivedDay();
				arrRow[5] = cmVO.getReleaseDay();
				arrRow[6] = cmVO.getNote();
				cmt.getDtmCarInfo().addRow(arrRow);
			} // end for


		} catch (SQLException e) {
			e.printStackTrace();
		} // end catch
	}// setCarInfoTable
	
	//입고대기차량 테이블 셋팅
	public void setAddCar() {
		BookingManagerDAO bmDAO = BookingManagerDAO.getInstance();
		List<BookingManagerVO> list = null;
        // 현재 날짜 구하기
        LocalDate today = LocalDate.now();

        // +7일 후의 날짜 계산
        LocalDate plus7Days = today.plusDays(999999);        
        // -7일 후의 날짜 계산
        LocalDate minus7Days = today.minusDays(999999);

        // 날짜를 원하는 형식으로 포맷팅
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String plus7DaysFormatted = plus7Days.format(formatter);
        String minus7DaysFormatted = minus7Days.format(formatter);

		try {
			list = bmDAO.selectBooking("", "", "Y");
			
			// JTable의 칼럼이 0개라면 칼럼명 추가
			if (cmt.getJtbWaitTable().getColumnCount() == 0) {
				// JTable 칼럼명 설정
				String[] columnNames = { "예약번호", "예약시간", "모델명", "증상", "아이디", "이름", "수락/거절","사유","선택" };
				for (int i = 0; i < columnNames.length; i++) {
					cmt.getDtmWait().addColumn(columnNames[i]);
				} // end for
			} // end if

			// JTable 데이터 삭제
			cmt.getDtmWait().setRowCount(0);

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
				cmt.getDtmWait().addRow(arrRow);
			} // end for
			
			 // 특정열 숨기기 
			int[] hideValue = {3,4,6,7,8};
	        TableColumnModel columnModel = cmt.getJtbWaitTable().getColumnModel();
	        for(int i =0;i<hideValue.length;i++) {
		        TableColumn column = columnModel.getColumn(hideValue[i]); 
		        column.setMinWidth(0);
		        column.setMaxWidth(0);
		        column.setPreferredWidth(0);
	        }
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//날짜검색 클릭 이벤트
		if (e.getSource() == cmt.getJbDateSearch()) {
			setCarInfoTable();
		} // end if
		
//		//차량정보 클릭 이벤트
//		if (e.getSource() == cmt.getJbCarInfo()) {
//			String str = "차량정보";
//			// 테이블 미 선택시 예외처리
//			try {
//				new CarManagerSubWindow(cmt, str);
//			}catch (ArrayIndexOutOfBoundsException ae) {
//				JOptionPane.showMessageDialog(null, "조회할 차량을 선택하세요");
//			}//end catch
//		} // end if
		
		//입고 클릭 이벤트
		if (e.getSource() == cmt.getJbCarAdd()) {
			String str = "입고";
			// 테이블 미 선택시 예외처리
			try {
				new CarManagerSubWindow(cmt, str);
			}catch (ArrayIndexOutOfBoundsException ae) {
				JOptionPane.showMessageDialog(null, "조회할 차량을 선택하세요");
			}//end catch
		} // end if
		
		//정보수정 클릭 이벤트
		if (e.getSource() == cmt.getJbCarInfoModify()) {
			String str = "정보수정";
			// 테이블 미 선택시 예외처리
			try {
				new CarManagerSubWindow(cmt, str);
			}catch (ArrayIndexOutOfBoundsException ae) {
				ae.printStackTrace();
				JOptionPane.showMessageDialog(null, "수정할 차량을 선택하세요");
			}//end catch
		} // end if
		
		
		
		
		
		
	}// actionPerformed


} // class