package kr.co.sist.user.vo;


public class HistoryVO {

	private String inbound, detail, carno, modelname, username
					, tel, email, outbound, empname, issue, hdetail, hnot ,sname;
	private int price, historyno, sunitprice, sprice, upamount, distance;
	
	public HistoryVO() {
		super();
	}

	public HistoryVO(String inbound, String detail, int historyno, int price) {
		super();
		this.inbound = inbound;
		this.detail = detail;
		this.historyno = historyno;
		this.price = price;
	}
	
	public HistoryVO(String inbound, String carno, String modelname, String username, String tel, String email,
			String outbound, String empname, int distance, String issue, String hdetail, String hnot,
			int historyno) {
		super();
		this.inbound = inbound;
		this.carno = carno;
		this.modelname = modelname;
		this.username = username;
		this.tel = tel;
		this.email = email;
		this.outbound = outbound;
		this.empname = empname;
		this.distance = distance;
		this.issue = issue;
		this.hdetail = hdetail;
		this.hnot = hnot;
		this.historyno = historyno;
	}

	public HistoryVO(String sname, int sunitprice, int sprice, int upamount) {
		super();
		this.sname = sname;
		this.sunitprice = sunitprice;
		this.sprice = sprice;
		this.upamount = upamount;
	}

	public String getInbound() {
		return inbound;
	}

	public String getDetail() {
		return detail;
	}

	public int getHistoryno() {
		return historyno;
	}

	public String getCarno() {
		return carno;
	}

	public String getModelname() {
		return modelname;
	}

	public String getUsername() {
		return username;
	}

	public String getTel() {
		return tel;
	}

	public String getEmail() {
		return email;
	}

	public String getOutbound() {
		return outbound;
	}

	public String getEmpname() {
		return empname;
	}

	public int getDistance() {
		return distance;
	}

	public String getIssue() {
		return issue;
	}

	public String getHdetail() {
		return hdetail;
	}

	public String getHnot() {
		return hnot;
	}

	public String getSname() {
		return sname;
	}

	public int getPrice() {
		return price;
	}

	public int getSunitprice() {
		return sunitprice;
	}

	public int getSprice() {
		return sprice;
	}

	public int getUpamount() {
		return upamount;
	}
	
	

	public void setInbound(String inbound) {
		this.inbound = inbound;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public void setHistoryno(int historyno) {
		this.historyno = historyno;
	}

	public void setCarno(String carno) {
		this.carno = carno;
	}

	public void setModelname(String modelname) {
		this.modelname = modelname;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setOutbound(String outbound) {
		this.outbound = outbound;
	}

	public void setEmpname(String empname) {
		this.empname = empname;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

	public void setIssue(String issue) {
		this.issue = issue;
	}

	public void setHdetail(String hdetail) {
		this.hdetail = hdetail;
	}

	public void setHnot(String hnot) {
		this.hnot = hnot;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public void setSunitprice(int sunitprice) {
		this.sunitprice = sunitprice;
	}

	public void setSprice(int sprice) {
		this.sprice = sprice;
	}

	public void setUpamount(int upamount) {
		this.upamount = upamount;
	}

	@Override
	public String toString() {
		return "HistoryVO [inbound=" + inbound + ", detail=" + detail + ", historyno=" + historyno + ", carno=" + carno
				+ ", modelname=" + modelname + ", username=" + username + ", tel=" + tel + ", email=" + email
				+ ", outbound=" + outbound + ", empname=" + empname + ", distance=" + distance + ", issue=" + issue
				+ ", hdetail=" + hdetail + ", hnot=" + hnot + ", sname=" + sname + ", price=" + price + ", sunitprice="
				+ sunitprice + ", sprice=" + sprice + ", upamount=" + upamount + "]";
	}


	
	
	
}
