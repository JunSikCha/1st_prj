package client;

public class UserVO {
	private String id, password, name, email;
	private int phoneNum;
	
	public UserVO() {
		super();
	}

	public UserVO(String id, String password, String name, String email, int phoneNum) {
		super();
		this.id = id;
		this.password = password;
		this.name = name;
		this.email = email;
		this.phoneNum = phoneNum;
	}

	public String getId() {
		return id;
	}

	public String getPassword() {
		return password;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public int getPhoneNum() {
		return phoneNum;
	}

	@Override
	public String toString() {
		return "UserVO [id=" + id + ", password=" + password + ", name=" + name + ", email=" + email + ", phoneNum="
				+ phoneNum + "]";
	}
	
}
