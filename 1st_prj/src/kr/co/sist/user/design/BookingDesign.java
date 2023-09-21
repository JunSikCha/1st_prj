package kr.co.sist.user.design;

import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;

import kr.co.sist.user.event.BookingEvt;

public class BookingDesign extends JFrame {
	
	private BookingEvt bdEvt;
	private JComboBox<String>jcbBranch;
	private JComboBox<String>jcbBookYear;
	private JComboBox<String>jcbBookMonth;
	private JComboBox<String>jcbBookDay;
	private JComboBox<String>jcbBookTime;
	private DefaultComboBoxModel<String>dcbmjcbBranch;
	private DefaultComboBoxModel<String>dcbmjcbBookYear;
	private DefaultComboBoxModel<String>dcbmjcbBookMonth;
	private DefaultComboBoxModel<String>dcbmjcbBookday;
	private DefaultComboBoxModel<String>dcbmjcbBookTime;
	private JScrollPane jspjcbBranch;
	private JScrollPane jspjcbBookYear;
	private JScrollPane jspjcbBookMonth;
	private JScrollPane jspjcbBookDay;
	private JScrollPane jspjcbBookTime;
	private DefaultTableModel dtmjcbBranch;
	private DefaultTableModel dtmjcbBookYear;
	private DefaultTableModel dtmjcbBookMonth;
	private DefaultTableModel dtmjcbBookDay;
	private DefaultTableModel dtmjcbBookTime;
	private JTextArea jtaDetail;
	private JTable jtBranch;
	private JTable jtBookYear;
	private JTable jtBookMonth;
	private JTable jtBookDay;
	private JTable jtBookTime;
	private JButton jbtCancel;
	private JButton jbtComplete;
	

