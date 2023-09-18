package kr.co.sist.user.design;

import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import kr.co.sist.user.event.ModifyEvt;

public class ModifyDesign extends JFrame {

	private ModifyEvt mdEvt;
	private JButton jbtModifyUserDesign;
	private JButton jbtModifyPassDesign;

	public ModifyDesign() {
		super("정보수정");
		JLabel jlModify = new JLabel("정보수정");
		jbtModifyUserDesign = new JButton("회원정보수정");
		jbtModifyPassDesign = new JButton("비밀번호변경");

		ModifyEvt mde = new ModifyEvt(this);

		jlModify.setBounds(240, 40, 150, 100);
		jbtModifyUserDesign.setBounds(110, 140, 150, 100);
		jbtModifyPassDesign.setBounds(330, 140, 150, 100);

		Font titleFont = new Font("SansSerif", Font.BOLD, 25);
		jlModify.setFont(titleFont);
		Font btnFont = new Font("SansSerif", Font.BOLD, 15);
		jbtModifyPassDesign.setFont(btnFont);
		jbtModifyUserDesign.setFont(btnFont);

		mdEvt = new ModifyEvt(this);
		jbtModifyPassDesign.addActionListener(mdEvt);
		jbtModifyUserDesign.addActionListener(mdEvt);

		setLayout(null);
		add(jlModify);
		add(jbtModifyPassDesign);
		add(jbtModifyUserDesign);

		setBounds(400, 350, 600, 400);
		setVisible(true);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				dispose();
			}
		});
	}// ModifyDesign

	public ModifyEvt getMdEvt() {
		return mdEvt;
	}

	public JButton getJbtModifyUserDesign() {
		return jbtModifyUserDesign;
	}

	public JButton getJbtModifyPassDesign() {
		return jbtModifyPassDesign;
	}

	public static void main(String args[]) {
		new ModifyDesign();
	}

}// class
