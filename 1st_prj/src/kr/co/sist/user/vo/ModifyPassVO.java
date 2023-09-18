package kr.co.sist.user.vo;

public class ModifyPassVO {
	
	private String id;
	private String newPass;
	
	public ModifyPassVO() {
		super();
	}

	public ModifyPassVO(String id, String newPass) {
		super();
		this.id = id;
		this.newPass = newPass;
	}

	public String getID() {
		return id;
	}

	public String getNewPass() {
		return newPass;
	}
	

	public void setId(String id) {
		this.id = id;
	}

	public void setNewPass(String newPass) {
		this.newPass = newPass;
	}

	@Override
	public String toString() {
		return "ModifyPassVO [id=" + id + ", newPass=" + newPass + "]";
	}
	
	
	
}
