package manager.MyInformation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import manager.carmanager.CarManager;
import manager.login.LoginVO;

public class MyInformationTabEvt implements ActionListener {
	private MyInformationTab mit;
	
	CarManager cm;
	
	public MyInformationTabEvt(MyInformationTab mit, CarManager cm) {
		this.mit=mit;
		this.cm = cm;
		LoginVO lVO = this.cm.getlVO();
		
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
	}

}
