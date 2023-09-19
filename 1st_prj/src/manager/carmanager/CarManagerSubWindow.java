package manager.carmanager;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

public class CarManagerSubWindow extends JDialog {

	private CarManagerTab cmt;

	private JLabel jlTitle;
	private JPanel jpTitle;

	private JPanel jpMaintenencrNo;
	private JPanel jpcarName;
	private JPanel jpPhone;
	private JPanel jpreceiveDay;
	private JPanel jpempName;
	private JTextField jtfMaintenencrNo;
	private JTextField jtfcarName;
	private JTextField jtfPhone;
	private JTextField jtfreceiveDay;
	private JTextField jtfempName;

	private JPanel jpCarNo;
	private JPanel jpClientName;
	private JPanel jpClientEmail;
	private JPanel jpReleaseDay;
	private JPanel jpCarmileage;
	private JTextField jtfCarNo;
	private JTextField jtfClientName;
	private JTextField jtfClientEmail;
	private JTextField jtfReleaseDay;
	private JTextField jtfCarmileage;

	private JPanel jpFaultDetail;
	private JPanel jpMaintenanceDetail;
	private JPanel jpPartName;
	private JPanel jpSUnitPrice;
	private JPanel jpSPrice;
	private JTextField jtfFaultDetail;
	private JTextField jtfMaintenanceDetail;
	private JComboBox jtfPartName;
	private JTable jtPartTable;
	private JButton jbPartAdd;
	private JButton jbPartRemove;

	private JPanel jpNote;
	private JPanel jpTotal;
	private JTextField jtfNote;
	private JTextField jtfTotal;

	private JButton jbCancle;
	private JButton jbFunction;

	private JScrollPane scrollPane;
	private DefaultTableModel dtm;
	private DefaultComboBoxModel<String> model;

