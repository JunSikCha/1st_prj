package manager.MyInformation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import manager.login.LoginVO;

public class MyInformationTabEvt implements ActionListener {
	private MyInformationTab mit;
	private  LoginVO lVO;
	
	public MyInformationTabEvt(MyInformationTab mit,LoginVO lVO) {
		this.mit = mit;
		this.lVO = lVO;
		setEmpInfo();
	}
	
	public void setEmpInfo() {
		mit.getJtfBranchName().setText(lVO.getCtname());
		mit.getJtfBranchAddr().setText(lVO.getCtaddr());
		mit.getJtfBranchNo().setText(lVO.getCenterNo());
		mit.getJtfManagerPhone().setText(lVO.getEmptel());
		
		mit.getJtfManagerEmail().setText(lVO.getEmpemail());
		mit.getJlMIMessage().setText(lVO.getEmpname()+"님 안녕하세요.");
		mit.getJtfEmpNo().setText(lVO.getEmpno());
		
		
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==mit.getJbinfoModify()) {
			new MyInformationSubWindow(mit);
		}
	}

}
