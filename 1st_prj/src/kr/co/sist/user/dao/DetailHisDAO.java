package kr.co.sist.user.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kr.co.sist.user.dbconn.DbConn;
import kr.co.sist.user.vo.HistoryVO;

public class DetailHisDAO {

	private static DetailHisDAO dhDAO;

	private DetailHisDAO() {

	}// DetailHisDAO

	public static DetailHisDAO getInstance() {
		if (dhDAO == null) {
			dhDAO = new DetailHisDAO();
		}
		return dhDAO;
	}// getInstance

	public HistoryVO selectDetail(String id, int historyno) throws SQLException {
		HistoryVO hiVO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		DbConn db = DbConn.getInstance();

		try {
			con = db.getConnection("192.168.10.150", "manager", "1234");

			StringBuilder selectDetail = new StringBuilder();
			selectDetail.append(
					"	select ui.user_name, ui.user_tel, ui.user_email, uci.carno, uci.cmileage, ci.mname, bk.issue					")
					.append("	, hi.historyno, hi.hdetail, hi.hnote, hi.hinbound, hi.houtbound, ei.empname										")
					.append("	from user_info ui, user_car_info uci, car_info ci, booking bk, history hi, emp_info ei							")
					.append("	where ui.modelno=uci.modelno and uci.carno=bk.carno and uci.modelno=ci.modelno and bk.booking_no=hi.booking_no	")
					.append("	and hi.empno=ei.empno and ui.user_id=? and hi.historyno=?														");

			pstmt = con.prepareStatement(selectDetail.toString());

			pstmt.setString(1, id);
			pstmt.setInt(2, historyno);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				hiVO = new HistoryVO(rs.getString("hinbound"), rs.getString("carno"), rs.getString("mname"),
						rs.getString("user_name"), rs.getString("user_tel"), rs.getString("user_email"),
						rs.getString("houtbound"), rs.getString("empname"), rs.getInt("cmileage"),
						rs.getString("issue"), rs.getString("hdetail"), rs.getString("hnote"), rs.getInt("historyno"));
			}

		} finally {
			db.dbClose(rs, pstmt, con);
		}

		return hiVO;
	}

	public List<HistoryVO> selectPartsInfo(int historyno) throws SQLException {
		HistoryVO htVO;

		List<HistoryVO> htList = new ArrayList<HistoryVO>();

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		DbConn db = DbConn.getInstance();

		try {

			con = db.getConnection("192.168.10.150", "manager", "1234");

			StringBuilder selectPi = new StringBuilder();
			selectPi.append("	select distinct up.upamount, pi.sname, pi.sunitprice, pi.sprice		")
					.append("	from history hi, used_parts up, parts_info pi						")
					.append("	where hi.historyno=up.historyno and up.sn=pi.sn and hi.historyno= ?	");

			pstmt = con.prepareStatement(selectPi.toString());

			pstmt.setInt(1, historyno);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				htVO = new HistoryVO(rs.getString("sname"), rs.getInt("sunitprice"), rs.getInt("sprice"), rs.getInt("upamount"));
				htList.add(htVO);
			}//end while

		} finally {
			db.dbClose(rs, pstmt, con);
		}//end finally

		return htList;
	}//selectPartsInfo
	
	public static void main(String args[]) {
		try {
			System.out.println(new DetailHisDAO().selectPartsInfo(88));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}//class
