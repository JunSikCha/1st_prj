package manager.MyInformation;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;

public class MyInformationTab extends JPanel implements ActionListener {
	
	private MyInformationTabEvt mifEvt;
	private DefaultTableModel dtm;
	
	//좌측테이블
	private JLabel jlMIMessage;
	private Panel pMIMessage;
	
	//우측 테이블
	private JLabel jlBranchName;
	private JLabel jlBranchNo;
	private JLabel jlManagerPhone;
	private JLabel jlManagerEmail;
	private JLabel jlBranchAddr;
	
	private Panel pBranchName;
	private Panel pBranchNo;
	private Panel pManagerPhone;
	private Panel pManagerEmail;
	private Panel pBranchAddr;
	
	private JTextArea jtaBranchName;
	private JTextArea jtaBranchNo;
	private JTextArea jtaManagerPhone;
	private JTextArea jtaManagerEmail;
	private JTextArea jtaBranchAddr;
	
	private JButton jbMIHome;
	private JButton jbinfoModify;

	
	public MyInformationTab() {
		dtm = new DefaultTableModel();
		
		//왼쪽, 
		ImageIcon empImg = new ImageIcon("");
//		lMIMessage = new JLabel(empName + "(" + empNo + ")" + "님 안녕하세요?");
		jlMIMessage = new JLabel("안녕하세요");
		
		//오른쪽, 세로 게시판 형태
		jlBranchName = new JLabel("지점명");
		jlBranchNo = new JLabel("지점번호");
		jlManagerPhone = new JLabel("전화번호");
		jlManagerEmail = new JLabel("이메일");
		jlBranchAddr = new JLabel("지점주소");
		
		jbMIHome = new JButton("홈화면");
		jbinfoModify = new JButton("정보수정");
		
		setLayout(null);
		
		pMIMessage = new Panel();
		pMIMessage.setLayout(new BorderLayout());
		pMIMessage.add(jlMIMessage, BorderLayout.CENTER);
		
		pBranchName = new Panel();
		pBranchName.setLayout(new BorderLayout());
		pBranchName.add(jlBranchName, BorderLayout.CENTER);
		
		pBranchNo = new Panel();
		pBranchNo.setLayout(new BorderLayout());
		pBranchNo.add(jlBranchNo, BorderLayout.CENTER);
		
		pManagerPhone = new Panel();
		pManagerPhone.setLayout(new BorderLayout());
		pManagerPhone.add(jlManagerPhone, BorderLayout.CENTER);
				
		pManagerEmail = new Panel();
		pManagerEmail.setLayout(new BorderLayout());
		pManagerEmail.add(jlManagerEmail, BorderLayout.CENTER);
		
		pBranchAddr = new Panel();
		pBranchAddr.setLayout(new BorderLayout());
		pBranchAddr.add(jlBranchAddr, BorderLayout.CENTER);
		
		jtaBranchName = new JTextArea();
		jtaBranchNo = new JTextArea();
		jtaManagerPhone = new JTextArea();
		jtaManagerEmail = new JTextArea();
		jtaBranchAddr = new JTextArea();
		
		//게시판색상
		pMIMessage.setBackground(Color.GRAY);
		pBranchName.setBackground(Color.lightGray);
		pBranchNo.setBackground(Color.lightGray);
		pManagerPhone.setBackground(Color.lightGray);
		pManagerEmail.setBackground(Color.lightGray);
		pBranchAddr.setBackground(Color.lightGray);
		
		//추가
		add("Center",pMIMessage);
		
		add("Center",pBranchName);
		add("Center",pBranchNo);
		add("Center",pManagerPhone);
		add("Center",pManagerEmail);
		add("Center",pBranchAddr);
		
		add("Center",jtaBranchName);
		add("Center",jtaBranchNo);
		add("Center",jtaManagerPhone);
		add("Center",jtaManagerEmail);
		add("Center",jtaBranchAddr);
		
		add("Center", jbMIHome);
		add("Center", jbinfoModify);
		
		mifEvt = new MyInformationTabEvt(this);
		
		//클릭 이벤트
		jbMIHome.addActionListener(mifEvt);
		jbinfoModify.addActionListener(mifEvt);
		
		//사이즈
		pMIMessage.setBounds(150, 208, 200, 80);
		
		pBranchName.setBounds(480, 100, 80, 25);
		pBranchNo.setBounds(480, 140, 80, 25);
		pManagerPhone.setBounds(480, 180, 80, 25);
		pManagerEmail.setBounds(480, 220, 80, 25);
		pBranchAddr.setBounds(480, 260, 80, 25);
		
		jtaBranchName.setBounds(570, 100, 120, 25);
		jtaBranchNo.setBounds(570, 140, 120, 25);
		jtaManagerPhone.setBounds(570, 180, 120, 25);
		jtaManagerEmail.setBounds(570, 220, 120, 25);
		jtaBranchAddr.setBounds(570, 260, 120, 25);
		
		jbMIHome.setBounds(250, 520, 120, 30);
		jbinfoModify.setBounds(570, 520, 120, 30);
		
		pBranchName.setVisible(true);
		pBranchNo.setVisible(true);
		pManagerPhone.setVisible(true);
		pManagerEmail.setVisible(true);
		pBranchAddr.setVisible(true);
		jbMIHome.setVisible(true);
		jbinfoModify.setVisible(true);
		
//		setVisible(true);
		
		
		
		
		

	}//MyInformationTab


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
	
}//class	
