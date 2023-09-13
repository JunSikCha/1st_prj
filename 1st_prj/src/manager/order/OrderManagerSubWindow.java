package manager.order;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;


public class OrderManagerSubWindow extends JDialog{

	private JLabel jlTitle;
	
	private JCheckBox jcbPartNo;
	
	private JTextField jtfPartStock;
	private JTextField jtfPartUnit;
	private JTextField jtfOrderQuantity;
	
	private JButton jbCancle;
	private JButton jbOk;
	
	private OrderManagerTab omt;
	private OrderManagerSubWindowEvt omswe;
	private JScrollPane scrollPane;
	private DefaultTableModel dtm;

	private JTextField jtfPartName;

	private JTextField jtfAddNumber;

	
	
	public OrderManagerSubWindow(OrderManagerTab omt) {
		
		this.omt=omt;
		
		setLayout(null);
		
		//상단
		jlTitle= new JLabel("발주");
		Font imswNameFont = new Font(null, Font.BOLD, 20);
        jlTitle.setFont(imswNameFont);
		
        scrollPane = new JScrollPane();
        
        //게시판
        JLabel jlPartName = new JLabel("부품명");
        JLabel jlPartStock = new JLabel("현 재고");
        JLabel jlPartUnit = new JLabel("단위");
        JLabel jlOrderQuantity = new JLabel("발주 수량");
        
        //수정 가능
        jtfPartName = new JTextField();
        jtfAddNumber = new JTextField();
        //수정 불가능
        jtfPartStock = new JTextField();
        jtfPartStock.setEditable(false);
        jtfPartUnit = new JTextField();
        jtfPartUnit.setEditable(false);
        
		jbCancle = new JButton("취소");
		jbOk = new JButton("확인");
		
        //추가
      	setLayout(null);
      		
      	add("Center", jlTitle);
      	
      	add("Center", jlPartName);
      	add("Center", jlPartStock);
      	add("Center", jlPartUnit);
      	add("Center", jlOrderQuantity);
      	
      	add("Center", jtfPartName);
      	add("Center", jtfPartStock);
      	add("Center", jtfPartUnit);
      	add("Center", jtfAddNumber);
		
      	add("Center", jbCancle);
      	add("Center", jbOk);
		
      	dtm = new DefaultTableModel();
		
//      	OrderManagerSubWindowEvt  omswe= new OrderManagerSubWindowEvt(omt,this);
//		jbOk.addActionListener(omswe);
		
		
		//크기 조정 및 배치
		jlTitle.setBounds(10, 6, 140, 20);
		scrollPane.setBounds(60, 50, 800, 770); 
		
		jlPartName.setBounds(70, 40, 80, 30);
		jlPartStock.setBounds(70, 170, 80, 30);
		jlPartUnit.setBounds(170, 170, 80, 30);
		jlOrderQuantity.setBounds(70, 220, 80, 30);
		
		jtfPartName.setBounds(70, 110, 240, 30);
		jtfPartStock.setBounds(70, 240, 100, 30);
		jtfPartUnit.setBounds(190, 240, 100, 30);
//		jtfOrderQuantity.setBounds(70, 280, 80, 30);
		
		jbCancle.setBounds(60, 500, 120, 30);
		jbOk.setBounds(200, 500, 120, 30);
		
		
		setBounds(omt.getX()+620, omt.getY()+190, 400, 600);
		
		jlTitle.setVisible(true);
		scrollPane.setVisible(true);
		
		jbCancle.setVisible(true);
		jbOk.setVisible(true);
		
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
	
		
	} //OrderManagerSubWindow

	public static void main(String[] args) {
		OrderManagerTab omt = new OrderManagerTab();
		new OrderManagerSubWindow(omt);
	}


} //class

