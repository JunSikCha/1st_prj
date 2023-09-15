package manager.carmanager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;
import javax.swing.JTable;

import manager.inventory.InventoryManagerDAO;
import manager.inventory.InventoryManagerVO;
import manager.inventory.PartInfoVO;

public class CarManagerSubWindowEvt implements ActionListener, MouseListener {

	private CarManagerTab cmt;
	private CarManagerSubWindow cmsw;

	private String releaseDay;
	private String mode;

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
			carmodifySet();
//			modifyCarInfo();
		} else {
			addCarSet();
			partInfoConbo();
		} // end else
	}// CarManagerSubWindowEvt

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

				String[] columnNames = { "부품명", "단가", "공임비", "사용량", "소계" };
				for (int i = 0; i < columnNames.length; i++) {
					cmsw.getDtm().addColumn(columnNames[i]);
				} // end for
			} // end if

			// JTable 데이터 삭제
			cmsw.getDtm().setRowCount(0);

			// JTable 행 정보 추가
			// 사용부품 테이블
			String[] arrRow = new String[5];
			for (int i = 0; i < listPiVO.size(); i++) {
				PartInfoVO piVO = listPiVO.get(i);
				arrRow[0] = piVO.getPartName();
				arrRow[1] = String.valueOf(piVO.getPartCost());
				arrRow[2] = String.valueOf(piVO.getLaborCost());
				arrRow[3] = String.valueOf(piVO.getUsedPartQuantity());
				// 소계
				arrRow[4] = String.valueOf((piVO.getPartCost() + piVO.getLaborCost()) * piVO.getUsedPartQuantity());
				cmsw.getDtm().addRow(arrRow);
			} // end for

			int total = 0;
			// 합계 구하는 수식
			for (int i = 0; i < cmsw.getDtm().getRowCount(); i++) {
				total += Integer.parseInt(String.valueOf(cmsw.getDtm().getValueAt(i, 4)));
			} // end if
			cmsw.getJtfTotal().setText(String.valueOf(total));
			cmsw.getJtPartTable().setEditingColumn(3);
		} catch (SQLException e) {
			e.printStackTrace();
		} // end catch

	}// oneCarInfo

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

	// 정보수정 창
	// JTF 읽기전용 메소드
	public void carmodifySet() {
		cmsw.getJtfMaintenencrNo().setEditable(false);
		cmsw.getJtfcarName().setEditable(false);
		cmsw.getJtfPhone().setEditable(false);
		cmsw.getJtfreceiveDay().setEditable(false);
		cmsw.getJtfempName().setEditable(false);

		cmsw.getJtfCarNo().setEditable(false);
		cmsw.getJtfcarName().setEditable(false);
		cmsw.getJtfClientEmail().setEditable(false);
		cmsw.getJtfClientName().setEditable(false);
		// 출고날짜만 수정가능
		cmsw.getJtfReleaseDay().setEditable(true);

		cmsw.getJtfCarmileage().setEditable(false);

		cmsw.getJtfFaultDetail().setEditable(false);
		cmsw.getJtfMaintenanceDetail().setEditable(false);

		cmsw.getJtfNote().setEditable(false);
		cmsw.getJtfTotal().setEditable(false);

		cmsw.getScrollPane().setBounds(50, 260, 580, 100);

	}// carInfoSet

	// 차량추가 창
	public void addCarSet() {
		cmsw.getJbFunction().setText("추가");
		cmsw.getScrollPane().setBounds(50, 260, 580, 100);

		// JTable의 칼럼이 0개라면 칼럼명 추가
		if (cmsw.getJtPartTable().getColumnCount() == 0) {

			String[] columnNames = { "부품명", "단가", "공임비", "사용량", "소계" };
			for (int i = 0; i < columnNames.length; i++) {
				cmsw.getDtm().addColumn(columnNames[i]);
			} // end for
		} // end if
	}// addCarSet

	// 사용부품 콤보박스 메소드
	public void partInfoConbo() {
		InventoryManagerDAO imDAO = InventoryManagerDAO.getInstance();
		List<InventoryManagerVO> VOlist = null;
		try {
			VOlist = imDAO.selectInventoryInfo("");
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < VOlist.size(); i++) {
				sb.append(VOlist.get(i).getPartName()).append("[").append(VOlist.get(i).getPartNo()).append("]");
				cmsw.getModel().addElement(sb.toString());
				sb.setLength(0);
			} // end for

		} catch (SQLException e) {
			e.printStackTrace();
		} // end catch
	}// partInfoConbo

	// 선택된 데이터 테이블에 추가
	public void addBtnPart() {
		// 선택된 데이터 전처리 이름과 SN으로 나누기
		String partInfo = cmsw.getModel().getSelectedItem().toString();
		String partSN = partInfo.substring(partInfo.indexOf("[") + 1, partInfo.indexOf("]"));

		CarManagerDAO cmDAO = CarManagerDAO.getInstance();
		PartInfoVO piVO = null;
		try {
			// 선택된 SN으로 DAO처리후 VO받기
			piVO = cmDAO.selectAddPart(partSN);
			String[] arrRow = new String[5];
			arrRow[0] = piVO.getPartName();
			arrRow[1] = String.valueOf(piVO.getPartCost());
			arrRow[2] = String.valueOf(piVO.getLaborCost());
			arrRow[3] = String.valueOf(piVO.getUsedPartQuantity());
			// 소계
			arrRow[4] = String.valueOf((piVO.getPartCost() + piVO.getLaborCost()) * piVO.getUsedPartQuantity());
			// 받아온 VO로 테이블에 데이터 추가
			cmsw.getDtm().addRow(arrRow);
		} catch (SQLException e) {
			e.printStackTrace();
		} // end catch
	}// addBtnPart

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
		System.out.println(flag);
		// yes 0 no 1 닫기 -1
		if (flag == 0) {
			cmsw.getDtm().removeRow(row);
		} // end if
	}// removeBtnPart

	// 정보수정창 기능메소드
	public void modifyCarInfo() {
		String date = cmsw.getJtfReleaseDay().getText();
		String hno = cmsw.getJtfMaintenencrNo().getText();

		if (date != "null") {
			// "YYYY-MM-DD" 형식의 정규식
			String regex = "\\d{4}-\\d{2}-\\d{2}";

			// 정규식 패턴을 컴파일합니다.
			Pattern pattern = Pattern.compile(regex);

			// 입력 문자열과 패턴을 매칭합니다.
			Matcher strMatcher = pattern.matcher(date);

			if (!strMatcher.matches()) {
				JOptionPane.showMessageDialog(cmsw, "2023-01-01 양식으로 작성해주세요");
				return;
			}//end if

			if (!releaseDay.equals(date)) {
				CarManagerDAO cmDAO = CarManagerDAO.getInstance();
				int cnt = 0;
				try {
					cnt = cmDAO.updateCarInfo(hno, date);
				} catch (SQLException e) {
					e.printStackTrace();
				}finally {
					JOptionPane.showMessageDialog(cmsw, cnt + "건 수정되었습니다.");
				}
				
			} // end if
		}//end if
	}// modifyCarInfo
	
	//차량추가창 메소드
	public void addCarMethod() {
		//차량추가창 에 입력한 테이터를 VO에 넣기
		CarManagerVO cmVO = new CarManagerVO();
		cmVO.setMaintenanceNo(Integer.parseInt(cmsw.getJtfMaintenencrNo().getText()));
		cmVO.setCarName(cmsw.getJtfcarName().getText());
		cmVO.setClientPhone(cmsw.getJtfPhone().getText());
		cmVO.setReceivedDay(cmsw.getJtfreceiveDay().getText());
		cmVO.setEmpName(cmsw.getJtfempName().getText());
		cmVO.setCarNo(cmsw.getJtfCarNo().getText());
		cmVO.setClientName(cmsw.getJtfClientName().getText());
		cmVO.setClientEmail(cmsw.getJtfClientEmail().getText());
		cmVO.setReleaseDay(cmsw.getJtfReleaseDay().getText());
		cmVO.setCarMileage(Integer.parseInt(cmsw.getJtfCarmileage().getText()));
		cmVO.setFaultDetail(cmsw.getJtfFaultDetail().getText());
		cmVO.setMaintenanceDetail(cmsw.getJtfMaintenanceDetail().getText());
		cmVO.setNote(cmsw.getJtfNote().getText());
		System.out.println("----------");
		System.out.println(cmVO);
		System.out.println("----------");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == cmsw.getJbFunction()) {
			if (mode.equals("차량정보")) {
				cmsw.dispose();
			} else if (mode.equals("정보수정")) {
				modifyCarInfo();
			} else {
				addCarMethod();
			}
		} // end if

		// 취소버튼 클릭시 종료
		if (e.getSource() == cmsw.getJbCancle()) {
			cmsw.dispose();
		} // end if

		// 추가 버튼 클릭시 테이블에 부품정보 추가
		if (e.getSource() == cmsw.getJbPartAdd()) {
			addBtnPart();
		} // end if

		// 제거버튼 클릭시 테이블에 선택된 부품정보 제거
		if (e.getSource() == cmsw.getJbPartRemove()) {
			removeBtnPart();
		} // end if
	}// actionPerformed

	@Override
	public void mouseClicked(MouseEvent e) {
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

}