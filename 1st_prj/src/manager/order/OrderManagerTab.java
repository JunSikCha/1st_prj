package manager.order;

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

import manager.login.LoginVO;

@SuppressWarnings("serial")
public class OrderManagerTab extends JPanel implements ActionListener {

	private OrderManagerEvt omEvt;

	private JLabel jlOMName;
	private JTable jtbOrderInfoTable;
	private JScrollPane scrollPane;

	private JLabel jlOMMiddle;
	private JTextField jtfStartDate;
	private JTextField jtfEndDate;
	private JButton jbDateSearch;

	private JButton jbOrder;
	private DefaultTableModel dtm;

	public OrderManagerTab(LoginVO lVO) {

		// 발주 게시판
		dtm = new DefaultTableModel() {
			// 전체 수정 불가
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}

			// isCellEditable
		};

		// 페이지 이름
		jlOMName = new JLabel("부품 발주 관리");
		Font oMNameFont = new Font(null, Font.BOLD, 20);
		jlOMName.setFont(oMNameFont);

		// 재고 게시판
		jtbOrderInfoTable = new JTable(dtm);
		scrollPane = new JScrollPane(jtbOrderInfoTable);
		// 게시판 열 굵게
		JTableHeader tableHeader = jtbOrderInfoTable.getTableHeader();
		Font headerFont = new Font(null, Font.BOLD, 14);
		tableHeader.setFont(headerFont);
		// 게시판 행 얇게
		DefaultTableCellRenderer renderer = (DefaultTableCellRenderer) jtbOrderInfoTable
				.getDefaultRenderer(Object.class);
		Font dataFont = new Font(null, Font.PLAIN, 14);
		renderer.setFont(dataFont);
		renderer.setHorizontalAlignment(SwingConstants.CENTER); // 데이터 가운데 정렬

		// 날짜, 검색
		jlOMMiddle = new JLabel("~");
		Font oMMiddleFont = new Font(null, Font.BOLD, 14);
		jlOMMiddle.setFont(oMMiddleFont);

		jtfStartDate = new JTextField();
		jtfEndDate = new JTextField();
		jbDateSearch = new JButton("검색");

		jbOrder = new JButton("발주");

		// 추가
		setLayout(null);

		add("North", jlOMName);
		add("Center", scrollPane);

		add("Center", jlOMMiddle);
		add("Center", jtfStartDate);
		add("Center", jtfEndDate);
		add("Center", jbDateSearch);

		add("Center", jbOrder);

		// 클릭 이벤트

		omEvt = new OrderManagerEvt(this,lVO);
		jbDateSearch.addActionListener(omEvt);
		jbOrder.addActionListener(omEvt);

		// 크기 조정 및 배치
		jlOMName.setBounds(70, 56, 140, 20);
		scrollPane.setBounds(70, 90, 800, 450);

		jtfStartDate.setBounds(70, 560, 140, 30); // 시작 날짜 필드의 위치와 크기 설정
		jlOMMiddle.setBounds(220, 560, 20, 20);
		jtfEndDate.setBounds(240, 560, 140, 30); // 종료 날짜 필드의 위치와 크기 설정
		jbDateSearch.setBounds(390, 560, 70, 30); // 검색 버튼의 위치와 크기 설정

		jbOrder.setBounds(750, 560, 120, 30);

		scrollPane.setVisible(true);
		setVisible(true);

	} // OrderManagerTab

	// getter
	
	public DefaultTableModel getDtm() {
		return dtm;
	}

	public OrderManagerEvt getOmEvt() {
		return omEvt;
	}

	public JLabel getoMName() {
		return jlOMName;
	}

	public JTable getJtbOrderInfoTable() {
		return jtbOrderInfoTable;
	}

	public JScrollPane getScrollPane() {
		return scrollPane;
	}

	public JLabel getOmMiddle() {
		return jlOMMiddle;
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

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

}// class
