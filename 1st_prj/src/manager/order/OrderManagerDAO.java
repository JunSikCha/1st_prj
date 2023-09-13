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
	
	public List<OrderManagerVO> selectOrderInfo(String strDate, String endDate) throws SQLException{
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
			.append("		where op.sn=pi.sn	");
			
			if(!strDate.equals("")) {
				sb.append("	and	hinbound between TO_DATE(?, 'YYYY-MM-DD') and TO_DATE(?, 'YYYY-MM-DD') ");
			}//end if
			
			sb.append("		order by orderno desc		");
			pstmt = con.prepareStatement(sb.toString());
			
			if(!strDate.equals("")) {
				pstmt.setString(1, strDate);
				pstmt.setString(2, endDate);
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
	
	public PartInfoVO selectPartInfo(String partName) {
		PartInfoVO pVO = new PartInfoVO();
		
		return pVO;
	}
	
	public void insertOrderInfo(OrderManagerVO omVO) {
		
		
		
	}
	
	public int updateStock(String partName, int quantity) {
		int count =0;
		
		return count;
	}

}
