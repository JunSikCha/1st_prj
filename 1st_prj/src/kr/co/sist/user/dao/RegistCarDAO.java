package kr.co.sist.user.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kr.co.sist.user.dbconn.DbConn;
import kr.co.sist.user.vo.RegistCarVO;

public class RegistCarDAO {
	
	private static RegistCarDAO rDAO;
	
	public static RegistCarDAO getInstance() {
		if(rDAO == null) {
			rDAO = new RegistCarDAO();
		}//end if
		return rDAO;
	}//getInstance
	
	public List<String> selectModel() throws SQLException{
		List<String> nameList = new ArrayList<String>();
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		DbConn db = DbConn.getInstance();
		
		try {
			con = db.getConnection("192.168.10.150", "manager", "1234");
			String selectModel = "select mname from car_info";
			
			pstmt = con.prepareStatement(selectModel);			
			
			rs=pstmt.executeQuery();
			while(rs.next()) {
				nameList.add(rs.getString("mname"));
			}//end while
			
		}finally {
			db.dbClose(rs, pstmt, con);
		}//end finally
		
		return nameList;
	}//selectCarno
	
	public String selectModelno(String mname) throws SQLException{
		String modelNo = null;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		DbConn db = DbConn.getInstance();
		
		try {
			con = db.getConnection("192.168.10.150", "manager", "1234");
			String selectModelno = "select modelno from car_info where mname=?";
			
			pstmt = con.prepareStatement(selectModelno);
					
			pstmt.setString(1, mname);
			
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				modelNo = rs.getString("modelno");
			}//end while
			
		}finally {
			db.dbClose(rs, pstmt, con);
		}//end finally
		
		return modelNo;
	}//selectCarno
	
	
	
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
	
	public int updateUserCarInfo(RegistCarVO rcVO) throws SQLException {
		int rowCnt = 0;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		DbConn db = DbConn.getInstance();
		
		try {
			con = db.getConnection("192.168.10.150", "manager", "1234");
			
			StringBuilder updateInfo = new StringBuilder();
			updateInfo
			.append("	update user_info		")
			.append("	set carno=?, modelno=?	")
			.append("	where user_id=?			");
			
			pstmt = con.prepareStatement(updateInfo.toString());
			
			pstmt.setString(1, rcVO.getCarNo());
			pstmt.setString(2, rcVO.getModelNo());
			pstmt.setString(3, rcVO.getId());
			
			rowCnt = pstmt.executeUpdate();
			
		}finally {
			db.dbClose(null, pstmt, con);
		}//end finally
		
		return rowCnt;
	}
	
}//class
