package manager.carmanager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

import manager.booking.BookingManagerDAO;
import manager.booking.BookingManagerVO;
import manager.login.LoginVO;

public class CarManagerTabEvt implements ActionListener {
	private CarManagerTab cmt;
	private LoginVO lVO;

	public CarManagerTabEvt(CarManagerTab cmt, LoginVO lVO) {
		this.cmt = cmt;
		this.lVO = lVO;
		setCarInfoTable();
		setAddTable();
		setOutTable();
		this.cmt.getJtbCarInfoTable().getColumn("정비번호").setPreferredWidth(80);
		this.cmt.getJtbCarInfoTable().getColumn("차량번호").setPreferredWidth(80);
		this.cmt.getJtbCarInfoTable().getColumn("모델명").setPreferredWidth(100);
		this.cmt.getJtbCarInfoTable().getColumn("수리 내역").setPreferredWidth(200);
		this.cmt.getJtbCarInfoTable().getColumn("입고일").setPreferredWidth(80);
		this.cmt.getJtbCarInfoTable().getColumn("출고일").setPreferredWidth(80);
		this.cmt.getJtbCarInfoTable().getColumn("비고").setPreferredWidth(200);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		// 입고 클릭 이벤트
		if (e.getSource() == cmt.getJbCarAdd()) {
			String str = "입고";
			// 테이블 미 선택시 예외처리
			try {
				new CarManagerSubWindow(cmt, str,lVO);
			} catch (ArrayIndexOutOfBoundsException ae) {
				JOptionPane.showMessageDialog(null, "입고할 차량을 선택하세요");
			} // end catch
		} // end if

		// 정보수정 클릭 이벤트
		if (e.getSource() == cmt.getJbCarInfoModify()) {
			String str = "정보수정";
			// 테이블 미 선택시 예외처리
			try {
				new CarManagerSubWindow(cmt, str,lVO);
			} catch (ArrayIndexOutOfBoundsException ae) {
				JOptionPane.showMessageDialog(null, "수정할 차량을 선택하세요");
			} // end catch
		} // end if

		// 출고버튼 클릭 이벤트
		if (e.getSource() == cmt.getJbCarOut()) {
			String str = "출고";
			try {
				new CarManagerSubWindow(cmt, str,lVO);
			} catch (ArrayIndexOutOfBoundsException ae) {
				ae.getStackTrace();
				JOptionPane.showMessageDialog(null, "출고할 차량을 선택하세요");
			} // end catch
		}

		// 수리완료 클릭 이벤트
		if (e.getSource() == cmt.getJbCarRepairEnd()) {
			try {
			repairComplete();
			setCarInfoTable();
			setOutTable();
			
			} catch (ArrayIndexOutOfBoundsException ae) {
				JOptionPane.showMessageDialog(null, "수리완료할 차량을 선택하세요");
			} // end catch
		} // end if
	}// actionPerformed

	// 입고차량 테이블 셋팅
	public void setCarInfoTable() {
		CarManagerDAO cmDAO = CarManagerDAO.getInstance();

		List<CarManagerVO> list = null;

		String centerNo = lVO.getCenterNo();

		try {
			list = cmDAO.selectCarInfo(centerNo, "y");

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

	// 대기차량 테이블 셋팅
	public void setAddTable() {
		BookingManagerDAO bmDAO = BookingManagerDAO.getInstance();
		List<BookingManagerVO> list = null;
		// 현재 날짜 구하기
//		LocalDate today = LocalDate.now();

//		// +7일 후의 날짜 계산
//		LocalDate plus7Days = today.plusDays(999999);
//		// -7일 후의 날짜 계산
//		LocalDate minus7Days = today.minusDays(999999);
//
//		// 날짜를 원하는 형식으로 포맷팅
//		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//		String plus7DaysFormatted = plus7Days.format(formatter);
//		String minus7DaysFormatted = minus7Days.format(formatter);

		String certerNo = lVO.getCenterNo();

		try {
			list = bmDAO.selectBooking("", "", "Y", certerNo,null);

			// JTable의 칼럼이 0개라면 칼럼명 추가
			if (cmt.getJtbWaitTable().getColumnCount() == 0) {
				// JTable 칼럼명 설정
				String[] columnNames = { "예약번호", "예약시간", "모델명", "증상", "아이디", "이름", "수락/거절", "사유", "선택" };
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
			int[] hideValue = { 3, 4, 6, 7, 8 };
			TableColumnModel columnModel = cmt.getJtbWaitTable().getColumnModel();
			for (int i = 0; i < hideValue.length; i++) {
				TableColumn column = columnModel.getColumn(hideValue[i]);
				column.setMinWidth(0);
				column.setMaxWidth(0);
				column.setPreferredWidth(0);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// 출차 대기차량 테이블
	public void setOutTable() {
		CarManagerDAO cmDAO = CarManagerDAO.getInstance();

		List<CarManagerVO> list = null;

		String certerNo = lVO.getCenterNo();
		try {
			list = cmDAO.selectCarInfo(certerNo, "n");

			// JTable의 칼럼이 0개라면 칼럼명 추가
			if (cmt.getJtbOutputTable().getColumnCount() == 0) {
				// JTable 칼럼명 설정
				String[] columnNames = { "정비번호", "차량번호", "모델명", "이름" };
				for (int i = 0; i < columnNames.length; i++) {
					cmt.getDtmOutput().addColumn(columnNames[i]);
				} // end for
			} // end if

			// JTable 데이터 삭제
			cmt.getDtmOutput().setRowCount(0);

			// JTable 행 정보 추가
			String[] arrRow = new String[4];
			for (int i = 0; i < list.size(); i++) {
				CarManagerVO cmVO = list.get(i);
				arrRow[0] = String.valueOf(cmVO.getHistoryNo());
				arrRow[1] = cmVO.getCarNo();
				arrRow[2] = cmVO.getCarName();
				arrRow[3] = cmVO.getClientName();
				cmt.getDtmOutput().addRow(arrRow);
			} // end for

		} catch (SQLException e) {
			e.printStackTrace();
		} // end catch
	}

	// 수리완료버튼
	public void repairComplete() {
		int row = cmt.getJtbCarInfoTable().getSelectedRow();
		int flag = JOptionPane.showConfirmDialog(cmt,
				"차량번호 [" + cmt.getJtbCarInfoTable().getValueAt(row, 1) + "] 를 수리완료 처리하시겠습니까?");
		if (flag == 0) {
			CarManagerDAO cmDAO = CarManagerDAO.getInstance();
			try {
				cmDAO.updateCarStatus(cmt.getJtbCarInfoTable().getValueAt(row, 0).toString());
			} catch (SQLException e) {
				e.printStackTrace();
			} // end catch
			JOptionPane.showMessageDialog(cmt, "수리완료 처리를 했습니다.");
			setOutTable();
			setCarInfoTable();
		} // end if
	}// repairComplete

} // class