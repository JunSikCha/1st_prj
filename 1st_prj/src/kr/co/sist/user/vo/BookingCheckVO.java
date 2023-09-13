package kr.co.sist.user.vo;

public class BookingCheckVO {
	
	private String bdate, btime, detail, center, status, reason;

	public BookingCheckVO() {
		super();
	}

	public BookingCheckVO(String bdate, String btime, String detail, String center, String status, String reason) {
		super();
		this.bdate = bdate;
		this.btime = btime;
		this.detail = detail;
		this.center = center;
		this.status = status;
		this.reason = reason;
	}

	public void setBdate(String bdate) {
		this.bdate = bdate;
	}

	public void setBtime(String btime) {
		this.btime = btime;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public void setCenter(String center) {
		this.center = center;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getBdate() {
		return bdate;
	}

	public String getBtime() {
		return btime;
	}

	public String getDetail() {
		return detail;
	}

	public String getCenter() {
		return center;
	}

	public String getStatus() {
		return status;
	}

	public String getReason() {
		return reason;
	}

	@Override
	public String toString() {
		return "BookingCheckVO [bdate=" + bdate + ", btime=" + btime + ", detail=" + detail + ", center=" + center
				+ ", status=" + status + ", reason=" + reason + "]";
	}
	
	
	
}
