package manager.inventory;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;



public class InventoryManagerSubWindow extends JDialog{
	
	private JLabel jlTitle;
	
	private JTextField jtfPartName;
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
        jtfPartName = new JTextField();
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
		
		add("Center", jbCancle);
		add("Center",jbOk);
		
		dtm = new DefaultTableModel();
		
		InventoryManagerSubWindowEvt imswe = new InventoryManagerSubWindowEvt(imt,this);
		jbOk.addActionListener(imswe);
		
		
		//크기 조정 및 배치
		jlTitle.setBounds(10, 6, 140, 20);
		scrollPane.setBounds(60, 50, 800, 770); 
		
//		jlPartName.setBounds(EXIT_ON_CLOSE, ABORT, WIDTH, HEIGHT);
//		jlPartNo.setBounds(EXIT_ON_CLOSE, ABORT, WIDTH, HEIGHT);
//		jlAddNumber.setBounds(EXIT_ON_CLOSE, ABORT, WIDTH, HEIGHT);
//		jlPartUnit.setBounds(EXIT_ON_CLOSE, ABORT, WIDTH, HEIGHT);
//		jlPartCost.setBounds(EXIT_ON_CLOSE, ABORT, WIDTH, HEIGHT);
//		jlLaborCost.setBounds(EXIT_ON_CLOSE, ABORT, WIDTH, HEIGHT);
		
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
	
	public static void main(String[] args) {
		InventoryManagerTab imt = new InventoryManagerTab();
	      new InventoryManagerSubWindow(imt);
	   }//main

} //class
