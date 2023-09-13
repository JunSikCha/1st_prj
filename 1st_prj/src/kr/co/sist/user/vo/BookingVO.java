package kr.co.sist.user.vo;

public class BookingVO {
	
	private String carno, modelno, issue, centerno, centername, bdate;
	
	public BookingVO() {
		super();
	}

	public BookingVO(String centername) {
		super();
		this.centername = centername;
	}
	
	public BookingVO(String carno, String modelno, String issue, String centerno, String bdate) {
		super();
		this.carno = carno;
		this.modelno = modelno;
		this.issue = issue;
		this.centerno = centerno;
		this.bdate = bdate;
	}

	public String getCarno() {
		return carno;
	}

	public String getModelno() {
		return modelno;
	}

	public String getIssue() {
		return issue;
	}

	public String getCenterno() {
		return centerno;
	}

	public String getCentername() {
		return centername;
	}

	public String getBdate() {
		return bdate;
	}

	public void setCarno(String carno) {
		this.carno = carno;
	}

	public void setModelno(String modelno) {
		this.modelno = modelno;
	}

	public void setIssue(String issue) {
		this.issue = issue;
	}

	public void setCenterno(String centerno) {
		this.centerno = centerno;
	}

	public void setBdate(String bdate) {
		this.bdate = bdate;
	}

	@Override
	public String toString() {
		return "BookingVO [carno=" + carno + ", modelno=" + modelno + ", issue=" + issue + ", centerno=" + centerno
				+ ", centername=" + centername + ", bdate=" + bdate + "]";
	}

}
