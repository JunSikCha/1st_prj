package kr.co.sist.user.vo;

public class ClientMainVO {

	private String userCarNo, userCarName;

	public ClientMainVO() {
		super();
	}

	public ClientMainVO(String userCarNo, String userCarName) {
		super();
		this.userCarNo = userCarNo;
		this.userCarName = userCarName;
	}

	public String getUserCarNo() {
		return userCarNo;
	}

	public String getUserCarName() {
		return userCarName;
	}

	@Override
	public String toString() {
		return "ClientMainVO [userCarNo=" + userCarNo + ", userCarName=" + userCarName + "]";
	}
	
}
