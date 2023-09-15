package kr.co.sist.user.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.util.List;

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
		setModelNo();
	}
	


	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == rcd.getJbtComplete()) {
			addCarInfo();
		}
		
		if(ae.getSource()==rcd.getJbtCancel()) {
			rcd.dispose();
		}

	}
	
	@Override
	public void windowClosing(WindowEvent e) {
		rcd.dispose();
	}
	

	public void setModelNo() {
		RegistCarDAO rcDAO = new RegistCarDAO();
		
		try {
			List<String> listModelNo = rcDAO.selectModel();
			for(String mno : listModelNo) {
				rcd.getDcbmModel().addElement(mno);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}//setModelNo

	private void addCarInfo() {
		RegistCarDAO rcDAO = new RegistCarDAO();
		try {		
			
			rcVO = new RegistCarVO();
			rcVO.setCarModel(rcDAO.selectModelno(rcd.getJcbModel().getSelectedItem().toString()));
			rcVO.setCarNo(rcd.getJtfCarnum().getText());
			rcVO.setDistance(Integer.parseInt(rcd.getJtfDistance().getText()));

			RegistCarDAO rDAO = RegistCarDAO.getInstance();
	        rDAO.insertCarinfo(rcVO);
			
			System.out.println(rcVO.getCarModel()+" 차량 추가 완료");
			JOptionPane.showMessageDialog(rcd, "차량등록이 완료되었습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	

}
