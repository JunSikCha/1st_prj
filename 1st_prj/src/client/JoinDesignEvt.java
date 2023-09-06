package client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JOptionPane;

public class JoinDesignEvt extends WindowAdapter implements ActionListener {

	private JoinDesign jd;
	
	public JoinDesignEvt(JoinDesign jd) {
		this.jd=jd;
	}

	
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==jd.getJbtldCheck()) {
			ldCheck();
		}
//		if(ae.getSource()==jd.getJbtOk()) {
//			RegistOkDesign rod = new RegistOkDesign();
//			rod.setVisible(true);
//		}
//		if(ae.getSource()==jd.getJbtCancel()) {
//			RegistCancelDesign rcd = new RegistCancelDesign();
//			rcd.setVisible(true);
//		}

	}
 
	@Override
	public void windowClosing(WindowEvent we) {
		jd.dispose();

	}
	
	private void  ldCheck() {
		String id= jd.getJtfId().getText().trim();
		boolean isDuplicated = isIdDuplicated(id);
		 if (isDuplicated) {
		        JOptionPane.showMessageDialog(jd, "사용 불가능한 아이디입니다.");
		    } else {
		        JOptionPane.showMessageDialog(jd, "사용 가능한 아이디입니다.");
		    }
	}
	private boolean isIdDuplicated(String id) {
		  return "ID".equals(id);
	}
	

}
