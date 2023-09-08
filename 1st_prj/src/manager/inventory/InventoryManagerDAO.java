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

	public List<InventoryManagerVO> selectInventoryInfo(String partName) throws SQLException {
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
			.append("		where 	pi.sn=s.sn	");

			if(!partName.equals("")) {
				sb.append("	and	sname like '%'||?||'%' ");
			}//end if
			pstmt = con.prepareStatement(sb.toString());

			if(!partName.equals("")) {
				pstmt.setString(1, partName);
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

	public void insertInventoryInfo(InventoryManagerVO imVO) {

	}

}
