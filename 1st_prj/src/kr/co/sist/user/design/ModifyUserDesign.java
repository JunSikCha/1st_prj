package kr.co.sist.user.design;

import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import kr.co.sist.user.event.ModifyUserEvt;

@SuppressWarnings("serial")
public class ModifyUserDesign extends JFrame {

	private ModifyUserEvt mudEvt;
	private JLabel jlUserModfiy;
	private JLabel jlName;
	private JTextField jtfName;
	private JLabel jlPhoneNum;
	private JTextField jtfPhoneNum;
	private JLabel jlEmail;
	private JTextField jtfEmail;
	private JButton jbtComplete;
	private JButton jbtCancel;
	
	public ModifyUserDesign() {
		super("회원정보 수정");
		
		JLabel jlUserModfiy = new JLabel("회원정보수정");
		JLabel jlName = new JLabel("사용자명");
		JLabel jlPhoneNum = new JLabel("전화번호");
		JLabel jlEmail = new JLabel("이메일");
		
		jtfName = new JTextField();
		jtfPhoneNum = new JTextField();
		jtfEmail = new JTextField();
		
		jbtComplete = new JButton("완료");
		jbtCancel = new JButton("X");
		
		Font titleFont = new Font(null, Font.BOLD, 20);
		jlUserModfiy.setFont(titleFont);
		
		Font labelFont = new Font(null, Font.BOLD, 15);
		jlName.setFont(labelFont);
		jlPhoneNum.setFont(labelFont);
		jlEmail.setFont(labelFont);
		
		jlUserModfiy.setBounds(180, 0, 150, 100);
		jlName.setBounds(70, 60, 150, 100);
		jtfName.setBounds(70, 130, 350, 40);
		jlPhoneNum.setBounds(70, 160, 150, 100);
		jtfPhoneNum.setBounds(70, 240, 350, 40);
		jlEmail.setBounds(70, 270,150, 100);
		jtfEmail.setBounds(70, 340, 350, 40);
		jbtComplete.setBounds(0,420,500,40);
		jbtCancel.setBounds(435,2,50,30);
		
		setLayout(null);
		add(jlUserModfiy);
		add(jlName);
		add(jtfName);
		add(jlPhoneNum);
		add(jtfPhoneNum);
		add(jlEmail);
		add(jtfEmail);
		add(jbtComplete);
		add(jbtCancel);
		
		mudEvt = new ModifyUserEvt(this);
		jbtComplete.addActionListener(mudEvt);
		jbtCancel.addActionListener(mudEvt);
		
		setBounds(400,400,500,500);
		setVisible(true);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent we) {
				dispose();
			}
		});
		
	}

	public ModifyUserEvt getMudEvt() {
		return mudEvt;
	}

	public JLabel getJlUserModfiy() {
		return jlUserModfiy;
	}

	public JLabel getJlName() {
		return jlName;
	}

	public JTextField getJtfName() {
		return jtfName;
	}

	public JLabel getJlPhoneNum() {
		return jlPhoneNum;
	}

	public JTextField getJtfPhoneNum() {
		return jtfPhoneNum;
	}

	public JLabel getJlEmail() {
		return jlEmail;
	}

	public JTextField getJtfEmail() {
		return jtfEmail;
	}

	public JButton getJbtComplete() {
		return jbtComplete;
	}

	public JButton getJbtCancel() {
		return jbtCancel;
	}
	

}