	public BookingDesign() {
		super("정비예약");
		
		
		JLabel jlTitle = new JLabel("정비예약");
		JLabel jlBranch = new JLabel("지점명");
		JLabel  jlBookdate = new JLabel("예약일자");
		JLabel  jlBookTime = new JLabel("예약시간");
		JLabel  jlDetail = new JLabel("간략한 설명");
		jbtComplete = new JButton("예약");
		jbtCancel = new JButton("취소");
		
		dcbmjcbBranch=new DefaultComboBoxModel<String>();
		dcbmjcbBookYear=new DefaultComboBoxModel<String>();
		dcbmjcbBookMonth=new DefaultComboBoxModel<String>();
		dcbmjcbBookday=new DefaultComboBoxModel<String>();
		dcbmjcbBookTime=new DefaultComboBoxModel<String>();
		jcbBranch= new JComboBox<String>();
		jcbBookYear= new JComboBox<String>();
		jcbBookMonth= new JComboBox<String>();
		jcbBookDay= new JComboBox<String>();
		jcbBookTime= new JComboBox<String>();
		
		 jtBranch = new JTable(dtmjcbBranch);
		 jtBookYear = new JTable(dtmjcbBookYear);
		 jtBookMonth = new JTable(dtmjcbBookMonth);
		 jtBookDay = new JTable(dtmjcbBookDay);
		 jtBookTime = new JTable(dtmjcbBookTime);
		 jspjcbBranch = new JScrollPane(jtBranch);
		 jspjcbBookYear = new JScrollPane(jtBookYear);
		 jspjcbBookMonth = new JScrollPane(jtBookMonth);
		 jspjcbBookDay = new JScrollPane(jtBookDay);
		 jspjcbBookTime = new JScrollPane(jtBookTime);
		 jtaDetail = new JTextArea("내용을 입력해주세요");
		 jtaDetail.setBackground(java.awt.Color.WHITE);
		 jtaDetail.setText("내용을 입력해주세요");
		 
		 jcbBranch.addActionListener(bdEvt);
		 jcbBookYear.addActionListener(bdEvt);
		 jcbBookMonth.addActionListener(bdEvt);
		 jcbBookDay.addActionListener(bdEvt);
		 jcbBookTime.addActionListener(bdEvt);
		 jbtComplete.addActionListener(bdEvt);
		 jbtCancel.addActionListener(bdEvt);
		
		 JPanel jpNorth = new JPanel();
		 JPanel jpMiddle = new JPanel();
		 JPanel jpSouth = new JPanel();
		 jpNorth.add(jcbBranch);
		 jpMiddle.add(jcbBookYear);
		 jpMiddle.add(jcbBookMonth);
		 jpMiddle.add(jcbBookDay);
		 jpSouth.add(jcbBookTime);
		 
		 jlTitle.setBounds(10, 2, 200, 50);
		 jlBranch.setBounds(90, 20, 100, 100);
		 jcbBranch.setBounds(90, 90, 200, 30);
		 jlBookdate.setBounds(90, 100, 100, 100);
		 jcbBookYear.setBounds(90, 170, 80, 30);
		 jcbBookMonth.setBounds(180, 170, 50, 30);
		 jcbBookDay.setBounds(240, 170, 50, 30);
		 jlBookTime.setBounds(90, 210, 200, 30);
		 jcbBookTime.setBounds(90, 240, 200, 30);
		 jlDetail.setBounds(90, 280, 200, 50);
		 jtaDetail.setBounds(90, 320, 200, 50);
		 jbtComplete.setBounds(60, 415, 100, 40);
		 jbtCancel.setBounds(200, 415, 100, 40);
		 
		 
		 Font titleFont = new Font("SansSerif", Font.BOLD, 20);
	      jlTitle.setFont(titleFont);
	      Font labelFont = new Font("SansSerif", Font.BOLD, 17);
	     jlBranch.setFont(labelFont);
	     jlBookdate.setFont(labelFont);
	     jlBookTime.setFont(labelFont);
	     jlDetail.setFont(labelFont);
	      Font btnFont = new Font("SansSerif", Font.BOLD, 15);
	      jbtComplete.setFont(btnFont);
	      jbtCancel.setFont(btnFont);
		 
	      setLayout(null);
	      add(jlTitle);
	      add(jlBranch);
	      add(jlBookdate);
	      add(jlBookTime);
	      add(jlDetail);
	      add(jtaDetail);
	      add(jcbBranch);
	      add(jcbBookYear);
	      add(jcbBookMonth);
	      add(jcbBookDay);
	      add(jcbBookTime);
	      add(jbtComplete);
	      add(jbtCancel);
	      
	      bdEvt = new  BookingEvt (this);
	      
	      jcbBranch.addActionListener(bdEvt);
	      jcbBookYear.addActionListener(bdEvt);
	      jcbBookMonth.addActionListener(bdEvt);
	      jcbBookDay.addActionListener(bdEvt);
	      jcbBookTime.addActionListener(bdEvt);
	      
	      jbtComplete.addActionListener(bdEvt);
		  jbtCancel.addActionListener(bdEvt);
		 
		setBounds(700,280,400,500);
		setVisible(true);
		addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				dispose();
			}
			
		});
		
	}//BookingCheckDesign


	public BookingEvt getBdEvt() {
		return bdEvt;
	}


	public JComboBox<String> getJcbBranch() {
		return jcbBranch;
	}


	public JComboBox<String> getJcbBookYear() {
		return jcbBookYear;
	}


	public JComboBox<String> getJcbBookMonth() {
		return jcbBookMonth;
	}


	public JComboBox<String> getJcbBookDay() {
		return jcbBookDay;
	}


	public JComboBox<String> getJcbBookTime() {
		return jcbBookTime;
	}


	public DefaultComboBoxModel<String> getDcbmjcbBranch() {
		return dcbmjcbBranch;
	}


	public DefaultComboBoxModel<String> getDcbmjcbBookYear() {
		return dcbmjcbBookYear;
	}


	public DefaultComboBoxModel<String> getDcbmjcbBookMonth() {
		return dcbmjcbBookMonth;
	}


	public DefaultComboBoxModel<String> getDcbmjcbBookday() {
		return dcbmjcbBookday;
	}


	public DefaultComboBoxModel<String> getDcbmjcbBookTime() {
		return dcbmjcbBookTime;
	}


	public JScrollPane getJspjcbBranch() {
		return jspjcbBranch;
	}


	public JScrollPane getJspjcbBookYear() {
		return jspjcbBookYear;
	}


	public JScrollPane getJspjcbBookMonth() {
		return jspjcbBookMonth;
	}


	public JScrollPane getJspjcbBookDay() {
		return jspjcbBookDay;
	}


	public JScrollPane getJspjcbBookTime() {
		return jspjcbBookTime;
	}


	public DefaultTableModel getDtmjcbBranch() {
		return dtmjcbBranch;
	}


	public DefaultTableModel getDtmjcbBookYear() {
		return dtmjcbBookYear;
	}


	public DefaultTableModel getDtmjcbBookMonth() {
		return dtmjcbBookMonth;
	}


	public DefaultTableModel getDtmjcbBookDay() {
		return dtmjcbBookDay;
	}


	public DefaultTableModel getDtmjcbBookTime() {
		return dtmjcbBookTime;
	}


	public JTextArea getJtaDetail() {
		return jtaDetail;
	}


	public JTable getJtBranch() {
		return jtBranch;
	}


	public JTable getJtBookYear() {
		return jtBookYear;
	}


	public JTable getJtBookMonth() {
		return jtBookMonth;
	}


	public JTable getJtBookDay() {
		return jtBookDay;
	}


	public JTable getJtBookTime() {
		return jtBookTime;
	}


	public JButton getJbtCancel() {
		return jbtCancel;
	}


	public JButton getJbtComplete() {
		return jbtComplete;
	}


	public void setJcbBookDay(JComboBox<String> jcbBookDay) {
		this.jcbBookDay = jcbBookDay;
	}



	
	
}//class