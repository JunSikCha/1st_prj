package manager.MyInformation;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import manager.login.LoginVO;

@SuppressWarnings("serial")
public class MyInformationTab extends JPanel implements ActionListener {
	
	private MyInformationTabEvt mifEvt;
	
	//좌측테이블
	private JLabel jlMIMessage;
	private JPanel jpMIMessage;
	//우측 테이블
	private JPanel jpBranchName;
	private JPanel jpBranchNo;
	private JPanel jpManagerPhone;
	private JPanel jpManagerEmail;
	private JPanel jpBranchAddr;
	
	private JTextField jtfBranchName;
	private JTextField jtfBranchNo;
	private JTextField jtfManagerPhone;
	private JTextField jtfManagerEmail;
	private JTextField jtfBranchAddr;
	private JTextField jtfEmpNo;
	
	private JButton jbinfoModify;

	
	public MyInformationTab(LoginVO lVO) {
		setLayout(null);
		
		//왼쪽
		ImageIcon empImg = new ImageIcon("경로 적기");
		JLabel jlEmpImg = new JLabel(empImg); //관리자 사진
		
		
		//게시판 형식, 배경색
//		JLabel lMIMessage = new JLabel(empName + "(" + empNo + ")" + "님 안녕하세요?");
		jlMIMessage = new JLabel("안녕하세요?",JLabel.CENTER);
		jpMIMessage = new JPanel();
		jpMIMessage.setLayout(new BorderLayout());
		jpMIMessage.add(jlMIMessage);
		jpMIMessage.setBackground(Color.gray);
		Font mINameFont = new Font(null, Font.BOLD, 14);
		jlMIMessage.setFont(mINameFont);
		
		JLabel jlBranchName = new JLabel("지점명",JLabel.CENTER);
		jpBranchName = new JPanel();
		jpBranchName.setLayout(new BorderLayout());
		jpBranchName.add(jlBranchName);
		jpBranchName.setBackground(Color.gray);
		
		JLabel jlBranchNo = new JLabel("지점번호",JLabel.CENTER);
		jpBranchNo = new JPanel();
		jpBranchNo.setLayout(new BorderLayout());
		jpBranchNo.add(jlBranchNo);
		jpBranchNo.setBackground(Color.gray);
		
		JLabel jlManagerPhone = new JLabel("전화번호",JLabel.CENTER);
		jpManagerPhone = new JPanel();
		jpManagerPhone.setLayout(new BorderLayout());
		jpManagerPhone.add(jlManagerPhone);
		jpManagerPhone.setBackground(Color.gray);
		
		JLabel jlManagerEmail = new JLabel("이메일",JLabel.CENTER);
		jpManagerEmail = new JPanel();
		jpManagerEmail.setLayout(new BorderLayout());
		jpManagerEmail.add(jlManagerEmail);
		jpManagerEmail.setBackground(Color.gray);
		
		JLabel jlBranchAddr = new JLabel("지점주소",JLabel.CENTER);
		jpBranchAddr = new JPanel();
		jpBranchAddr.setLayout(new BorderLayout());
		jpBranchAddr.add(jlBranchAddr);
		jpBranchAddr.setBackground(Color.gray);
		
		
		//하단 버튼
//		jbMIHome = new JButton("홈화면");
		jbinfoModify = new JButton("정보수정");
		
		//게시판 수정 가능 영역
		jtfBranchName = new JTextField();
		jtfBranchName.setEditable(false);
		jtfBranchNo = new JTextField();
		jtfBranchNo.setEditable(false);
		jtfManagerPhone = new JTextField();
		jtfManagerPhone.setEditable(false);
		jtfManagerEmail = new JTextField();
		jtfManagerEmail.setEditable(false);
		jtfBranchAddr = new JTextField();
		jtfBranchAddr.setEditable(false);
		
		jtfEmpNo = new JTextField();
		
		
		//추가
		add("Center",jlEmpImg);
		add("Center",jpMIMessage);
		
		
		add("Center",jpBranchName);
		add("Center",jpBranchNo);
		add("Center",jpManagerPhone);
		add("Center",jpManagerEmail);
		add("Center",jpBranchAddr);
		
		add("Center",jtfBranchName);
		add("Center",jtfBranchNo);
		add("Center",jtfManagerPhone);
		add("Center",jtfManagerEmail);
		add("Center",jtfBranchAddr);
		
		
//		add("Center", jbMIHome);
		add("Center", jbinfoModify);
		
		add("Center",jtfEmpNo);
		
		//클릭 이벤트
		mifEvt = new MyInformationTabEvt(this,lVO);
		
//		jbMIHome.addActionListener(mifEvt);
		jbinfoModify.addActionListener(mifEvt);
		
		//사이즈
		jlEmpImg.setBounds(170, 100, 220, 220);
		jpMIMessage.setBounds(140, 330, 220, 80);
		
		jpBranchName.setBounds(480, 110, 109, 58);
		jpBranchNo.setBounds(480, 170, 109, 58);
		jpManagerPhone.setBounds(480, 230, 109, 58);
		jpManagerEmail.setBounds(480, 290, 109, 58);
		jpBranchAddr.setBounds(480, 350, 109, 58);
		
		jtfBranchName.setBounds(590, 110, 209, 58);
		jtfBranchNo.setBounds(590, 170, 209, 58);
		jtfManagerPhone.setBounds(590, 230, 209, 58);
		jtfManagerEmail.setBounds(590, 290, 209, 58);
		jtfBranchAddr.setBounds(590, 350, 209, 58);
		
//		jbMIHome.setBounds(250, 520, 120, 30);
		jbinfoModify.setBounds(570, 520, 120, 30);
		

	}//MyInformationTab

	
	
	//getter 

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}



	public MyInformationTabEvt getMifEvt() {
		return mifEvt;
	}



	public JTextField getJtfEmpNo() {
		return jtfEmpNo;
	}



	public JButton getJbinfoModify() {
		return jbinfoModify;
	}



	public JLabel getJlMIMessage() {
		return jlMIMessage;
	}



	public JTextField getJtfBranchName() {
		return jtfBranchName;
	}



	public JTextField getJtfBranchNo() {
		return jtfBranchNo;
	}



	public JTextField getJtfManagerPhone() {
		return jtfManagerPhone;
	}



	public JTextField getJtfManagerEmail() {
		return jtfManagerEmail;
	}



	public JTextField getJtfBranchAddr() {
		return jtfBranchAddr;
	}



	
	
}//class	
	
