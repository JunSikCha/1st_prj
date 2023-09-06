package client;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClientMainDAO {

	private static ClientMainDAO cDAO;
	
	private ClientMainDAO() {
		
	}//ClientMainDAO
	
	public static ClientMainDAO getInstance() {
		if(cDAO == null) {
			cDAO = new ClientMainDAO();
		}//end if
		return cDAO;
	}//getInstance
	
	public ClientMainVO selectCarInfo(String id) throws SQLException {
		ClientMainVO cmVO=null;
		
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		DbConn db = DbConn.getInstance();
		
		try {
			con = db.getConnection("192.168.10.150", "manager", "1234");
			
			StringBuilder selectCarInfo = new StringBuilder();
			selectCarInfo
			.append("		SELECT uci.carno, ci.mName")
			.append("		FROM user_info ui, USER_CAR_INFO uci, CAR_INFO ci")
			.append("		WHERE ui.modelno = uci.modelno and uci.modelno = ci.modelno and ui.user_id =?");
			
			pstmt =con.prepareStatement(selectCarInfo.toString());
			
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				cmVO = new ClientMainVO(rs.getString("carno"),rs.getString("mName"));
//				cmList.add(cmVO);
			}//end while
			
		}finally {
			db.dbClose(rs, pstmt, con);
		}//end finally
		
		return cmVO;
	}//selectCarInfo
	
	public static void main(String[] args) {
		ClientMainDAO cmDAO = new ClientMainDAO();
		try {
			System.out.println(cmDAO.selectCarInfo("cha"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}//class
