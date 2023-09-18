package kr.co.sist.user.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kr.co.sist.user.dbconn.DbConn;
import kr.co.sist.user.vo.BookingCheckVO;



public class BookingCheckDAO {

	private static BookingCheckDAO bcDAO;

	private BookingCheckDAO() {

	}// BookingCheckDAO

	public static BookingCheckDAO getInstance() {
		if (bcDAO == null) {
			bcDAO = new BookingCheckDAO();
		}
		return bcDAO;
	}// getInstance

	public List<BookingCheckVO> selectBooking(String id, String strDate,String endDate) throws SQLException {
		BookingCheckVO bcVO;
		List<BookingCheckVO> bcList = new ArrayList<BookingCheckVO>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		DbConn db = DbConn.getInstance();

		try {

			con = db.getConnection("192.168.10.150", "manager", "1234");

			StringBuilder selectBooking = new StringBuilder();
			selectBooking
			.append(" SELECT to_char(bk.booking_date, 'yyyy-mm-dd') bdate, to_char(bk.booking_date, 'hh24:mi') btime, ht.hdetail, ci.ctname, bk.bstatus, bk.reason")
            .append(" FROM user_info ui, history ht, Booking bk, center_info ci")
            .append(" WHERE ui.carno = ht.carno and ht.carno = bk.carno and bk.centerno = ci.centerno and ui.user_id = ?");

if (!strDate.equals("")) {
   selectBooking.append(" and bk.booking_date between TO_DATE(?, 'YYYY-MM-DD') and TO_DATE(?, 'YYYY-MM-DD')");
}

selectBooking.append(" group by bk.booking_no, to_char(bk.booking_date, 'yyyy-mm-dd'), to_char(bk.booking_date, 'hh24:mi'), ht.hdetail, ci.ctname, bk.bstatus, bk.reason");

			
			pstmt = con.prepareStatement(selectBooking.toString());

			if(!strDate.equals("")) {
				pstmt.setString(1, id);
				pstmt.setString(2, strDate);
				pstmt.setString(3, endDate);
				
			}

			rs = pstmt.executeQuery();

			while (rs.next()) {
				bcVO = new BookingCheckVO();
				bcVO.setBdate(rs.getString("bdate"));
				bcVO.setBtime(rs.getString("btime"));
				bcVO.setDetail(rs.getString("hdetail"));
				bcVO.setCenter(rs.getString("ctname"));
				bcVO.setStatus(rs.getString("bstatus"));
				bcVO.setReason(rs.getString("reason"));
				
				bcList.add(bcVO);
			}

		} finally {
			db.dbClose(rs, pstmt, con);
		}//end finally

		return bcList;
	}//selectBooking
	public static void main(String[] args) {
		BookingCheckDAO bcDAO = new BookingCheckDAO();
		try {
			System.out.println(bcDAO.selectBooking("kim2", "2022-09-03", "2022-09-05"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
	}

}//class
