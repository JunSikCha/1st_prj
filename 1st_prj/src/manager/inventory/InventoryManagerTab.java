package manager.inventory;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class InventoryManagerTab extends JPanel implements ActionListener {
	// 주석은 시진핑
	private InventoryManagerTabEvt imtEvt;

	private JLabel iMName;
	private JTable jtbInventoryInfoTable;
	private JScrollPane scrollPane;

	private JTextField jtfPartName;
	private JButton jbPartNameSearch;

	private JButton jbAdd;

	private DefaultTableModel dtm;

	
	public InventoryManagerTab() {

		// 재고 게시판
		dtm = new DefaultTableModel() {
			// 전체 수정 불가

			@Override
			public boolean isCellEditable(int row, int column) {
				return false;

			}

			// isCellEditable
		};

		// 페이지 이름
		iMName = new JLabel("재고 부품 관리");
		Font imNameFont = new Font(null, Font.BOLD, 20);
		iMName.setFont(imNameFont);

		jtbInventoryInfoTable = new JTable(dtm);
		scrollPane = new JScrollPane(jtbInventoryInfoTable);

		// 게시판 열 굵게
		JTableHeader tableHeader = jtbInventoryInfoTable.getTableHeader();
		Font headerFont = new Font(null, Font.BOLD, 14);
		tableHeader.setFont(headerFont);
		// 게시판 행 얇게
		DefaultTableCellRenderer renderer = (DefaultTableCellRenderer) jtbInventoryInfoTable
				.getDefaultRenderer(Object.class);
		Font dataFont = new Font(null, Font.PLAIN, 14);
		renderer.setFont(dataFont);
		renderer.setHorizontalAlignment(SwingConstants.CENTER); // 데이터 가운데 정렬

		// 부품명, 검색
		jtfPartName = new JTextField();
		jbPartNameSearch = new JButton("검색");

		jbAdd = new JButton("추가");

		// 추가
		setLayout(null);

		add("North", iMName);
		add("Center", scrollPane);

		add("Center", jtfPartName);
		add("Center", jbPartNameSearch);

		add("Center", jbAdd);

		// 클릭 이벤트
		imtEvt = new InventoryManagerTabEvt(this);

		jbPartNameSearch.addActionListener(imtEvt);
		jbAdd.addActionListener(imtEvt);

		// 크기 조정 및 배치
		iMName.setBounds(70, 56, 140, 20);
		scrollPane.setBounds(70, 90, 800, 450);

		jtfPartName.setBounds(70, 560, 180, 30);
		jbPartNameSearch.setBounds(260, 560, 70, 30);

		jbAdd.setBounds(750, 560, 120, 30);

		scrollPane.setVisible(true);
		setVisible(true);

	} // InventoryManagerTap

	// getter method
	public DefaultTableModel getDtm() {
		return dtm;
	}

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

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

} // class
