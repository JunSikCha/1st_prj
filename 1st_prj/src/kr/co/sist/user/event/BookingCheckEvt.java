package kr.co.sist.user.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import kr.co.sist.user.dao.BookingCheckDAO;
import kr.co.sist.user.design.BookingCheckDesign;
import kr.co.sist.user.vo.BookingCheckVO;

public class BookingCheckEvt implements ActionListener {
	private BookingCheckDesign bcd;
	
	public BookingCheckEvt(BookingCheckDesign bcd) {
		this.bcd=bcd;
	}//BookingCheckEvt
	
	public void setBookingCheckTable() {
		BookingCheckDAO bcDAO = BookingCheckDAO.getInstance();
		
		List<BookingCheckVO> bcList = null;
		
		// "YYYY-MM-DD" 형식의 정규식
		String regex = "\\d{4}-\\d{2}-\\d{2}";
		
		// 정규식 패턴을 컴파일합니다.
		Pattern pattern = Pattern.compile(regex);
		
		// 입력 문자열과 패턴을 매칭합니다.
		
		
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {

	}

}
