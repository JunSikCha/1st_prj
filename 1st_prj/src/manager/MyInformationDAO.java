package manager;

public class MyInformationDAO {
	private static MyInformationDAO miDAO;
	
	private MyInformationDAO() {
		
	}
	
	public static MyInformationDAO getInstance() {
		if(miDAO==null) {
			miDAO=new MyInformationDAO();
		}
		return miDAO;
	}
	
	public MyInformationVO selectEmpInfo(/* ManagerLoginVO */) {
		MyInformationVO miVO=new MyInformationVO();
		
		return miVO;
	}
	
	public MyInformationVO selectMyInfomation() {
		MyInformationVO miVO= new MyInformationVO();
		
		return miVO;
	}
	
	public void updateInfomation(MyInformationVO miVO) {
		
	}
	
	public String selectConfimPass(String id, String pw) {
		String msg = "";
		
		return msg;
	}
	
	
		

}
