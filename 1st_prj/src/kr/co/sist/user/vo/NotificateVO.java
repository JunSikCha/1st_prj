package kr.co.sist.user.vo;

import java.util.Date;

public class NotificateVO {

	private String id, username, bstatus, reason, ctname, bdate, outbound;

	public NotificateVO() {
		super();
	}
	
	public NotificateVO(String outbound) {
		super();
		this.outbound = outbound;
	}

	public NotificateVO(String bstatus, String reason,String bdate, String ctname) {
		super();
		this.bstatus = bstatus;
		this.reason = reason;
		this.bdate = bdate;
		this.ctname = ctname;
	}

	public String getId() {
		return id;
	}

	public String getUsername() {
		return username;
	}

	public String getBstatus() {
		return bstatus;
	}

	public String getReason() {
		return reason;
	}
	
	public String getCtname() {
		return ctname;
	}

	public String getBdate() {
		return bdate;
	}

	public String getOutbound() {
		return outbound;
	}

	@Override
	public String toString() {
		return "NotificateVO [id=" + id + ", username=" + username + ", bstatus=" + bstatus + ", reason=" + reason
				+ ", ctname=" + ctname + ", bdate=" + bdate + ", outbound=" + outbound + "]";
	}
		

}