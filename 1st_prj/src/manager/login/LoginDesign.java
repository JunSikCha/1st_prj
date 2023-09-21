package manager.login;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class LoginDesign extends JFrame {

	private LoginEvt lgEvt;
	private JTextField jtfId;
	private JPasswordField jpwPass;
	private JButton jbLogin;
	private JButton jbjoin;
	private BufferedImage backgroundImage;

	public LoginDesign() {
        super("로그인 화면");

        // 라벨 생성
        JLabel jlId = new JLabel("사       번");
        JLabel jlblPass = new JLabel("비밀번호");
//        JLabel jlblDc = new JLabel("아직 회원이 아니신가요?");
        jtfId = new JTextField("1");
        jpwPass = new JPasswordField("1234");

        // 버튼 생성
        jbLogin = new JButton("확인");
//        jbjoin = new JButton("회원가입");
     
        


        Font labelFont = new Font("SansSerif", Font.BOLD, 14);
        jlId.setFont(labelFont);
        jlblPass.setFont(labelFont);

        jlId.setForeground(Color.WHITE);
        jlblPass.setForeground(Color.WHITE);
//        jlblDc.setForeground(Color.GRAY);

        setLayout(null);
        add(jlId);
        add(jlblPass);
        add(jtfId);
        add(jpwPass);
        add(jbLogin);
//        add(jlblDc);

        // 이미지 아이콘으로 마이카
        JLabel imgLabel = new JLabel();
        ImageIcon icon = new ImageIcon("E:/dev/back_bmw3.png");
//        ImageIcon icon = new ImageIcon("E:/dev/back_bmw4.jpg");
        imgLabel.setIcon(icon);
        
        

        jlId.setBounds(300, 230, 80, 510);
        jlblPass.setBounds(300, 270, 80, 510);
//        jlblDc.setBounds(350, 140, 150, 510);
        
        jtfId.setBounds(370, 470, 180, 30);
        jpwPass.setBounds(370, 510, 180, 30);
        
        jbLogin.setBounds(570, 470, 60, 70);
//        jbjoin.setBounds(500, 380, 100, 30);

        imgLabel.setBounds(0, 0, 950, 740);
        imgLabel.setHorizontalAlignment(JLabel.CENTER);
        getContentPane().add(imgLabel);
//        add(jbjoin);
        
        
        
        
        
        
        
        lgEvt = new LoginEvt(this);
        jtfId.addActionListener(lgEvt);
		jpwPass.addActionListener(lgEvt);
        jbLogin.addActionListener(lgEvt);
        jpwPass.addActionListener(lgEvt);
//        jbjoin.addActionListener(lgEvt);
        
        addWindowListener(lgEvt);

        setBounds(400, 150, 950, 740);
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