	public CarManagerSubWindow(CarManagerTab cmt, String str) {
		this.cmt = cmt;

		setLayout(null);
		// 좌측 상단
		jlTitle = new JLabel(str);
		jpTitle = new JPanel();
		jpTitle.add(jlTitle, BorderLayout.CENTER);
		jpTitle.setBackground(Color.gray);

		model = new DefaultComboBoxModel<String>();

		// 게시판 형식, 배경색
		JLabel jlMaintenencrNo = new JLabel("정비번호");
		jpMaintenencrNo = new JPanel();
		jpMaintenencrNo.add(jlMaintenencrNo, BorderLayout.CENTER);
		jpMaintenencrNo.setBackground(Color.gray);

		JLabel jlcarName = new JLabel("모델명");
		jpcarName = new JPanel();
		jpcarName.add(jlcarName, BorderLayout.CENTER);
		jpcarName.setBackground(Color.gray);

		JLabel jlPhone = new JLabel("전화번호");
		jpPhone = new JPanel();
		jpPhone.add(jlPhone, BorderLayout.CENTER);
		jpPhone.setBackground(Color.gray);

		JLabel jlreceiveDay = new JLabel("입고일");
		jpreceiveDay = new JPanel();
		jpreceiveDay.add(jlreceiveDay, BorderLayout.CENTER);
		jpreceiveDay.setBackground(Color.gray);

		JLabel jlempName = new JLabel("점검사원명");
		jpempName = new JPanel();
		jpempName.add(jlempName, BorderLayout.CENTER);
		jpempName.setBackground(Color.gray);

		JLabel jlCarNo = new JLabel("차량번호");
		jpCarNo = new JPanel();
		jpCarNo.add(jlCarNo, BorderLayout.CENTER);
		jpCarNo.setBackground(Color.gray);

		JLabel jlClientName = new JLabel("고객명");
		jpClientName = new JPanel();
		jpClientName.add(jlClientName, BorderLayout.CENTER);
		jpClientName.setBackground(Color.gray);

		JLabel jlClientEmail = new JLabel("이메일");
		jpClientEmail = new JPanel();
		jpClientEmail.add(jlClientEmail, BorderLayout.CENTER);
		jpClientEmail.setBackground(Color.gray);

		JLabel jlReleaseDay = new JLabel("출고일");
		jpReleaseDay = new JPanel();
		jpReleaseDay.add(jlReleaseDay, BorderLayout.CENTER);
		jpReleaseDay.setBackground(Color.gray);

		JLabel jlCarmileage = new JLabel("주행거리");
		jpCarmileage = new JPanel();
		jpCarmileage.add(jlCarmileage, BorderLayout.CENTER);
		jpCarmileage.setBackground(Color.gray);

		JLabel jlFaultDetail = new JLabel("고장증상");
		jpFaultDetail = new JPanel();
		jpFaultDetail.add(jlFaultDetail, BorderLayout.CENTER);
		jpFaultDetail.setBackground(Color.gray);

		JLabel jlMaintenanceDetail = new JLabel("점검내용");
		jpMaintenanceDetail = new JPanel();
		jpMaintenanceDetail.add(jlMaintenanceDetail, BorderLayout.CENTER);
		jpMaintenanceDetail.setBackground(Color.gray);

		JLabel jlPartName = new JLabel("사용 부품명");
		jpPartName = new JPanel();
		jpPartName.add(jlPartName, BorderLayout.CENTER);
		jpPartName.setBackground(Color.gray);

		JLabel jlNote = new JLabel("비고");
		jpNote = new JPanel();
		jpNote.add(jlNote, BorderLayout.CENTER);
		jpNote.setBackground(Color.gray);

		JLabel jlTotal = new JLabel("합계");
		jpTotal = new JPanel();
		jpTotal.add(jlTotal, BorderLayout.CENTER);
		jpTotal.setBackground(Color.gray);

		// 게시판 기입 내용 칸
		jtfMaintenencrNo = new JTextField();
		jtfcarName = new JTextField();
		jtfPhone = new JTextField();
		jtfreceiveDay = new JTextField();
		jtfempName = new JTextField();
		jtfCarNo = new JTextField();
		jtfClientName = new JTextField();
		jtfClientEmail = new JTextField();
		jtfReleaseDay = new JTextField();
		jtfCarmileage = new JTextField();
		jtfFaultDetail = new JTextField();
		jtfMaintenanceDetail = new JTextField();

		jtfPartName = new JComboBox<String>(model);

		jtfNote = new JTextField();
		jtfTotal = new JTextField();

		// 하단 버튼
		jbPartAdd = new JButton("추가");
		jbPartRemove = new JButton("제거");

		jbCancle = new JButton("취소");
		jbFunction = new JButton("수정");

		// 부품 게시판
		dtm = new DefaultTableModel() {
			// 수량칼럼만 수정가능
			@Override
			public boolean isCellEditable(int row, int column) {
				int[] readOnlyColumns = { 0, 1, 2, 4 }; // 읽기 전용으로 만들고자 하는 칼럼 인덱스 배열

				for (int readOnlyColumn : readOnlyColumns) {
					if (column == readOnlyColumn) {
						// 읽기 전용으로 설정한 칼럼은 false를 반환하여 편집을 비활성화합니다.
						return false;
					} // end if
				} // end for

				// 나머지 칼럼은 편집 가능하게 설정합니다.
				return true;
			}// isCellEditable
		};
		jtPartTable = new JTable(dtm);
		scrollPane = new JScrollPane(jtPartTable);

		// SubWindow이벤트 실행
		CarManagerSubWindowEvt cmswe = new CarManagerSubWindowEvt(this.cmt, this, str);
		jbFunction.addActionListener(cmswe); // 수정
		jbPartAdd.addActionListener(cmswe); // 추가
		jbPartRemove.addActionListener(cmswe); // 제거
		jbCancle.addActionListener(cmswe); // 취소

		// 게시판형태 테두리 선 주기
		Border cmswBD = BorderFactory.createLineBorder(Color.LIGHT_GRAY);
		jpTitle.setBorder(cmswBD);
		jpMaintenencrNo.setBorder(cmswBD);
		jpcarName.setBorder(cmswBD);
		jpPhone.setBorder(cmswBD);
		jpreceiveDay.setBorder(cmswBD);
		jpempName.setBorder(cmswBD);
		jpCarNo.setBorder(cmswBD);
		jpClientName.setBorder(cmswBD);
		jpClientEmail.setBorder(cmswBD);
		jpReleaseDay.setBorder(cmswBD);
		jpCarmileage.setBorder(cmswBD);
		jpFaultDetail.setBorder(cmswBD);
		jpMaintenanceDetail.setBorder(cmswBD);
		jpNote.setBorder(cmswBD);
		jpTotal.setBorder(cmswBD);

		// 추가
		setLayout(null);
		setTitle(str);
		add("Center", jpTitle);

		add("Center", jpMaintenencrNo);
		add("Center", jpcarName);
		add("Center", jpPhone);
		add("Center", jpreceiveDay);
		add("Center", jpempName);

		add("Center", jtfMaintenencrNo);
		add("Center", jtfcarName);
		add("Center", jtfPhone);
		add("Center", jtfreceiveDay);
		add("Center", jtfempName);

		add("Center", jpCarNo);
		add("Center", jpClientName);
		add("Center", jpClientEmail);
		add("Center", jpReleaseDay);
		add("Center", jpCarmileage);

		add("Center", jtfCarNo);
		add("Center", jtfClientName);
		add("Center", jtfClientEmail);
		add("Center", jtfReleaseDay);
		add("Center", jtfCarmileage);

		add("Center", jpFaultDetail);
		add("Center", scrollPane);
		add("Center", jpMaintenanceDetail);
		add("Center", jpPartName);
		add("Center", jpNote);
		add("Center", jpTotal);

		add("Center", jtfFaultDetail);
		add("Center", jtfMaintenanceDetail);
		add("Center", jtfPartName);
		add("Center", jtfNote);
		add("Center", jtfTotal);

		add("Center", jbPartAdd);
		add("Center", jbPartRemove);
		add("Center", jbCancle);
		add("Center", jbFunction);

		// 위치 조절
		jpTitle.setBounds(50, 60, 270, 30);

		jpMaintenencrNo.setBounds(50, 90, 145, 30);
		jpcarName.setBounds(50, 120, 145, 30);
		jpPhone.setBounds(50, 150, 145, 30);
		jpreceiveDay.setBounds(50, 180, 145, 30);
		jpempName.setBounds(50, 210, 145, 30);

		jtfMaintenencrNo.setBounds(195, 90, 145, 30);
		jtfcarName.setBounds(195, 120, 145, 30);
		jtfPhone.setBounds(195, 150, 145, 30);
		jtfreceiveDay.setBounds(195, 180, 145, 30);
		jtfempName.setBounds(195, 210, 145, 30);

		jpCarNo.setBounds(340, 90, 145, 30);
		jpClientName.setBounds(340, 120, 145, 30);
		jpClientEmail.setBounds(340, 150, 145, 30);
		jpReleaseDay.setBounds(340, 180, 145, 30);
		jpCarmileage.setBounds(340, 210, 145, 30);

		jtfCarNo.setBounds(485, 90, 145, 30);
		jtfClientName.setBounds(485, 120, 145, 30);
		jtfClientEmail.setBounds(485, 150, 145, 30);
		jtfReleaseDay.setBounds(485, 180, 145, 30);
		jtfCarmileage.setBounds(485, 210, 145, 30);

		jpFaultDetail.setBounds(50, 240, 290, 30);
		jpMaintenanceDetail.setBounds(50, 270, 290, 30);
		jpPartName.setBounds(50, 400, 145, 30);
		jpNote.setBounds(50, 460, 290, 30);
		jpTotal.setBounds(50, 490, 290, 30);

		jtfFaultDetail.setBounds(340, 240, 290, 30);
		jtfMaintenanceDetail.setBounds(340, 270, 290, 30);
		jtfPartName.setBounds(50, 430, 580, 30);
		jtfNote.setBounds(340, 460, 290, 30);
		jtfTotal.setBounds(340, 490, 290, 30);

		jbPartAdd.setBounds(510, 400, 60, 30);
		jbPartRemove.setBounds(570, 400, 60, 30);

		jbCancle.setBounds(180, 550, 120, 30);
		jbFunction.setBounds(380, 550, 120, 30);

		setBounds(cmt.getX() + 520, cmt.getY() + 190, 700, 600);

		jlTitle.setVisible(true);

		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

	} // CarManagerSubWindow

