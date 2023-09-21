package manager.carmanager;

public class UsedPartVO {
	private String sn;
	private int historyNo;
	private int bookingNo;
	private String carNo;
	private String modelNo;
	private int empNo;
	private int amount;
	@Override
	public String toString() {
		return "UsedPartVO [sn=" + sn + ", historyNo=" + historyNo + ", bookingNo=" + bookingNo + ", carNo=" + carNo
				+ ", modelNo=" + modelNo + ", empNo=" + empNo + ", amount=" + amount + "]";
	}
	public String getSn() {
		return sn;
	}
	public void setSn(String sn) {
		this.sn = sn;
	}
	public int getHistoryNo() {
		return historyNo;
	}
	public void setHistoryNo(int historyNo) {
		this.historyNo = historyNo;
	}
	public int getBookingNo() {
		return bookingNo;
	}
	public void setBookingNo(int bookingNo) {
		this.bookingNo = bookingNo;
	}
	public String getCarNo() {
		return carNo;
	}
	public void setCarNo(String carNo) {
		this.carNo = carNo;
	}
	public String getModelNo() {
		return modelNo;
	}
	public void setModelNo(String modelNo) {
		this.modelNo = modelNo;
	}
	public int getEmpNo() {
		return empNo;
	}
	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}

	
}
