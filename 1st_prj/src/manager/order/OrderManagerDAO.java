package manager.order;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dbConn.DbConn;
import manager.carmanager.CarManagerVO;
import manager.inventory.PartInfoVO;

public class OrderManagerDAO {
	private static OrderManagerDAO imDAO;
	
	private OrderManagerDAO() {
		
	}
	
	public static OrderManagerDAO getInstance() {
		if(imDAO==null) {
			imDAO=new OrderManagerDAO();
		}
		return imDAO;
	}
	
	//발주탭 전체 발주내용 출력
	public List<OrderManagerVO> selectOrderInfo(String strDate, String endDate,String certerno) throws SQLException{
		List<OrderManagerVO> list = new ArrayList<OrderManagerVO>();
		OrderManagerVO omVO	= null;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		DbConn db = DbConn.getInstance();
		
		try {
			
			con=db.getConnection("192.168.10.150", "manager", "1234");
			StringBuilder sb = new StringBuilder();
			
			sb
			.append("		select  orderno, oinput_date, op.sn, pi.sname , oamount,pi.sunit    ,pi.sunitprice	")
			.append("		from order_parts op, parts_info pi	")
			.append("		where op.sn=pi.sn	and op.centerno = ? ");
			
			if(!strDate.equals("")) {
				sb.append("	and	hinbound between TO_DATE(?, 'YYYY-MM-DD') and TO_DATE(?, 'YYYY-MM-DD') ");
			}//end if
			
			sb.append("		order by orderno desc		");
			pstmt = con.prepareStatement(sb.toString());
			
			pstmt.setString(1, certerno);
			
			if(!strDate.equals("")) {
				pstmt.setString(2, strDate);
				pstmt.setString(3, endDate);
			}//end if
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				omVO = new OrderManagerVO();
				omVO.setOrderNo(rs.getInt("orderno"));
				omVO.setOrderDate(rs.getString("oinput_date"));
				omVO.setPartNo(rs.getString("sn"));
				omVO.setPartName(rs.getString("sname"));
				omVO.setOrderQuantity(rs.getInt("oamount"));
				omVO.setPartUnit(rs.getString("sunit"));
				omVO.setPartCost(rs.getInt("sunitprice"));
				
				list.add(omVO);
			}//end while
			
		}finally {
			db.dbClose(rs, pstmt, con);
		}//finally
		return list;
	}
	
	//현 재고와 단위조회
	public PartInfoVO selectPartInfo(String partNo) throws SQLException{
		
		PartInfoVO piVO = new PartInfoVO();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		DbConn db = DbConn.getInstance();
		
		try {
			
			con=db.getConnection("192.168.10.150", "manager", "1234");
			StringBuilder sb = new StringBuilder();
			
			sb
			.append("		select  pi.sn, sname, amount   , sunit	")
			.append("		from 	parts_info pi, stock s	")
			.append("		where 	pi.sn = ? and pi.sn = s. sn 	");
			
			pstmt = con.prepareStatement(sb.toString());
			
			pstmt.setString(1, partNo);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				piVO.setPartStock(rs.getString("amount"));
				piVO.setPartUnit(rs.getString("sunit"));
				
			}//end if
			
		}finally {
			db.dbClose(rs, pstmt, con);
		}//finally
		
		
		return	 piVO;
	}//selectOnePartInfo
	
	//발주번호 조회하기
	public int selectOrderNo() throws SQLException{
		int orderNo = 0;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		DbConn db = DbConn.getInstance();
		
		try {
			
			con=db.getConnection("192.168.10.150", "manager", "1234");
			StringBuilder sb = new StringBuilder();
			
			sb
			.append("		select  max( orderno)	")
			.append("		from order_parts	");
			
			pstmt = con.prepareStatement(sb.toString());
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				orderNo = rs.getInt(1);
			}
		}finally {
			db.dbClose(null, pstmt, con);
		}//finally
		return orderNo;
	}
	
	//발주DB에 인설트
	public int insertOrderInfo(OrderManagerVO omVO,String centerNo) throws SQLException {
		int rowCnt = 0;
		Connection con = null;
		PreparedStatement pstmt = null;
		
		DbConn db = DbConn.getInstance();
		
		try {
			
			con=db.getConnection("192.168.10.150", "manager", "1234");
			StringBuilder sb = new StringBuilder();
			
			sb
			.append("		insert into order_parts(orderno, sn, oamount, centerno,oinput_date)	")
			.append("		values( ?,?,?,?,sysdate) 		");
			
			pstmt = con.prepareStatement(sb.toString());
			
			pstmt.setInt(1, omVO.getOrderNo());
			pstmt.setString(2, omVO.getPartNo());
			pstmt.setInt(3, omVO.getOrderQuantity());
			pstmt.setString(4, centerNo);
			
			rowCnt = pstmt.executeUpdate();
		}finally {
			db.dbClose(null, pstmt, con);
		}//finally
		return rowCnt;
	}
	
	public int updateStock(String partsn, int quantity,String centerNo) throws SQLException {
		int cnt =0;
		Connection con = null;
		PreparedStatement pstmt = null;
		
		DbConn db = DbConn.getInstance();
		
		try {
			
			con=db.getConnection("192.168.10.150", "manager", "1234");
			StringBuilder sb = new StringBuilder();
			
			sb
			.append("		update  stock					")
			.append("		set     amount = ?			")
			.append("		where 	sn = ?	and centerno = ?		");
			
			pstmt = con.prepareStatement(sb.toString());
			
			pstmt.setInt(1, quantity);
			pstmt.setString(2, partsn);
			pstmt.setString(3, centerNo);
			
			cnt = pstmt.executeUpdate();
		}finally {
			db.dbClose(null, pstmt, con);
		}//finally
		return cnt;
	}

}
