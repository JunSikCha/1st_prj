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
import manager.MyInformation.MyInformationVO;
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
	
	//입고차량관리 테이블
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
	
	//차량 세부정보
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
	
	public int selectHistoryNoMAX() throws SQLException {
		int max = 0;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		DbConn db = DbConn.getInstance();
		
		try {
			con=db.getConnection("192.168.10.150", "manager", "1234");
			StringBuilder sb = new StringBuilder();
			
			sb
			.append("		select  max(historyno)	")
			.append("		from 	history	");
			
			pstmt = con.prepareStatement(sb.toString());
			
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				max = rs.getInt(1);
			}
			
		}finally {
			db.dbClose(rs, pstmt, con);
		}//finally
		return max;
	}//selectHistoryNoMAX
	
	
	public CarManagerVO selectUserInfo(String id) throws SQLException {
		CarManagerVO cmVO = new CarManagerVO();
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		DbConn db = DbConn.getInstance();
		
		try {
			con=db.getConnection("192.168.10.150", "manager", "1234");
			StringBuilder sb = new StringBuilder();
			
			sb
			.append("		select ui.carno, ui.modelno ,uci.cmileage, user_tel, user_email	")
			.append("		from 	user_info ui, user_car_info uci		")
			.append("		where ui.carno=uci.carno and user_id = ? 	");
			
			pstmt = con.prepareStatement(sb.toString());
			
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				cmVO.setCarNo(rs.getString("carno"));
				cmVO.setModelNo(rs.getString("modelno"));
				cmVO.setCarMileage(rs.getInt("cmileage"));
				cmVO.setClientPhone(rs.getString("user_tel"));
				cmVO.setClientEmail(rs.getString("user_email"));
			}
			
		}finally {
			db.dbClose(rs, pstmt, con);
		}//finally
		
		return cmVO;
	}
	
	public List<MyInformationVO> selectEmpInfo() throws SQLException {
		List<MyInformationVO> list = new ArrayList<MyInformationVO>();
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		DbConn db = DbConn.getInstance();
		
		try {
			con=db.getConnection("192.168.10.150", "manager", "1234");
			StringBuilder sb = new StringBuilder();
			
			sb
			.append("		select  empno, empname	")
			.append("		from 	emp_info	");
			
			pstmt = con.prepareStatement(sb.toString());
			
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				MyInformationVO miVO = new MyInformationVO();
				miVO.setEmpNo(rs.getInt("empno"));
				miVO.setEmpName(rs.getString("empname"));
				list.add(miVO);
			}
			
		}finally {
			db.dbClose(rs, pstmt, con);
		}//finally
		
		
		return list;
	}
	
