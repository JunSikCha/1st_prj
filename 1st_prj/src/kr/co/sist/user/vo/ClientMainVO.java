package kr.co.sist.user.vo;

public class ClientMainVO {

	private String userCarNo, userCarName, userModelNo, mimage;

	public ClientMainVO() {
		super();
	}

	public ClientMainVO(String userCarNo, String userCarName, String userModelNo, String mimage) {
		super();
		this.userCarNo = userCarNo;
		this.userCarName = userCarName;
		this.userModelNo = userModelNo;
		this.mimage = mimage;
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
	
	public String getMimage() {
		return mimage;
	}

	@Override
	public String toString() {
		return "ClientMainVO [userCarNo=" + userCarNo + ", userCarName=" + userCarName + ", userModelNo=" + userModelNo
				+ ", mimage=" + mimage + "]";
	}

	
}
