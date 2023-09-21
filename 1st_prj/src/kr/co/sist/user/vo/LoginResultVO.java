package kr.co.sist.user.vo;

public class LoginResultVO {
	private String name;

	
	public LoginResultVO() {
		super();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public LoginResultVO(String name) {
		super();
		this.name = name;
	}
	@Override
	public String toString() {
		return "LoginVO [name=" + name + "]";
	}
	
}
