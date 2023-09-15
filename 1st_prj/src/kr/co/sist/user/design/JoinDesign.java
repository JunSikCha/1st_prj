package kr.co.sist.user.design;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import kr.co.sist.user.event.JoinDesignEvt;


public class JoinDesign extends JFrame {
	private JoinDesignEvt jdEvt;
	
	private JTextField jtfId;
	private JPasswordField jpwPass;
	private JPasswordField jtfCheckPass;
	private JTextField jtfName;
	private JTextField jtfPhNum;
	private JTextField jtfEmail;
	private JButton jbtldCheck;
	private JButton jbtOk;
	private JButton jbtCancel;
	
	
	public JoinDesign() {
		super("회원가입");
		JLabel jlTitle = new JLabel("회원가입");
		JLabel jlId = new JLabel("아이디");
	    jtfId = new JTextField();
	    JLabel jlblPass = new JLabel("비밀번호");
	    jpwPass=new JPasswordField();
	    JLabel jlblCheckPass = new JLabel("비밀번호 확인");
	    jtfCheckPass =new JPasswordField();
	    JLabel jlblName = new JLabel("이름");
	    jtfName = new JTextField();
	    JLabel jlblPhNum = new JLabel("전화번호");
	    jtfPhNum = new JTextField();
	    JLabel jlblEmail = new JLabel("이메일");
	    jtfEmail = new JTextField();
	    
	    jbtldCheck =new JButton("중복확인");
	    jbtOk =new JButton("등록");
	    jbtCancel =new JButton("취소");
	    
	    jlTitle.setBounds(300, 10, 80, 100);
	    jlId.setBounds(400, 40, 80, 100);
        jtfId.setBounds(400, 100, 200, 30);
        jlblPass.setBounds(400, 105, 80, 100);
        jpwPass.setBounds(400, 165, 200, 30);
        jlblCheckPass.setBounds(400, 175, 80, 100);
        jtfCheckPass.setBounds(400, 235, 200, 30);
        jlblName.setBounds(400, 245, 80, 100);
        jtfName.setBounds(400, 305, 200, 30);
        jlblPhNum.setBounds(400, 315, 80, 100);
        jtfPhNum.setBounds(400, 375, 200, 30);
        jlblEmail.setBounds(400, 385, 80, 100);
        jtfEmail.setBounds(400, 445, 200, 30);

        jbtldCheck.setBounds(620, 100, 100, 30);
        jbtOk.setBounds(400, 500, 80, 30);
        jbtCancel.setBounds(520, 500, 80, 30);
        
        Font labelFont = new Font("SansSerif", Font.BOLD, 16);
        jlTitle.setFont(labelFont);
        
        jdEvt = new JoinDesignEvt(this);
        		
        
        jbtldCheck.addActionListener(jdEvt);
        jbtOk.addActionListener(jdEvt);
        jbtCancel.addActionListener(jdEvt);
        
	    setLayout(null);
	    add(jlTitle);
	    add(jlId);
	    add(jlblPass);
	    add(jlblCheckPass);
	    add(jlblName);
	    add(jlblPhNum);
	    add(jlblPhNum);
	    add(jlblEmail);
	    add(jtfId);
		add(jpwPass);
		add(jtfCheckPass);
		add(jtfName);
		add(jtfPhNum);
		add(jtfEmail);
		add(jbtldCheck);
		add(jbtOk);
		add(jbtCancel);
	    
		 setBounds(800, 500, 1000, 700);
	     setVisible(true);
	     setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}


	public JoinDesignEvt getJdEvt() {
		return jdEvt;
	}


	public JTextField getJtfId() {
		return jtfId;
	}


	public JPasswordField getJpwPass() {
		return jpwPass;
	}


	public JPasswordField getJtfCheckPass() {
		return jtfCheckPass;
	}


	public JTextField getJtfName() {
		return jtfName;
	}


	public JTextField getJtfPhNum() {
		return jtfPhNum;
	}


	public JTextField getJtfEmail() {
		return jtfEmail;
	}


	public JButton getJbtldCheck() {
		return jbtldCheck;
	}


	public JButton getJbtOk() {
		return jbtOk;
	}


	public JButton getJbtCancel() {
		return jbtCancel;
	}


	public static void main(String[] args) {
		new JoinDesign();
	}

}
