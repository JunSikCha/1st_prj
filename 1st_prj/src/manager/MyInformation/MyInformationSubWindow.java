package manager.MyInformation;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import manager.inventory.InventoryManagerSubWindowEvt;
import manager.order.OrderManagerSubWindowEvt;

public class MyInformationSubWindow extends JDialog{

	private JLabel jlTitle;
	private JScrollPane scrollPane;
	
	private JTextField jtfManagerPhone;
	private JTextField jtfManagerEmail;
	private JPasswordField jpfPassword;
	private JPasswordField jpfPasswordConfirm;
	
	private JButton jbCancel;
	private JButton jbConfirm;
	
	private MyInformationTab mit;
	private MyInformationSubWindow misw;
	private DefaultTableModel dtm; //myInfo 정보 가져오기
	
	
	public MyInformationSubWindow(MyInformationTab mit) {
		this.mit = mit;
		
		setLayout(null);

		//상단
		jlTitle = new JLabel("정보 수정");
		Font miNameFont = new Font(null, Font.BOLD, 20);
        jlTitle.setFont(miNameFont);
		
        scrollPane = new JScrollPane();
		
        //게시판
        JLabel jlManagerPhone = new JLabel("전화번호");
        JLabel jlManagerEmail = new JLabel("이메일");
        JLabel jlPassword = new JLabel("비밀번호");
        JLabel jlPasswordConfirm = new JLabel("비밀번호 확인");
        
        //수정가능
        jtfManagerPhone = new JTextField();
        jtfManagerEmail = new JTextField();
        jpfPassword = new JPasswordField();
        jpfPasswordConfirm = new JPasswordField();
		
        jbCancel = new JButton("취소");
        jbConfirm = new JButton("수정");
        
        
        //추가
      	setLayout(null);
      		
      	add("Center", jlTitle);
      	
      	add("Center", jlManagerPhone);
      	add("Center", jlManagerEmail);
      	add("Center", jlPassword);
      	add("Center", jlPasswordConfirm);
      	
      	add("Center", jtfManagerPhone);
      	add("Center", jtfManagerEmail);
      	add("Center", jpfPassword);
      	add("Center", jpfPasswordConfirm);
      	
      	add("Center", jbCancel);
      	add("Center", jbConfirm);
      	
      	
      	dtm = new DefaultTableModel(); //myInfo 정보 가져오기
		//클릭 이벤트
		MyInformationSubWindowEvt misw = new MyInformationSubWindowEvt(mit,this);
		jbConfirm.addActionListener(misw);
		
		//크기 조정 및 배치
		jlTitle.setBounds(10, 6, 140, 20);
		scrollPane.setBounds(60, 50, 800, 770); 
				
		jlManagerPhone.setBounds(70, 40, 80, 30);
		jtfManagerPhone.setBounds(70, 70, 240, 30);
				
		jlManagerEmail.setBounds(70, 110, 80, 30);
		jtfManagerEmail.setBounds(70, 140, 240, 30);
				
		jlPassword.setBounds(70, 180, 80, 30);
		jpfPassword.setBounds(70, 210, 240, 30);
				
		jlPasswordConfirm.setBounds(70, 250, 80, 30);
		jpfPasswordConfirm.setBounds(70, 280, 240, 30);
				
				
		jbCancel.setBounds(60, 500, 120, 30);
		jbConfirm.setBounds(200, 500, 120, 30);
				
		setBounds(mit.getX()+650, mit.getY()+190, 400, 600);
				
				
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);		
		
	} //MyInformationSubWindow


	//getter
	public JLabel getJlTitle() {
		return jlTitle;
	}


	public JScrollPane getScrollPane() {
		return scrollPane;
	}


	public JTextField getJtfManagerPhone() {
		return jtfManagerPhone;
	}


	public JTextField getJtfManagerEmail() {
		return jtfManagerEmail;
	}


	public JPasswordField getJpfPassword() {
		return jpfPassword;
	}


	public JPasswordField getJpfPasswordConfirm() {
		return jpfPasswordConfirm;
	}


	public JButton getJbCancel() {
		return jbCancel;
	}


	public JButton getJbConfirm() {
		return jbConfirm;
	}


	public MyInformationTab getMit() {
		return mit;
	}


	public MyInformationSubWindow getMisw() {
		return misw;
	}


	public DefaultTableModel getDtm() {
		return dtm;
	}
	
	//getter
	
	
	
}
