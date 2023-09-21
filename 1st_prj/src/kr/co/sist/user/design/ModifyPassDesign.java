package kr.co.sist.user.design;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import kr.co.sist.user.event.ModifyPassEvt;

@SuppressWarnings("serial")
public class ModifyPassDesign extends JFrame{
	private ModifyDesign md;
	
	private ModifyPassEvt mpdEvt;
	
	private JTextField jtfcurPwdField;
	private JTextField jtfnewPwdField;
	private JTextField jtfconfirmPwd;
	private JButton jbtComplete;
	
	public ModifyPassDesign(ModifyDesign md) {
		this.md=md;
		
		JLabel jlModifyPass = new JLabel("비밀번호 변경");
		JLabel jlcurPwd = new JLabel("기존 비밀번호");
		jtfcurPwdField = new JTextField();
		JLabel jlnewPwd = new JLabel("변경할 비밀번호");
		jtfnewPwdField = new JTextField();
		JLabel jlconfirmPwd = new JLabel("비밀번호 확인");
		jtfconfirmPwd = new JTextField();
		
		jbtComplete = new JButton("비밀번호 변경");
		
		Font titleFont = new Font(null, Font.BOLD, 25);
		 jlModifyPass.setFont(titleFont);
		 Font labelFont = new Font(null, Font.BOLD, 18);
		 jlcurPwd.setFont(labelFont);
		 jlnewPwd.setFont(labelFont);
		 jlconfirmPwd.setFont(labelFont);
		 
		 jlModifyPass.setBounds(120, 10, 180, 100);
			jlcurPwd.setBounds(70, 70, 150, 100);
			jtfcurPwdField.setBounds(70, 140, 250, 40);
			jlnewPwd.setBounds(70, 160, 150, 100);
			jtfnewPwdField.setBounds(70, 240, 250, 40);
			jlconfirmPwd.setBounds(70, 270,150, 100);
			jtfconfirmPwd.setBounds(70, 340, 250, 40);
			jbtComplete.setBounds(120,420,150,30);
		
			setLayout(null);
			add(jlModifyPass);
			add(jlcurPwd);
			add(jtfcurPwdField);
			add(jlnewPwd);
			add(jtfnewPwdField);
			add(jlconfirmPwd);
			add(jtfconfirmPwd);
			add(jbtComplete);
		
		mpdEvt = new ModifyPassEvt(this);
		jbtComplete.addActionListener(mpdEvt);
		
		setBounds(md.getX()+0,md.getY()-50,400,500);
		setVisible(true);
		 
	}

	public ModifyPassEvt getMpdEvt() {
		return mpdEvt;
	}

	public JTextField getJtfcurPwdField() {
		return jtfcurPwdField;
	}

	public JTextField getJtfnewPwdField() {
		return jtfnewPwdField;
	}

	public JTextField getJtfconfirmPwd() {
		return jtfconfirmPwd;
	}


	public JButton getJbtComplete() {
		return jbtComplete;
	}


}
