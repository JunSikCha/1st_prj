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
public class HistoryDesign extends JFrame {
	
	private HistoryDesignEvt hdEvt;
	
	private JLabel jlTitle;
	private JLabel jlHistoryPeriod;
	private JLabel jlHistory;
	private JButton jbtToday;
	private JButton jbt7days;
	private JButton jbt1month;
	private JButton jbt3month;
	private JButton jbtMonthlyChk;
	private JButton jbtChk;
	private JButton jbtMain;
	private JButton jbtDetail;
	private JButton jbtPrev;
	private JButton jbtNext;
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
	private JScrollPane jspHistoryDesign;
	private DefaultTableModel dtmHistoryDesign;
	private JTable jtHistoryDesign;
	
	public HistoryDesign() {
		super("차량 정비 내역");
		JLabel  jlTitle = new JLabel("차량정비내역");
		JLabel  jlHistoryPeriod = new JLabel("조회기간");
		JLabel  jlHistory = new JLabel("조회내역");
		jbtToday = new JButton("오늘");
		jbt7days = new JButton("7일");
		jbt1month = new JButton("1개월");
		jbt3month = new JButton("3개월");
		jbtMonthlyChk = new JButton("월별조회");
		jbtChk = new JButton("조회");
		jbtMain = new JButton("메인화면으로");
		jbtDetail = new JButton("상세");
		jbtPrev = new JButton("<prev");
		jbtNext = new JButton("next>");
		
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
		dtmHistoryDesign = new DefaultTableModel();
		jtHistoryDesign = new JTable(dtmHistoryDesign);
		jspHistoryDesign = new JScrollPane(jtHistoryDesign);
	    jcbStartDate.addActionListener(hdEvt);
	    jcbEndDate.addActionListener(hdEvt);
	    
	    JPanel jpNorth = new JPanel();
	    JPanel jpSouth = new JPanel();
	    jpNorth.add(jcbStartDate);
	    jpSouth.add(jcbEndDate);
	    
	    jlTitle.setBounds(10, 5, 150, 100);
		jlHistoryPeriod.setBounds(80, 130, 100, 30);
		jlHistory.setBounds(350, 180, 100, 100);
		jspHistoryDesign.setBounds(90,240,600,400);
		add(jspHistoryDesign);
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
		jlTitle.setFont(titleFont);
		Font labelFont = new Font("SansSerif", Font.BOLD, 13);
		jbtToday.setFont(labelFont);
		jbt7days.setFont(labelFont);
		jbt1month.setFont(labelFont);
		jbt3month.setFont(labelFont);
		jbtMonthlyChk.setFont(labelFont);
		jbtChk.setFont(labelFont);
		Font btnFont = new Font("SansSerif", Font.BOLD, 17);
		jlHistoryPeriod.setFont(btnFont);
		jlHistory.setFont(btnFont);
		jbtMain.setFont(btnFont);
		
		setLayout(null);
		add(jlTitle);
		add(jlHistoryPeriod);
		add(jlHistory);
		add(jcbStartDate);
		add(jcbEndDate);
		add(jbtToday);
		add(jbt7days);
		add(jbt1month);
		add(jbt3month);
		add(jbtMonthlyChk);
		add(jbtChk);
		add(jbtMain);
		
	    hdEvt = new HistoryDesignEvt(this);
		jbtToday.addActionListener(hdEvt);
		jbt7days.addActionListener(hdEvt);
		jbt1month.addActionListener(hdEvt);
		jbt3month.addActionListener(hdEvt);
		jbtMonthlyChk.addActionListener(hdEvt);
		jbtChk.addActionListener(hdEvt);
		jbtMain.addActionListener(hdEvt);
		
		
	    
		setBounds(600, 350, 800, 700);
		setVisible(true);
	}//HistoryDesign

	public JLabel getJlTitle() {
		return jlTitle;
	}

	public JLabel getJlHistoryPeriod() {
		return jlHistoryPeriod;
	}

	public JLabel getJlHistory() {
		return jlHistory;
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

	public JButton getJbtPrev() {
		return jbtPrev;
	}

	public JButton getJbtNext() {
		return jbtNext;
	}

	public JComboBox<String> getJcbStartDate() {
		return jcbStartDate;
	}

	public JComboBox<String> getJcbEndDate() {
		return jcbEndDate;
	}

	public DefaultComboBoxModel<String> getDcbmStartDate() {
		return dcbmStartDate;
	}

	public DefaultComboBoxModel<String> getDcbmEndDate() {
		return dcbmEndDate;
	}

	public JScrollPane getJspStartDate() {
		return jspStartDate;
	}

	public JScrollPane getJspEndDate() {
		return jspEndDate;
	}

	public DefaultTableModel getDtmStartDate() {
		return dtmStartDate;
	}

	public DefaultTableModel getDtmEndDate() {
		return dtmEndDate;
	}

	public JTable getJtaStartDate() {
		return jtaStartDate;
	}

	public JTable getJtaEndDate() {
		return jtaEndDate;
	}

	public JScrollPane getJspHistoryDesign() {
		return jspHistoryDesign;
	}

	public DefaultTableModel getDtmHistoryDesign() {
		return dtmHistoryDesign;
	}

	public JTable getJtHistoryDesign() {
		return jtHistoryDesign;
	}

	
}//class
