package manager.inventory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dbConn.DbConn;

public class InventoryManagerDAO {
	private static InventoryManagerDAO imDAO;

	private InventoryManagerDAO() {

	}

	public static InventoryManagerDAO getInstance() {
		if (imDAO == null) {
			imDAO = new InventoryManagerDAO();
		}

		return imDAO;
	}

	public List<InventoryManagerVO> selectInventoryInfo(String partName,String certerNo) throws SQLException {
		List<InventoryManagerVO> list = new ArrayList<InventoryManagerVO>();
		InventoryManagerVO imVO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		DbConn db = DbConn.getInstance();

		try {

			con = db.getConnection("192.168.10.150", "manager", "1234");
			StringBuilder sb = new StringBuilder();

			sb
			.append("		select  pi.sn,sname, amount, sunit,sunitprice, sprice, sinput_date	")
			.append("		from 	parts_info pi, stock s	")
			.append("		where 	pi.sn=s.sn and centerno = ?	");

			if(!partName.equals("")) {
				sb.append("	and	sname like '%'||?||'%' ");
			}//end if
			pstmt = con.prepareStatement(sb.toString());

			pstmt.setString(1, certerNo);
			if(!partName.equals("")) {
				pstmt.setString(2, partName);
			}//end if

			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				imVO = new InventoryManagerVO();
				imVO.setPartNo(rs.getString("sn"));
				imVO.setPartName(rs.getString("sname"));
				imVO.setPartStock(rs.getInt("amount"));
				imVO.setPartUnit(rs.getString("sunit"));
				imVO.setPartCost(rs.getInt("sunitprice"));
				imVO.setLaborCost(rs.getInt("sprice"));
				
				list.add(imVO);
				
			}
		} finally {
			db.dbClose(rs, pstmt, con);
		} // finally

		return list;
	}

	public int insertInventoryInfo(InventoryManagerVO imVO) throws SQLException {
		int rowCnt = 0;
		Connection con = null;
		PreparedStatement pstmt = null;
		
		DbConn db = DbConn.getInstance();
		
		try {
			
			con=db.getConnection("192.168.10.150", "manager", "1234");
			StringBuilder sb = new StringBuilder();
			
			sb
			.append("		insert into  parts_info(sn, sname, sunit, sunitprice, sprice, sinput_date)	")
			.append("		values (	?,?,?,?,?,sysdate)  		");
			
			pstmt = con.prepareStatement(sb.toString());
			
			pstmt.setString(1,imVO.getPartNo() );
			pstmt.setString(2,imVO.getPartName() );
			pstmt.setInt(3, imVO.getPartCost());
			pstmt.setInt(4, imVO.getLaborCost());
			
			rowCnt = pstmt.executeUpdate();
		}finally {
			db.dbClose(null, pstmt, con);
		}//finally
		return rowCnt;
	}
}
