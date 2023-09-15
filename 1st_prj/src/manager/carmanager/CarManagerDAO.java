package manager.carmanager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

import dbConn.DbConn;
import manager.inventory.PartInfoVO;

public class CarManagerDAO {
	private static CarManagerDAO cMDAO;
	
	private CarManagerDAO() {
		
	}//CarManagerDAO
	
	public static CarManagerDAO getInstance() {
		if(cMDAO==null) {
			cMDAO=new CarManagerDAO();
		}
		return cMDAO;
	}//getInstance
	
	public List<CarManagerVO> selectCarInfo(String strDate, String endDate) throws SQLException{
		List<CarManagerVO> list = new ArrayList<CarManagerVO>();
		CarManagerVO cmVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		DbConn db = DbConn.getInstance();
		
		try {
			
			con=db.getConnection("192.168.10.150", "manager", "1234");
			StringBuilder sb = new StringBuilder();
			
			sb
			.append("		select  h.historyno, h.carno, c.mname  , h.hdetail ,to_char( hinbound,'yyyy-mm-dd') hinbound, to_char(houtbound,'yyyy-mm-dd') houtbound, h.hnote	")
			.append("		from car_info c,history h	")
			.append("		where (c.modelno=h.modelno)	");
			
			if(!strDate.equals("")) {
				sb.append("	and	hinbound between TO_DATE(?, 'YYYY-MM-DD') and TO_DATE(?, 'YYYY-MM-DD') ");
			}//end if
			pstmt = con.prepareStatement(sb.toString());
			
			if(!strDate.equals("")) {
				pstmt.setString(1, strDate);
				pstmt.setString(2, endDate);
			}//end if
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				cmVO = new CarManagerVO();
				cmVO.setHistoryNo(rs.getInt("historyno"));
				cmVO.setCarNo(rs.getString("carno"));
				cmVO.setCarName(rs.getString("mname"));
				cmVO.setMaintenanceDetail(rs.getString("hdetail"));
				cmVO.setReceivedDay(rs.getString("hinbound"));
				cmVO.setReleaseDay(rs.getString("houtbound"));
				cmVO.setNote(rs.getString("hnote"));
				
				list.add(cmVO);
			}//end while
			
		}finally {
			db.dbClose(rs, pstmt, con);
		}//finally
		return list;
	}//selectCarInfo
	
	public CarManagerVO selectOneCarInfo(CarManagerVO VO) throws SQLException {
		CarManagerVO cmVO = VO;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		DbConn db = DbConn.getInstance();
		
		try {
			con=db.getConnection("192.168.10.150", "manager", "1234");
			StringBuilder sb = new StringBuilder();
			
			sb
			.append("		select  ui.user_name,ui.user_tel, ui.user_email, uc.cmileage, b.issue,e.empname	")
			.append("		from 	history h,user_car_info uc,  booking b, user_info ui, emp_info e	")
			.append("		where 	historyno= ? and uc.carno= ? and ui.carno= ? and ")
			.append("				b.booking_no=h.booking_no and e.empno=h.empno	");
			pstmt = con.prepareStatement(sb.toString());
			
			pstmt.setInt(1, cmVO.getHistoryNo());
			pstmt.setString(2, cmVO.getCarNo());
			pstmt.setString(3, cmVO.getCarNo());
			
			
			rs = pstmt.executeQuery();
			
			
			while(rs.next()) {
				
				cmVO.setClientName(rs.getString("user_name"));
				cmVO.setClientPhone(rs.getString("user_tel"));
				cmVO.setClientEmail(rs.getString("user_email"));
				cmVO.setCarMileage(rs.getInt("cmileage"));
				cmVO.setFaultDetail(rs.getString("issue"));
				cmVO.setEmpName(rs.getString("empname"));
			}//end while
			
		}finally {
			db.dbClose(rs, pstmt, con);
		}//finally
		
		return cmVO;
	}//selectOneCarInfo
	
	public List<PartInfoVO> selectOnePartInfo(int historyno) throws SQLException{
		List<PartInfoVO> list = new ArrayList<PartInfoVO>();
		
		PartInfoVO piVO = new PartInfoVO();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		DbConn db = DbConn.getInstance();
		
		try {
			
			con=db.getConnection("192.168.10.150", "manager", "1234");
			StringBuilder sb = new StringBuilder();
			
			sb
			.append("		select  u.sn,p.sname, p.sunitprice, p.sprice, u.upamount	")
			.append("		from 	used_parts u, parts_info p	")
			.append("		where 	u.sn=p.sn and historyno= ?	");
			
			pstmt = con.prepareStatement(sb.toString());
			
			pstmt.setInt(1, historyno);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				piVO.setPartNo(rs.getString("sn"));
				piVO.setPartName(rs.getString("sname"));
				piVO.setPartCost(rs.getInt("sunitprice"));
				piVO.setLaborCost(rs.getInt("sprice"));
				piVO.setUsedPartQuantity(rs.getInt("upamount"));
				
				list.add(piVO);
			}//end while
			
		}finally {
			db.dbClose(rs, pstmt, con);
		}//finally
		
		
		return	 list;
	}//selectOnePartInfo
	
	//파트시리얼넘버로 파트정보조회
	//차량추가, 정보수정 윈도우에 적용
	public PartInfoVO selectAddPart(String partSN) throws SQLException {
		
		PartInfoVO piVO = new PartInfoVO();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		DbConn db = DbConn.getInstance();
		
		try {
			
			con=db.getConnection("192.168.10.150", "manager", "1234");
			StringBuilder sb = new StringBuilder();
			
			sb
			.append("		select  sname, sunitprice, sprice	")
			.append("		from 	parts_info p				")
			.append("		where 	sn = ?						");
			
			pstmt = con.prepareStatement(sb.toString());
			
			pstmt.setString(1, partSN);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				piVO.setPartName(rs.getString("sname"));
				piVO.setPartCost(rs.getInt("sunitprice"));
				piVO.setLaborCost(rs.getInt("sprice"));
				
			}//end while
			
		}finally {
			db.dbClose(rs, pstmt, con);
		}//finally
		return piVO;
	}//selectAddPart
	
	public void insertCarInfo(CarManagerVO cVO) {
		
	}//insertCarInfo
	public void insertPartInfo(PartInfoVO pVO) {
		
	}//insertPartInfo
	
	public int updateCarInfo(String hno,String endDate) throws SQLException {
		int rowCnt = 0;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		DbConn db = DbConn.getInstance();
		
		try {
			
			con=db.getConnection("192.168.10.150", "manager", "1234");
			StringBuilder sb = new StringBuilder();
			
			sb
			.append("		update  history	")
			.append("		set     houtbound	= ?			")
			.append("		where 	historyno = ?						");
			
			pstmt = con.prepareStatement(sb.toString());
			
			pstmt.setString(1, endDate);
			pstmt.setString(2, hno);
			
			rowCnt = pstmt.executeUpdate();
		}finally {
			db.dbClose(null, pstmt, con);
		}//finally
		return rowCnt;
	}//updateCarInfo
	
//	public static void main(String[] args) {
//		CarManagerDAO dao = new CarManagerDAO();
//		List<CarManagerVO> list = new ArrayList<CarManagerVO>();
//		
//		try {
//			list = dao.selectCarInfo("2022-09-04", "2022-09-05");
//			
//			for(CarManagerVO str : list) {
//				System.out.println(str);
//			}//
//			System.out.println( list.size());
//			
//			for(int i=0;i<list.size();i++) {
//				System.out.print(list.get(i).getCarNo()+"\t");
//				System.out.print(list.get(i).getCarName()+"\t");
//				System.out.print(list.get(i).getMaintenanceDetail()+"\t");
//				System.out.print(list.get(i).getReceivedDay()+"\t");
//				System.out.print(list.get(i).getReleaseDay()+"\n");
//				
//			}
//			
//			
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//	}
	

}//class
