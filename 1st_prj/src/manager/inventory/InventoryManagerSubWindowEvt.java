package manager.inventory;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InventoryManagerSubWindowEvt implements ActionListener {
//	private InventoryManagerSubWindow imsw;
	
	public InventoryManagerSubWindowEvt(/* InventoryManagerSubWindow imsw */) {
		
	}
	
	public InventoryManagerVO addPartInfo() {
		InventoryManagerVO imVO = new InventoryManagerVO();
		
		return imVO;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
	}

}
