package manager.login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dbConn.DbConn;


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
	
	public LoginVO selectLogin(LoginVO VO) throws SQLException {
		LoginVO lVO = VO;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		DbConn db = DbConn.getInstance();
		
		try {
			con = db.getConnection("192.168.10.150", "manager", "1234");
			
			StringBuilder selectLogin = new StringBuilder();
			selectLogin
			.append("		select empname, empemail, emptel,centerno  ")
			.append("		from emp_info   ")
			.append("		where empno=? and emppw=? ");
			
			pstmt = con.prepareStatement(selectLogin.toString());
			
			pstmt.setString(1, lVO.getEmpno());
			pstmt.setString(2, lVO.getPassword());
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				lVO.setEmpname(rs.getString("empname"));
				lVO.setEmpemail(rs.getString("empemail"));
				lVO.setEmptel(rs.getString("emptel"));
				lVO.setCenterNo(rs.getString("centerno"));
				lVO.setEmpname(rs.getString("empname"));
				
			}
			
		}finally {
			db.dbClose(rs, pstmt, con);
		}//end finally
		
		return lVO;
	}
	
	
}
