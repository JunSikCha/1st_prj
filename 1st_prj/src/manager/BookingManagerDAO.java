package manager;

import java.util.ArrayList;
import java.util.List;

public class BookingManagerDAO {
	private static BookingManagerDAO bmDAO;
	
	private BookingManagerDAO() {
		
	}
	
	public static BookingManagerDAO getInstance() {
		if(bmDAO==null) {
			bmDAO=new BookingManagerDAO();
		}
		return bmDAO;
	}
	
	public List<BookingManagerDAO> selectBooking(String date, String id){
		List<BookingManagerDAO> list = new ArrayList<BookingManagerDAO>();
		
		return list;
	}
	
	public int updateAccept(List<String> no) {
		int count =0;
		
		return count;
	}
	
	public int updateRefusal(List<String> no,String reasons) {
		int count =0;
		
		return count;
	}

}
