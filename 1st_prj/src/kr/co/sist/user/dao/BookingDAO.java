package kr.co.sist.user.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import kr.co.sist.user.dbconn.DbConn;
import kr.co.sist.user.vo.BookingVO;

public class BookingDAO {

	private static BookingDAO bDAO;

	private BookingDAO() {

	}// BookingDAO

	public static BookingDAO getInstance() {
		if (bDAO == null) {
			bDAO = new BookingDAO();
		}
		return bDAO;
	}// getInstance

	public void insertBooking(BookingVO bVO) throws SQLException {

		Connection con = null;
		PreparedStatement pstmt = null;

		DbConn db = DbConn.getInstance();

		try {
			con = db.getConnection("192.168.10.150", "manager", "1234");
			
			StringBuilder insertBooking = new StringBuilder();
			
			insertBooking
			.append("	insert into booking(booking_no, carno, modelno, issue, to_char(booking_date,'yyyy-mm-dd hh24:mi:ss') bdate, centerno)	")
			.append("	values ((select max(booking_no)+1 from booking),?,?,?,?,?)	");

			pstmt = con.prepareStatement(insertBooking.toString());
			
			pstmt.setString(1, bVO.getCarno());
			pstmt.setString(2, bVO.getModelno());
			pstmt.setString(3, bVO.getIssue());
			pstmt.setString(4, bVO.getBdate());
			pstmt.setString(5, bVO.getCenterno());
			
			pstmt.execute();
			
		} finally {
			db.dbClose(null, pstmt, con);
		}//finally

	}//insertBooking

}
