package kr.co.sist.user.design;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import kr.co.sist.user.event.ModifyPassEvt;

@SuppressWarnings("serial")
public class ModifyPassDesign extends JFrame{
	
	private ModifyPassEvt mpdEvt;
	
	private JLabel jlModifyPass;
	private JLabel jlcurPwd;
	private JTextField jtfcurPwdField;
	private JLabel jlnewPwd;
	private JTextField jtfnewPwdField;
	private JLabel jlconfirmPwd;
	private JTextField jtfconfirmPwd;
	private JButton jbtCancel;
	private JButton jbtComplete;
	
	public ModifyPassDesign() {
		super("비밀번호변경");
		
		JLabel jlModifyPass = new JLabel("비밀번호 변경");
		JLabel jlcurPwd = new JLabel("기존 비밀번호");
		jtfcurPwdField = new JTextField();
		JLabel jlnewPwd = new JLabel("비밀번호");
		jtfnewPwdField = new JTextField();
		JLabel jlconfirmPwd = new JLabel("비밀번호 확인");
		jtfconfirmPwd = new JTextField();
		
		jbtComplete = new JButton("비밀번호 변경");
		jbtCancel = new JButton("X");
		
		Font titleFont = new Font(null, Font.BOLD, 20);
		 jlModifyPass.setFont(titleFont);
		 Font labelFont = new Font(null, Font.BOLD, 15);
		 jlcurPwd.setFont(labelFont);
		 jlnewPwd.setFont(labelFont);
		 jlconfirmPwd.setFont(labelFont);
		 
		jlModifyPass.setBounds(180, 0, 150, 100);
		jlcurPwd.setBounds(70, 60, 150, 100);
		jtfcurPwdField.setBounds(70, 130, 350, 40);
		jlnewPwd.setBounds(70, 160, 150, 100);
		jtfnewPwdField.setBounds(70, 240, 350, 40);
		jlconfirmPwd.setBounds(70, 270,150, 100);
		jtfconfirmPwd.setBounds(70, 340, 350, 40);
		jbtComplete.setBounds(0,420,500,40);
		jbtCancel.setBounds(435,2,50,30);
		
		setLayout(null);
		add(jlModifyPass);
		add(jlcurPwd);
		add(jtfcurPwdField);
		add(jlnewPwd);
		add(jtfnewPwdField);
		add(jlconfirmPwd);
		add(jtfconfirmPwd);
		add(jbtComplete);
		add(jbtCancel);
		
		mpdEvt = new ModifyPassEvt(this);
		jbtComplete.addActionListener(mpdEvt);
		jbtCancel.addActionListener(mpdEvt);
		
		setBounds(400,400,500,500);
		setVisible(true);
		 
	}

	public ModifyPassEvt getMpdEvt() {
		return mpdEvt;
	}

	public JLabel getJlModifyPass() {
		return jlModifyPass;
	}

	public JLabel getJlcurPwd() {
		return jlcurPwd;
	}

	public JTextField getJtfcurPwdField() {
		return jtfcurPwdField;
	}

	public JLabel getJlnewPwd() {
		return jlnewPwd;
	}

	public JTextField getJtfnewPwdField() {
		return jtfnewPwdField;
	}

	public JLabel getJlconfirmPwd() {
		return jlconfirmPwd;
	}

	public JTextField getJtfconfirmPwd() {
		return jtfconfirmPwd;
	}

	public JButton getJbtCancel() {
		return jbtCancel;
	}

	public JButton getJbtComplete() {
		return jbtComplete;
	}
	
	

}
