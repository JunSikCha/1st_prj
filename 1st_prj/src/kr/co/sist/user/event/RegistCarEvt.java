package kr.co.sist.user.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import kr.co.sist.user.dao.RegistCarDAO;
import kr.co.sist.user.design.LoginDesign;
import kr.co.sist.user.design.RegistCarDesign;
import kr.co.sist.user.vo.RegistCarVO;

public class RegistCarEvt extends WindowAdapter implements ActionListener {

	private RegistCarVO rcVO;
	
	private RegistCarDesign rcd;
	
	public RegistCarEvt(RegistCarDesign rcd) {
		this.rcd=rcd;
		
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == rcd.getJbtComplete()) {
			registMessage();
		}
		
		if(ae.getSource()==rcd.getJbtCancel()) {
			rcd.dispose();
		}

	}
	
	public void registMessage() {
		String registcar= new String();
		JOptionPane.showMessageDialog(rcd, "차량등록이 완료되었습니다.");
	}

	private void addCarInfo(String carModel, String carNo, int distance) {
		try {		
			
			rcVO = new RegistCarVO();
			rcVO.setCarModel(carModel);
			rcVO.setCarNo(carNo);
			rcVO.setDistance(distance);

			RegistCarDAO rDAO = RegistCarDAO.getInstance();
	        rDAO.insertCarinfo(rcVO);
			
			System.out.println(rcVO.getCarModel()+" 차량 추가 완료");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
