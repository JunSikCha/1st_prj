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

import kr.co.sist.user.event.HistoryEvt;

@SuppressWarnings("serial")
public class HistoryDesign extends JFrame {
	
	private HistoryEvt hdEvt;
	
	private JButton jbtToday;
	private JButton jbt7days;
	private JButton jbt1month;
	private JButton jbt3month;
	private JButton jbtMonthlyChk;
	private JButton jbtChk;
	private JButton jbtMain;
	private JButton jbtDetail;
	private JButton jbtNext;
	private JTextField jtfStartDate;
	private JTextField jtfEndDate;
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
		jbtDetail = new JButton("상세보기");
		jbtNext = new JButton("next >");
		
		jtfStartDate= new JTextField();
		jtfEndDate= new JTextField();
		dtmHistoryDesign = new DefaultTableModel() {
			//테이블 수정 못하게
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
			
		};
		jtHistoryDesign = new JTable(dtmHistoryDesign);
		jspHistoryDesign = new JScrollPane(jtHistoryDesign);
	    jtfStartDate.addActionListener(hdEvt);
	    jtfEndDate.addActionListener(hdEvt);
	    
	    JPanel jpNorth = new JPanel();
	    JPanel jpSouth = new JPanel();
	    jpNorth.add(jtfStartDate);
	    jpSouth.add(jtfEndDate);
	    
	    jlTitle.setBounds(10, 5, 150, 100);
		jlHistoryPeriod.setBounds(80, 130, 100, 30);
		jlHistory.setBounds(350, 180, 100, 100);
		jspHistoryDesign.setBounds(80,240,600,300);
		add(jspHistoryDesign);
		jtfStartDate.setBounds(200, 150, 150, 30);
		jtfEndDate.setBounds(380, 150, 150, 30);
		jbtToday.setBounds(200, 100, 80, 30);
		jbt7days.setBounds(300, 100, 80, 30);
		jbt1month.setBounds(400, 100, 80, 30);
		jbt3month.setBounds(500, 100, 80, 30);
		jbtMonthlyChk.setBounds(600, 100, 120, 30);
		jbtChk.setBounds(550, 150, 100, 30);
		jbtMain.setBounds(300, 600, 150, 30);
		jbtNext.setBounds(400, 550, 100, 30);
		jbtDetail.setBounds(250, 550, 100, 30);
	    
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
		add(jtfStartDate);
		add(jtfEndDate);
		add(jbtToday);
		add(jbt7days);
		add(jbt1month);
		add(jbt3month);
		add(jbtMonthlyChk);
		add(jbtChk);
		add(jbtMain);
		add(jbtNext);
		add(jbtDetail);
		
	    hdEvt = new HistoryEvt(this);
		jbtToday.addActionListener(hdEvt);
		jbt7days.addActionListener(hdEvt);
		jbt1month.addActionListener(hdEvt);
		jbt3month.addActionListener(hdEvt);
		jbtMonthlyChk.addActionListener(hdEvt);
		jbtChk.addActionListener(hdEvt);
		jbtNext.addActionListener(hdEvt);
		jbtDetail.addActionListener(hdEvt);
		jbtMain.addActionListener(hdEvt);
		
		
	    
		setBounds(600, 350, 800, 700);
		setVisible(true);
	}//HistoryDesign

	public HistoryEvt getHdEvt() {
		return hdEvt;
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
		return jbtDetail;
	}

	public JButton getJbtNext() {
		return jbtNext;
	}

	public JTextField getJtfStartDate() {
		return jtfStartDate;
	}

	public JTextField getJtfEndDate() {
		return jtfEndDate;
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

	public static void main(String args[]) {
		new HistoryDesign();
	}


	
}//class
