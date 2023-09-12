package manager.inventory;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

public class InventoryManagerTabEvt implements ActionListener {
	
	private InventoryManagerTab imt;
	
	public InventoryManagerTabEvt( InventoryManagerTab imt) {
		this.imt=imt;
		setInventoryTable();
	}
	
	public void setInventoryTable() {
		InventoryManagerDAO imDAO = InventoryManagerDAO.getInstance();
		List<InventoryManagerVO> list = null;
		
//		String partName = imt.getJtfPartName().getText();
		try {
			list = imDAO.selectInventoryInfo("");
			
			
			
			
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void partNameSerch() {
		
	}
	

	

	@Override
	public void actionPerformed(ActionEvent e) {
	}

}
