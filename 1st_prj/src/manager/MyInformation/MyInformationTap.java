package manager.MyInformation;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Image;
import java.awt.Panel;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class MyInformationTap extends JPanel{
	//좌측테이블
//	private Image background=
//			new ImageIcon(MyInformationTab.class.getResource("사용자에 있는 BMW로고 넣어주세요")).getImage();
	
	
	//우측 테이블
	private JLabel lBranchName;
	private JLabel lBranchNo;
	private JLabel lManagerPhone;
	private JLabel lManagerEmail;
	private JLabel lBranchAddr;
	
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
	

	
	public MyInformationTap() {
		//세로 게시판 형태
		lBranchName = new JLabel("지점명");
		lBranchNo = new JLabel("지점번호");
		lManagerPhone = new JLabel("전화번호");
		lManagerEmail = new JLabel("이메일");
		lBranchAddr = new JLabel("지점주소");
		
		
		setLayout(null);
		
		pBranchName = new Panel();
		pBranchName.setLayout(new BorderLayout());
		pBranchName.add(lBranchName, BorderLayout.NORTH);
		
		pBranchNo = new Panel();
		pBranchNo.setLayout(new BorderLayout());
		pBranchNo.add(lBranchNo, BorderLayout.NORTH);
		
		pManagerPhone = new Panel();
		pManagerPhone.setLayout(new BorderLayout());
		pManagerPhone.add(lManagerPhone, BorderLayout.NORTH);
				
		pManagerEmail = new Panel();
		pManagerEmail.setLayout(new BorderLayout());
		pManagerEmail.add(lManagerEmail, BorderLayout.NORTH);
		
		pBranchAddr = new Panel();
		pBranchAddr.setLayout(new BorderLayout());
		pBranchAddr.add(lBranchAddr, BorderLayout.NORTH);
		
		//게시판색상
		pBranchName.setBackground(Color.lightGray);
		pBranchNo.setBackground(Color.lightGray);
		pManagerPhone.setBackground(Color.lightGray);
		pManagerEmail.setBackground(Color.lightGray);
		pBranchAddr.setBackground(Color.lightGray);
		
		//추가
		add("Center",pBranchName);
		add("Center",pBranchNo);
		add("Center",pManagerPhone);
		add("Center",pManagerEmail);
		add("Center",pBranchAddr);
		
		//사이즈
		pBranchName.setBounds(480, 100, 70, 20);
		pBranchNo.setBounds(480, 140, 70, 20);
		pManagerPhone.setBounds(480, 180, 70, 20);
		pManagerEmail.setBounds(480, 220, 70, 20);
		pBranchAddr.setBounds(480, 260, 70, 20);
		
		pBranchName.setVisible(true);
		pBranchNo.setVisible(true);
		pManagerPhone.setVisible(true);
		pManagerEmail.setVisible(true);
		pBranchAddr.setVisible(true);
		
//		setVisible(true);
		
		
		
		
		

	}//MyInformationTab
	
	
	
}//class	
