package kr.co.sist.user.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kr.co.sist.user.dbconn.DbConn;
import kr.co.sist.user.vo.HistoryVO;

public class HistoryDAO {
	
	private static HistoryDAO htDAO;
	
	private HistoryDAO() {
		
	}//HistoryDAO
	
	public static HistoryDAO getInstance() {
		if(htDAO == null) {
			htDAO = new HistoryDAO();
		}
		return htDAO;
	}//getInstance
	
	public List<HistoryVO> selectHistory(String id) throws SQLException{
		HistoryVO htVO;
		
		List<HistoryVO> htList = new ArrayList<HistoryVO>();
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		DbConn db = DbConn.getInstance();
		
		try {
			
			con = db.getConnection("192.168.10.150", "manager", "1234");
			
			StringBuilder selectHistory = new StringBuilder();
			selectHistory
			.append("	SELECT ht.hinbound, ht.hdetail, pi.sunitprice+pi.sprice total	")
			.append("	FROM user_info ui, history ht, used_parts up, parts_info pi	")
			.append("	WHERE ui.carno=ht.carno and ht.carno=up.carno and up.sn=pi.sn and ui.user_id=?	");
			
			pstmt = con.prepareStatement(selectHistory.toString());
			
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				htVO = new HistoryVO(rs.getDate("hinbound"),rs.getString("hdetail"),rs.getInt("total"));
				htList.add(htVO);
			}
			
		}finally {
			db.dbClose(rs, pstmt, con);
		}
		
		return htList;
	}//selectHistory
	
	public static void main(String[] args) {
		HistoryDAO htDAO = new HistoryDAO();
		try {
			System.out.println(htDAO.selectHistory("kim2"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}// main
	
}//class
