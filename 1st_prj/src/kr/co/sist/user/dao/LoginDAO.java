package kr.co.sist.user.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import kr.co.sist.user.dbconn.DbConn;
import kr.co.sist.user.vo.LoginResultVO;
import kr.co.sist.user.vo.LoginVO;

public class LoginDAO {
	
	private static LoginDAO lgDAO;
	
	private LoginDAO() {
		
	}//LoginDAO
	
	public static LoginDAO getInstance() {
		if(lgDAO == null) {
			lgDAO = new LoginDAO();
		}//end if
		return lgDAO;
	}//getInstance
	
	public LoginResultVO login(LoginVO lVO) throws SQLException {
		LoginResultVO lrVO = null;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		DbConn db = DbConn.getInstance();
		
		try {
			con = db.getConnection("192.168.10.150", "manager", "1234");
			
			StringBuilder selectLogin = new StringBuilder();
			selectLogin
			.append("		select user_name  ")
			.append("		from user_info   ")
			.append("		where user_id=? and user_pw=? ");
			
			pstmt = con.prepareStatement(selectLogin.toString());
			
			pstmt.setString(1, lVO.getId());
			pstmt.setString(2, lVO.getPassword());
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				lrVO = new LoginResultVO(rs.getString("user_name"));
			}
			
		}finally {
			db.dbClose(rs, pstmt, con);
		}//end finally
		
		return lrVO;
	}
	
	
}
