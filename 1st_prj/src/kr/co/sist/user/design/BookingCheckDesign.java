
package kr.co.sist.user.design;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import kr.co.sist.user.event.BookingCheckEvt;


@SuppressWarnings("serial")
public class BookingCheckDesign extends JFrame  {

	private BookingCheckEvt bcdEvt;

	private JButton jbtToday;
	private JButton jbt7days;
	private JButton jbt1month;
	private JButton jbt3month;
	private JButton jbtMonthlyChk;
	private JButton jbtChk;
	private JButton jbtMain;
	private JTextField jtfStartDate;
	private JTextField jtfEndDate;
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
      
		
		jtfStartDate = new JTextField();
		jtfEndDate = new JTextField();
		dtmBookingCheckDesign = new DefaultTableModel();
		jtBookingCheckDesign = new JTable(dtmBookingCheckDesign);
		jspBookingCheckDesign = new JScrollPane(jtBookingCheckDesign);
		jtfStartDate.addActionListener(bcdEvt);
		jtfEndDate.addActionListener(bcdEvt);
			
		JPanel jpNorth = new JPanel();
		JPanel jpSouth = new JPanel();
		jpNorth.add(jtfStartDate);
		jpSouth.add(jtfEndDate);
		
		///////////////////////////////////////////////////

		jlBookingCheckDesign.setBounds(10, 5, 150, 100);
		jlBookingPeriod.setBounds(80, 130, 100, 30);
		jlviewHistory.setBounds(350, 180, 100, 100);
		
		//////////////////////////////////////////////////////
		jspBookingCheckDesign.setBounds(45,240,700,350);
		add(jspBookingCheckDesign);
		///////////////////////////////////////////////////////
		jbtToday.setBounds(200, 100, 80, 30);
		jbt7days.setBounds(300, 100, 80, 30);
		jbt1month.setBounds(400, 100, 80, 30);
		jbt3month.setBounds(500, 100, 80, 30);
		jbtMonthlyChk.setBounds(600, 100, 120, 30);
		jbtChk.setBounds(550, 150, 100, 30);
		jbtMain.setBounds(320, 600, 140, 30);
		jtfStartDate.setBounds(200, 150, 150, 30);
		jtfEndDate.setBounds(380, 150, 150, 30);

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
		add(jtfStartDate);
		add(jtfEndDate);
		add(jlBookingCheckDesign);
		add(jlBookingPeriod);
		add(jlviewHistory);
		add(jbtToday);
		add(jbt7days);
		add(jbt1month);
		add(jbt3month);
		add(jbtMonthlyChk);
		add(jbtChk);
		add(jbtMain);

		bcdEvt = new BookingCheckEvt(this);
		jbtToday.addActionListener(bcdEvt);
		jbt7days.addActionListener(bcdEvt);
		jbt1month.addActionListener(bcdEvt);
		jbt3month.addActionListener(bcdEvt);
		jbtMonthlyChk.addActionListener(bcdEvt);
		jbtChk.addActionListener(bcdEvt);
		jbtMain.addActionListener(bcdEvt);

		setBounds(600, 350, 800, 700);
		setVisible(true);
	}
	
	
	
	public BookingCheckEvt getBcdEvt() {
		return bcdEvt;
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



	public JTextField getJtfStartDate() {
		return jtfStartDate;
	}



	public JTextField getJtfEndDate() {
		return jtfEndDate;
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



	public static void main(String args[]) {
		new BookingCheckDesign();
	}




	}
