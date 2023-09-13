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
	private JLabel jlTitle;
	private JLabel jlBranch;
	private JLabel jlBookdate;
	private JLabel jlBookTime;
	private JLabel jlDetail;
	private JComboBox<String>jcbBranch;
	private JComboBox<String>jcbBookdate;
	private JComboBox<String>jcbBookTime;
	private DefaultComboBoxModel<String>dcbmjcbBranch;
	private DefaultComboBoxModel<String>dcbmjcbBookdate;
	private DefaultComboBoxModel<String>dcbmjcbBookTime;
	private JScrollPane jspjcbBranch;
	private JScrollPane jspjcbBookdate;
	private JScrollPane jspjcbBookTime;
	private DefaultTableModel dtmjcbBranch;
	private DefaultTableModel dtmjcbBookdate;
	private DefaultTableModel dtmjcbBookTime;
	private JTextArea jtaDetail;
	private JTable jtBranch;
	private JTable jtBookdate;
	private JTable jtBookTime;
	private JButton jbtCancel;
	private JButton jbtComplete;
	private JButton jbtX;
	

	public BookingDesign() {
		super("정비예약");
		
		
		JLabel jlTitle = new JLabel("정비예약");
		JLabel jlBranch = new JLabel("지점명");
		JLabel  jlBookdate = new JLabel("예약일자");
		JLabel  jlBookTime = new JLabel("예약시간");
		JLabel  jlDetail = new JLabel("간략한 설명");
		jbtComplete = new JButton("예약");
		jbtCancel = new JButton("취소");
		jbtX = new JButton("X");
		
		
		String[] BranchName= {"강남점","분당점","부산점"};
		String[] DateName= {"2023.08.01","2023.08.02","2023.08.03"};
		String[] TimeName= {"2PM","3PM","4PM"};
	
		dcbmjcbBranch=new DefaultComboBoxModel<String>();
		dcbmjcbBookdate=new DefaultComboBoxModel<String>();
		dcbmjcbBookTime=new DefaultComboBoxModel<String>();
		jcbBranch= new JComboBox<String>(BranchName);
		jcbBookdate= new JComboBox<String>(DateName);
		jcbBookTime= new JComboBox<String>(TimeName);
		dtmjcbBranch = new DefaultTableModel(null,BranchName);
		dtmjcbBookdate = new DefaultTableModel(null,DateName);
		dtmjcbBookTime = new DefaultTableModel(null,TimeName);
		 jtBranch = new JTable(dtmjcbBranch);
		 jtBookdate = new JTable(dtmjcbBookdate);
		 jtBookTime = new JTable(dtmjcbBookTime);
		 jspjcbBranch = new JScrollPane(jtBranch);
		 jspjcbBookdate = new JScrollPane(jtBookdate);
		 jspjcbBookTime = new JScrollPane(jtBookTime);
		 jtaDetail = new JTextArea("내용을 입력해주세요");
		 jtaDetail.setBackground(java.awt.Color.WHITE);
		 jtaDetail.setText("내용을 입력해주세요");
		 
		 jcbBranch.addActionListener(bdEvt);
		 jcbBookdate.addActionListener(bdEvt);
		 jcbBookTime.addActionListener(bdEvt);
		 jbtComplete.addActionListener(bdEvt);
		 jbtCancel.addActionListener(bdEvt);
		
		 JPanel jpNorth = new JPanel();
		 JPanel jpMiddle = new JPanel();
		 JPanel jpSouth = new JPanel();
		 jpNorth.add(jcbBranch);
		 jpMiddle.add(jcbBookdate);
		 jpSouth.add(jcbBookTime);
		 
		 jlTitle.setBounds(10, 2, 200, 50);
		 jlBranch.setBounds(100, 20, 100, 100);
		 jcbBranch.setBounds(100, 90, 200, 30);
		 jlBookdate.setBounds(100, 100, 100, 100);
		 jcbBookdate.setBounds(100, 160, 200, 30);
		 jlBookTime.setBounds(100, 210, 200, 30);
		 jcbBookTime.setBounds(100, 240, 200, 30);
		 jlDetail.setBounds(100, 280, 200, 50);
		 jtaDetail.setBounds(100, 350, 200, 50);
		 jbtComplete.setBounds(70, 415, 100, 40);
		 jbtCancel.setBounds(220, 415, 100, 40);
		 jbtX.setBounds(334, 2, 50, 30);
		 
		 
		 Font titleFont = new Font("SansSerif", Font.BOLD, 18);
	      jlTitle.setFont(titleFont);
	      Font labelFont = new Font("SansSerif", Font.BOLD, 15);
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
	      add(jcbBranch);
	      add(jcbBookdate);
	      add(jcbBookTime);
	      add(jbtComplete);
	      add(jbtCancel);
	      add(jbtX);
	      
	      bdEvt = new  BookingEvt (this);
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


	public JButton getJbtX() {
		return jbtX;
	}


	public BookingEvt getBdEvt() {
		return bdEvt;
	}


	public JLabel getJlTitle() {
		return jlTitle;
	}


	public JLabel getJlBranch() {
		return jlBranch;
	}


	public JLabel getJlBookdate() {
		return jlBookdate;
	}


	public JLabel getJlBookTime() {
		return jlBookTime;
	}


	public JLabel getJlDetail() {
		return jlDetail;
	}


	public JComboBox<String> getJcbBranch() {
		return jcbBranch;
	}


	public JComboBox<String> getJcbBookdate() {
		return jcbBookdate;
	}


	public JComboBox<String> getJcbBookTime() {
		return jcbBookTime;
	}


	public DefaultComboBoxModel<String> getDcbmjcbBranch() {
		return dcbmjcbBranch;
	}


	public DefaultComboBoxModel<String> getDcbmjcbBookdate() {
		return dcbmjcbBookdate;
	}


	public DefaultComboBoxModel<String> getDcbmjcbBookTime() {
		return dcbmjcbBookTime;
	}


	public JScrollPane getJspjcbBranch() {
		return jspjcbBranch;
	}


	public JScrollPane getJspjcbBookdate() {
		return jspjcbBookdate;
	}


	public JScrollPane getJspjcbBookTime() {
		return jspjcbBookTime;
	}


	public DefaultTableModel getDtmjcbBranch() {
		return dtmjcbBranch;
	}


	public DefaultTableModel getDtmjcbBookdate() {
		return dtmjcbBookdate;
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


	public JTable getJtBookdate() {
		return jtBookdate;
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
	
	
	
}//class