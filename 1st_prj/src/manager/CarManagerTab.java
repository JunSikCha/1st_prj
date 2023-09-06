package manager;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
//import java.awt.Color;
//
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class CarManagerTab extends JPanel { //차량관리탭
	
	private CarManagerTabEvt cmtEvt;
	
	private JLabel cMName;
    private JScrollPane scrollPane;
    private JTable jtbCarInfoTable;
	
    private JLabel cmMiddle;
	private JTextField jtfStartDate;
	private JTextField jtfEndDate;
	private JButton jbDateSearch;
	
	private JButton jbtCarInfo;
	private JButton jbtCarAdd;
	private JButton jbtCarInfoModify;
	
	private DefaultTableModel dtm;//11


    
    public CarManagerTab() {
    	
        setLayout(new BorderLayout());
        
//        String[] columnNames = {"차량번호", "모델명", "수리 내역", "입고일", "출고일", "비고"};
//        String[][] data = null;
//        String[][] data = { //확인용 데이터. 추후에 자료 받아와야함!
//                {"123일 5678", "iX", "엔진오일 교체", "2023-08-23", "2023-08-25", ""},
//                {"128조 3561", "컴페티션", "타이어 교체", "2023-08-23", "2023-08-27", ""},
//                {"586화 1111", "어쩌고", "주유구 점검", "2023-08-30", "2023-08-31", ""},
//                {"320이 3492", "저쩌고", "기어 교체", "2023-09-01", "2023-09-12", ""},
//                {"932팅 1489", "얼씨고", "유리창 교체", "2023-09-18", "2023-09-23", ""},
//                {"521아 6437", "절씨고", "시트 교체", "2023-09-25", "2023-09-27", ""},
//                {"359자 5617", "알파고", "암튼 교체함", "2023-09-27", "2023-10-01", ""}
//        };
        
        
        cMName = new JLabel("입고 차량 관리");
        Font cmNameFont = new Font(null, Font.BOLD, 20);
        cMName.setFont(cmNameFont);
        
		dtm=new DefaultTableModel();//11

        //정보 게시판
//        jtbCarInfoTable = new JTable(data, columnNames);//11
        jtbCarInfoTable = new JTable(dtm);//11
        scrollPane = new JScrollPane(jtbCarInfoTable);
        //컬럼네임 크기 조절
        JTableHeader tableHeader = jtbCarInfoTable.getTableHeader();
        Font headerFont = new Font(null, Font.BOLD, 14);
        tableHeader.setFont(headerFont);
        //데이터 크기 조절
        DefaultTableCellRenderer renderer = (DefaultTableCellRenderer) jtbCarInfoTable.getDefaultRenderer(Object.class);
        Font dataFont = new Font(null, Font.PLAIN, 14);
        renderer.setFont(dataFont);
        renderer.setHorizontalAlignment(SwingConstants.CENTER); //데이터 가운데 정렬
        
        
        //날짜, 검색
        cmMiddle = new JLabel("~");
        Font cmMiddleFont = new Font(null,Font.BOLD, 14);
        cmMiddle.setFont(cmMiddleFont);
        
        jtfStartDate = new JTextField();
      	jtfEndDate = new JTextField();
      	jbDateSearch = new JButton("검색");
      		
      	jbtCarInfo = new JButton("차량 정보");
      	jbtCarAdd = new JButton("차량 추가");
      	jbtCarInfoModify = new JButton("정보 수정");
      	
      	
        
        //추가
        setLayout(null);
        
        add("North", cMName);
        add("Center", scrollPane);
        
        add("Center", cmMiddle);
		add("Center", jtfStartDate);
		add("Center", jtfEndDate);
		add("Center", jbDateSearch);
		
		add("Center", jbtCarInfo);
		add("Center", jbtCarAdd);
		add("Center", jbtCarInfoModify);
		
		cmtEvt = new CarManagerTabEvt(this);//11
		
		//클릭 이벤트
		jtfStartDate.addActionListener(cmtEvt);
		jtfEndDate.addActionListener(cmtEvt);
		jbDateSearch.addActionListener(cmtEvt);
		
		jbtCarInfo.addActionListener(cmtEvt);
		jbtCarAdd.addActionListener(cmtEvt);
		jbtCarInfoModify.addActionListener(cmtEvt);
		
		
		
		//크기 조정 및 배치
		cMName.setBounds(10, 6, 140, 20);
		scrollPane.setBounds(80, 50, 800, 400); // 테이블의 위치와 크기 설정
		
		cmMiddle.setBounds(430, 500, 20, 20);
		jtfStartDate.setBounds(280, 500, 140, 30); // 시작 날짜 필드의 위치와 크기 설정
		jtfEndDate.setBounds(450, 500, 140, 30); // 종료 날짜 필드의 위치와 크기 설정
		jbDateSearch.setBounds(610, 500, 70, 30); // 검색 버튼의 위치와 크기 설정

		jbtCarInfo.setBounds(250, 550, 120, 30); // "차량 정보" 버튼의 위치와 크기 설정
		jbtCarAdd.setBounds(420, 550, 120, 30); // "차량 추가" 버튼의 위치와 크기 설정
		jbtCarInfoModify.setBounds(590, 550, 120, 30); // "정보 수정" 버튼의 위치와 크기 설정
		
		scrollPane.setVisible(true);
		setVisible(true);
        
        
    } //CarManagerTap1

    //11
    public DefaultTableModel getDtm() {
		return dtm;
	}


	//getter method
	public JLabel getCMName() {
		return cMName;
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
		return jbtCarInfo;
	}


	public JButton getJbtCarAdd() {
		return jbtCarAdd;
	}


	public JButton getJbtCarInfoModify() {
		return jbtCarInfoModify;
	} //
    
    	
} //class
