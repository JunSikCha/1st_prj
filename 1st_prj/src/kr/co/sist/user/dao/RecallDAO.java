package kr.co.sist.user.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kr.co.sist.user.dbconn.DbConn;
import kr.co.sist.user.vo.RecallVO;

public class RecallDAO {

	private static RecallDAO rcDAO;
	
	private RecallDAO() {
		
	}//RecallDAO
	
	public static RecallDAO getInstance() {
		if(rcDAO == null) {
			rcDAO = new RecallDAO();
		}//end if
		return rcDAO;
	}//getInstance
	
	public List<RecallVO> selectRecall(String id) throws SQLException {
		
		List<RecallVO> rcList = new ArrayList<RecallVO>();
		
		RecallVO rcVO = null;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		DbConn db = DbConn.getInstance();
		
		try {
			con = db.getConnection("192.168.10.150", "manager", "1234");
			
			StringBuilder selectRecall = new StringBuilder();
			selectRecall
			.append(	"	select ci.mName, rc.rDetail, rc.rDate"							)
			.append(	"	from user_info ui, user_car_info uci, car_info ci, recall rc"	)
			.append(	"	where ui.carno = uci.carno and uci.modelno = ci.modelno "
					+ "and ci.modelno = rc.modelno and ui.user_id=?"					);
			
			pstmt = con.prepareStatement(selectRecall.toString());
			
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				rcVO = new RecallVO(rs.getString("mName"), rs.getString("rDetail"), rs.getDate("rDate"));
				rcList.add(rcVO);
			}
			
		}finally {
			db.dbClose(rs, pstmt, con);
		}
		return rcList;
	}
	
	public static void main(String[] args) {
		RecallDAO rcDAO = new RecallDAO();
		try {
			System.out.println(rcDAO.selectRecall("hong"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}//class
