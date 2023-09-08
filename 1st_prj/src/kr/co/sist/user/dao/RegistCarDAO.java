package kr.co.sist.user.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import kr.co.sist.user.dbconn.DbConn;
import kr.co.sist.user.vo.RegistCarVO;

public class RegistCarDAO {
	
	private static RegistCarDAO rDAO;
	
	private RegistCarDAO() {
		
	}//RegistCarDAO
	
	public static RegistCarDAO getInstance() {
		if(rDAO == null) {
			rDAO = new RegistCarDAO();
		}//end if
		return rDAO;
	}//getInstance
	
	public void insertCarinfo(RegistCarVO rcVO) throws SQLException {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		DbConn db = DbConn.getInstance();
		
		try {
			con = db.getConnection("192.168.10.150", "manager", "1234");
			
			String insertCarinfo ="insert into user_car_info(MODELNO, CARNO, CMILEAGE) values(?,?,?)";
			pstmt = con.prepareStatement(insertCarinfo);
			
			pstmt.setString(1, rcVO.getCarModel());
			pstmt.setString(2, rcVO.getCarNo());
			pstmt.setInt(3, rcVO.getDistance());
			
			pstmt.execute();
			
		}finally {
			db.dbClose(null, pstmt, con);
		}//finally
		
	}//insertCarinfo
	
}//class
