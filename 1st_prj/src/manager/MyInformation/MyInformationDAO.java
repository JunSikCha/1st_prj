package manager.MyInformation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dbConn.DbConn;

public class MyInformationDAO {
	private static MyInformationDAO miDAO;
	
	private MyInformationDAO() {
		
	} //MyInformationDAO
	
	
	public static MyInformationDAO getInstance() {
		if(miDAO==null) {
			miDAO=new MyInformationDAO();
		}
		return miDAO;
	} //getInstance
	
	
	
	//매니저 로그인을 통해 매니저 정보 불러오기
	public MyInformationVO selectEmpInfo(/*ManagerLoginVO*/) throws SQLException {
		MyInformationVO miVO=new MyInformationVO();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		DbConn db = DbConn.getInstance();
		
		try {
			con=db.getConnection("192.168.10.144", "manager", "1234");
			StringBuilder sb = new StringBuilder();
		
		sb
		.append("	select  	CTNAME, ci.CENTERNO, EMPTEL, EMPEMAIL, CTADDR")
		.append("	from    	CENTER_INFO CI, EMP_INFO EI")
		.append("	WHERE		CI.CENTERNO = EI.CENTERNO AND EMPNO=?;");
		pstmt = con.prepareStatement(sb.toString());
		
		pstmt.setString(1, miVO.getBranchName());
		
	} finally {
		db.dbClose(rs, pstmt, con);
	} //end finally
		return miVO;
		
	} //selectEmpInfo
	
	
	
	public MyInformationVO selectMyInfomation() {
		MyInformationVO miVO= new MyInformationVO();
		
		return miVO;
	} //selectMyInfomation
	
	
	
	//정보수정
	public void updateInfomation(String ManagerPhone, String ManagerEmail, String Password) throws SQLException {
		int rowCnt = 0;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		DbConn db = DbConn.getInstance();
		
		try {
			
			con=db.getConnection("192.168.10.144", "manager", "1234");
			StringBuilder sb = new StringBuilder();
			
			sb
			.append("	update  	EMPINFO_EI	")
			.append("	set     	EI.EMPTEL = ?, EI.EMPEMAIL = ?, EI.EMPPW = ?")
			.append("	where 		EMPNO = ?");
			
			pstmt = con.prepareStatement(sb.toString());
			
			pstmt.setString(1, ManagerPhone);
			pstmt.setString(2, ManagerEmail);
			pstmt.setString(3, Password);
			
			rowCnt = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(null, pstmt, con);
		}//finally
		return;
	}//updateCarInfo
	
	
	
	//비번 확인
	public String selectConfimPass(String id, String pw) {
		String msg = "비밀번호가 수정 되었습니다.";
		
		return msg;
	} //selectConfimPass
	
	
		

} //class
