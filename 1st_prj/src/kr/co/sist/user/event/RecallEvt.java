package kr.co.sist.user.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.util.List;

import kr.co.sist.user.dao.RecallDAO;
import kr.co.sist.user.design.RecallDesign;
import kr.co.sist.user.vo.RecallVO;

public class RecallEvt extends WindowAdapter implements ActionListener {

	private RecallDesign rd;
	
	public RecallEvt(RecallDesign rd) {
		this.rd=rd;
		setCarInfoTable();
	}//RecallEvt
	
	public void setCarInfoTable() {
		RecallDAO rcDAO = RecallDAO.getInstance();
		List<RecallVO> rcList = null;
		
		try {
			rcList = rcDAO.selectRecall(UserData.id);
			
		// JTable의 칼럼이 0개라면 칼럼명 추가
		if(rd.getjtRecall().getColumnCount()==0) {			
			//JTable 컬럼명 설정
			String[]colNames= {"차명","리콜사유","리콜날짜"};
			for(int i=0; i<colNames.length;i++) {
				rd.getDtmRecallDesign().addColumn(colNames[i]);
			}//end for
		}//end if
		
		//JTable 행 정보 추가
		String[] addRow = new String[3];
		for(int i=0; i<rcList.size(); i++) {
			RecallVO rcVO = rcList.get(i);
			addRow[0] = rcVO.getCarName();
			addRow[1] = rcVO.getRecallReason();
			addRow[2] = String.valueOf(rcVO.getRecallDate());
			rd.getDtmRecallDesign().addRow(addRow);
		}//end for
		
		} catch (SQLException e) {
			e.printStackTrace();
		}//and catch
	}//setCarInfoTable
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		

	}
	public void windowClosing(WindowEvent we) {
		rd.dispose();

	}
}
