package manager.carmanager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

import manager.MyInformation.MyInformationVO;
import manager.inventory.InventoryManagerDAO;
import manager.inventory.InventoryManagerVO;
import manager.inventory.PartInfoVO;

public class CarManagerSubWindowEvt implements ActionListener, MouseListener {

	private CarManagerTab cmt;
	private CarManagerSubWindow cmsw;

	private String releaseDay;
	private String mode;
	private CarManagerVO cmVO;

	private List<Map<String, Integer>> originList;

	public CarManagerSubWindowEvt(CarManagerTab cmt, CarManagerSubWindow cmsw, String mode) {
		this.cmt = cmt;
		this.cmsw = cmsw;
		this.mode = mode;

		// 눌린 버튼에 따라 subwindow설정변경
		if (mode.equals("차량정보")) {
			setOneCarInfo();
			carInfoSet();
		} else if (mode.equals("정보수정")) {
			setOneCarInfo();
			partInfoConbo();
			modifyBtnValue();
//			originList = partTableOrigin();
//			modifyBtnRenew();
		} else if(mode.equals("입고")){
			addBtnWindow();
			this.cmVO = addBtnValue();
			partInfoConbo();
		} // end else
	}// CarManagerSubWindowEvt
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// 기능버튼 클릭시
		if (e.getSource() == cmsw.getJbFunction()) {
			if (mode.equals("차량정보")) {
				cmsw.dispose();
			} else if (mode.equals("정보수정")) {
				// 출고일 update
				modifyBtnRenew();
				// partTable update
//				partTableChanged();
//				useUpdatePart();
			}else if(mode.equals("입고")) {
				addBtnInput();
			} else {
//				addCarMethod();
			}
		} // end if

		// 취소버튼 클릭시 종료
		if (e.getSource() == cmsw.getJbCancle()) {
			cmsw.dispose();
		} // end if

		// 추가 버튼 클릭시 테이블에 부품정보 추가
		if (e.getSource() == cmsw.getJbPartAdd()) {
			partAddBtnTable();
			partAddABtnDb();
		} // end if

