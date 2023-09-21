package manager.inventory;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class InventoryManagerSubWindowEvt implements ActionListener {
	private InventoryManagerSubWindow imsw;
	private InventoryManagerTab imt;

	public InventoryManagerSubWindowEvt(InventoryManagerTab imt, InventoryManagerSubWindow imsw) {
		this.imt = imt;
		this.imsw = imsw;
	}

	public void addPartInfo() {
		InventoryManagerVO imVO = new InventoryManagerVO();
		if (imsw.getJtfPartName().getText().equals("")) {
			JOptionPane.showMessageDialog(imsw, "부품명을 입력하세요");
			return;
		}
		imVO.setPartName(imsw.getJtfPartName().getText());
		
		if (imsw.getJtfPartNo().getText().equals("")) {
			JOptionPane.showMessageDialog(imsw, "부품넘버을 입력하세요");
			return;
		}
		imVO.setPartNo(imsw.getJtfPartNo().getText());
		
		if (imsw.getJtfAddNumber().getText().equals("")) {
			JOptionPane.showMessageDialog(imsw, "추가수량을 입력하세요");
			return;
		}
		imVO.setPartStock(Integer.parseInt(imsw.getJtfAddNumber().getText()));
		
		if (imsw.getJtfPartUnit().getText().equals("")) {
			JOptionPane.showMessageDialog(imsw, "단위를 입력하세요");
			return;
		}
		imVO.setPartUnit(imsw.getJtfPartUnit().getText());
		
		if (imsw.getJtfPartCost().getText().equals("")) {
			JOptionPane.showMessageDialog(imsw, "단가를 입력하세요");
			return;
		}
		imVO.setPartCost(Integer.parseInt(imsw.getJtfPartCost().getText()));
		
		if (imsw.getJtfLaborCost().getText().equals("")) {
			JOptionPane.showMessageDialog(imsw, "공임비를 입력하세요");
			return;
		}
		imVO.setLaborCost(Integer.parseInt(imsw.getJtfLaborCost().getText()));

		InventoryManagerDAO imDAO = InventoryManagerDAO.getInstance();
		try {
			int cnt = imDAO.insertInventoryInfo(imVO);
			if(cnt==1) {
				JOptionPane.showMessageDialog(imsw, imVO.getPartName()+"을 추가하였습니다.");
			}else {
				JOptionPane.showMessageDialog(imsw, "부품 추가에 실패했습니다.\n 관리자에게 문의하세요");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == imsw.getJbCancle()) {
			imsw.dispose();
		}
		if (e.getSource() == imsw.getJbOk()) {
			addPartInfo();
		}
	}

}
