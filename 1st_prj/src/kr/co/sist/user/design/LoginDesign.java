package kr.co.sist.user.design;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import kr.co.sist.user.event.LoginEvt;

import java.awt.Color;
import java.awt.Font;

@SuppressWarnings("serial")
public class LoginDesign extends JFrame {
	
	private LoginEvt lgEvt;
	private JTextField  jtfId;
	private JPasswordField jpwPass; 
	private JButton jbLogin; 
	private JButton jbjoin;
	
    public LoginDesign() {
        super("로그인 화면");

        // 라벨 생성
        JLabel jlId = new JLabel("아이디");
        JLabel jlblPass = new JLabel("비밀번호");
        JLabel jlblDc = new JLabel("아직 회원이 아니신가요?");
        jtfId = new JTextField("hong");
        jpwPass = new JPasswordField("1234");

        // 버튼 생성
        jbLogin = new JButton("확인");
        jbjoin = new JButton("회원가입");
     
        getContentPane().setBackground(Color.BLACK);

        jlId.setBounds(220, 140, 80, 510);
        jlblPass.setBounds(220, 180, 80, 510);
        jlblDc.setBounds(260, 220, 150, 510);

        jtfId.setBounds(300, 380, 180, 30);
        jpwPass.setBounds(300, 420, 180, 30);

        jbLogin.setBounds(500, 380, 60, 70);
        jbjoin.setBounds(420, 460, 100, 30);

        Font labelFont = new Font("SansSerif", Font.BOLD, 18);
        jlId.setFont(labelFont);
        jlblPass.setFont(labelFont);

        jlId.setForeground(Color.white);
        jlblPass.setForeground(Color.white);
        jlblDc.setForeground(Color.GRAY);


        setLayout(null);
        add(jlId);
        add(jlblPass);
        add(jtfId);
        add(jpwPass);
        add(jlblDc);

        // 이미지 아이콘으로 마이카
        JLabel imgLabel = new JLabel();
        ImageIcon icon = new ImageIcon("E:/dev/workspace/first_project/src/kr/co/sist/image/bmw1.png");
        imgLabel.setIcon(icon);

//        imgLabel.setBounds(240, 50, 500, 200);
//        imgLabel.setHorizontalAlignment(JLabel.CENTER);
//        getContentPane().add(imgLabel);

        add(jbLogin);
        add(jbjoin);
        
        lgEvt = new LoginEvt(this);
        jtfId.addActionListener(lgEvt);
		jpwPass.addActionListener(lgEvt);
        jbLogin.addActionListener(lgEvt);
        jbjoin.addActionListener(lgEvt);
        
        addWindowListener(lgEvt);
        imgLabel.setBounds(0, 0, 800, 600);
        imgLabel.setHorizontalAlignment(JLabel.CENTER);
        getContentPane().add(imgLabel);

        setBounds(500, 300, 800, 600);
        setVisible(true);
    }
    

    public JTextField getJtfId() {
		return jtfId;
	}


	public JPasswordField getJpwPass() {
		return jpwPass;
	}


	public JButton getJbLogin() {
		return jbLogin;
	}


	public JButton getJbjoin() {
		return jbjoin;
	}

}