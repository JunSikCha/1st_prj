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
	private ClientMainDesign cmd;
	
	private  RegistCarEvt rcEvt;
	private JLabel jlModel;
	private JLabel jlCarNum;
	private JLabel jlDistance;
	private DefaultComboBoxModel<String> dcbmModel;
	private JComboBox<String>jcbModel;
	private JScrollPane jspRegisterCarDesign;
	private JTextField jtfCarnum;
	private JTextField jtfDistance;
	private JButton jbtComplete;
	private DefaultTableModel dtmRegisterCarDesign;
	private JTable jtRegisterCarDesign;
	
	public RegistCarDesign(ClientMainDesign cmd) {
		this.cmd=cmd;
		JLabel jlRegist = new JLabel("차량 정보 등록");
		JLabel jlModel = new JLabel("모델명");
		JLabel jlCarnum = new JLabel("차량번호");
		JLabel jlDistance = new JLabel("주행거리");
		
		jtfCarnum = new JTextField();
		jtfDistance = new JTextField();		
		jbtComplete = new JButton("완료");
		
		dcbmModel = new DefaultComboBoxModel<String>();
		jcbModel = new JComboBox<String>(dcbmModel);
		jtRegisterCarDesign = new JTable(dtmRegisterCarDesign);
		jspRegisterCarDesign = new JScrollPane(jtRegisterCarDesign);
		
		
		jcbModel.addActionListener(rcEvt);
		JPanel jpNorth = new JPanel();
		jpNorth.add(jcbModel);
		
		 jlRegist.setBounds(105, 50, 200, 50);
		 jlModel.setBounds(100, 100, 100, 100);
		 jcbModel.setBounds(90, 170, 200, 30);
		 jlCarnum.setBounds(100, 180, 100, 100);
		 jtfCarnum.setBounds(90, 250, 200, 30);
		 jlDistance.setBounds(100, 290, 200, 30);
		 jtfDistance.setBounds(90, 320, 200, 30);
		 jbtComplete.setBounds(140, 400, 80, 30);
		
		
		 Font titleFont = new Font("SansSerif", Font.BOLD, 23);
	      jlRegist.setFont(titleFont);
	      Font labelFont = new Font("SansSerif", Font.BOLD, 17);
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
		 
		 rcEvt= new RegistCarEvt(this);
		 jbtComplete.addActionListener(rcEvt);
		
		 setBounds(cmd.getX()+300,cmd.getY()+30,380,500);
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


}//class
