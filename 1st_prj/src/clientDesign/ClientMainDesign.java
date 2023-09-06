package clientDesign;

import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class ClientMainDesign extends JFrame {
	
	private ClientMainEvt cmEvt;
	
	private JLabel jlCarname;
	private JLabel jlCarNo;
	private JLabel jlDefaultimg;
	
	private JButton jbtRegist;
	private JButton jbtModify;
	private JButton jbtHistory;
	private JButton jbtBook;
	private JButton jbtBookCheck;
	private JButton jbtRecall;
	private JButton jbtNotify;

	public ClientMainDesign()
	{
		super("메인화면");
			
		//타이틀
		JLabel jlTitle = new JLabel("마이카 관리");
		Font titleFont = new Font(null, Font.BOLD, 20);
		jlTitle.setFont(titleFont);
		
		ImageIcon logoImg = new ImageIcon("E:/dev/workspace/first_project/src/kr/co/sist/image/logo.png");
		JLabel jlLogo = new JLabel(logoImg); //로고
		
		jlCarname = new JLabel("My Car's Name"); //차량 이름
		Font carnameFont = new Font(null, Font.BOLD, 25);
		jlCarname.setFont(carnameFont);
		
		jlCarNo = new JLabel("My Car's Number"); //차량 번호
		
		//차량이미지
		ImageIcon dft = new ImageIcon("E:/dev/workspace/first_project/src/kr/co/sist/image/default.png");
		jlDefaultimg = new JLabel(dft);
		
		//버튼
		jbtRecall = new JButton("리콜 확인");
		jbtNotify = new JButton("알림 확인");
		jbtRegist = new JButton("차량 등록");
		jbtModify = new JButton("회원 정보 수정");
		jbtHistory = new JButton("차량 정비 내역");
		jbtBook = new JButton("정비 예약");
		jbtBookCheck = new JButton("예약 조회");
		
		jlTitle.setBounds(30,0,150,50);
		jlLogo.setBounds(80,50,100,100);
		jlCarname.setBounds(200,50,300,60);
		jlCarNo.setBounds(210,75,150,100);
		jlDefaultimg.setBounds(90,180,600,360);
		
		jbtRecall.setBounds(850,30,100,30);
		jbtNotify.setBounds(1000,30,100,30);
		jbtRegist.setBounds(750,160,350,60);
		jbtModify.setBounds(750,240,350,60);		
		jbtHistory.setBounds(750,320,350,60);		
		jbtBook.setBounds(750,400,350,60);		
		jbtBookCheck.setBounds(750,480,350,60);		
		
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
			
		setBounds(300,150,1200,700);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}//ClientMainDesign
	
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
	
}//class
