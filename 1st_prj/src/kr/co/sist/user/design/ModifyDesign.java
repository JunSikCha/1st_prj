package kr.co.sist.user.design;

import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class ModifyDesign extends JFrame {
	
	
	private ModifyDesignEvt mdEvt;
	private JLabel jlModify;
	private JButton jbtCancel;
	private JButton jbtModifyUserDesign;
	private JButton jbtModifyPassDesign;

	public ModifyDesign() {
		super("정보수정");
		JLabel jlModify =new JLabel("정보수정");
		jbtModifyUserDesign = new JButton("회원정보수정");
		jbtModifyPassDesign = new JButton("비밀번호변경");
		jbtCancel = new JButton("X");
		
		ModifyDesignEvt mde = new ModifyDesignEvt(this);
		
		jlModify.setBounds(240, 40, 150, 100);
		jbtModifyUserDesign.setBounds(110, 140, 150, 100);
		jbtModifyPassDesign.setBounds(330, 140, 150, 100);
		jbtCancel.setBounds(540, 2, 50, 30);
		
		
		 Font titleFont = new Font("SansSerif", Font.BOLD, 25);
	      jlModify.setFont(titleFont);
		Font btnFont = new Font("SansSerif", Font.BOLD, 15);
	      jbtModifyPassDesign.setFont(btnFont);
	      jbtModifyUserDesign.setFont(btnFont);
	      
	      mdEvt= new ModifyDesignEvt(this);
	      jbtModifyPassDesign.addActionListener(mdEvt);
	      jbtModifyUserDesign.addActionListener(mdEvt);
	      jbtCancel.addActionListener(mdEvt);
	      
	      setLayout(null);
	      add(jlModify);
	      add(jbtCancel);
	      add(jbtModifyPassDesign);
	      add(jbtModifyUserDesign);
	      
		setBounds(400,350,600,400);
		setVisible(true);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				dispose();
			}
		});
	}//ModifyDesign

	public ModifyDesignEvt getMdEvt() {
		return mdEvt;
	}

	public JLabel getJlModify() {
		return jlModify;
	}

	public JButton getJbtCancel() {
		return jbtCancel;
	}

	public JButton getJbtModifyUserDesign() {
		return jbtModifyUserDesign;
	}

	public JButton getJbtModifyPassDesign() {
		return jbtModifyPassDesign;
	}
	
	
	
}//class