//	public List<CarManagerVO> selectCarAdd(){
//		List<CarManagerVO> list = new ArrayList<CarManagerVO>();
//		CarManagerVO cmVO = null;
//		Connection con = null;
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//		
//		DbConn db = DbConn.getInstance();
//		
//		try {
//			
//			con=db.getConnection("192.168.10.150", "manager", "1234");
//			StringBuilder sb = new StringBuilder();
//			
//			sb
//			.append("		select  h.historyno, h.carno, c.mname  , h.hdetail ,to_char( hinbound,'yyyy-mm-dd') hinbound, to_char(houtbound,'yyyy-mm-dd') houtbound, h.hnote	")
//			.append("		from car_info c,history h	")
//			.append("		where (c.modelno=h.modelno)	");
//			
//			if(!strDate.equals("")) {
//				sb.append("	and	hinbound between TO_DATE(?, 'YYYY-MM-DD') and TO_DATE(?, 'YYYY-MM-DD') ");
//			}//end if
//			pstmt = con.prepareStatement(sb.toString());
//			
//			if(!strDate.equals("")) {
//				pstmt.setString(1, strDate);
//				pstmt.setString(2, endDate);
//			}//end if
//			
//			rs = pstmt.executeQuery();
//			
//			while(rs.next()) {
//				cmVO = new CarManagerVO();
//				cmVO.setHistoryNo(rs.getInt("historyno"));
//				cmVO.setCarNo(rs.getString("carno"));
//				cmVO.setCarName(rs.getString("mname"));
//				cmVO.setMaintenanceDetail(rs.getString("hdetail"));
//				cmVO.setReceivedDay(rs.getString("hinbound"));
//				cmVO.setReleaseDay(rs.getString("houtbound"));
//				cmVO.setNote(rs.getString("hnote"));
//				
//				list.add(cmVO);
//			}//end while
//			
//		}finally {
//			db.dbClose(rs, pstmt, con);
//		}//finally
//		
//		return list;
//	}
	
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
	
	//파트시리얼넘버로 파트정보조회 후
	//파트 테이블에 정보 기입
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
			.append("		select  sn,sname, sunitprice, sprice	")
			.append("		from 	parts_info p				")
			.append("		where 	sn = ?						");
			
			pstmt = con.prepareStatement(sb.toString());
			
			pstmt.setString(1, partSN);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				piVO.setPartNo(rs.getString("sn"));
				piVO.setPartName(rs.getString("sname"));
				piVO.setPartCost(rs.getInt("sunitprice"));
				piVO.setLaborCost(rs.getInt("sprice"));
				
			}//end while
			
		}finally {
			db.dbClose(rs, pstmt, con);
		}//finally
		return piVO;
	}//selectAddPart

	
	public int insertHistory(CarManagerVO cmVO) throws SQLException {
		int rowCnt = 0;
		Connection con = null;
		PreparedStatement pstmt = null;
		
		DbConn db = DbConn.getInstance();
		
		try {
			
			con=db.getConnection("192.168.10.150", "manager", "1234");
			StringBuilder sb = new StringBuilder();
			
			sb
			.append("		insert into  history(historyno, booking_no, carno,modelno,empno, hinbound, hstatus)	")
			.append("		values (	?,?,?,?,?,?,'y')  		");
			
			pstmt = con.prepareStatement(sb.toString());
			
			pstmt.setInt(1, cmVO.getMaintenanceNo());
			pstmt.setInt(2, cmVO.getBookingNo());
			pstmt.setString(3, cmVO.getCarNo());
			pstmt.setString(4, cmVO.getModelNo());
			pstmt.setInt(5, cmVO.getEmpNo());
			pstmt.setString(6, cmVO.getReceivedDay());
			
			rowCnt = pstmt.executeUpdate();
		}finally {
			db.dbClose(null, pstmt, con);
		}//finally
		return rowCnt;
	}//insertCarInfo
	public void insertPartInfo(PartInfoVO piVO) throws SQLException {
		int rowCnt = 0;
		Connection con = null;
		PreparedStatement pstmt = null;
		
		DbConn db = DbConn.getInstance();
		
		try {
			
			con=db.getConnection("192.168.10.150", "manager", "1234");
			StringBuilder sb = new StringBuilder();
			
			sb
			.append("		insert into  history(sn, historyno, booking_no, carno,modelno,empno, upamount)	")
			.append("		values (	?,?,?,?,?,?,1)  		");
			
			pstmt = con.prepareStatement(sb.toString());
			
			pstmt.setString(1, piVO.getPartNo());
			pstmt.setInt(2, piVO.getLaborCost());
			pstmt.setString(3, piVO.getCarNo());
			pstmt.setString(4, piVO.getModelNo());
			pstmt.setInt(5, piVO.getEmpNo());
//			pstmt.setString(6, piVO.getReceivedDay());
			
			rowCnt = pstmt.executeUpdate();
		}finally {
			db.dbClose(null, pstmt, con);
		}
	}//insertPartInfo
	
	//정보수정창 수리내역, 노트 수정 메소드
	public int updateInfoModify(String hno, String md, String note) throws SQLException {
		int rowCnt = 0;
		Connection con = null;
		PreparedStatement pstmt = null;
		
		DbConn db = DbConn.getInstance();
		
		try {
			
			con=db.getConnection("192.168.10.150", "manager", "1234");
			StringBuilder sb = new StringBuilder();
			
			sb
			.append("		update  history	")
			.append("		set     hdetail	= ?, hnote = ?			")
			.append("		where 	historyno = ?						");
			
			pstmt = con.prepareStatement(sb.toString());
			
			pstmt.setString(1, md);
			pstmt.setString(2, note);
			pstmt.setString(3, hno);
			
			rowCnt = pstmt.executeUpdate();
		}finally {
			db.dbClose(null, pstmt, con);
		}//finally
		
		return rowCnt;
	}
	
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
	
	public int updataPartInfo(String ChangedValue,String sn,String historyNo) throws SQLException {
		int cnt = 0;
		Connection con = null;
		PreparedStatement pstmt = null;
		
		DbConn db = DbConn.getInstance();
		System.out.println(ChangedValue);
		System.out.println(historyNo);
		System.out.println(sn);
		
		try {
			
			con=db.getConnection("192.168.10.150", "manager", "1234");
			StringBuilder sb = new StringBuilder();
			
			sb
			.append("		update  used_parts	")
			.append("		set     upamount	= ?			")
			.append("		where 	sn = ? and historyno = ?		");
			
			pstmt = con.prepareStatement(sb.toString());
			
			pstmt.setString(1, ChangedValue);
			pstmt.setString(2, sn);
			pstmt.setString(3, historyNo);
			
			cnt = pstmt.executeUpdate();
		}finally {
			db.dbClose(null, pstmt, con);
		}//finally
		return cnt;
	}
	
	public int deletePartTable(String sn,String historyNo) throws SQLException {
		int rowCnt = 0;
		Connection con = null;
		PreparedStatement pstmt = null;

		DbConn db = DbConn.getInstance();
		try {
			// 1. 드라이버 로드
			// 2. 커넥션 얻기
			con=db.getConnection("192.168.10.150", "manager", "1234");
			// 3. 쿼리문생성객체 얻기
			String deleteStudent = "delete from used_parts where historyNo = ? and sn = ? ";
			pstmt = con.prepareStatement(deleteStudent);

			// 4. 바인드값 설정
			pstmt.setString(1, sn);
			pstmt.setString(2, historyNo);
			// 5. 쿼리문 실행후 결과 얻기
			rowCnt = pstmt.executeUpdate();
		} finally {
			// 6. 연결 끊기
			db.dbClose(null, pstmt, con);
		}
		return rowCnt;
	}
	
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
