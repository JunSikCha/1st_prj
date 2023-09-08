package clientDesign;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

@SuppressWarnings("serial")
public class RegistCarDesign extends JFrame {
	
//	private  RegistCarEvt rcEvt;
	private JLabel jtfModel;
	private JLabel jtfCarNum;
	private JLabel jtfDistance;
	private DefaultComboBoxModel<String>dcbmjcbRegisterCarDesign;
	private JComboBox<String>jcbRegisterCarDesign;
	private JScrollPane jspRegisterCarDesign;
	private JButton jbtCancel;
	private JButton jbtComplete;
	private DefaultTableModel dtmRegisterCarDesign;
	private JTable jtRegisterCarDesign;
	
	public RegistCarDesign() {
		super("차량 등록");
		JLabel jtfModel = new JLabel("모델명");
		JLabel jtfCarnum = new JLabel("차량번호");
		String[] columnNames = {"520D", "320D","720D"};
		dcbmjcbRegisterCarDesign = new DefaultComboBoxModel<String>();
		jcbRegisterCarDesign = new JComboBox<String>(dcbmjcbRegisterCarDesign);
		dtmRegisterCarDesign = new DefaultTableModel(null,columnNames);
		jtRegisterCarDesign = new JTable(dtmRegisterCarDesign);
		jspRegisterCarDesign = new JScrollPane();
		
//		RegistCarEvt rce = new RegistCarEvt(this);
//		jcbRegisterCarDesign.addActionListener(rce);
		JPanel jpNorth = new JPanel();
		jpNorth.add(jcbRegisterCarDesign);
		
		add("North",jpNorth);
		
		
		setBounds(700,280,400,500);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}//RegistCarDesign

//	public RegistCarEvt getRcEvt() {
//		return rcEvt;
//	}
//
//	public void setRcEvt(RegistCarEvt rcEvt) {
//		this.rcEvt = rcEvt;
//	}

	public JLabel getJtfModel() {
		return jtfModel;
	}

	public void setJtfModel(JLabel jtfModel) {
		this.jtfModel = jtfModel;
	}

	public JLabel getJtfCarNum() {
		return jtfCarNum;
	}

	public void setJtfCarNum(JLabel jtfCarNum) {
		this.jtfCarNum = jtfCarNum;
	}

	public JLabel getJtfDistance() {
		return jtfDistance;
	}

	public void setJtfDistance(JLabel jtfDistance) {
		this.jtfDistance = jtfDistance;
	}

	public DefaultComboBoxModel<String> getDcbmjcbRegisterCarDesign() {
		return dcbmjcbRegisterCarDesign;
	}

	public void setDcbmjcbRegisterCarDesign(DefaultComboBoxModel<String> dcbmjcbRegisterCarDesign) {
		this.dcbmjcbRegisterCarDesign = dcbmjcbRegisterCarDesign;
	}

	public JComboBox<String> getJcbRegisterCarDesign() {
		return jcbRegisterCarDesign;
	}

	public void setJcbRegisterCarDesign(JComboBox<String> jcbRegisterCarDesign) {
		this.jcbRegisterCarDesign = jcbRegisterCarDesign;
	}

	public JScrollPane getJspRegisterCarDesign() {
		return jspRegisterCarDesign;
	}

	public void setJspRegisterCarDesign(JScrollPane jspRegisterCarDesign) {
		this.jspRegisterCarDesign = jspRegisterCarDesign;
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
	
}//class
