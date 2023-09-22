package manager.order;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JOptionPane;

import manager.inventory.InventoryManagerDAO;
import manager.inventory.InventoryManagerVO;
import manager.inventory.PartInfoVO;
import manager.login.LoginVO;

public class OrderManagerSubWindowEvt implements ActionListener {

	private OrderManagerTab omt;
	private OrderManagerSubWindow omsw;
	private LoginVO lVO;

	public OrderManagerSubWindowEvt(OrderManagerTab omt, OrderManagerSubWindow omsw,LoginVO lVO) {
		this.omt = omt;
		this.omsw = omsw;
		this.lVO = lVO;
		comboBoxSet();
	}

	//발주창 콤보박스 처리 메소드
	public void comboBoxSet() {
		InventoryManagerDAO imDAO = InventoryManagerDAO.getInstance();
		List<InventoryManagerVO> VOlist = null;
		String certerNo = lVO.getCenterNo();
		try {
			VOlist = imDAO.selectInventoryInfo("",certerNo);
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < VOlist.size(); i++) {
				sb.append(VOlist.get(i).getPartName()).append(" [").append(VOlist.get(i).getPartNo()).append("]");
				omsw.getModel().addElement(sb.toString());
				sb.setLength(0);
			} // end for
		} catch (SQLException e) {
			e.printStackTrace();
		} // end catch
	}

	//발주창 콤보박스 선택된 부품 재고량, 단위 설정 메소드
	public void partAmount() {
		String partName = omsw.getJtfPartName().getSelectedItem().toString();
		String partNo = partName.substring(partName.indexOf("[")+1,partName.indexOf("]"));
		OrderManagerDAO omDAO = OrderManagerDAO.getInstance();
		String centerNo = lVO.getCenterNo();
		
		try {
			PartInfoVO piVO = omDAO.selectPartInfo(partNo,centerNo);
			omsw.getJtfPartStock().setText(piVO.getPartStock());
			omsw.getJtfPartUnit().setText(piVO.getPartUnit());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	//발주 버튼 눌렀을때 정보 insert
	public void addOrderInfo() {
		String partName = omsw.getJtfPartName().getSelectedItem().toString();
		String partNo = partName.substring(partName.indexOf("[")+1,partName.indexOf("]"));
		if(omsw.getJtfOrderQuantity().getText().equals("")) {
			JOptionPane.showMessageDialog(omt, "발주할 수량을 입력해주세요");
			return;
		}
		int amount = Integer.parseInt(omsw.getJtfOrderQuantity().getText());
		OrderManagerDAO omDAO = OrderManagerDAO.getInstance();
		
		try {
			//발주테이블 인설트
			int orderNo = omDAO.selectOrderNo();
			OrderManagerVO omVO = new OrderManagerVO();
			omVO.setPartNo(partNo);
			omVO.setOrderQuantity(amount);
			omVO.setOrderNo(orderNo+1);
			String centerNo = lVO.getCenterNo();
			int cnt = omDAO.insertOrderInfo(omVO,centerNo);
			if(cnt != 1 ) {
				JOptionPane.showMessageDialog(omsw, "발주에 오류가 발생하였습니다.\n 다시 시도해 주세요");
				return;
			}
			JOptionPane.showMessageDialog(omsw, partName+" 제품을 " + amount + "개 발주시켰습니다.");
			//재고테이블 업데이트
			PartInfoVO piVO = omDAO.selectPartInfo(partNo,centerNo);
			int totalAmount = Integer.parseInt(piVO.getPartStock()) + amount;
			System.out.println(totalAmount);
			
			cnt = omDAO.updateStock(partNo, totalAmount,centerNo);
			int flag = JOptionPane.showConfirmDialog(omsw, "계속 발주하시겠습니까?","발주",JOptionPane.YES_NO_OPTION);
			if(flag!=0) {
				omt.getOmEvt().setOrderTable();
				omsw.dispose();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == omsw.getJtfPartName()) {
			partAmount();
		}
		
		if(e.getSource() == omsw.getJbOk()){
			addOrderInfo();
			omsw.dispose();
		}
		
		if(e.getSource() == omsw.getJbCancle()) {
			omsw.dispose();
		}

	}

}
