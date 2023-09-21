package kr.co.sist.user.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import kr.co.sist.user.dbconn.DbConn;
import kr.co.sist.user.vo.NotificateVO;

public class NotificateDAO {

	private static NotificateDAO noDAO;

	private NotificateDAO() {

	}// NotificateDAO

	public static NotificateDAO getInstance() {
		if (noDAO == null) {
			noDAO = new NotificateDAO();
		} // end if
		return noDAO;
	}// getInstance

	//예약에 관한 알림``
	public NotificateVO selectBookingInfo(String id) throws SQLException {
		NotificateVO noVO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		DbConn db = DbConn.getInstance();

		try {
			con = db.getConnection("192.168.10.150", "manager", "1234");

			StringBuilder selectBookingInfo = new StringBuilder();
			selectBookingInfo
			.append("	SELECT bstatus, reason, bdate, ctname from (								")
			.append("	select bk.bstatus, bk.reason, to_char(bk.booking_date,'yyyy-mm-dd') bdate, ci.ctname	")
			.append("	from user_info ui, booking bk, center_info ci					")
			.append("	where ui.carno=bk.carno and bk.centerno=ci.centerno and user_id= ?	")
			.append("	order by bk.booking_date desc)										")
			.append("	where rownum = 1													");
			
			pstmt = con.prepareStatement(selectBookingInfo.toString());
			
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				noVO = new NotificateVO(rs.getString("bstatus"), rs.getString("reason"), rs.getString("bdate"), rs.getString("ctname"));
			}//end if
			
		} finally {
			db.dbClose(rs, pstmt, con);
		}//end finally

		return noVO;
	}
	
	public NotificateVO selectHistoryInfo(String id) throws SQLException {
		NotificateVO noVO = null;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		DbConn db = DbConn.getInstance();
		try {
			
		con = db.getConnection("192.168.10.150", "manager", "1234");
		
		StringBuilder selectHistoryInfo = new StringBuilder();
		selectHistoryInfo
		.append("	select houtbound from(								")
		.append("	select to_char(ht.houtbound,'yyyy-mm-dd') houtbound	")
		.append("	from user_info ui, history ht						")
		.append("	where ui.carno=ht.carno and user_id= ?				")
		.append("	order by ht.houtbound desc)							")
		.append("	where rownum=1										");
		
		pstmt = con.prepareStatement(selectHistoryInfo.toString());
		
		pstmt.setString(1, id);
		
		rs = pstmt.executeQuery();
		
		if(rs.next()) {
			noVO = new NotificateVO(rs.getString("houtbound"));
		}
		
		}finally {
			db.dbClose(rs, pstmt, con);
		}
		
		return noVO;
	}
	
	public static void main(String args[]) {
		try {
			System.out.println(new NotificateDAO().selectHistoryInfo("kim2"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}// class
