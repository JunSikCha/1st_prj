package manager.inventory;

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

public class InventoryManagerTab extends JPanel{

	private JLabel iMName;
	private JTable jtbInventoryInfoTable;
	private JScrollPane scrollPane;
	
	private JTextField jtfPartName;
	private JButton jbPartNameSearch;
	
	private JButton jbAdd;
	
	public InventoryManagerTab() {
		
		setLayout(new BorderLayout());
		
		String[] columnNames = { "시리얼넘버", "부품명", "재고", "단위", "단가", "공임비" };
		
		String[][] data = { //확인용 데이터. 추후 자료 받기
				{"123456", "핸들", "5", "개", "365,000", "120,000"},
				{"123456", "핸들", "5", "개", "365,000", "120,000"},
				{"123456", "핸들", "5", "개", "365,000", "120,000"},
				{"123456", "핸들", "5", "개", "365,000", "120,000"},
				{"123456", "핸들", "5", "개", "365,000", "120,000"},
				{"123456", "핸들", "5", "개", "365,000", "120,000"},
				{"123456", "핸들", "5", "개", "365,000", "120,000"}
		};
		//partNo,partName, partStock, partUnit, partCost, laborCost
		
		
		//페이지 이름
		iMName = new JLabel("재고 부품 관리");
		Font imNameFont = new Font(null, Font.BOLD, 20);
        iMName.setFont(imNameFont);
        
        //재고 게시판
        jtbInventoryInfoTable = new JTable(data, columnNames);
		scrollPane = new JScrollPane(jtbInventoryInfoTable);
		//컬럼네임 크기 조절
        JTableHeader tableHeader = jtbInventoryInfoTable.getTableHeader();
        Font headerFont = new Font(null, Font.BOLD, 14);
        tableHeader.setFont(headerFont);
        //데이터 크기 조절
        DefaultTableCellRenderer renderer = (DefaultTableCellRenderer) jtbInventoryInfoTable.getDefaultRenderer(Object.class);
        Font dataFont = new Font(null, Font.PLAIN, 14);
        renderer.setFont(dataFont);
        renderer.setHorizontalAlignment(SwingConstants.CENTER); //데이터 가운데 정렬
        
        
        //부품명, 검색
        jtfPartName = new JTextField();
        jbPartNameSearch = new JButton("검색");
		
        jbAdd = new JButton("추가");
        
        //추가
        setLayout(null);
        
        add("North", iMName);
        add("Center", scrollPane);
        
        add("Center", jtfPartName);
        add("Center", jbPartNameSearch);
        
        add("Center", jbAdd);
        
        
        //클릭 이벤트
//        jtfPartName.addActionListener(imtEvt);
//        jbPartNameSearch.addActionListener(imtEvt);
        
        //크기 조정 및 배치
        iMName.setBounds(10, 6, 140, 20);
        scrollPane.setBounds(80, 50, 800, 400); 
        
        jtfPartName.setBounds(250, 520, 180, 30);
        jbPartNameSearch.setBounds(460, 520, 70, 30);
        
        jbAdd.setBounds(580, 520, 120, 30);
        
        scrollPane.setVisible(true);
        setVisible(true);
        
        
	} //InventoryManagerTap

	//getter method
	public JLabel getiMName() {
		return iMName;
	}

	public JTable getJtbInventoryInfoTable() {
		return jtbInventoryInfoTable;
	}

	public JScrollPane getScrollPane() {
		return scrollPane;
	}

	public JTextField getJtfPartName() {
		return jtfPartName;
	}

	public JButton getJbPartNameSearch() {
		return jbPartNameSearch;
	}

	public JButton getJbAdd() {
		return jbAdd;
	}

	
	
} //class
