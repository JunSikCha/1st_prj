package manager.inventory;

import java.util.ArrayList;
import java.util.List;

public class InventoryManagerDAO {
	private static InventoryManagerDAO imDAO;
	
	private InventoryManagerDAO() {
		
	}
	
	public static InventoryManagerDAO getInstance() {
		if(imDAO==null) {
			imDAO=new InventoryManagerDAO();
		}
		
		return imDAO;
	}
	
	public List<InventoryManagerVO> selectInventoryInfo(String partName) {
		List<InventoryManagerVO> list = new ArrayList<InventoryManagerVO>();
		
		return list;
	}
	

	public void insertInventoryInfo(InventoryManagerVO imVO) {
		
		
	}
	

}
