package kr.co.sist.user.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import kr.co.sist.user.dbconn.DbConn;
import kr.co.sist.user.vo.NotificateVO;

public class NotificateDAO {
	
	private static NotificateDAO noDAO;
	
	private NotificateDAO() {
		
	}//NotificateDAO
	
	public static NotificateDAO getInstance() {
		if(noDAO == null) {
			noDAO = new NotificateDAO();
		}//end if
		return noDAO;
	}//getInstance
	
	public NotificateVO selectNotifyInfo() {
		NotificateVO noVO = null;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		DbConn db = DbConn.getInstance();
		
		
		
		return noVO;
	}
	
}//class
