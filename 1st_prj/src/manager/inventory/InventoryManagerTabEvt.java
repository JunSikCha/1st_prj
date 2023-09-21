package manager.inventory;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

import manager.carmanager.CarManagerVO;
import manager.login.LoginVO;

public class InventoryManagerTabEvt implements ActionListener {
	
	private InventoryManagerTab imt;
	private LoginVO lVO;
	
	public InventoryManagerTabEvt( InventoryManagerTab imt,LoginVO lVO) {
		this.imt=imt;
		this.lVO = lVO;
		setInventoryTable();
		
	}
	
	public void setInventoryTable() {
		InventoryManagerDAO imDAO = InventoryManagerDAO.getInstance();
		List<InventoryManagerVO> list = null;
		
		String partName = imt.getJtfPartName().getText();
		String certerNo = lVO.getCenterNo();
		
		try {
			list = imDAO.selectInventoryInfo(partName,certerNo);
			
			//JTable의 칼럼이 0개라면 칼럼명 추가
			if(imt.getJtbInventoryInfoTable().getColumnCount()==0) {
				//JTable 칼럼명 설정
				String[] columnNames = {"S/N","부품명", "재고량", "단위", "단가", "공임비"};
				for(int i=0;i<columnNames.length;i++) {
					imt.getDtm().addColumn(columnNames[i]);
				}//end for
			}//end if
			
			//JTable 데이터 삭제
			imt.getDtm().setRowCount(0);
			
			//JTable 행 정보 추가
			String[] arrRow = new String[7];
			for(int i=0;i<list.size();i++) {
				InventoryManagerVO imVO = list.get(i);
				arrRow[0] = imVO.getPartNo();
				arrRow[1] = imVO.getPartName();
				arrRow[2] = String.valueOf(imVO.getPartStock());
				arrRow[3] = imVO.getPartUnit();
				arrRow[4] = String.valueOf(imVO.getPartCost());
				arrRow[5] = String.valueOf(imVO.getLaborCost());
				imt.getDtm().addRow(arrRow);
			}//end for
		} catch (SQLException e) {
			e.printStackTrace();
		}//end catch
	}//setInventoryTable
	
	public void partNameSerch() {
		
	}
	

	

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==imt.getJbPartNameSearch()){
			setInventoryTable();
		}
		if(e.getSource()==imt.getJbAdd()) {
			new InventoryManagerSubWindow(imt);
		}
		if(e.getSource()==imt.getJbRefresh()) {
			setInventoryTable();
		}
	}

}