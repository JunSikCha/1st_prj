package kr.co.sist.user.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import kr.co.sist.user.dbconn.DbConn;
import kr.co.sist.user.vo.ModifyPassVO;

public class ModifyPassDAO {
	
	private static ModifyPassDAO mpDAO;
	
	private ModifyPassDAO() {
		
	}//ModifyPassDAO
	
	public static ModifyPassDAO getInstance() {
		if(mpDAO == null) {
			mpDAO = new ModifyPassDAO();
		}
		return mpDAO;
	}
	
	public int updatePass(ModifyPassVO mpVO) throws SQLException {
		int rowCnt = 0;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		DbConn db = DbConn.getInstance();
		
		try {
			
			con = db.getConnection("192.168.10.150", "manager", "1234");
			
			StringBuilder updatePass = new StringBuilder();
			updatePass
			.append("	update user_info	")
			.append("	set user_pw=?		")
			.append("	where user_id=?		");
			
			pstmt = con.prepareStatement(updatePass.toString());
			
			pstmt.setString(1, mpVO.getNewPass());
			pstmt.setString(2, mpVO.getID());
			
			rowCnt = pstmt.executeUpdate();
			
		}finally {
			db.dbClose(null, pstmt, con);
		}//end finally
		
		return rowCnt;
	}//updatePass
	
}
