package kr.co.sist.user.vo;

public class ClientMainVO {

	private String userCarNo, userCarName, userModelNo;

	public ClientMainVO() {
		super();
	}

	public ClientMainVO(String userCarNo, String userCarName, String userModelNo) {
		super();
		this.userCarNo = userCarNo;
		this.userCarName = userCarName;
		this.userModelNo = userModelNo;
	}

	public String getUserCarNo() {
		return userCarNo;
	}

	public String getUserCarName() {
		return userCarName;
	}

	public String getUserModelNo() {
		return userModelNo;
	}

	@Override
	public String toString() {
		return "ClientMainVO [userCarNo=" + userCarNo + ", userCarName=" + userCarName + ", userModelNo=" + userModelNo
				+ "]";
	}


	
}
