 package kr.co.sist.user.design;

import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import kr.co.sist.user.event.RegistCarEvt;

@SuppressWarnings("serial")
public class RegistCarDesign extends JFrame {
	
	private  RegistCarEvt rcEvt;
	private JLabel jlModel;
	private JLabel jlCarNum;
	private JLabel jlDistance;
	private DefaultComboBoxModel<String> dcbmModel;
	private JComboBox<String>jcbModel;
	private JScrollPane jspRegisterCarDesign;
	private JTextField jtfCarnum;
	private JTextField jtfDistance;
	private JButton jbtCancel;
	private JButton jbtComplete;
	private DefaultTableModel dtmRegisterCarDesign;
	private JTable jtRegisterCarDesign;
	
	public RegistCarDesign() {
		super("차량 등록");
		JLabel jlRegist = new JLabel("차량 정보 등록");
		JLabel jlModel = new JLabel("모델명");
		JLabel jlCarnum = new JLabel("차량번호");
		JLabel jlDistance = new JLabel("주행거리");
		
		jtfCarnum = new JTextField();
		jtfDistance = new JTextField();		
		jbtComplete = new JButton("완료");
		jbtCancel = new JButton("X");
		
		dcbmModel = new DefaultComboBoxModel<String>();
		jcbModel = new JComboBox<String>(dcbmModel);
		jtRegisterCarDesign = new JTable(dtmRegisterCarDesign);
		jspRegisterCarDesign = new JScrollPane(jtRegisterCarDesign);
		
		
		jcbModel.addActionListener(rcEvt);
		JPanel jpNorth = new JPanel();
		jpNorth.add(jcbModel);
		
		 jlRegist.setBounds(10, 2, 200, 50);
		 jlModel.setBounds(100, 40, 100, 100);
		 jcbModel.setBounds(100, 110, 200, 30);
		 jlCarnum.setBounds(100, 140, 100, 100);
		 jtfCarnum.setBounds(100, 200, 200, 30);
		 jlDistance.setBounds(100, 260, 200, 30);
		 jtfDistance.setBounds(100, 290, 200, 30);
		 jbtComplete.setBounds(0, 413, 400, 50);
		 jbtCancel.setBounds(334, 2, 50, 30);
		
		 Font titleFont = new Font("SansSerif", Font.BOLD, 18);
	      jlRegist.setFont(titleFont);
	      Font labelFont = new Font("SansSerif", Font.BOLD, 13);
	      jlModel.setFont(labelFont);
	      jlCarnum.setFont(labelFont);
	      jlDistance.setFont(labelFont);
	      Font btnFont = new Font("SansSerif", Font.BOLD, 15);
	      jbtComplete.setFont(btnFont);
	    
		 
		 setLayout(null);
		 add(jlRegist);
		 add(jlModel);
		 add("North",jpNorth);
		 add(jcbModel);
		 add(jlCarnum);
		 add(jtfCarnum);
		 add(jlDistance);
		 add(jtfDistance);
		 add(jbtComplete);
		 add(jbtCancel);
		 
		 rcEvt= new RegistCarEvt(this);
		 jbtComplete.addActionListener(rcEvt);
		 jbtCancel.addActionListener(rcEvt);
		
		setBounds(700,280,400,500);
		setVisible(true);
		addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				dispose();
			}
			
		});
		
	}//RegistCarDesign
	
	public RegistCarEvt getRcEvt() {
		return rcEvt;
	}


	public void setRcEvt(RegistCarEvt rcEvt) {
		this.rcEvt = rcEvt;
	}



	public JLabel getJlModel() {
		return jlModel;
	}


	public void setJlModel(JLabel jlModel) {
		this.jlModel = jlModel;
	}


	public JLabel getJlCarNum() {
		return jlCarNum;
	}


	public void setJlCarNum(JLabel jlCarNum) {
		this.jlCarNum = jlCarNum;
	}

	
	public JLabel getJlDistance() {
		return jlDistance;
	}


	public void setJlDistance(JLabel jlDistance) {
		this.jlDistance = jlDistance;
	}


	public DefaultComboBoxModel<String> getDcbmModel() {
		return dcbmModel;
	}


	public void setDcbmjcbRegisterCarDesign(DefaultComboBoxModel<String> dcbmjcbRegisterCarDesign) {
		this.dcbmModel = dcbmjcbRegisterCarDesign;
	}



	public JComboBox<String> getJcbModel() {
		return jcbModel;
	}






	public void setJcbRegisterCarDesign(JComboBox<String> jcbRegisterCarDesign) {
		this.jcbModel = jcbRegisterCarDesign;
	}






	public JScrollPane getJspRegisterCarDesign() {
		return jspRegisterCarDesign;
	}






	public void setJspRegisterCarDesign(JScrollPane jspRegisterCarDesign) {
		this.jspRegisterCarDesign = jspRegisterCarDesign;
	}






	public JTextField getJtfCarnum() {
		return jtfCarnum;
	}






	public void setJtfCarnum(JTextField jtfCarnum) {
		this.jtfCarnum = jtfCarnum;
	}






	public JTextField getJtfDistance() {
		return jtfDistance;
	}






	public void setJtfDistance(JTextField jtfDistance) {
		this.jtfDistance = jtfDistance;
	}






	public JButton getJbtCancel() {
		return jbtCancel;
	}






	public void setJbtCancel(JButton jbtCancel) {
		this.jbtCancel = jbtCancel;
	}






	public JButton getJbtComplete() {
		return jbtComplete;
	}






	public void setJbtComplete(JButton jbtComplete) {
		this.jbtComplete = jbtComplete;
	}






	public DefaultTableModel getDtmRegisterCarDesign() {
		return dtmRegisterCarDesign;
	}






	public void setDtmRegisterCarDesign(DefaultTableModel dtmRegisterCarDesign) {
		this.dtmRegisterCarDesign = dtmRegisterCarDesign;
	}






	public JTable getJtRegisterCarDesign() {
		return jtRegisterCarDesign;
	}






	public void setJtRegisterCarDesign(JTable jtRegisterCarDesign) {
		this.jtRegisterCarDesign = jtRegisterCarDesign;
	}


	public static void main(String[] args) {
		new RegistCarDesign();
	}
	

}//class
