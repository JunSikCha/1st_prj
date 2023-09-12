package manager.carmanager;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Panel;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class CarManagerSubWindow extends JDialog {

	private CarManagerTab cmt;
	
	private JLabel jlTitle;
	private Panel pTitle;
	
	private Panel pMaintenencrNo;
	private Panel pcarName;
	private Panel pPhone;
	private Panel preceiveDay;
	private Panel pempName;
	private JTextField jtfMaintenencrNo;
	private JTextField jtfcarName;
	private JTextField jtfPhone;
	private JTextField jtfreceiveDay;
	private JTextField jtfempName;
	//	
	private Panel pCarNo;
	private Panel pClientName;
	private Panel pClientEmail;
	private Panel pReleaseDay;
	private Panel pCarmileage;
	//
	private JTextField jtfCarNo;
	private JTextField jtfClientName;
	private JTextField jtfClientEmail;
	private JTextField jtfReleaseDay;
	private JTextField jtfCarmileage;
	
	private Panel pFaultDetail;
	private Panel pMaintenanceDetail;
	private Panel pPartName;
	private Panel pSUnitPrice;
	private Panel pSPrice;
	//
	private JTextField jtfFaultDetail;
	private JTextField  jtfMaintenanceDetail;
	private JComboBox  jtfPartName;
	private JTable jtPartTable;
	private JButton jbPartAdd;
	
	private Panel pNote;
	private Panel pTotal;
	//
	private JTextField jtfNote;
	private JTextField jtfTotal;
	
	private JButton jbCancle;
	private JButton jbFunction;

	private JComponent scrollPane;
	private DefaultTableModel dtm;
	
		
	public CarManagerSubWindow(CarManagerTab cmt) {
		this.cmt=cmt;
		
		setLayout(null);
		
		jlTitle = new JLabel("차량정보");
		pTitle = new Panel();
//		pTitle.setLayout(new BorderLayout());
		pTitle.add(jlTitle, BorderLayout.CENTER);
		pTitle.setBackground(Color.gray);
		
		
		JLabel jlMaintenencrNo = new JLabel("정비번호");
		pMaintenencrNo = new Panel();
		pMaintenencrNo.add(jlMaintenencrNo, BorderLayout.CENTER);
		pMaintenencrNo.setBackground(Color.gray);
		
		JLabel jlcarName = new JLabel("모델명");
		pcarName = new Panel();
		pcarName.add(jlcarName, BorderLayout.CENTER);
		pcarName.setBackground(Color.gray);
		
		JLabel jlPhone = new JLabel("전화번호");
		pPhone = new Panel();
		pPhone.add(jlPhone, BorderLayout.CENTER);
		pPhone.setBackground(Color.gray);
		
		JLabel jlreceiveDay = new JLabel("입고일");
		preceiveDay = new Panel();
		preceiveDay.add(jlreceiveDay, BorderLayout.CENTER);
		preceiveDay.setBackground(Color.gray);
		
		JLabel jlempName = new JLabel("점검사원명");
		pempName = new Panel();
		pempName.add(jlempName, BorderLayout.CENTER);
		pempName.setBackground(Color.gray);
		//
		jtfMaintenencrNo = new JTextField();
		jtfcarName = new JTextField();
		jtfPhone = new JTextField();
		jtfreceiveDay = new JTextField();
		jtfempName = new JTextField();
		
		
		JLabel jlCarNo = new JLabel("차량번호");
		pCarNo = new Panel();
		pCarNo.add(jlCarNo, BorderLayout.CENTER);
		pCarNo.setBackground(Color.gray);
		
		JLabel jlClientName = new JLabel("고객명");
		pClientName = new Panel();
		pClientName.add(jlClientName, BorderLayout.CENTER);
		pClientName.setBackground(Color.gray);
		
		JLabel jlClientEmail = new JLabel("이메일");
		pClientEmail = new Panel();
		pClientEmail.add(jlClientEmail, BorderLayout.CENTER);
		pClientEmail.setBackground(Color.gray);
		
		JLabel jlReleaseDay = new JLabel("출고일");
		pReleaseDay = new Panel();
		pReleaseDay.add(jlReleaseDay, BorderLayout.CENTER);
		pReleaseDay.setBackground(Color.gray);
		
		JLabel jlCarmileage = new JLabel("주행거리");
		pCarmileage = new Panel();
		pCarmileage.add(jlempName, BorderLayout.CENTER);
		pCarmileage.setBackground(Color.gray);
		//
		jtfCarNo = new JTextField();
		jtfClientName = new JTextField();
		jtfClientEmail = new JTextField();
		jtfReleaseDay = new JTextField();
		jtfCarmileage = new JTextField();
		
		
		JLabel jlFaultDetail = new JLabel("고장증상");
		pFaultDetail = new Panel();
		pFaultDetail.add(jlFaultDetail, BorderLayout.CENTER);
		pFaultDetail.setBackground(Color.gray);
		
		JLabel jlMaintenanceDetail = new JLabel("점검내용");
		pMaintenanceDetail = new Panel();
		pMaintenanceDetail.add(jlMaintenanceDetail, BorderLayout.CENTER);
		pMaintenanceDetail.setBackground(Color.gray);
		
		JLabel jlNote = new JLabel("비고");
		pNote = new Panel();
		pNote.add(jlNote, BorderLayout.CENTER);
		pNote.setBackground(Color.gray);
		
		JLabel jlTotal = new JLabel("합계");
		pTotal = new Panel();
		pTotal.add(jlTotal, BorderLayout.CENTER);
		pTotal.setBackground(Color.gray);
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
		jtPartTable = new JTable(dtm);
        scrollPane = new JScrollPane(jtPartTable);

        //컬럼네임 크기 조절
        JTableHeader tableHeader = jtPartTable.getTableHeader();
        Font headerFont = new Font(null, Font.BOLD, 14);
        tableHeader.setFont(headerFont);
        //데이터 크기 조절
        DefaultTableCellRenderer renderer = (DefaultTableCellRenderer) jtPartTable.getDefaultRenderer(Object.class);
        Font dataFont = new Font(null, Font.PLAIN, 14);
        renderer.setFont(dataFont);
        renderer.setHorizontalAlignment(SwingConstants.CENTER); //데이터 가운데 정렬
		
        dtm = new DefaultTableModel();
	       
		CarManagerSubWindowEvt cmswe = new CarManagerSubWindowEvt(cmt,this);
		jbFunction.addActionListener(cmswe);
		
        
		//추가
		setLayout(null);
        
        add("Center", pTitle);
        
        add("Center", pMaintenencrNo);
		add("Center", pcarName);
		add("Center", pPhone);
		add("Center", preceiveDay);
		add("Center", pempName);
		add("Center", jtfMaintenencrNo);
		add("Center", jtfcarName);
		add("Center", jtfPhone);
		add("Center", jtfreceiveDay);
		add("Center", jtfempName);
		
		add("Center", pCarNo);
		add("Center", pClientName);
		add("Center", pClientEmail);
		add("Center", pReleaseDay);
		add("Center", pCarmileage);
		add("Center", jtfCarNo);
		add("Center", jtfClientName);
		add("Center", jtfClientEmail);
		add("Center", jtfReleaseDay);
		add("Center", jtfCarmileage);
		
		add("Center", pFaultDetail);
		
		add("Center", jtPartTable);
		add("Center", pMaintenanceDetail);
		add("Center", pNote);
		add("Center", pTotal);
		add("Center", jtfMaintenanceDetail);
		add("Center", jtfNote);
		add("Center", jtfTotal);
		
		add("Center", jbPartAdd);
		add("Center", jbCancle);
		add("Center", jbFunction);

	
		//위치 조절
		pTitle.setBounds(50, 20, 580, 30);
		scrollPane.setBounds(60, 50, 800, 720); 
		
		pMaintenencrNo.setBounds(50, 50, 145, 30);
		pcarName.setBounds(50, 80, 145, 30);
		pPhone.setBounds(50, 110, 145, 30);
		preceiveDay.setBounds(50, 140, 145, 30);
		pempName.setBounds(50, 170, 145, 30);
		//
		jtfMaintenencrNo.setBounds(195, 50, 145, 30);
		jtfcarName.setBounds(195, 80, 145, 30);
		jtfPhone.setBounds(195, 110, 145, 30);
		jtfreceiveDay.setBounds(195, 140, 145, 30);
		jtfempName.setBounds(195, 170, 145, 30);
		
		
		pCarNo.setBounds(340, 50, 145, 30);
		pClientName.setBounds(340, 80, 145, 30);
		pClientEmail.setBounds(340, 110, 145, 30);
		pReleaseDay.setBounds(340, 140, 145, 30);
		pCarmileage.setBounds(340, 170, 145, 30);
		//
		jtfCarNo.setBounds(485, 50, 145, 30);
		jtfClientName.setBounds(485, 80, 145, 30);
		jtfClientEmail.setBounds(485, 110, 145, 30);
		jtfReleaseDay.setBounds(485, 140, 145, 30);
		jtfCarmileage.setBounds(485, 170, 145, 30);
		
		pFaultDetail.setBounds(50, 200, 580, 30);
		
		pMaintenanceDetail.setBounds(50, 230, 290, 30);
		jtPartTable.setBounds(50, 270, 575, 100);
		pNote.setBounds(50, 380, 290, 30);
		pTotal.setBounds(50, 410, 290, 30);
		jtfMaintenanceDetail.setBounds(340, 230, 290, 30);
		jtfNote.setBounds(340, 380, 290, 30);
		jtfTotal.setBounds(340, 410, 290, 30);
		
		jbCancle.setBounds(180, 480, 120, 30);
		jbPartAdd.setBounds(380, 480, 120, 30);
		jbFunction.setBounds(380, 480, 120, 30);
		
		setBounds(cmt.getX()+520, cmt.getY()+190, 700, 600);
		
		scrollPane.setVisible(true);
		jlTitle.setVisible(true);
		
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
		
	} //CarManagerSubWindow


	public CarManagerTab getCmt() {
		return cmt;
	}


	public JLabel getJlTitle() {
		return jlTitle;
	}


	public Panel getpTitle() {
		return pTitle;
	}


	public Panel getpMaintenencrNo() {
		return pMaintenencrNo;
	}


	public Panel getPcarName() {
		return pcarName;
	}


	public Panel getpPhone() {
		return pPhone;
	}


	public Panel getPreceiveDay() {
		return preceiveDay;
	}


	public Panel getPempName() {
		return pempName;
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


	public Panel getpCarNo() {
		return pCarNo;
	}


	public Panel getpClientName() {
		return pClientName;
	}


	public Panel getpClientEmail() {
		return pClientEmail;
	}


	public Panel getpReleaseDay() {
		return pReleaseDay;
	}


	public Panel getpCarmileage() {
		return pCarmileage;
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


	public JTable getjtPartTable() {
		return jtPartTable;
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
