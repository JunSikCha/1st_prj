package kr.co.sist.user.vo;


public class CenterVO {
	
	private String centerNo;
	private String cName;
	private String cAddr;

	public CenterVO(String centerNo, String cName, String cAddr) {
		this.centerNo = centerNo;
		this.cName = cName;
		this.cAddr = cAddr;
	}

	public CenterVO() {
		super();
	}

	
	@Override
	public String toString() {
		return "CenterVO [centerNo=" + centerNo + ", cName=" + cName + ", cAddr=" + cAddr + "]";
	}

	public String getCenterNo() {
		return centerNo;
	}

	public void setCenterNo(String centerNo) {
		this.centerNo = centerNo;
	}

	public String getcName() {
		return cName;
	}

	public void setcName(String cName) {
		this.cName = cName;
	}

	public String getcAddr() {
		return cAddr;
	}

	public void setcAddr(String cAddr) {
		this.cAddr = cAddr;
	}
	
	
	
	
}
