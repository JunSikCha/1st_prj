package manager.order;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;

public class OrderManagerTab extends JPanel{
	
	private JLabel oMName;
	private JTable jtbOrderInfoTable;
	private JScrollPane scrollPane;
	
	private JLabel omMiddle;
	private JTextField jtfStartDate;
	private JTextField jtfEndDate;
	private JButton jbDateSearch;
	
	
	private JButton jbOrder;

	
	public OrderManagerTab() {
		
		setLayout(new BorderLayout());
		
		String[] columnNames = {"발주번호", "발주일", "시리얼넘버", "부품명", "발주수량", "단위", "단가"};
		
		String [][] data = { //확인용 데이터. 추후 자료 받기
				{"123455", "2023-09-23", "K12da", "핸들", "5", "개", "123,000"},
				{"123455", "2023-09-23", "K12da", "핸들", "5", "개", "123,000"},
				{"123455", "2023-09-23", "K12da", "핸들", "5", "개", "123,000"},
				{"123455", "2023-09-23", "K12da", "핸들", "5", "개", "123,000"},
				{"123455", "2023-09-23", "K12da", "핸들", "5", "개", "123,000"},
				{"123455", "2023-09-23", "K12da", "핸들", "5", "개", "123,000"},
				{"123455", "2023-09-23", "K12da", "핸들", "5", "개", "123,000"}
		};
	//orderNo, orderDate, partNo, PartName, orderQuantity, partUnit, partCost
	
		//페이지 이름
		oMName = new JLabel("부품 발주 관리");
		Font omNameFont = new Font(null, Font.BOLD, 20);
		oMName.setFont(omNameFont);

		//재고 게시판
		jtbOrderInfoTable = new JTable(data, columnNames);
		scrollPane = new JScrollPane(jtbOrderInfoTable);
		//컬럼네임 크기 조절
		JTableHeader tableHeader = jtbOrderInfoTable.getTableHeader();
		Font headerFont = new Font(null, Font.BOLD, 14);
		tableHeader.setFont(headerFont);
		//데이터 크기 조절
		DefaultTableCellRenderer renderer = (DefaultTableCellRenderer) jtbOrderInfoTable.getDefaultRenderer(Object.class);
		Font dataFont = new Font(null, Font.PLAIN, 14);
		renderer.setFont(dataFont);
		renderer.setHorizontalAlignment(SwingConstants.CENTER); //데이터 가운데 정렬


		//날짜, 검색
		omMiddle = new JLabel("~");
        Font omMiddleFont = new Font(null,Font.BOLD, 14);
        omMiddle.setFont(omMiddleFont);
        
        jtfStartDate = new JTextField();
      	jtfEndDate = new JTextField();
      	jbDateSearch = new JButton("검색");
      		
      	jbOrder = new JButton("발주");
      	

		//추가
		setLayout(null);

		add("North", oMName);
		add("Center", scrollPane);

		add("Center", omMiddle);
		add("Center", jtfStartDate);
		add("Center", jtfEndDate);
		add("Center", jbDateSearch);

		add("Center", jbOrder);



	//크기 조정 및 배치
	oMName.setBounds(10, 6, 140, 20);
	scrollPane.setBounds(80, 50, 800, 400); 

	jtfStartDate.setBounds(190, 520, 140, 30); // 시작 날짜 필드의 위치와 크기 설정
	omMiddle.setBounds(340, 520, 20, 20);
	jtfEndDate.setBounds(360, 520, 140, 30); // 종료 날짜 필드의 위치와 크기 설정
	jbDateSearch.setBounds(520, 520, 70, 30); // 검색 버튼의 위치와 크기 설정

	jbOrder.setBounds(620, 520, 120, 30);

	scrollPane.setVisible(true);
	setVisible(true);


	} //OrderManagerTab

	
	//getter
	public JLabel getoMName() {
		return oMName;
	}


	public JTable getJtbOrderInfoTable() {
		return jtbOrderInfoTable;
	}


	public JScrollPane getScrollPane() {
		return scrollPane;
	}


	public JLabel getOmMiddle() {
		return omMiddle;
	}


	public JTextField getJtfStartDate() {
		return jtfStartDate;
	}


	public JTextField getJtfEndDate() {
		return jtfEndDate;
	}


	public JButton getJbDateSearch() {
		return jbDateSearch;
	}


	public JButton getJbOrder() {
		return jbOrder;
	}
	
	
	
}//class
