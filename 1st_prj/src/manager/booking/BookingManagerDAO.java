package manager.booking;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dbConn.DbConn;
import manager.carmanager.CarManagerVO;

public class BookingManagerDAO {
	private static BookingManagerDAO bmDAO;
	
	private BookingManagerDAO() {
		
	}
	
	public static BookingManagerDAO getInstance() {
		if(bmDAO==null) {
			bmDAO=new BookingManagerDAO();
		}
		return bmDAO;
	}
	
	public List<BookingManagerVO> selectBooking(String strDate, String endDate,String status,String certerNo, String isnull) throws SQLException{
		List<BookingManagerVO> list = new ArrayList<BookingManagerVO>();
		
		BookingManagerVO bmVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		DbConn db = DbConn.getInstance();
		
		try {
			
			con=db.getConnection("192.168.10.150", "manager", "1234");
			StringBuilder sb = new StringBuilder();
			
			sb
			.append("		select  booking_no, to_char(booking_date,'yyyy-mm-dd HH:mi') booking_date, ci.mname,issue,  bstatus, ui.user_id, ui.user_name, reason	")
			.append("		from booking b, car_info ci, user_info ui	")
			.append("		where centerno = ? and  b.modelno=ci.modelno and ui.carno=b.carno  	");
			
			if(!strDate.equals("")) {
				sb.append("	and	booking_date between TO_DATE(?, 'YYYY-MM-DD') and TO_DATE(?, 'YYYY-MM-DD') ");
			}//end if
			if(status!=null&&status.equals("Y")) {
				sb.append("		and bstatus = 'y'	");
			}
			if(isnull!=null) {
				sb.append("	and bstatus is null	");
			}
			
			sb
			.append("		order by booking_no desc	");
			pstmt = con.prepareStatement(sb.toString());
			
			pstmt.setString(1, certerNo);
			
			if(!strDate.equals("")) {
				pstmt.setString(2, strDate);
				pstmt.setString(3, endDate);
			}//end if
			
			
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				bmVO = new BookingManagerVO();
				bmVO.setBookingNo(rs.getInt("booking_no"));
				bmVO.setBookingDate(rs.getString("booking_date"));
				bmVO.setCarName(rs.getString("mname"));
				bmVO.setFaultDetail(rs.getString("issue"));
				bmVO.setClientId(rs.getString("user_id"));
				bmVO.setClientName(rs.getString("user_name"));
				bmVO.setBookingBoolean(rs.getString("bstatus"));
				bmVO.setReasons(rs.getString("reason"));
				list.add(bmVO);
			}//end while
			
		}finally {
			db.dbClose(rs, pstmt, con);
		}//finally
		
		
		
		return list;
	}
	

	//신청을 수락하는 메소드(수락버튼을 누를때)
	public int updateAccept(List<String> no) throws SQLException {
		int cnt=0;
		Connection con = null;
		PreparedStatement pstmt = null;
		DbConn db = DbConn.getInstance();
		
		try {
		con=db.getConnection("192.168.10.150", "manager", "1234");
		StringBuilder sb = new StringBuilder();
		sb
		.append("		update  booking 	")
		.append("		set  bstatus='y' 	")
		.append("		where  booking_no = ? 	");
		
		pstmt = con.prepareStatement(sb.toString());
		
		//매개변수 no의 개수만큼 반복쿼리
		for(int i=0; i<no.size(); i++) {
			pstmt.setInt(1, Integer.valueOf(no.get(i)));
			System.out.println(Integer.valueOf(no.get(i)));
			cnt += pstmt.executeUpdate();
			System.out.println(cnt);
			pstmt.clearParameters();
			}
		} finally {
			db.dbClose(null, pstmt, con);
		}
		return cnt;
	}
	
	//신청을 거절하는 메소드
	public int updateRefusal(List<String> no,String reasons) throws SQLException {
		int cnt =0;

		Connection con = null;
		PreparedStatement pstmt = null;
		
		DbConn db = DbConn.getInstance();
		
		try {
		con=db.getConnection("192.168.10.150", "manager", "1234");
		StringBuilder sb = new StringBuilder();
		sb
		.append("		update booking 	")
		.append("		set bstatus= 'n' , reason= ?   	")
		.append("		where booking_no = ? 	");
		
		pstmt = con.prepareStatement(sb.toString());
		
		for(int i=0; i<no.size(); i++) {
			pstmt.setString(1, reasons);
			pstmt.setString(2, no.get(i));
			
			cnt += pstmt.executeUpdate();
			pstmt.clearParameters();
			}
		
		} finally {
			db.dbClose(null, pstmt, con);
		}
		
		return cnt;
	}

}
