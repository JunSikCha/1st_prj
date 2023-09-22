package manager.order;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import manager.login.LoginVO;

public class OrderManagerEvt implements ActionListener {
	private OrderManagerTab omt;
	private LoginVO lVO;
	
	public OrderManagerEvt(OrderManagerTab omt,LoginVO lVO) {
		this.omt = omt;
		this.lVO = lVO;
		setOrderTable();
	}
	
	public void setOrderTable() {
		OrderManagerDAO omDAO = OrderManagerDAO.getInstance();

		String strDate = omt.getJtfStartDate().getText();
		String endDate = omt.getJtfEndDate().getText();
		List<OrderManagerVO> list = null;

		// "YYYY-MM-DD" 형식의 정규식
		String regex = "\\d{4}-\\d{2}-\\d{2}";

		// 정규식 패턴을 컴파일합니다.
		Pattern pattern = Pattern.compile(regex);

		// 입력 문자열과 패턴을 매칭합니다.
		Matcher strMatcher = pattern.matcher(strDate);
		Matcher endMatcher = pattern.matcher(endDate);

		// 정규식 패턴에 일치하지 않으면 ""으로 처리
		if (!strMatcher.matches() || !endMatcher.matches()) {
			strDate = "";
			endDate = "";
		} // end if
		String certerNo = lVO.getCenterNo();

		try {
			list = omDAO.selectOrderInfo(strDate, endDate,certerNo);

			// JTable의 칼럼이 0개라면 칼럼명 추가
			if (omt.getJtbOrderInfoTable().getColumnCount() == 0) {
				// JTable 칼럼명 설정
				String[] columnNames = { "발주번호", "발주일", "S/N", "부품명", "발주수량", "단위", "단가", "소계" };
				for (int i = 0; i < columnNames.length; i++) {
					omt.getDtm().addColumn(columnNames[i]);
				} // end for
			} // end if

			// JTable 데이터 삭제
			omt.getDtm().setRowCount(0);

			// JTable 행 정보 추가
			String[] arrRow = new String[8];
			for (int i = 0; i < list.size(); i++) {
				OrderManagerVO omVO = list.get(i);
				arrRow[0] = String.valueOf(omVO.getOrderNo());
				arrRow[1] = omVO.getOrderDate();
				arrRow[2] = omVO.getPartNo();
				arrRow[3] = omVO.getPartName();
				arrRow[4] = String.valueOf(omVO.getOrderQuantity());
				arrRow[5] = omVO.getPartUnit();
				arrRow[6] = String.valueOf(omVO.getPartCost());
				arrRow[7] = String.valueOf(omVO.getOrderQuantity()*omVO.getPartCost());
				omt.getDtm().addRow(arrRow);
			} // end for


		} catch (SQLException e) {
			e.printStackTrace();
		} // end catch
		
	}
	
	public void dateSerch() {
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==omt.getJbOrder()){
			new OrderManagerSubWindow(omt,lVO);
		}
		
		
	}
	
}
