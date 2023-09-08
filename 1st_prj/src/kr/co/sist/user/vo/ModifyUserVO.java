package kr.co.sist.user.vo;

public class ModifyUserVO {
	
	private String userID, userName, userTel, userEmail;

	public ModifyUserVO() {
		super();
	}

	public ModifyUserVO(String userName) {
		super();
		this.userName = userName;
	}
	public ModifyUserVO(String userID, String userTel, String userEmail) {
		super();
		this.userID = userID;
		this.userTel = userTel;
		this.userEmail = userEmail;
	}

	public String getUserID() {
		return userName;

	}
	public String getUserName() {
		return userName;
	}

	public String getUserTel() {
		return userTel;
	}

	public String getUserEmail() {
		return userEmail;
	}

	@Override
	public String toString() {
		return "ModifyUserVO [userID=" + userID + ", userName=" + userName + ", userTel=" + userTel + ", userEmail=" + userEmail + "]";
	}
	
}
