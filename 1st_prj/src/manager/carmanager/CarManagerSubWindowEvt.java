package manager.carmanager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import manager.inventory.InventoryManagerTab;
import manager.inventory.PartInfoVO;

public class CarManagerSubWindowEvt implements ActionListener, MouseListener {
	
	private CarManagerTab cmt;
	private CarManagerSubWindow cmsw;
	
	public CarManagerSubWindowEvt(CarManagerTab cmt,CarManagerSubWindow cmsw ) {
		this.cmt = cmt;
		this.cmsw = cmsw;
		setOneCarInfo();
	}
	
	
	public void setOneCarInfo() {
		CarManagerDAO cmDAO = CarManagerDAO.getInstance();
		CarManagerVO cmVO = new CarManagerVO();
		List<PartInfoVO> listPiVO = new ArrayList<PartInfoVO>();
		
		
		int historyno = Integer.parseInt(cmt.getJtbCarInfoTable().getValueAt(cmt.getJtbCarInfoTable().getSelectedRow(),0).toString());
		String carNo = String.valueOf(cmt.getJtbCarInfoTable().getValueAt(cmt.getJtbCarInfoTable().getSelectedRow(),1));
		String carName = String.valueOf(cmt.getJtbCarInfoTable().getValueAt(cmt.getJtbCarInfoTable().getSelectedRow(),2));
		String maintenanceDetail = String.valueOf(cmt.getJtbCarInfoTable().getValueAt(cmt.getJtbCarInfoTable().getSelectedRow(),3));
		String receivedDay = String.valueOf(cmt.getJtbCarInfoTable().getValueAt(cmt.getJtbCarInfoTable().getSelectedRow(),4));
		String releaseDay = String.valueOf(cmt.getJtbCarInfoTable().getValueAt(cmt.getJtbCarInfoTable().getSelectedRow(),5));
		String note = String.valueOf(cmt.getJtbCarInfoTable().getValueAt(cmt.getJtbCarInfoTable().getSelectedRow(),6));
		
		cmVO.setHistoryNo(historyno);
		cmVO.setCarNo(carNo);
		cmVO.setCarName(carName);
		cmVO.setReceivedDay(receivedDay);
		cmVO.setReleaseDay(releaseDay);
		cmVO.setMaintenanceDetail(maintenanceDetail);
		cmVO.setNote(note);
		
		
		try {
			cmVO = cmDAO.selectOneCarInfo(cmVO);
			
			listPiVO = cmDAO.selectOnePartInfo(historyno);
			
			cmsw.getJtfMaintenencrNo().setText(String.valueOf(cmVO.getMaintenanceNo()));
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
//			for(int i =0; i< cmsw.getDtm().getRowCount();i++) {
//			total += Integer.parseInt(String.valueOf(cmsw.getDtm().getValueAt(4, i)));
//			}//end if
			cmsw.getJtfTotal().setText(String.valueOf(total));
			
		} catch (SQLException e) {
			e.printStackTrace();
		}//end catch
		
	}//oneCarInfo
	
	public CarManagerVO addCarInfo() {
	
		return null;
	}
	
	public void modifyCarInfo() {
		
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

	@Override
	public void actionPerformed(ActionEvent e) {
	}

}