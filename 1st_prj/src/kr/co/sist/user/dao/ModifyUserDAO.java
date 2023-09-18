package kr.co.sist.user.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import kr.co.sist.user.dbconn.DbConn;
import kr.co.sist.user.vo.ModifyUserVO;

public class ModifyUserDAO {

	private static ModifyUserDAO muDAO;
	
	private ModifyUserDAO() {
		
	}//ModifyUserDAO
	
	public static ModifyUserDAO getInstance() {
		if(muDAO == null) {
			muDAO = new ModifyUserDAO();
		}
		return muDAO;
	}//getInstance
	
	public ModifyUserVO selectUserName(String id) throws SQLException {
		ModifyUserVO muVO = null;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		DbConn db = DbConn.getInstance();
		
		try {
			
			con = db.getConnection("192.168.10.150", "manager", "1234");
			
			StringBuilder selectUserName = new StringBuilder();
			selectUserName
			.append("	select user_name	")
			.append("	from user_info	")
			.append("	where user_id=?	");
			
			pstmt = con.prepareStatement(selectUserName.toString());
			
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				muVO = new ModifyUserVO(rs.getString("user_name"));
			}//end if
			
			System.out.println(muVO);
			
		}finally {
			db.dbClose(rs, pstmt, con);
		}//end finally
		
		return muVO;
	}//selectUserName
	
	public int updateUser(ModifyUserVO muVO) throws SQLException {
		int rowCnt = 0;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		DbConn db = DbConn.getInstance();
		
		try {
			con = db.getConnection("192.168.10.150", "manager", "1234");
			
			StringBuilder updateUser = new StringBuilder();
			updateUser
			.append("	update user_info					")
			.append("	set user_tel=	?, user_email=	?	")
			.append("	where user_id=	?					");
			
			pstmt=con.prepareStatement(updateUser.toString());
			
			pstmt.setString(1, muVO.getUserTel());
			pstmt.setString(2, muVO.getUserEmail());
			pstmt.setString(3, muVO.getUserID());
			
			rowCnt=pstmt.executeUpdate();
			
		}finally {
			db.dbClose(null, pstmt, con);
		}//finally
		return rowCnt;
	}//updateUser
	
}//class
