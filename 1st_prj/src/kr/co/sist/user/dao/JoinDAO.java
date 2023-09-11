package kr.co.sist.user.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import kr.co.sist.user.dbconn.DbConn;
import kr.co.sist.user.vo.JoinVO;


public class JoinDAO {
	
	public boolean IdCheck(String id) throws SQLException {
		boolean check;
		
		Connection con = null;
		PreparedStatement pstmt=null;
		ResultSet rs= null;
		
		try {
			con=DbConn.getInstance().getConnection("192.168.10.150", "manager", "1234");
			StringBuilder Query= new StringBuilder();
			Query.append(" select user_id from user_info ")
			.append(" where user_id = ? ");
			pstmt=con.prepareStatement(Query.toString());
			pstmt.setString(1, id);
			rs=pstmt.executeQuery();
			check=rs.next();
		} finally {
			DbConn.getInstance().dbClose(rs, pstmt, con);
		}
		return check;
	}//IdCheck
	
	public boolean createId(JoinVO jVO) throws SQLException {
		boolean check;
		
		Connection con = null;
		PreparedStatement pstmt=null;
		ResultSet rs= null;
		
		try {
			con=DbConn.getInstance().getConnection("192.168.10.150", "manager", "1234");
			StringBuilder Query= new StringBuilder();
			Query.append(" insert into user_info(user_id,user_pw,user_name,user_tel,user_email) values ( ?, ?, ?, ?, ?) ");
			pstmt=con.prepareStatement(Query.toString());
			pstmt.setString(1, jVO.getId());
			pstmt.setString(2, jVO.getPass());
			pstmt.setString(3, jVO.getName());
			pstmt.setString(4, jVO.getTel());
			pstmt.setString(5, jVO.getEmail());
			rs=pstmt.executeQuery();
			check=rs.next();
		} finally {
			DbConn.getInstance().dbClose(rs, pstmt, con);
		}
		return check;
	}
	

	/*
	 * public static void main(String[] args) { JoinDAO jd = new JoinDAO(); //
	 * JoinVO jVO= new JoinVO("pk1", "1234","테스형", "010-1111-2222", "tes@bro.com");
	 * try { System.out.println(jd.IdCheck("tes")); //
	 * System.out.println(jd.createId(jVO)); } catch (SQLException e) {
	 * e.printStackTrace(); }
	 * 
	 * }//main
	 */



}//JoinDAO