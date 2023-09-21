package kr.co.sist.user.design;

import java.awt.Font;
import java.sql.SQLException;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import kr.co.sist.user.dao.ClientMainDAO;
import kr.co.sist.user.event.ClientMainEvt;
import kr.co.sist.user.event.UserData;
import kr.co.sist.user.vo.ClientMainVO;

@SuppressWarnings("serial")
public class ClientMainDesign extends JFrame {
	
	private LoginDesign ld;

	private ClientMainEvt cmEvt;

	private JLabel jlCarname;
	private JLabel jlCarNo;
	private JLabel jlDefaultimg;
	private ImageIcon dft;

	private JButton jbtRegist;
	private JButton jbtModify;
	private JButton jbtHistory;
	private JButton jbtBook;
	private JButton jbtBookCheck;
	private JButton jbtRecall;
	private JButton jbtNotify;

	public ClientMainDesign(LoginDesign ld) {
		this.ld=ld;

		// 타이틀
		JLabel jlTitle = new JLabel("마이카 관리");
		Font titleFont = new Font(null, Font.BOLD, 20);
		jlTitle.setFont(titleFont);

		ImageIcon logoImg = new ImageIcon("E:/dev/workspace/first_project/src/kr/co/sist/image/logo.png");
		JLabel jlLogo = new JLabel(logoImg); // 로고

		jlCarname = new JLabel();// 차량 이름
		Font carnameFont = new Font(null, Font.BOLD, 25);
		jlCarname.setFont(carnameFont);

		jlCarNo = new JLabel(); // 차량 번호

		// 차량이미지
		dft = new ImageIcon();
		jlDefaultimg = new JLabel();

		// 버튼
		jbtRecall = new JButton("리콜 확인");
		jbtNotify = new JButton("알림 확인");
		jbtRegist = new JButton("차량 등록");
		jbtModify = new JButton("회원 정보 수정");
		jbtHistory = new JButton("차량 정비 내역");
		jbtBook = new JButton("정비 예약");
		jbtBookCheck = new JButton("예약 조회");

		jlTitle.setBounds(30, 0, 150, 50);
		jlLogo.setBounds(80, 50, 100, 100);
		jlCarNo.setBounds(140,10,150,100);
		jlCarname.setBounds(140,65,300,60);
		jlDefaultimg.setBounds(90, 180, 600, 360);

		jbtRecall.setBounds(650,90,100,30);
		jbtNotify.setBounds(800,90,100,30);
		jbtRegist.setBounds(650, 130, 250, 60);
		jbtModify.setBounds(650, 200, 250, 60);
		jbtHistory.setBounds(650, 270, 250, 60);
		jbtBook.setBounds(650, 340, 250, 60);
		jbtBookCheck.setBounds(650, 410, 250, 60);
		
		setLayout(null);

		add(jlTitle);
		add(jlLogo);
		add(jlCarname);
		add(jlCarNo);
		add(jlDefaultimg);

		add(jbtRecall);
		add(jbtNotify);
		add(jbtRegist);
		add(jbtModify);
		add(jbtHistory);
		add(jbtBook);
		add(jbtBookCheck);

		cmEvt = new ClientMainEvt(this);
		jbtRegist.addActionListener(cmEvt);
		jbtModify.addActionListener(cmEvt);
		jbtHistory.addActionListener(cmEvt);
		jbtBook.addActionListener(cmEvt);
		jbtBookCheck.addActionListener(cmEvt);
		jbtRecall.addActionListener(cmEvt);
		jbtNotify.addActionListener(cmEvt);

		setBounds(ld.getX()+0,ld.getY()+50,950,550);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}// ClientMainDesign
	

	public ClientMainEvt getCmEvt() {
		return cmEvt;
	}

	public JLabel getJlCarname() {
		return jlCarname;
	}

	public JLabel getJlCarNo() {
		return jlCarNo;
	}
	
	public ImageIcon getDft() {
		return dft;
	}

	public JLabel getJlDefaultimg() {
		return jlDefaultimg;
	}

	public JButton getJbtRegist() {

		return jbtRegist;
	}

	public JButton getJbtModify() {
		return jbtModify;
	}

	public JButton getJbtHistory() {
		return jbtHistory;
	}

	public JButton getJbtBook() {
		return jbtBook;
	}

	public JButton getJbtBookCheck() {
		return jbtBookCheck;
	}

	public JButton getJbtRecall() {
		return jbtRecall;
	}

	public JButton getJbtNotify() {
		return jbtNotify;
	}

}// class
