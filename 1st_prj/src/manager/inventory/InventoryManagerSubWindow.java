package manager.inventory;

import java.awt.Font;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;



public class InventoryManagerSubWindow extends JDialog{
	//임시주석
	private JLabel jlTitle;
	
	private JComboBox jtfPartName;
	private DefaultComboBoxModel<String> model;
	
	private JTextField jtfPartNo;
	private JTextField jtfAddNumber;
	private JTextField jlAddNumber;
	private JTextField jtfPartUnit;
	private JTextField jtfPartCost;
	private JTextField jtfLaborCost;

	private JButton jbCancle;
	private JButton jbOk;
	
	private InventoryManagerTab imt;
	private JComponent scrollPane;
	private DefaultTableModel dtm;
	
	private InventoryManagerSubWindowEvt imswEvt;
	
	public InventoryManagerSubWindow(InventoryManagerTab imt) {
		
		
		this.imt=imt;
		
		setLayout(null);
		
		//좌측 상단
		jlTitle= new JLabel("추가");
		Font imswNameFont = new Font(null, Font.BOLD, 20);
        jlTitle.setFont(imswNameFont);
		
        scrollPane = new JScrollPane();
        
        JLabel jlPartName = new JLabel("부품명");
        JLabel jlPartNo = new JLabel("시리얼넘버");
        JLabel jlAddNumber = new JLabel("추가수량");
        JLabel jlPartUnit = new JLabel("단위");
        JLabel jlPartCost = new JLabel("단가");
        JLabel jlLaborCost = new JLabel("공임비");
        
        //수정 가능
        jtfAddNumber = new JTextField();
        //수정 불가능
        jtfPartNo = new JTextField();
        jtfPartNo.setEditable(false);
        
        jtfPartUnit = new JTextField();
        jtfPartUnit.setEditable(false);
        
        jtfPartCost = new JTextField();
        jtfPartCost.setEditable(false);
        
        jtfLaborCost = new JTextField();
        jtfLaborCost.setEditable(false);
        
        model = new DefaultComboBoxModel<String>();
        jtfPartName = new JComboBox(model);
        
        
        jbCancle = new JButton("취소");
        jbOk = new JButton("확인");
        
        
		//추가
		setLayout(null);
		
		add("Center", jlTitle);
		
		add("Center",jlPartName);
		add("Center",jlPartNo);
		add("Center",jlAddNumber);
		add("Center",jlPartUnit);
		add("Center",jlPartCost);
		add("Center",jlLaborCost);
		add("Center", jtfPartName);
		add("Center",jtfPartNo);
		add("Center",jtfAddNumber);
		add("Center",jtfPartUnit);
		add("Center",jtfPartCost);
		add("Center",jtfLaborCost);
		
		add("Center", jbCancle);
		add("Center",jbOk);
		
		dtm = new DefaultTableModel();
		
		InventoryManagerSubWindowEvt imswe = new InventoryManagerSubWindowEvt(imt,this);
		jbOk.addActionListener(imswe);
		
		
		
		
		//크기 조정 및 배치
		jlTitle.setBounds(10, 6, 140, 20);
		scrollPane.setBounds(60, 50, 800, 770); 
		
		jlPartName.setBounds(70, 40, 80, 30);
		jtfPartName.setBounds(70, 70, 240, 30);
		
		jlPartNo.setBounds(70, 110, 80, 30);
		jtfPartNo.setBounds(70, 140, 240, 30);
		
		jlAddNumber.setBounds(70, 180, 80, 30);
		jtfAddNumber.setBounds(70, 210, 240, 30);
		
		jlPartUnit.setBounds(70, 250, 80, 30);
		jtfPartUnit.setBounds(70, 280, 240, 30);
		
		jlPartCost.setBounds(70, 320, 80, 30);
		jtfPartCost.setBounds(70, 350, 240, 30);
		
		jlLaborCost.setBounds(70, 390, 80, 30);
		jtfLaborCost.setBounds(70, 420, 240, 30);
		
		
		jbCancle.setBounds(60, 500, 120, 30);
		jbOk.setBounds(200, 500, 120, 30);
		
		setBounds(imt.getX()+620, imt.getY()+190, 400, 600);
		
		jlTitle.setVisible(true);
		scrollPane.setVisible(true);
		jbCancle.setVisible(true);
		jbOk.setVisible(true);
		
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		
	}
	
//	public static void main(String[] args) {
//		InventoryManagerTab imt = new InventoryManagerTab();
//	      new InventoryManagerSubWindow(imt);
//	   }//main //배치 확인용 메인

	public JLabel getJlTitle() {
		return jlTitle;
	}


	public JTextField getJtfPartNo() {
		return jtfPartNo;
	}

	public JTextField getJtfAddNumber() {
		return jtfAddNumber;
	}

	public JTextField getJlAddNumber() {
		return jlAddNumber;
	}

	public JTextField getJtfPartUnit() {
		return jtfPartUnit;
	}

	public JTextField getJtfPartCost() {
		return jtfPartCost;
	}

	public JTextField getJtfLaborCost() {
		return jtfLaborCost;
	}

	public JButton getJbCancle() {
		return jbCancle;
	}

	public JButton getJbOk() {
		return jbOk;
	}

	public InventoryManagerTab getImt() {
		return imt;
	}

	public JComponent getScrollPane() {
		return scrollPane;
	}

	public DefaultTableModel getDtm() {
		return dtm;
	}

	public InventoryManagerSubWindowEvt getImswEvt() {
		return imswEvt;
	}

	
} //class
