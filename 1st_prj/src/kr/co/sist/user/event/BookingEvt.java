package kr.co.sist.user.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import kr.co.sist.user.dao.BookingDAO;
import kr.co.sist.user.vo.BookingVO;

public class BookingEvt implements ActionListener{
	
	private BookingVO bVO;

	
	private void addBooking(String carno, String modelno, String issue, String centername ,String bdate) {
		
		try {
		bVO = new BookingVO();
		
		if(centername.equals("교대점")) {
			bVO.setCenterno("S001");
		}else if(centername.equals("역삼점")) {
			bVO.setCenterno("S002");
		}else {
			bVO.setCenterno("S003");
		}
		
		bVO.setCarno(carno);
		bVO.setModelno(modelno);
		bVO.setIssue(issue);
		bVO.setBdate(bdate);
		
		BookingDAO bDAO = BookingDAO.getInstance();
			bDAO.insertBooking(bVO);
			
			System.out.println(bVO.getCarno()+"차량 예약 완료");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
	}
	
	public static void main(String[] args) {
		new BookingEvt().addBooking("testc", "testc", "testc", "교대점","2023");
	}

}
