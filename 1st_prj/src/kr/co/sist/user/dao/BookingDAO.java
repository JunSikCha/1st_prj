package kr.co.sist.user.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kr.co.sist.user.dbconn.DbConn;
import kr.co.sist.user.vo.BookingVO;
import kr.co.sist.user.vo.CenterVO;

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

	public List<CenterVO> getCenterInfo() throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs=null;
		//커넥션 얻고, 쿼리
		DbConn db = DbConn.getInstance();
		try {
			con = db.getConnection("192.168.10.150", "manager", "1234");
			StringBuilder Query = new StringBuilder();
			Query.append(" select * from Center_info ");
			pstmt=con.prepareStatement(Query.toString());
			
			rs=pstmt.executeQuery();
			
			//쿼리해온 Center Info를 VO객체에 담기
			CenterVO cVO = new CenterVO();

			List<CenterVO> cVOList = new ArrayList<CenterVO>(); //CenterVO
			while( rs.next()){
				cVO = new CenterVO();
				cVO.setCenterNo(rs.getString("CENTERNO"));
				cVO.setcName(rs.getString("CTNAME"));
				cVO.setcAddr(rs.getString("CTADDR"));	
				
				//임의의 변수로 설정
				//콤보박스의 센터 이름 추가
				//jcbCenterName.add(rs.getString("CTNAME"));
				
				cVOList.add(cVO);
			}

			return cVOList;
		} finally {
			db.dbClose(rs, pstmt, con);
		}//end finally
	}

	//Booking테이블에 데이터 삽입
	public boolean insertBooking(BookingVO bVO) throws SQLException {

		Connection con = null;
		PreparedStatement pstmt = null;

		DbConn db = DbConn.getInstance();

		try {
			con = db.getConnection("192.168.10.150", "manager", "1234");
			
			StringBuilder insertBooking = new StringBuilder();
			
			insertBooking
			.append("	 insert into booking(booking_no, carno, modelno, issue, booking_date, centerno)	")
			.append("	 values ((select max(booking_no)+1 from booking), ?, ?, ?, ?, ? )	");

			pstmt = con.prepareStatement(insertBooking.toString());
			
			pstmt.setString(1, bVO.getCarno());
			pstmt.setString(2, bVO.getModelno());
			pstmt.setString(3, bVO.getIssue());
			pstmt.setString(4, bVO.getBdate());
			pstmt.setString(5, bVO.getCenterno());
			
			boolean flag = pstmt.execute();
			return flag;
		} finally {
			db.dbClose(null, pstmt, con);
		}//finally

	}//insertBooking
}//class
