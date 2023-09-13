package kr.co.sist.user.design;

import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JToggleButton;
import javax.swing.table.DefaultTableModel;

import project.db용.RecallDesignEvt3;

@SuppressWarnings("serial")
public class RecallDesign extends JFrame {
	private RecallDesignEvt rdEvt;
	private JLabel jlTitle;
	private JLabel jlSubTitle;
	private JLabel jlCarModel;
	private JLabel jlCarModel2;
	private JLabel jlRecallImg;
	private JLabel jlCarname;
	private JLabel jlRecallReason;
	private JLabel jlRecallReason2;
	private JLabel jlRecallDate;
	private JLabel jlRecallDate2;
	private JButton jbtCancel;
	
	private JScrollPane jspRecallDesign;
	private DefaultTableModel dtmRecallDesign;
	private JTable jtRecallDesign;
	
	
	public RecallDesign() {
		super("리콜여부");
		JLabel jlTitle = new JLabel("리콜여부확인");
		JLabel jlSubTitle = new JLabel("대상자동차: ");
		JLabel  jlCarModel = new JLabel("BMW i4 M50");
		JLabel  jlCarModel2 = new JLabel("BMW i4 M50");
		JLabel  jlRecallImg = new JLabel("리콜 이미지");
		JLabel  jlCarname = new JLabel("차명");
		JLabel  jlRecallReason = new JLabel("리콜사유");
		JLabel  jlRecallReason2 = new JLabel("냉각수");
		JLabel  jlRecallDate = new JLabel("리콜날짜");
		JLabel  jlRecallDate2 = new JLabel("2023.08.22");
	    jbtCancel = new JButton("X");
	    
	    dtmRecallDesign = new DefaultTableModel();
	    jtRecallDesign = new JTable(dtmRecallDesign);
	    jspRecallDesign = new JScrollPane(jtRecallDesign);
	    
	  
	    
	    jspRecallDesign.setBounds(110,400,800,800);
	    add(jspRecallDesign);
	    
	    
	    setLayout(null);
        add(jlTitle);
        add(jlSubTitle);
        add(jlCarModel);
        add(jlCarModel2);
        add(jlRecallImg);
        add(jlCarname);
        add(jlRecallReason);
        add(jlRecallReason2);
        add(jlRecallDate);
        add(jlRecallDate2);
        add( jbtCancel);
        
        JLabel imgLabel = new JLabel();
        ImageIcon icon = new ImageIcon(RecallDesign.class.getResource("/project/bmw.JPG"));
        imgLabel.setIcon(icon);
        imgLabel.setBounds(150, 150, 300, 200);
        imgLabel.setHorizontalAlignment(JLabel.LEFT);
        getContentPane().add(imgLabel);

        JLabel imgLabel2 = new JLabel(); // imgLabel2 생성
        ImageIcon icon2 = new ImageIcon(RecallDesign.class.getResource("/project/recall.JPG"));
        imgLabel2.setIcon(icon2); // imgLabel2에 이미지 아이콘 설정
        imgLabel2.setBounds(600, 150, 300, 200); // 두 번째 이미지의 위치 설정
        imgLabel2.setHorizontalAlignment(JLabel.RIGHT); // 두 번째 이미지의 가로 정렬 설정
        getContentPane().add(imgLabel2);
        
        rdEvt = new RecallDesignEvt(this);
        jbtCancel.addActionListener(rdEvt);
        
        jlTitle.setBounds(430, 15, 180, 50);
        Font titleFont = new Font("SansSerif", Font.BOLD, 28);
        jlTitle.setFont(titleFont);
        jlSubTitle.setBounds(150, 80, 180, 50);
        jlCarModel.setBounds(300, 80, 200, 50);
        jlCarModel2.setBounds(150, 500, 200, 50);
        jlRecallImg.setBounds(600, 80, 200, 50);
        jlCarname.setBounds(150, 450, 140, 50);
        jlRecallReason.setBounds(450, 450, 140, 50);
        jlRecallReason2.setBounds(450, 500, 140, 50);
        jlRecallDate.setBounds(700, 450, 140, 50);
        jlRecallDate2.setBounds(700, 500, 140, 50);
        Font subTitleFont = new Font("SansSerif", Font.BOLD, 25);
        jlSubTitle.setFont(subTitleFont);
        jlCarModel.setFont(subTitleFont);
        jlCarModel2.setFont(subTitleFont);
        jlRecallImg.setFont(subTitleFont);
        jlCarname.setFont(subTitleFont);
        jlRecallReason.setFont(subTitleFont);
        jlRecallReason2.setFont(subTitleFont);
        jlRecallDate.setFont(subTitleFont);
        jlRecallDate2.setFont(subTitleFont);
        jbtCancel.setBounds(935, 2, 50, 30);
        Font btnFont = new Font("SansSerif", Font.BOLD, 20);
        jbtCancel.setFont(btnFont);
        
		setBounds(600,350,1000,700);
		setVisible(true);
		
	}
	


	public JScrollPane getJspRecallDesign() {
		return jspRecallDesign;
	}






	public DefaultTableModel getDtmRecallDesign() {
		return dtmRecallDesign;
	}






	public JTable getJtRecallDesign() {
		return jtRecallDesign;
	}






	public RecallDesignEvt getRdEvt() {
		return rdEvt;
	}






	public JLabel getJlTitle() {
		return jlTitle;
	}






	public JLabel getJlSubTitle() {
		return jlSubTitle;
	}






	public JLabel getJlCarModel() {
		return jlCarModel;
	}






	public JLabel getJlCarModel2() {
		return jlCarModel2;
	}






	public JLabel getJlRecallImg() {
		return jlRecallImg;
	}






	public JLabel getJlCarname() {
		return jlCarname;
	}






	public JLabel getJlRecallReason() {
		return jlRecallReason;
	}






	public JLabel getJlRecallReason2() {
		return jlRecallReason2;
	}






	public JLabel getJlRecallDate() {
		return jlRecallDate;
	}






	public JLabel getJlRecallDate2() {
		return jlRecallDate2;
	}






	public JButton getJbtCancel() {
		return jbtCancel;
	}






	public static void main(String[] args) {

	}

}
