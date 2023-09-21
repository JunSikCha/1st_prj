package kr.co.sist.user.design;

import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import kr.co.sist.user.event.ModifyUserEvt;
import kr.co.sist.user.event.UserData;

@SuppressWarnings("serial")
public class ModifyUserDesign extends JFrame {
	private ModifyDesign md;

	private ModifyUserEvt mudEvt;
	private JLabel jlOrName;
	private JTextField jtfPhoneNum;
	private JTextField jtfEmail;
	private JButton jbtComplete;
	
	public ModifyUserDesign(ModifyDesign md) {
		this.md=md;
		
		JLabel jlUserModfiy = new JLabel("회원정보수정");
		JLabel jlName = new JLabel("사용자명");
		JLabel jlPhoneNum = new JLabel("전화번호");
		JLabel jlEmail = new JLabel("이메일");
		
		jlOrName = new JLabel(UserData.name);
		jtfPhoneNum = new JTextField();
		jtfEmail = new JTextField();
		
		jbtComplete = new JButton("완료");
		
		Font titleFont = new Font(null, Font.BOLD, 25);
		jlUserModfiy.setFont(titleFont);
		
		Font labelFont = new Font(null, Font.BOLD, 18);
		jlName.setFont(labelFont);
		jlPhoneNum.setFont(labelFont);
		jlEmail.setFont(labelFont);
		
		Font labelFont2 = new Font(null, Font.BOLD, 20);
		jlOrName.setFont(labelFont2);
		
		jlUserModfiy.setBounds(120, 30, 180, 100);
		jlName.setBounds(70, 110, 150, 100);
		jlOrName.setBounds(70, 165, 250, 40);
		jlPhoneNum.setBounds(70, 180, 150, 100);
		jtfPhoneNum.setBounds(70, 250, 250, 40);
		jlEmail.setBounds(70, 280,150, 100);
		jtfEmail.setBounds(70, 350, 250, 40);
		jbtComplete.setBounds(140,420,100,30);
		
		setLayout(null);
		add(jlUserModfiy);
		add(jlName);
		add(jlOrName);
		add(jlPhoneNum);
		add(jtfPhoneNum);
		add(jlEmail);
		add(jtfEmail);
		add(jbtComplete);
		
		mudEvt = new ModifyUserEvt(this);
		jbtComplete.addActionListener(mudEvt);
		
		setBounds(md.getX()+0,md.getY()-50,400,500);
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

	public JLabel getJtfName() {
		return jlOrName;
	}

	public JTextField getJtfPhoneNum() {
		return jtfPhoneNum;
	}

	public JTextField getJtfEmail() {
		return jtfEmail;
	}

	public JButton getJbtComplete() {
		return jbtComplete;
	}


}