	private Object pTotal(String string, LineBorder border) {
		// TODO Auto-generated method stub
		return null;
	}

	// getter
	public JButton getJbPartRemove() {
		return jbPartRemove;
	}

	public CarManagerTab getCmt() {
		return cmt;
	}

	public JLabel getJlTitle() {
		return jlTitle;
	}

	public JPanel getJpTitle() {
		return jpTitle;
	}

	public JPanel getJpMaintenencrNo() {
		return jpMaintenencrNo;
	}

	public JPanel getJpcarName() {
		return jpcarName;
	}

	public JPanel getJpPhone() {
		return jpPhone;
	}

	public JPanel getJpreceiveDay() {
		return jpreceiveDay;
	}

	public JPanel getJpempName() {
		return jpempName;
	}

	public JTextField getJtfMaintenencrNo() {
		return jtfMaintenencrNo;
	}

	public JTextField getJtfcarName() {
		return jtfcarName;
	}

	public JTextField getJtfPhone() {
		return jtfPhone;
	}

	public JTextField getJtfreceiveDay() {
		return jtfreceiveDay;
	}

	public JTextField getJtfempName() {
		return jtfempName;
	}

	public JPanel getJpCarNo() {
		return jpCarNo;
	}

	public JPanel getJpClientName() {
		return jpClientName;
	}

