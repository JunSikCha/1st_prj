package manager.carmanager;

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

public class CarManagerTab extends JPanel implements ActionListener { // 차량관리탭
	// 아오 다영시치
	private CarManagerTabEvt cmtEvt;

	private JLabel jlCMName;
	private JTable jtbCarInfoTable;
	private JScrollPane scrollPane;

	private JTextField jtfStartDate;
	private JTextField jtfEndDate;
	private JButton jbDateSearch;

	private JButton jbCarInfo;
	private JButton jbCarAdd;
	private JButton jbCarInfoModify;

	private DefaultTableModel dtm;

	public CarManagerTab() {
		
		boolean[] flag = {false,false,false,true,false};

		dtm = new DefaultTableModel() {
			// 테이블 읽기전용으로 설정
			@Override
			public boolean isCellEditable(int row, int column) {
				return flag[2];
			}
		};


		// 페이지 이름
		jlCMName = new JLabel("입고 차량 관리");
		Font cmNameFont = new Font(null, Font.BOLD, 20);
		jlCMName.setFont(cmNameFont);

		// 정보 게시판
		jtbCarInfoTable = new JTable(dtm);
		scrollPane = new JScrollPane(jtbCarInfoTable);

		//////////////////////////////////////////////////////
		jtbCarInfoTable.getTableHeader().setReorderingAllowed(false);

		//////////////////////////////////////////////////////

		// 컬럼네임 크기 조절
		JTableHeader tableHeader = jtbCarInfoTable.getTableHeader();
		Font headerFont = new Font(null, Font.BOLD, 14);
		tableHeader.setFont(headerFont);
		// 데이터 크기 조절
		DefaultTableCellRenderer renderer = (DefaultTableCellRenderer) jtbCarInfoTable.getDefaultRenderer(Object.class);
		Font dataFont = new Font(null, Font.PLAIN, 14);
		renderer.setFont(dataFont);
		renderer.setHorizontalAlignment(SwingConstants.CENTER); // 데이터 가운데 정렬

		// 날짜, 검색
		JLabel cmMiddle = new JLabel("~");
		Font cmMiddleFont = new Font(null, Font.BOLD, 14);
		cmMiddle.setFont(cmMiddleFont);

		jtfStartDate = new JTextField();
		jtfEndDate = new JTextField();
		jbDateSearch = new JButton("검색");

		jbCarInfo = new JButton("차량 정보");
		jbCarAdd = new JButton("차량 추가");
		jbCarInfoModify = new JButton("정보 수정");

		// 추가
		setLayout(null);

		add("North", jlCMName);
		add("Center", scrollPane);

		add("Center", cmMiddle);
		add("Center", jtfStartDate);
		add("Center", jtfEndDate);
		add("Center", jbDateSearch);

		add("Center", jbCarInfo);
		add("Center", jbCarAdd);
		add("Center", jbCarInfoModify);

		cmtEvt = new CarManagerTabEvt(this);

		// 클릭 이벤트
		jtfStartDate.addActionListener(cmtEvt);
		jtfEndDate.addActionListener(cmtEvt);
		jbDateSearch.addActionListener(cmtEvt);

		jbCarInfo.addActionListener(cmtEvt);
		jbCarAdd.addActionListener(cmtEvt);
		jbCarInfoModify.addActionListener(cmtEvt);

		// 크기 조정 및 배치
		jlCMName.setBounds(60, 16, 140, 20);
		scrollPane.setBounds(60, 50, 800, 400);

		jtfStartDate.setBounds(65, 520, 140, 30);
		cmMiddle.setBounds(215, 520, 20, 20);
		jtfEndDate.setBounds(235, 520, 140, 30);
		jbDateSearch.setBounds(385, 520, 70, 30);

		jbCarInfo.setBounds(485, 520, 120, 30);
		jbCarAdd.setBounds(610, 520, 120, 30);
		jbCarInfoModify.setBounds(735, 520, 120, 30);

		scrollPane.setVisible(true);
		setVisible(true);

	} // CarManagerTap1

	public DefaultTableModel getDtm() {
		return dtm;
	}

	// getter method
	public JLabel getCMName() {
		return jlCMName;
	}

	public JScrollPane getScrollPane() {
		return scrollPane;
	}

	public JTable getJtbCarInfoTable() {
		return jtbCarInfoTable;
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

	public JButton getJbtCarInfo() {
		return jbCarInfo;
	}

	public JButton getJbtCarAdd() {
		return jbCarAdd;
	}

	public JButton getJbtCarInfoModify() {
		return jbCarInfoModify;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

} // class
