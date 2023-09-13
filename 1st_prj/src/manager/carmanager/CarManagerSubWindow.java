package manager.carmanager;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Panel;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class CarManagerSubWindow extends JDialog {

	private CarManagerTab cmt;
	
	private JLabel jlTitle;
	private JPanel jpTitle;
	
	private JPanel jpMaintenencrNo;
	private JPanel jpcarName;
	private JPanel jpPhone;
	private JPanel jpreceiveDay;
	private JPanel jpempName;
	private JTextField jtfMaintenencrNo;
	private JTextField jtfcarName;
	private JTextField jtfPhone;
	private JTextField jtfreceiveDay;
	private JTextField jtfempName;
	//	
	private JPanel jpCarNo;
	private JPanel jpClientName;
	private JPanel jpClientEmail;
	private JPanel jpReleaseDay;
	private JPanel jpCarmileage;
	//
	private JTextField jtfCarNo;
	private JTextField jtfClientName;
	private JTextField jtfClientEmail;
	private JTextField jtfReleaseDay;
	private JTextField jtfCarmileage;
	
	private JPanel jpFaultDetail;
	private JPanel jpMaintenanceDetail;
	private JPanel jpPartName;
	private JPanel jpSUnitPrice;
	private JPanel jpSPrice;
	//
	private JTextField jtfFaultDetail;
	private JTextField  jtfMaintenanceDetail;
	private JComboBox  jtfPartName;
	private JTable jtPartTable;
	private JButton jbPartAdd;
	
	private JPanel jpNote;
	private JPanel jpTotal;
	//
	private JTextField jtfNote;
	private JTextField jtfTotal;
	
	private JButton jbCancle;
	private JButton jbFunction;

	private JComponent scrollPane;
	private DefaultTableModel dtm;
	
		
	public CarManagerSubWindow(CarManagerTab cmt) {
		this.cmt=cmt;//cmt
		
		setLayout(null);
		
		jlTitle = new JLabel("차량정보");
		jpTitle = new JPanel();
//		pTitle.setLayout(new BorderLayout());
		jpTitle.add(jlTitle, BorderLayout.CENTER);
		jpTitle.setBackground(Color.gray);
		
		
		JLabel jlMaintenencrNo = new JLabel("정비번호");
		jpMaintenencrNo = new JPanel();
		jpMaintenencrNo.add(jlMaintenencrNo, BorderLayout.CENTER);
		jpMaintenencrNo.setBackground(Color.gray);
		
		JLabel jlcarName = new JLabel("모델명");
		jpcarName = new JPanel();
		jpcarName.add(jlcarName, BorderLayout.CENTER);
		jpcarName.setBackground(Color.gray);
		
		JLabel jlPhone = new JLabel("전화번호");
		jpPhone = new JPanel();
		jpPhone.add(jlPhone, BorderLayout.CENTER);
		jpPhone.setBackground(Color.gray);
		
		JLabel jlreceiveDay = new JLabel("입고일");
		jpreceiveDay = new JPanel();
		jpreceiveDay.add(jlreceiveDay, BorderLayout.CENTER);
		jpreceiveDay.setBackground(Color.gray);
		
		JLabel jlempName = new JLabel("점검사원명");
		jpempName = new JPanel();
		jpempName.add(jlempName, BorderLayout.CENTER);
		jpempName.setBackground(Color.gray);
		//
		jtfMaintenencrNo = new JTextField();
		jtfcarName = new JTextField();
		jtfPhone = new JTextField();
		jtfreceiveDay = new JTextField();
		jtfempName = new JTextField();
		
		
		JLabel jlCarNo = new JLabel("차량번호");
		jpCarNo = new JPanel();
		jpCarNo.add(jlCarNo, BorderLayout.CENTER);
		jpCarNo.setBackground(Color.gray);
		
		JLabel jlClientName = new JLabel("고객명");
		jpClientName = new JPanel();
		jpClientName.add(jlClientName, BorderLayout.CENTER);
		jpClientName.setBackground(Color.gray);
		
		JLabel jlClientEmail = new JLabel("이메일");
		jpClientEmail = new JPanel();
		jpClientEmail.add(jlClientEmail, BorderLayout.CENTER);
		jpClientEmail.setBackground(Color.gray);
		
		JLabel jlReleaseDay = new JLabel("출고일");
		jpReleaseDay = new JPanel();
		jpReleaseDay.add(jlReleaseDay, BorderLayout.CENTER);
		jpReleaseDay.setBackground(Color.gray);
		
		JLabel jlCarmileage = new JLabel("주행거리");
		jpCarmileage = new JPanel();
		jpCarmileage.add(jlCarmileage, BorderLayout.CENTER);
		jpCarmileage.setBackground(Color.gray);
		//
		jtfCarNo = new JTextField();
		jtfClientName = new JTextField();
		jtfClientEmail = new JTextField();
		jtfReleaseDay = new JTextField();
		jtfCarmileage = new JTextField();
		
		
		JLabel jlFaultDetail = new JLabel("고장증상");
		jpFaultDetail = new JPanel();
		jpFaultDetail.add(jlFaultDetail, BorderLayout.CENTER);
		jpFaultDetail.setBackground(Color.gray);
		
		JLabel jlMaintenanceDetail = new JLabel("점검내용");
		jpMaintenanceDetail = new JPanel();
		jpMaintenanceDetail.add(jlMaintenanceDetail, BorderLayout.CENTER);
		jpMaintenanceDetail.setBackground(Color.gray);
		
		JLabel jlPartName = new JLabel("사용 부품명");
		jpPartName = new JPanel();
		jpPartName.add(jlPartName, BorderLayout.CENTER);
		jpPartName.setBackground(Color.gray);
		
		JLabel jlNote = new JLabel("비고");
		jpNote = new JPanel();
		jpNote.add(jlNote, BorderLayout.CENTER);
		jpNote.setBackground(Color.gray);
		
		JLabel jlTotal = new JLabel("합계");
		jpTotal = new JPanel();
		jpTotal.add(jlTotal, BorderLayout.CENTER);
		jpTotal.setBackground(Color.gray);
		//
		jtfFaultDetail = new JTextField();
		jtfMaintenanceDetail = new JTextField();
		jtfPartName = new JComboBox();
		
		jbPartAdd = new JButton("추가");
		
		jtfNote = new JTextField();
		jtfTotal = new JTextField();
		
		jbCancle = new JButton("취소");
		jbFunction = new JButton("수정"); //맞나??
		
		
        
        //부품 게시판
		dtm = new DefaultTableModel();
		jtPartTable = new JTable(dtm);
        scrollPane = new JScrollPane(jtPartTable);

		
	    //SubWindow이벤트 실행 
		CarManagerSubWindowEvt cmswe = new CarManagerSubWindowEvt(cmt,this);
		jbFunction.addActionListener(cmswe);
		
		//게시판형태 테두리 선 주기
		Border cmswBD = BorderFactory.createLineBorder(Color.LIGHT_GRAY);
		jpTitle.setBorder(cmswBD);
		jpMaintenencrNo.setBorder(cmswBD);
		jpcarName.setBorder(cmswBD);
		jpPhone.setBorder(cmswBD);
		jpreceiveDay.setBorder(cmswBD);
		jpempName.setBorder(cmswBD);
		jpCarNo.setBorder(cmswBD);
		jpClientName.setBorder(cmswBD);
		jpClientEmail.setBorder(cmswBD);
		jpReleaseDay.setBorder(cmswBD);
		jpCarmileage.setBorder(cmswBD);
		jpFaultDetail.setBorder(cmswBD);
		jpMaintenanceDetail.setBorder(cmswBD);
		jpNote.setBorder(cmswBD);
		jpTotal.setBorder(cmswBD);
		
		//추가
		setLayout(null);
        
        add("Center", jpTitle);
        
        add("Center", jpMaintenencrNo);
		add("Center", jpcarName);
		add("Center", jpPhone);
		add("Center", jpreceiveDay);
		add("Center", jpempName);
		add("Center", jtfMaintenencrNo);
		add("Center", jtfcarName);
		add("Center", jtfPhone);
		add("Center", jtfreceiveDay);
		add("Center", jtfempName);
		
		add("Center", jpCarNo);
		add("Center", jpClientName);
		add("Center", jpClientEmail);
		add("Center", jpReleaseDay);
		add("Center", jpCarmileage);
		add("Center", jtfCarNo);
		add("Center", jtfClientName);
		add("Center", jtfClientEmail);
		add("Center", jtfReleaseDay);
		add("Center", jtfCarmileage);
		
		add("Center", jpFaultDetail);
//		add("Center", jtPartTable);
		add("Center", scrollPane);
		add("Center", jpMaintenanceDetail);
		add("Center", jpPartName);
		add("Center", jpNote);
		add("Center", jpTotal);
		add("Center", jtfFaultDetail);
		add("Center", jtfMaintenanceDetail);
		add("Center", jtfPartName);
		add("Center", jtfNote);
		add("Center", jtfTotal);
		
		add("Center", jbPartAdd);
		add("Center", jbCancle);
		add("Center", jbFunction);

	
		//위치 조절
		jpTitle.setBounds(50, 20, 580, 30);
		scrollPane.setBounds(60, 50, 800, 720); 
		
		jpMaintenencrNo.setBounds(50, 50, 145, 30);
		jpcarName.setBounds(50, 80, 145, 30);
		jpPhone.setBounds(50, 110, 145, 30);
		jpreceiveDay.setBounds(50, 140, 145, 30);
		jpempName.setBounds(50, 170, 145, 30);
		//
		jtfMaintenencrNo.setBounds(195, 50, 145, 30);
		jtfcarName.setBounds(195, 80, 145, 30);
		jtfPhone.setBounds(195, 110, 145, 30);
		jtfreceiveDay.setBounds(195, 140, 145, 30);
		jtfempName.setBounds(195, 170, 145, 30);
		
		
		jpCarNo.setBounds(340, 50, 145, 30);
		jpClientName.setBounds(340, 80, 145, 30);
		jpClientEmail.setBounds(340, 110, 145, 30);
		jpReleaseDay.setBounds(340, 140, 145, 30);
		jpCarmileage.setBounds(340, 170, 145, 30);
		//
		jtfCarNo.setBounds(485, 50, 145, 30);
		jtfClientName.setBounds(485, 80, 145, 30);
		jtfClientEmail.setBounds(485, 110, 145, 30);
		jtfReleaseDay.setBounds(485, 140, 145, 30);
		jtfCarmileage.setBounds(485, 170, 145, 30);
		
		jpFaultDetail.setBounds(50, 200, 290, 30);
		jpMaintenanceDetail.setBounds(50, 230, 290, 30);
		jpPartName.setBounds(50, 260, 290, 30);
		jpNote.setBounds(50, 390, 290, 30);
		jpTotal.setBounds(50, 420, 290, 30);
		
		scrollPane.setBounds(50, 290, 581, 100);
		
		jtfFaultDetail.setBounds(340, 200, 290, 30);
		jtfMaintenanceDetail.setBounds(340, 230, 290, 30);
		jtfPartName.setBounds(340, 260, 290, 30);
		jtfNote.setBounds(340, 390, 290, 30);
		jtfTotal.setBounds(340, 420, 290, 30);
		
		
		jbCancle.setBounds(180, 480, 120, 30);
		jbPartAdd.setBounds(380, 480, 120, 30);
		jbFunction.setBounds(380, 480, 120, 30);
		
		setBounds(cmt.getX()+520, cmt.getY()+190, 700, 600);
		
		scrollPane.setVisible(true);
		jlTitle.setVisible(true);
		
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
		
	} //CarManagerSubWindow


	private Object pTotal(String string, LineBorder border) {
		// TODO Auto-generated method stub
		return null;
	}


	public CarManagerTab getCmt() {
		return cmt;
	}


	public JLabel getJlTitle() {
		return jlTitle;
	}


	public JPanel getjpTitle() {
		return jpTitle;
	}


	public JPanel getjpMaintenencrNo() {
		return jpMaintenencrNo;
	}


	public JPanel getjpcarName() {
		return jpcarName;
	}


	public JPanel getjpPhone() {
		return jpPhone;
	}


	public JPanel getjpreceiveDay() {
		return jpreceiveDay;
	}


	public JPanel getjpempName() {
		return jpempName;
	}


	public JTextField getJtfMaintenencrNo() {
		return jtfMaintenencrNo;
	}


	public JTextField getJtfcarName() {
		return jtfcarName;
	}


	public JTextField getJtfPhone() {
		return jtfPhone;
	}


	public JTextField getJtfreceiveDay() {
		return jtfreceiveDay;
	}


	public JTextField getJtfempName() {
		return jtfempName;
	}


	public JPanel getjpCarNo() {
		return jpCarNo;
	}


	public JPanel getjpClientName() {
		return jpClientName;
	}


	public JPanel getjpClientEmail() {
		return jpClientEmail;
	}


	public JPanel getjjpReleaseDay() {
		return jpReleaseDay;
	}


	public JPanel getjpCarmileage() {
		return jpCarmileage;
	}


	public JTextField getJtfCarNo() {
		return jtfCarNo;
	}


	public JTextField getJtfClientName() {
		return jtfClientName;
	}


	public JTextField getJtfClientEmail() {
		return jtfClientEmail;
	}


	public JTextField getJtfReleaseDay() {
		return jtfReleaseDay;
	}


	public JTextField getJtfCarmileage() {
		return jtfCarmileage;
	}


	public JPanel getjpFaultDetail() {
		return jpFaultDetail;
	}


	public JPanel getjpMaintenanceDetail() {
		return jpMaintenanceDetail;
	}


	public JPanel getjpPartName() {
		return jpPartName;
	}


	public JPanel getjpSUnitPrice() {
		return jpSUnitPrice;
	}


	public JPanel getjpSPrice() {
		return jpSPrice;
	}


	public JTextField getJtfFaultDetail() {
		return jtfFaultDetail;
	}


	public JTextField getJtfMaintenanceDetail() {
		return jtfMaintenanceDetail;
	}


	public JComboBox getJtfPartName() {
		return jtfPartName;
	}


	public JTable getJtPartTable() {
		return jtPartTable;
	}


	public JButton getJbPartAdd() {
		return jbPartAdd;
	}


	public JPanel getjpNote() {
		return jpNote;
	}


	public JPanel getjpTotal() {
		return jpTotal;
	}


	public JTextField getJtfNote() {
		return jtfNote;
	}


	public JTextField getJtfTotal() {
		return jtfTotal;
	}


	public JButton getJbCancle() {
		return jbCancle;
	}


	public JButton getJbFunction() {
		return jbFunction;
	}


	public JComponent getScrollPane() {
		return scrollPane;
	}


	public DefaultTableModel getDtm() {
		return dtm;
	}


	
} //class
