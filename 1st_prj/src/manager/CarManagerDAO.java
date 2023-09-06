package manager;

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
	
	public CarManagerVO selectOneCarInfo(String carNo, String receivedDay) throws SQLException {
		CarManagerVO cmVO = new CarManagerVO();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		DbConn db = DbConn.getInstance();
		
		
		
		try {
			
			con=db.getConnection("192.168.10.150", "manager", "1234");
			StringBuilder sb = new StringBuilder();
			
			sb
			.append("		select  h.historyno,h.carno, c.mname  , h.hdetail , hinbound, houtbound, h.hnote	")
			.append("		from car_info c,history h	")
			.append("		where (c.modelno=h.modelno)	");
//			if(!strDate.equals("")) {
//				sb.append("	and	hinbound between TO_DATE(?, 'YYYY-MM-DD') and TO_DATE(?, 'YYYY-MM-DD') ");
//			}//end if
			pstmt = con.prepareStatement(sb.toString());
			
//			if(!strDate.equals("")) {
//				pstmt.setString(1, strDate);
//				pstmt.setString(2, endDate);
//			}//end if
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				
				cmVO.setCarNo(rs.getString("carno"));
				cmVO.setCarName(rs.getString("mname"));
				cmVO.setMaintenanceDetail(rs.getString("hdetail"));
				cmVO.setReceivedDay(rs.getString("hinbound"));
				cmVO.setReleaseDay(rs.getString("houtbound"));
				cmVO.setNote(rs.getString("hnote"));
				
			}//end while
			
		}finally {
			db.dbClose(rs, pstmt, con);
		}//finally
		
		return cmVO;
	}//selectOneCarInfo
	
	public List<PartInfoVO> selectOnePartInfo(String partNo){
		List<PartInfoVO> list = new ArrayList<PartInfoVO>();
		
		
		return	 list;
	}//selectOnePartInfo
	
	public void insertCarInfo(CarManagerVO cVO) {
		
	}//insertCarInfo
	public void insertPartInfo(PartInfoVO pVO) {
		
	}//insertPartInfo
	
	public void updateCarInfo(String endDate) {
		
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
