package manager.order;

import java.awt.Font;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import manager.login.LoginVO;


@SuppressWarnings("serial")
public class OrderManagerSubWindow extends JDialog{

	private JLabel jlTitle;
	
	private JComboBox jtfPartName;
	private DefaultComboBoxModel<String> model;
	private JTextField jtfPartStock;
	private JTextField jtfPartUnit;
	private JTextField jtfOrderQuantity;
	
	private JButton jbCancle;
	private JButton jbOk;
	
	private DefaultTableModel dtm;
	private OrderManagerTab omt;
	private OrderManagerSubWindowEvt omswe;
	private JScrollPane scrollPane;



	
	
	public OrderManagerSubWindow(OrderManagerTab omt, LoginVO lVO) {
		
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
        jtfOrderQuantity = new JTextField();
        //수정 불가능
        jtfPartStock = new JTextField();
        jtfPartStock.setEditable(false);
        jtfPartUnit = new JTextField();
        jtfPartUnit.setEditable(false);
        
		jbCancle = new JButton("취소");
		jbOk = new JButton("확인");
		
		model = new DefaultComboBoxModel<String>();
		jtfPartName = new JComboBox(model);
		
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
      	add("Center", jtfOrderQuantity);
		
      	add("Center", jbCancle);
      	add("Center", jbOk);
		
      	
		//클릭 이벤트
      	OrderManagerSubWindowEvt  omswe= new OrderManagerSubWindowEvt(omt,this,lVO);
		jbOk.addActionListener(omswe);
		jtfPartName.addActionListener(omswe);
		jbCancle.addActionListener(omswe);
		
		
		//크기 조정 및 배치
		jlTitle.setBounds(20, 6, 140, 20);
		scrollPane.setBounds(60, 50, 800, 770); 
		
		jlPartName.setBounds(80, 80, 80, 30);
		jlPartStock.setBounds(80, 220, 80, 30);
		jlPartUnit.setBounds(210, 220, 80, 30);
		jlOrderQuantity.setBounds(80, 320, 80, 30);
		
		jtfPartName.setBounds(80, 110, 230, 55);
		jtfPartStock.setBounds(80, 250, 100, 30);
		jtfPartUnit.setBounds(210, 250, 100, 30);
		jtfOrderQuantity.setBounds(80, 360, 230, 30);
		
		jbCancle.setBounds(70, 500, 120, 30);
		jbOk.setBounds(210, 500, 120, 30);
		
		
		setBounds(omt.getX()+650, omt.getY()+190, 400, 600);
		
		jlTitle.setVisible(true);
		scrollPane.setVisible(true);
		
		jbCancle.setVisible(true);
		jbOk.setVisible(true);
		setModal(true);
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
	
		
} //OrderManagerSubWindow
	
	
	
	//getter
	

	public JLabel getJlTitle() {
		return jlTitle;
	}

	public DefaultComboBoxModel<String> getModel() {
		return model;
	}



	public JComboBox getJtfPartName() {
		return jtfPartName;
	}

	public JTextField getJtfPartStock() {
		return jtfPartStock;
	}

	public JTextField getJtfPartUnit() {
		return jtfPartUnit;
	}

	public JTextField getJtfOrderQuantity() {
		return jtfOrderQuantity;
	}

	public JButton getJbCancle() {
		return jbCancle;
	}

	public JButton getJbOk() {
		return jbOk;
	}

	public OrderManagerTab getOmt() {
		return omt;
	}

	public OrderManagerSubWindowEvt getOmswe() {
		return omswe;
	}

	public JScrollPane getScrollPane() {
		return scrollPane;
	}

	public DefaultTableModel getDtm() {
		return dtm;
	}

	
	
	

} //class
