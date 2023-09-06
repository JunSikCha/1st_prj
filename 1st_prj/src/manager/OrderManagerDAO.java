package manager;

import java.util.ArrayList;
import java.util.List;

public class OrderManagerDAO {
	private static OrderManagerDAO imDAO;
	
	private OrderManagerDAO() {
		
	}
	
	public static OrderManagerDAO getInstance() {
		if(imDAO==null) {
			imDAO=new OrderManagerDAO();
		}
		return imDAO;
	}
	
	public List<OrderManagerVO> selectOrderInfo(String strDate, String endDate){
		List<OrderManagerVO> list = new ArrayList<OrderManagerVO>();
		
		return list;
	}
	
	public PartInfoVO selectPartInfo(String partName) {
		PartInfoVO pVO = new PartInfoVO();
		
		return pVO;
	}
	
	public void insertOrderInfo(OrderManagerVO omVO) {
		
		
		
	}
	
	public int updateStock(String partName, int quantity) {
		int count =0;
		
		return count;
	}

}