	public JPanel getJpClientEmail() {
		return jpClientEmail;
	}

	public JPanel getJpReleaseDay() {
		return jpReleaseDay;
	}

	public JPanel getJpCarmileage() {
		return jpCarmileage;
	}

	public JTextField getJtfCarNo() {
		return jtfCarNo;
	}

	public JTextField getJtfClientName() {
		return jtfClientName;
	}

	public JTextField getJtfClientEmail() {
		return jtfClientEmail;
	}

	public JTextField getJtfReleaseDay() {
		return jtfReleaseDay;
	}

	public JTextField getJtfCarmileage() {
		return jtfCarmileage;
	}

	public JPanel getJpFaultDetail() {
		return jpFaultDetail;
	}

	public JPanel getJpMaintenanceDetail() {
		return jpMaintenanceDetail;
	}

	public JPanel getJpPartName() {
		return jpPartName;
	}

	public JPanel getJpSUnitPrice() {
		return jpSUnitPrice;
	}

	public JPanel getJpSPrice() {
		return jpSPrice;
	}

	public JTextField getJtfFaultDetail() {
		return jtfFaultDetail;
	}

	public JTextField getJtfMaintenanceDetail() {
		return jtfMaintenanceDetail;
	}

	public JComboBox<String> getJtfPartName() {
		return jtfPartName;
	}

	public JTable getJtPartTable() {
		return jtPartTable;
	}

	public JButton getJbPartAdd() {
		return jbPartAdd;
	}

	public JPanel getJpNote() {
		return jpNote;
	}

	public JPanel getJpTotal() {
		return jpTotal;
	}

	public JTextField getJtfNote() {
		return jtfNote;
	}

	public JTextField getJtfTotal() {
		return jtfTotal;
	}

	public JButton getJbCancle() {
		return jbCancle;
	}

	public JButton getJbFunction() {
		return jbFunction;
	}

	public JComponent getScrollPane() {
		return scrollPane;
	}

	public DefaultTableModel getDtm() {
		return dtm;
	}

	public DefaultComboBoxModel<String> getModel() {
		return model;
	}

	public Object getPartModel() {
		// TODO Auto-generated method stub
		return null;
	}

	public JComboBox<String> getJtfEmpName() {
		// TODO Auto-generated method stub
		return null;
	}

} // class