		// 제거버튼 클릭시 테이블에 선택된 부품정보 제거
		if (e.getSource() == cmsw.getJbPartRemove()) {
			removeBtnPart();
		} // end if
	}// actionPerformed

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getClickCount() == 2) {
			partDataModify();
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

	// 차량 세부정보 삽입
	public void setOneCarInfo() {
		CarManagerDAO cmDAO = CarManagerDAO.getInstance();
		CarManagerVO cmVO = new CarManagerVO();
		List<PartInfoVO> listPiVO = new ArrayList<PartInfoVO>();

		// 기존 정보를 변수에 넣기
		int historyno = Integer
				.parseInt(cmt.getJtbCarInfoTable().getValueAt(cmt.getJtbCarInfoTable().getSelectedRow(), 0).toString());
		String carNo = String
				.valueOf(cmt.getJtbCarInfoTable().getValueAt(cmt.getJtbCarInfoTable().getSelectedRow(), 1));
		String carName = String
				.valueOf(cmt.getJtbCarInfoTable().getValueAt(cmt.getJtbCarInfoTable().getSelectedRow(), 2));
		String maintenanceDetail = String
				.valueOf(cmt.getJtbCarInfoTable().getValueAt(cmt.getJtbCarInfoTable().getSelectedRow(), 3));
		String receivedDay = String
				.valueOf(cmt.getJtbCarInfoTable().getValueAt(cmt.getJtbCarInfoTable().getSelectedRow(), 4));
		// 정보 수정시 출고일반 바꿀예정이라 애만 이럼
		releaseDay = String.valueOf(cmt.getJtbCarInfoTable().getValueAt(cmt.getJtbCarInfoTable().getSelectedRow(), 5));
		String note = String.valueOf(cmt.getJtbCarInfoTable().getValueAt(cmt.getJtbCarInfoTable().getSelectedRow(), 6));
		// CarManagerTab의 기존 정보를 변수에 넣어두고 VO에 넣기
		cmVO.setHistoryNo(historyno);
		cmVO.setCarNo(carNo);
		cmVO.setCarName(carName);
		cmVO.setReceivedDay(receivedDay);
		cmVO.setReleaseDay(releaseDay);
		cmVO.setMaintenanceDetail(maintenanceDetail);
		cmVO.setNote(note);

		try {
			// VO를 넣고 필요한 정보를 더 붙여서 받기
			cmVO = cmDAO.selectOneCarInfo(cmVO);
			// 부품 정보 받기
			listPiVO = cmDAO.selectOnePartInfo(historyno);

			// 정보를 입력하기
			cmsw.getJtfMaintenencrNo().setText(String.valueOf(cmVO.getHistoryNo()));
			cmsw.getJtfcarName().setText(cmVO.getCarName());
			cmsw.getJtfCarNo().setText(cmVO.getCarNo());
			cmsw.getJtfPhone().setText(cmVO.getClientPhone());
			cmsw.getJtfreceiveDay().setText(cmVO.getReceivedDay());
			cmsw.getJtfempName().setText(cmVO.getEmpName());
			cmsw.getJtfClientEmail().setText(cmVO.getClientEmail());
			cmsw.getJtfReleaseDay().setText(cmVO.getReleaseDay());
			cmsw.getJtfCarmileage().setText(String.valueOf(cmVO.getCarMileage()));
			cmsw.getJtfFaultDetail().setText(cmVO.getFaultDetail());
			cmsw.getJtfMaintenanceDetail().setText(cmVO.getMaintenanceDetail());
			cmsw.getJtfNote().setText(cmVO.getNote());
			cmsw.getJtfClientName().setText(cmVO.getClientName());

			// JTable의 칼럼이 0개라면 칼럼명 추가
			if (cmsw.getJtPartTable().getColumnCount() == 0) {

				String[] columnNames = { "SN", "부품명", "단가", "공임비", "사용량", "소계" };
				for (int i = 0; i < columnNames.length; i++) {
					cmsw.getDtm().addColumn(columnNames[i]);
				} // end for
			} // end if

			// JTable 데이터 삭제
			cmsw.getDtm().setRowCount(0);

			// JTable 행 정보 추가
			// 사용부품 테이블
			String[] arrRow = new String[6];
			for (int i = 0; i < listPiVO.size(); i++) {
				PartInfoVO piVO = listPiVO.get(i);
				arrRow[0] = piVO.getPartNo();
				arrRow[1] = piVO.getPartName();
				arrRow[2] = String.valueOf(piVO.getPartCost());
				arrRow[3] = String.valueOf(piVO.getLaborCost());
				arrRow[4] = String.valueOf(piVO.getUsedPartQuantity());
				// 소계
				arrRow[5] = String.valueOf((piVO.getPartCost() + piVO.getLaborCost()) * piVO.getUsedPartQuantity());
				cmsw.getDtm().addRow(arrRow);
			} // end for

			int total = 0;
			// 합계 구하는 수식
			for (int i = 0; i < cmsw.getDtm().getRowCount(); i++) {
				total += Integer.parseInt(String.valueOf(cmsw.getDtm().getValueAt(i, 5)));
			} // end if
			cmsw.getJtfTotal().setText(String.valueOf(total));
			// 열 숨기기
			TableColumnModel columnModel = cmsw.getJtPartTable().getColumnModel();
			TableColumn column = columnModel.getColumn(0);
			column.setMinWidth(0);
			column.setMaxWidth(0);
			column.setPreferredWidth(0);
			// partTable 수량만 수정가능하게
//	        cmsw.getJtPartTable().setEditingColumn(3);
		} catch (SQLException e) {
			e.printStackTrace();
		} // end catch

	}// setOneCarInfo

	// 차량정보 창 설정
	// JTF 읽기전용 메소드
	public void carInfoSet() {

		cmsw.getJbFunction().setText("확인");

		cmsw.getJtfMaintenencrNo().setEditable(false);
		cmsw.getJtfcarName().setEditable(false);
		cmsw.getJtfPhone().setEditable(false);
		cmsw.getJtfreceiveDay().setEditable(false);
		cmsw.getJtfempName().setEditable(false);

		cmsw.getJtfCarNo().setEditable(false);
		cmsw.getJtfcarName().setEditable(false);
		cmsw.getJtfClientEmail().setEditable(false);
		cmsw.getJtfClientName().setEditable(false);
		cmsw.getJtfReleaseDay().setEditable(false);
		cmsw.getJtfCarmileage().setEditable(false);

		cmsw.getJtfFaultDetail().setEditable(false);
		cmsw.getJtfMaintenanceDetail().setEditable(false);

		cmsw.getJtfNote().setEditable(false);
		cmsw.getJtfTotal().setEditable(false);

		cmsw.getJtfPartName().setVisible(false);
		cmsw.getJbPartAdd().setVisible(false);

		cmsw.getScrollPane().setBounds(50, 260, 580, 160);
//		cmsw.getScrollPane().setVisible(false);
//		cmsw.getJtPartTable().setVisible(false);
	}// carInfoSet



	
	//////////////////////////////////////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////////////////////////////////
	// 입고 창 셋팅
	public void addBtnWindow() {
		cmsw.getJbFunction().setText("입고");
		cmsw.getJtfempName().setVisible(false);
		cmsw.getJtfEmpName().setBounds(195, 170, 145, 30);
		partTableSet();
	}//addBtnWindow



	// 차량추가 창 값 셋팅
	public CarManagerVO addBtnValue() {
		int max = 0;
		CarManagerDAO cmDAO = CarManagerDAO.getInstance();
		CarManagerVO cmVO = null;
		try {
			// 정비번호 구하기 정비번호는 1씩증가하는 방식으로 하자
			max = cmDAO.selectHistoryNoMAX();
			JTable table = cmt.getJtbWaitTable();

			int bookingNo = Integer.parseInt(table.getValueAt(table.getSelectedRow(), 0).toString());
			String carName = table.getValueAt(table.getSelectedRow(), 2).toString();
			String issue = table.getValueAt(table.getSelectedRow(), 3).toString();
			String userID = table.getValueAt(table.getSelectedRow(), 4).toString();
			String userName = table.getValueAt(table.getSelectedRow(), 5).toString();

			cmVO = cmDAO.selectUserInfo(userID);
			cmVO.setBookingNo(bookingNo);
			cmVO.setCarName(carName);
			cmVO.setMaintenanceNo(max + 1);
			cmVO.setFaultDetail(issue);
			cmVO.setClientName(userName);

			//입고일은 오늘날짜 입력
			LocalDate today = LocalDate.now();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			String todayFormatted = today.format(formatter);
			cmVO.setReceivedDay(todayFormatted);
			
			cmsw.getJtfMaintenencrNo().setText(String.valueOf(cmVO.getMaintenanceNo()));
			cmsw.getJtfCarmileage().setText(String.valueOf(cmVO.getCarMileage()));
			cmsw.getJtfcarName().setText(cmVO.getCarName());
			cmsw.getJtfCarNo().setText(cmVO.getCarNo());
			cmsw.getJtfClientEmail().setText(cmVO.getClientEmail());
			cmsw.getJtfClientName().setText(cmVO.getClientName());
			cmsw.getJtfFaultDetail().setText(cmVO.getFaultDetail());
			cmsw.getJtfPhone().setText(cmVO.getClientPhone());
			cmsw.getJtfreceiveDay().setText(todayFormatted);

			// emp 콤보박스 설정
			List<MyInformationVO> list = cmDAO.selectEmpInfo();
			StringBuilder emp = new StringBuilder();
			for (int i = 0; i < list.size(); i++) {
				emp.append(list.get(i).getEmpName()).append("[").append(list.get(i).getEmpNo()).append("]");
				cmsw.getEmpModel().addElement(emp.toString());
				emp.setLength(0);
			}//end for

		} catch (SQLException e) {
			e.printStackTrace();
		}//end catch
		return cmVO;

	}// addCarSet
	
	//입고버튼 누르면 history테이블에 정보 입력
	public void addBtnInput() {
		String empName = cmsw.getJtfEmpName().getSelectedItem().toString();
		cmVO.setEmpName(empName.substring(0,empName.indexOf("[")));
		cmVO.setEmpNo(Integer.parseInt(empName.substring(empName.indexOf("[")+1,empName.indexOf("]"))));

		CarManagerDAO cmDAO = CarManagerDAO.getInstance();
		try {
			int flag = JOptionPane.showConfirmDialog(cmsw, "차량번호 [" + cmVO.getCarNo() + "] 를 입고처리 하시겠습니까?");
			if(flag==0) {
				cmDAO.insertHistory(cmVO);
				cmsw.dispose();
			}else {
				JOptionPane.showMessageDialog(cmsw, "취소했습니다");
			}//end else
		} catch (SQLException e) {
			e.printStackTrace();
		}//end catch
	}//addBtnInput
	//////////////////////////////////////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////////////////////////////////

	// 정보수정 창
	public void modifyBtnValue() {
		//점검내용, 비고 수정가능하게 변경
		cmsw.getJtfMaintenanceDetail().setEditable(true);
		cmsw.getJtfNote().setEditable(true);
	}// carInfoSet
	
	// 정보수정창 기능메소드
	public void modifyBtnRenew() {
		int cnt = 0;
		String hno = cmsw.getJtfMaintenencrNo().getText();
		String maintenanceDetail = cmsw.getJtfMaintenanceDetail().getText();
		String note = cmsw.getJtfNote().getText();
		
		CarManagerDAO cmDAO = CarManagerDAO.getInstance();
		
		try {
			
			cnt = cmDAO.updateInfoModify(hno, maintenanceDetail, note);
			if(cnt == 1) {
				JOptionPane.showMessageDialog(cmsw, "수정되었습니다.");
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		

//		if (date != "null") {
//			// "YYYY-MM-DD" 형식의 정규식
//			String regex = "\\d{4}-\\d{2}-\\d{2}";
//
//			// 정규식 패턴을 컴파일합니다.
//			Pattern pattern = Pattern.compile(regex);
//
//			// 입력 문자열과 패턴을 매칭합니다.
//			Matcher strMatcher = pattern.matcher(date);
//
//			if (!strMatcher.matches()) {
//				JOptionPane.showMessageDialog(cmsw, "2023-01-01 양식으로 작성해주세요");
//				return;
//			} // end if
//
//			if (!releaseDay.equals(date)) {
//				CarManagerDAO cmDAO = CarManagerDAO.getInstance();
//				int cnt = 0;
//				try {
//					cnt = cmDAO.updateCarInfo(hno, date);
//				} catch (SQLException e) {
//					e.printStackTrace();
//				} finally {
//					JOptionPane.showMessageDialog(cmsw, cnt + "건 수정되었습니다.");
//				}
//			} // end if
//		} // end if
	}// modifyBtnRenew
//	public void modifyBtnValue() {
//		//점검내용, 비고 수정가능하게 변경
//		cmsw.getJtfReleaseDay().setEditable(true);
//		
//		//출고일은 오늘날짜로 기본입력
//		LocalDate today = LocalDate.now();
//		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//		String todayFormatted = today.format(formatter);
//		cmsw.getJtfReleaseDay().setText(todayFormatted);
//	}// carInfoSet
//	// 정보수정창 기능메소드
//	public void modifyBtnRenew() {
//		String date = cmsw.getJtfReleaseDay().getText();
//		String hno = cmsw.getJtfMaintenencrNo().getText();
//		
//		if (date != "null") {
//			// "YYYY-MM-DD" 형식의 정규식
//			String regex = "\\d{4}-\\d{2}-\\d{2}";
//			
//			// 정규식 패턴을 컴파일합니다.
//			Pattern pattern = Pattern.compile(regex);
//			
//			// 입력 문자열과 패턴을 매칭합니다.
//			Matcher strMatcher = pattern.matcher(date);
//			
//			if (!strMatcher.matches()) {
//				JOptionPane.showMessageDialog(cmsw, "2023-01-01 양식으로 작성해주세요");
//				return;
//			} // end if
//			
//			if (!releaseDay.equals(date)) {
//				CarManagerDAO cmDAO = CarManagerDAO.getInstance();
//				int cnt = 0;
//				try {
//					cnt = cmDAO.updateCarInfo(hno, date);
//				} catch (SQLException e) {
//					e.printStackTrace();
//				} finally {
//					JOptionPane.showMessageDialog(cmsw, cnt + "건 수정되었습니다.");
//				}
//			} // end if
//		} // end if
//	}// modifyBtnRenew
	//////////////////////////////////////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////////////////////////////////
	
	// 사용부품 콤보박스 메소드
	public void partInfoConbo() {
		InventoryManagerDAO imDAO = InventoryManagerDAO.getInstance();
		List<InventoryManagerVO> VOlist = null;
		try {
			VOlist = imDAO.selectInventoryInfo("");
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < VOlist.size(); i++) {
				sb.append(VOlist.get(i).getPartName()).append(" [").append(VOlist.get(i).getPartNo()).append("]");
				cmsw.getPartModel().addElement(sb.toString());
				sb.setLength(0);
			} // end for
		} catch (SQLException e) {
			e.printStackTrace();
		} // end catch
	}// partInfoConbo

	// 선택된 데이터 테이블에 추가 및 데이터 조회후 테이블에 입력
	public void partAddBtnTable() {
		// 선택된 데이터 전처리 이름과 SN으로 나누기
		String partInfo = cmsw.getPartModel().getSelectedItem().toString();
		String partSN = partInfo.substring(partInfo.indexOf("[") + 1, partInfo.indexOf("]"));

		CarManagerDAO cmDAO = CarManagerDAO.getInstance();
		PartInfoVO piVO = null;
		try {
			// 선택된 SN으로 DAO처리후 VO받기
			piVO = cmDAO.selectAddPart(partSN);
			String[] arrRow = new String[6];
			arrRow[0] = piVO.getPartNo();
			arrRow[1] = piVO.getPartName();
			arrRow[2] = String.valueOf(piVO.getPartCost());
			arrRow[3] = String.valueOf(piVO.getLaborCost());
			//부품추가시 기본수량 1
			arrRow[4] = String.valueOf(1);
			// 소계
			arrRow[5] = String.valueOf((piVO.getPartCost() + piVO.getLaborCost()) * Integer.parseInt(arrRow[4]));
			// 받아온 VO로 테이블에 데이터 추가
			cmsw.getDtm().addRow(arrRow);
		} catch (SQLException e) {
			e.printStackTrace();
		} // end catch
	}// addBtnPart
	
	public void partAddABtnDb() {
		
	}

	// 테이블에 선택된 정보 제거
	public void removeBtnPart() {
		// 테이블 객체 가져오기
		JTable jTable = cmsw.getJtPartTable();
		// 선택된 row가져오기
		int row = jTable.getSelectedRow();
		// 선택된 부품이름 가져오기
		String partName = jTable.getValueAt(row, 0).toString();
		// 제거 여부 물어보기
		int flag = JOptionPane.showConfirmDialog(null, partName + "를 제거하겠습니까?", "확인", JOptionPane.YES_NO_OPTION);
		// yes 0 no 1 닫기 -1
		if (flag == 0) {
			cmsw.getDtm().removeRow(row);
			CarManagerDAO cmDAO = CarManagerDAO.getInstance();
			String sn = String.valueOf(jTable.getValueAt(row, 0));
			String historyNo = cmsw.getJtfMaintenencrNo().getText();
			try {
				int cnt = cmDAO.deletePartTable(sn, historyNo);
				if (cnt > 0) {
					JOptionPane.showMessageDialog(cmsw, partName + "를 제거했습니다.");
				} else {
					JOptionPane.showMessageDialog(cmsw, partName + "을 제거하지 못했습니다.\n 다시 확인해주세요.");
				} // end else
			} catch (SQLException e) {
				e.printStackTrace();
			} // end catch

		} // end if
	}// removeBtnPart


	// partTable 수량 변경 메소드
	public void partDataModify() {
		JTable table = cmsw.getJtPartTable();
		int row = table.getSelectedRow();
		String value = String.valueOf(table.getValueAt(row, 4));
		String sn = String.valueOf(table.getValueAt(row, 0));
		String historyNo = cmsw.getJtfMaintenencrNo().getText();

		String ChangedValue = JOptionPane.showInputDialog(cmsw, "변경할 수량을 입력하세요", value);
		if (ChangedValue != null) {
			table.setValueAt(ChangedValue, row, 4);
			CarManagerDAO cmDAO = CarManagerDAO.getInstance();
			try {
				int cnt = cmDAO.updataPartInfo(ChangedValue, sn, historyNo);
				if (cnt > 0) {
					JOptionPane.showMessageDialog(cmsw, ChangedValue + "개로 변경하였습니다.");
				} else {
					JOptionPane.showMessageDialog(cmsw, "변경에 실패하였습니다.\n 입력값을 확인해주세요.");
				} // end else
			} catch (SQLException e) {
				e.printStackTrace();
			} // catch
		} // end if
	}// partDataModify

	public void partDataRemove() {
		JTable table = cmsw.getJtPartTable();
		int row = table.getSelectedRow();
	}// remove



	// 차량추가창 메소드
//	public void addCarMethod() {
//		// 차량추가창 에 입력한 테이터를 VO에 넣기
//		CarManagerVO cmVO = new CarManagerVO();
//		cmVO.setMaintenanceNo(Integer.parseInt(cmsw.getJtfMaintenencrNo().getText()));
//		cmVO.setCarName(cmsw.getJtfcarName().getText());
//		cmVO.setClientPhone(cmsw.getJtfPhone().getText());
//		cmVO.setReceivedDay(cmsw.getJtfreceiveDay().getText());
//		cmVO.setEmpName(cmsw.getJtfempName().getText());
//		cmVO.setCarNo(cmsw.getJtfCarNo().getText());
//		cmVO.setClientName(cmsw.getJtfClientName().getText());
//		cmVO.setClientEmail(cmsw.getJtfClientEmail().getText());
//		cmVO.setReleaseDay(cmsw.getJtfReleaseDay().getText());
//		cmVO.setCarMileage(Integer.parseInt(cmsw.getJtfCarmileage().getText()));
//		cmVO.setFaultDetail(cmsw.getJtfFaultDetail().getText());
//		cmVO.setMaintenanceDetail(cmsw.getJtfMaintenanceDetail().getText());
//		cmVO.setNote(cmsw.getJtfNote().getText());
//		System.out.println("----------");
//		System.out.println(cmVO);
//		System.out.println("----------");
//	}
	
	// 파트테이블 칼럼명 셋팅
	public void partTableSet() {
		// JTable의 칼럼이 0개라면 칼럼명 추가
		if (cmsw.getJtPartTable().getColumnCount() == 0) {
			String[] partColumnNames = { "부품명", "단가", "공임비", "사용량", "소계" };
			for (int i = 0; i < partColumnNames.length; i++) {
				cmsw.getDtm().addColumn(partColumnNames[i]);
			} // end for
		} // end if
	}//partTableSet



}