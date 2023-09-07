package manager.booking;

import java.awt.BorderLayout;
import java.awt.Color;
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

public class BookingManagerTab extends JPanel{
	
	private JLabel bMName;
	private JTable jtbOrderInfoTable;
	private JScrollPane scrollPane;
	
	private JLabel omMiddle;
	private JTextField jtfStartDate;
	private JTextField jtfEndDate;
	private JButton jbDateSearch;
	
	
	private JButton jbAccept;
	private JButton jbRefusal;
	private JButton jbHistory;
	
	
	public BookingManagerTab() {
		setLayout(new BorderLayout());
		
		String[] columnNames = {"예약번호", "예약시간", "모델명", "증상", "아이디", "이름", "수락/거절", "☑" };
		
		String [][] data = { //확인용 데이터. 추후 자료 받기
				{"0001", "2023-09-23 15:37", "K12da", "삐용이가 이상해요", "zum-in", "김줌인", "수락" , "☑"},
				{"0001", "2023-09-23 15:37", "K12da", "삐용이가 이상해요", "zum-in", "김줌인", "수락" , "☑"},
				{"0001", "2023-09-23 15:37", "K12da", "삐용이가 이상해요", "zum-in", "김줌인", "수락" , "☑"},
				{"0001", "2023-09-23 15:37", "K12da", "삐용이가 이상해요", "zum-in", "김줌인", "수락" , "☑"},
				{"0001", "2023-09-23 15:37", "K12da", "삐용이가 이상해요", "zum-in", "김줌인", "수락" , "☑"},
				{"0001", "2023-09-23 15:37", "K12da", "삐용이가 이상해요", "zum-in", "김줌인", "수락" , "☑"},
				{"0001", "2023-09-23 15:37", "K12da", "삐용이가 이상해요", "zum-in", "김줌인", "수락" , "☑"}
				
		};
	//bookingNo, bookingDay + bookingTime, carName, faultDetail, clientId, clientName, bookingBoolean
	
		//페이지 이름
		bMName = new JLabel("예약 관리");
		Font bmNameFont = new Font(null, Font.BOLD, 20);
		bMName.setFont(bmNameFont);

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
      		
      	jbAccept = new JButton("수락");
      	jbRefusal = new JButton("거절");
      	jbHistory = new JButton("이력조회");
      	

		//추가
		setLayout(null);

		add("North", bMName);
		add("Center", scrollPane);

		add("Center", omMiddle);
		add("Center", jtfStartDate);
		add("Center", jtfEndDate);
		add("Center", jbDateSearch);

		add("Center", jbAccept);
		add("Center", jbRefusal);
		add("Center", jbHistory);



	//크기 조정 및 배치
	bMName.setBounds(10, 6, 140, 20);
	scrollPane.setBounds(80, 50, 800, 400); 

	jtfStartDate.setBounds(190, 500, 140, 30); // 시작 날짜 필드의 위치와 크기 설정
	omMiddle.setBounds(340, 500, 20, 20);
	jtfEndDate.setBounds(360, 500, 140, 30); // 종료 날짜 필드의 위치와 크기 설정
	jbDateSearch.setBounds(520, 500, 70, 30); // 검색 버튼의 위치와 크기 설정

	jbAccept.setBounds(620, 500, 120, 30);
	jbRefusal.setBounds(620, 500, 120, 30);
	jbHistory.setBounds(620, 500, 120, 30);

	scrollPane.setVisible(true);
	setVisible(true);


	} //BookingManagerTab
	
} //class
