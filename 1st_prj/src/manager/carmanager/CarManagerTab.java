package manager.carmanager;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import manager.login.LoginVO;

@SuppressWarnings("serial")
public class CarManagerTab extends JPanel implements ActionListener { // 차량관리탭
	// 아오 다영시치
	private CarManagerTabEvt cmtEvt;

	private JLabel jlCMNameL;
	private JLabel jlCMNameR;
	private JLabel jlCMNameM;
	
	private JTable jtbCarInfoTable;
	private JScrollPane jspCarInfoTable; //입고 차량 관리
	private DefaultTableModel dtmCarInfo;
	
	private JTable jtbWaitTable;
	private JScrollPane jspWaitTable;//대기 차량 관리
	private DefaultTableModel dtmWait;
	
	private JTable jtbOutputTable;
	private JScrollPane jspOutputTable;//출고 차량 관리
	private DefaultTableModel dtmOutput;

	private JButton jbCarAdd; //입고
	private JButton jbCarOut; //출고
	private JButton jbCarInfoModify; //정보수정
	private JButton jbCarRepairEnd; //수리완료





	public CarManagerTab(LoginVO lVO) {
		

		dtmCarInfo = new DefaultTableModel() {
			// 테이블 읽기전용으로 설정
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		dtmOutput = new DefaultTableModel() {
			// 테이블 읽기전용으로 설정
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		dtmWait = new DefaultTableModel() {
			// 테이블 읽기전용으로 설정
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};


		// 페이지 이름
		jlCMNameL = new JLabel("입고 대기 차량");
		Font cmNameFontL = new Font(null, Font.BOLD, 20);
		jlCMNameL.setFont(cmNameFontL);

		
		jlCMNameR = new JLabel("출고 대기 차량");
		Font cmNameFontR = new Font(null, Font.BOLD, 20);
		jlCMNameR.setFont(cmNameFontR);
		
		
		jlCMNameM = new JLabel("입고 차량 관리");
		Font cmNameFontM = new Font(null, Font.BOLD, 20);
		jlCMNameM.setFont(cmNameFontM);

		
		// 중앙 상단 입고 차량관리
		jtbCarInfoTable = new JTable(dtmCarInfo);
		jspCarInfoTable = new JScrollPane(jtbCarInfoTable);
		//좌측 하단 대기 차랑관리
		jtbWaitTable = new JTable(dtmWait);
		jspWaitTable = new JScrollPane(jtbWaitTable);
		//우측 하단 출고 차량관리
		jtbOutputTable = new JTable(dtmOutput);
		jspOutputTable = new JScrollPane(jtbOutputTable);
		
		
		//게시판 수정 불가
		jtbCarInfoTable.getTableHeader().setReorderingAllowed(false);
		jtbWaitTable.getTableHeader().setReorderingAllowed(false);
		jtbOutputTable.getTableHeader().setReorderingAllowed(false);

		
		//게시판 열 굵게
		JTableHeader tableHeader = jtbCarInfoTable.getTableHeader();
		Font headerFont = new Font(null, Font.BOLD, 14);
		tableHeader.setFont(headerFont);
		
		JTableHeader tableHeader2 = jtbWaitTable.getTableHeader();
		Font headerFont2 = new Font(null, Font.BOLD, 14);
		tableHeader2.setFont(headerFont2);
		
		JTableHeader tableHeader3 = jtbOutputTable.getTableHeader();
		Font headerFont3 = new Font(null, Font.BOLD, 14);
		tableHeader3.setFont(headerFont3);
		
		//게시판 행 얇게
		DefaultTableCellRenderer renderer = (DefaultTableCellRenderer) jtbCarInfoTable.getDefaultRenderer(Object.class);
		Font dataFont = new Font(null, Font.PLAIN, 14);
		renderer.setFont(dataFont);
		renderer.setHorizontalAlignment(SwingConstants.CENTER); // 데이터 가운데 정렬
		
		DefaultTableCellRenderer renderer2 = (DefaultTableCellRenderer) jtbWaitTable.getDefaultRenderer(Object.class);
		Font dataFont2 = new Font(null, Font.PLAIN, 14);
		renderer2.setFont(dataFont2);
		renderer2.setHorizontalAlignment(SwingConstants.CENTER); // 데이터 가운데 정렬
		
		DefaultTableCellRenderer renderer3 = (DefaultTableCellRenderer) jtbOutputTable.getDefaultRenderer(Object.class);
		Font dataFont3 = new Font(null, Font.PLAIN, 14);
		renderer3.setFont(dataFont3);
		renderer3.setHorizontalAlignment(SwingConstants.CENTER); // 데이터 가운데 정렬

		


		jbCarAdd = new JButton("입고");
		jbCarOut = new JButton("출고");
		
		jbCarInfoModify = new JButton("정보 수정");
		jbCarRepairEnd = new JButton("수리 완료");

		
		// 추가
		setLayout(null);

		add("North", jlCMNameL);
		add("North", jlCMNameR);
		add("North", jlCMNameM);
		
		add("Center", jspCarInfoTable);
		add("Center", jspWaitTable);
		add("Center", jspOutputTable);


		add("Center", jbCarAdd);
		add("Center", jbCarOut);
//		add("Center", jbCarInfo);
		add("Center", jbCarInfoModify);
		add("Center", jbCarRepairEnd);

		cmtEvt = new CarManagerTabEvt(this,lVO);

		// 클릭 이벤트

		jbCarAdd.addActionListener(cmtEvt);
		jbCarOut.addActionListener(cmtEvt);
		
//		jbCarInfo.addActionListener(cmtEvt);
		jbCarInfoModify.addActionListener(cmtEvt);
		jbCarRepairEnd.addActionListener(cmtEvt);

		// 크기 조정 및 배치
		jlCMNameL.setBounds(60, 56, 320, 20);
		jlCMNameR.setBounds(480, 56, 320, 20);
		jlCMNameM.setBounds(60, 320, 320, 20);
		
		
		jspWaitTable.setBounds(60, 90, 380, 140);
		jspOutputTable.setBounds(480, 90, 380, 140);
		jspCarInfoTable.setBounds(60, 350, 800, 190);

		
		jbCarAdd.setBounds(320, 250, 120, 30);
		jbCarOut.setBounds(740, 250, 120, 30);
		
//		jbCarInfo.setBounds(490, 560, 120, 30);
		jbCarInfoModify.setBounds(615, 560, 120, 30);
		jbCarRepairEnd.setBounds(740, 560, 120, 30);

		jspCarInfoTable.setVisible(true);
		setVisible(true);

	} // CarManagerTap1

	

	
	public DefaultTableModel getDtmCarInfo() {
		return dtmCarInfo;
	}




	public DefaultTableModel getDtmWait() {
		return dtmWait;
	}




	public DefaultTableModel getDtmOutput() {
		return dtmOutput;
	}




	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}


	// getter method
	public CarManagerTabEvt getCmtEvt() {
		return cmtEvt;
	}


	public JLabel getJlCMNameL() {
		return jlCMNameL;
	}


	public JLabel getJlCMNameR() {
		return jlCMNameR;
	}


	public JLabel getJlCMNameM() {
		return jlCMNameM;
	}


	public JTable getJtbCarInfoTable() {
		return jtbCarInfoTable;
	}


	public JScrollPane getJspCarInfoTable() {
		return jspCarInfoTable;
	}


	public JTable getJtbWaitTable() {
		return jtbWaitTable;
	}


	public JScrollPane getJspWaitTable() {
		return jspWaitTable;
	}


	public JTable getJtbOutputTable() {
		return jtbOutputTable;
	}


	public JScrollPane getJspOutputTable() {
		return jspOutputTable;
	}


	public JButton getJbCarAdd() {
		return jbCarAdd;
	}


	public JButton getJbCarOut() {
		return jbCarOut;
	}


//	public JButton getJbCarInfo() {
//		return jbCarInfo;
//	}


	public JButton getJbCarInfoModify() {
		return jbCarInfoModify;
	}


	public JButton getJbCarRepairEnd() {
		return jbCarRepairEnd;
	}

} // class
