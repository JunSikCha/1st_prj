
package kr.co.sist.user.design;

import java.awt.Font;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

@SuppressWarnings("serial")
public class BookingCheckDesign extends JFrame {


	private JLabel jlBookingCheckDesign;
	private JLabel jlBookingPeriod;
	private JLabel jlviewHistory;
	private JLabel jlBookDate;
	private JLabel jlBookTime;
	private JLabel jldefectDetail;
	private JLabel jlBranch;
	private JLabel jlcondition;
	private JLabel jlrefusal;
	private JButton jbtToday;
	private JButton jbt7days;
	private JButton jbt1month;
	private JButton jbt3month;
	private JButton jbtMonthlyChk;
	private JButton jbtChk;
	private JButton jbtMain;
	private JButton jbtDetail;
	private JComboBox<String>jcbStartDate;
	private JComboBox<String>jcbEndDate;
	private DefaultComboBoxModel<String>dcbmStartDate;
	private DefaultComboBoxModel<String>dcbmEndDate;
	private JScrollPane jspStartDate;
	private JScrollPane jspEndDate;
	private DefaultTableModel dtmStartDate;
	private DefaultTableModel dtmEndDate;
	private JTable jtaStartDate;
	private JTable jtaEndDate;
	

	private JScrollPane jspBookingCheckDesign;
	private DefaultTableModel dtmBookingCheckDesign;
	private JTable jtBookingCheckDesign;

	public BookingCheckDesign() {
		super("예약 조회");
		JLabel jlBookingCheckDesign = new JLabel("예약조회");
		JLabel jlBookingPeriod = new JLabel("조회기간");
		JLabel jlviewHistory = new JLabel("조회내역");
		jbtToday = new JButton("오늘");
		jbt7days = new JButton("7일");
		jbt1month = new JButton("1개월");
		jbt3month = new JButton("3개월");
		jbtMonthlyChk = new JButton("월별조회");
		jbtChk = new JButton("조회");
		jbtMain = new JButton("메인화면으로");
		jbtDetail = new JButton("상세");

		/////////////////////////////////////////////////////////
		String[] StartDate= {"2010-01-01","2010-01-02","2010-01-03"};
		String[] EndDate= {"2023-09-01","2023-09-02","2023-09-03"};
		dcbmStartDate= new DefaultComboBoxModel<String>();
		dcbmEndDate= new DefaultComboBoxModel<String>();
		jcbStartDate= new JComboBox<String>(StartDate);
		jcbEndDate= new JComboBox<String>(EndDate);
		dtmStartDate = new DefaultTableModel(null,StartDate);
		dtmEndDate = new DefaultTableModel(null,EndDate);
		jtaStartDate = new JTable(dtmStartDate);
		jtaEndDate = new JTable(dtmEndDate);
		jspStartDate = new JScrollPane(jtaStartDate);
		jspEndDate = new JScrollPane(jtaEndDate);
		dtmBookingCheckDesign = new DefaultTableModel();
		jtBookingCheckDesign = new JTable(dtmBookingCheckDesign);
		jspBookingCheckDesign = new JScrollPane(jtBookingCheckDesign);
	    
	    JPanel jpNorth = new JPanel();
	    JPanel jpSouth = new JPanel();
	    jpNorth.add(jcbStartDate);
	    jpSouth.add(jcbEndDate);
	    
		///////////////////////////////////////////////////

		jlBookingCheckDesign.setBounds(10, 5, 150, 100);
		jlBookingPeriod.setBounds(80, 130, 100, 30);
		jlviewHistory.setBounds(350, 180, 100, 100);
		
		//////////////////////////////////////////////////////
		jspBookingCheckDesign.setBounds(90,240,600,400);
		add(jspBookingCheckDesign);
		///////////////////////////////////////////////////////
		jcbStartDate.setBounds(200, 150, 150, 30);
		jcbEndDate.setBounds(380, 150, 150, 30);
		jbtToday.setBounds(200, 100, 80, 30);
		jbt7days.setBounds(300, 100, 80, 30);
		jbt1month.setBounds(400, 100, 80, 30);
		jbt3month.setBounds(500, 100, 80, 30);
		jbtMonthlyChk.setBounds(600, 100, 120, 30);
		jbtChk.setBounds(550, 150, 100, 30);
		
		jbtMain.setBounds(340, 300, 100, 30);

		Font titleFont = new Font("SansSerif", Font.BOLD, 22);
		jlBookingCheckDesign.setFont(titleFont);
		jlBookingPeriod.setFont(titleFont);
		Font labelFont = new Font("SansSerif", Font.BOLD, 17);
		jlviewHistory.setFont(labelFont);
		jbtToday.setFont(labelFont);
		jbt7days.setFont(labelFont);
		jbt1month.setFont(labelFont);
		jbt3month.setFont(labelFont);
		jbtMonthlyChk.setFont(labelFont);
		jbtChk.setFont(labelFont);
		
		Font btnFont = new Font("SansSerif", Font.BOLD, 13);
		jbtMain.setFont(btnFont);

		setLayout(null);
		add(jlBookingCheckDesign);
		add(jlBookingPeriod);
		add(jlviewHistory);
		add(jcbStartDate);
		add(jcbEndDate);
		add(jbtToday);
		add(jbt7days);
		add(jbt1month);
		add(jbt3month);
		add(jbtMonthlyChk);
		add(jbtChk);
		add(jbtMain);


		setBounds(600, 350, 800, 700);
		setVisible(true);

	}// BookingCheckDesign


	public JLabel getJlBookingCheckDesign() {
		return jlBookingCheckDesign;
	}

	public JLabel getJlBookingPeriod() {
		return jlBookingPeriod;
	}

	public JLabel getJlviewHistory() {
		return jlviewHistory;
	}


	public JLabel getJlBookDate() {
		return jlBookDate;
	}

	public JLabel getJlBookTime() {
		return jlBookTime;
	}

	public JLabel getJldefectDetail() {
		return jldefectDetail;
	}

	public JLabel getJlBranch() {
		return jlBranch;
	}

	public JLabel getJlcondition() {
		return jlcondition;
	}

	public JLabel getJlrefusal() {
		return jlrefusal;
	}


	public JButton getJbtToday() {
		return jbtToday;
	}

	public JButton getJbt7days() {
		return jbt7days;
	}

	public JButton getJbt1month() {
		return jbt1month;
	}

	public JButton getJbt3month() {
		return jbt3month;
	}

	public JButton getJbtMonthlyChk() {
		return jbtMonthlyChk;
	}

	public JButton getJbtChk() {
		return jbtChk;
	}

	public JButton getJbtMain() {
		return jbtMain;
	}


	public JButton getJbtDetail() {
		return jbtDetail;
	}

	public JScrollPane getJspBookingCheckDesign() {
		return jspBookingCheckDesign;
	}

	public DefaultTableModel getDtmBookingCheckDesign() {
		return dtmBookingCheckDesign;
	}

	public JTable getJtBookingCheckDesign() {
		return jtBookingCheckDesign;
	}

	
	

}// class
