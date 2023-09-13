package manager.carmanager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import manager.inventory.InventoryManagerDAO;
import manager.inventory.InventoryManagerVO;
import manager.inventory.PartInfoVO;

public class CarManagerSubWindowEvt implements ActionListener, MouseListener {
	
	private CarManagerTab cmt;
	private CarManagerSubWindow cmsw;
	
	private String releaseDay;
	
	public CarManagerSubWindowEvt(CarManagerTab cmt,CarManagerSubWindow cmsw,String str ) {
		this.cmt = cmt;
		this.cmsw = cmsw;
		
		//눌린 버튼에 따라 subwindow설정변경
		if(str.equals("차량정보")) {
			this.cmsw.getJbFunction().setName("확인");
			setOneCarInfo();
			textFieldEditable(str);
		}else if (str.equals("정보수정")) {
			setOneCarInfo();
			textFieldEditable(str);
			partInfo();
			modifyCarInfo();
		}else {
			addCarInfo();
		}//end else
	}//CarManagerSubWindowEvt
	
	
	public void setOneCarInfo() {
		CarManagerDAO cmDAO = CarManagerDAO.getInstance();
		CarManagerVO cmVO = new CarManagerVO();
		List<PartInfoVO> listPiVO = new ArrayList<PartInfoVO>();
		
		//기존 정보를 변수에 넣기
		int historyno = Integer.parseInt(cmt.getJtbCarInfoTable().getValueAt(cmt.getJtbCarInfoTable().getSelectedRow(),0).toString());
		String carNo = String.valueOf(cmt.getJtbCarInfoTable().getValueAt(cmt.getJtbCarInfoTable().getSelectedRow(),1));
		String carName = String.valueOf(cmt.getJtbCarInfoTable().getValueAt(cmt.getJtbCarInfoTable().getSelectedRow(),2));
		String maintenanceDetail = String.valueOf(cmt.getJtbCarInfoTable().getValueAt(cmt.getJtbCarInfoTable().getSelectedRow(),3));
		String receivedDay = String.valueOf(cmt.getJtbCarInfoTable().getValueAt(cmt.getJtbCarInfoTable().getSelectedRow(),4));
		//정보 수정시 출고일반 바꿀예정이라 애만 이럼
		releaseDay = String.valueOf(cmt.getJtbCarInfoTable().getValueAt(cmt.getJtbCarInfoTable().getSelectedRow(),5));
		String note = String.valueOf(cmt.getJtbCarInfoTable().getValueAt(cmt.getJtbCarInfoTable().getSelectedRow(),6));
		//CarManagerTab의 기존 정보를 변수에 넣어두고 VO에 넣기
		cmVO.setHistoryNo(historyno);
		cmVO.setCarNo(carNo);
		cmVO.setCarName(carName);
		cmVO.setReceivedDay(receivedDay);
		cmVO.setReleaseDay(releaseDay);
		cmVO.setMaintenanceDetail(maintenanceDetail);
		cmVO.setNote(note);
		
		
		try {
			//VO를 넣고 필요한 정보를 더 붙여서 받기
			cmVO = cmDAO.selectOneCarInfo(cmVO);
			//부품 정보 받기
			listPiVO = cmDAO.selectOnePartInfo(historyno);
			
			//정보를 입력하기
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
			
			//JTable의 칼럼이 0개라면 칼럼명 추가
			if(cmsw.getJtPartTable().getColumnCount()==0) {

			String[] columnNames = {"부품명","단가", "공임비", "사용량", "소계"};
				for(int i=0;i<columnNames.length;i++) {
					cmsw.getDtm().addColumn(columnNames[i]);
				}//end for
			}//end if
			
			//JTable 데이터 삭제
			cmsw.getDtm().setRowCount(0);
			
			// JTable 행 정보 추가
			// 사용부품 테이블
			String[] arrRow = new String[7];
			for(int i=0;i<listPiVO.size();i++) {
				PartInfoVO piVO = listPiVO.get(i);
				arrRow[0] = piVO.getPartName();
				arrRow[1] = String.valueOf(piVO.getPartCost());
				arrRow[2] = String.valueOf(piVO.getLaborCost());
				arrRow[3] = String.valueOf(piVO.getUsedPartQuantity());
				// 소계
				arrRow[4] = String.valueOf((piVO.getPartCost()+piVO.getLaborCost())*piVO.getUsedPartQuantity());
				cmsw.getDtm().addRow(arrRow);
			}//end for
			
			int total = 0;
			// 합계 구하는 수식
			for(int i =0; i< cmsw.getDtm().getRowCount();i++) {
			total += Integer.parseInt(String.valueOf(cmsw.getDtm().getValueAt(i, 4)));
			}//end if
			cmsw.getJtfTotal().setText(String.valueOf(total));
			
		} catch (SQLException e) {
			e.printStackTrace();
		}//end catch
		
	}//oneCarInfo
	
	//JTF 읽기전용 메소드
	public void textFieldEditable(String str) {
		cmsw.getJtfMaintenencrNo().setEditable(false);
		cmsw.getJtfcarName().setEditable(false);
		cmsw.getJtfPhone().setEditable(false);
		cmsw.getJtfreceiveDay().setEditable(false);
		cmsw.getJtfempName().setEditable(false);
		
		
		cmsw.getJtfCarNo().setEditable(false);
		cmsw.getJtfcarName().setEditable(false);
		cmsw.getJtfClientEmail().setEditable(false);
		cmsw.getJtfClientName().setEditable(false);
		//차량정보 버튼이면 읽기전용, 정보수정칸이면 쓰기가능으로 변환
		if(str.equals("차량정보")) {
			cmsw.getJtfReleaseDay().setEditable(false);
		}else {
			cmsw.getJtfReleaseDay().setEditable(true);
			
		}//end else
		cmsw.getJtfCarmileage().setEditable(false);
		
		
		cmsw.getJtfFaultDetail().setEditable(false);
		cmsw.getJtfMaintenanceDetail().setEditable(false);
		
		
		cmsw.getJtfNote().setEditable(false);
		cmsw.getJtfTotal().setEditable(false);
	}//textFieldEditable
	
	//사용부품 추가 메소드
	public void partInfo() {
		InventoryManagerDAO imDAO = InventoryManagerDAO.getInstance();
		List<InventoryManagerVO> VOlist = null;
		List<String> strList = new ArrayList<String>();
		try {
			VOlist = imDAO.selectInventoryInfo("");
			StringBuilder sb = new StringBuilder();
			for(int i=0;i<VOlist.size();i++) {
//				strList.add(VOlist.get(i).getPartName());
//				sb.append(VOlist.get(i).getPartName())/* .append(VOlist.get(i).getPartNo()) */;
				cmsw.getModel().addElement(VOlist.get(i).getPartName());
//				cmsw.getModel().addElement(sb);
//				sb.setLength(0);
			}
			
//			cmsw.getModel().addAll(strList);
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public CarManagerVO addCarInfo() {
	
		return null;
	}
	
	public void modifyCarInfo() {
		String date = cmsw.getJtfReleaseDay().getText();
		if(!releaseDay.equals(date)) {
			System.out.println("데이터 수정됨!");
		}
	}
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==cmsw.getJbFunction()) {
			modifyCarInfo();
		}
	}
	

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