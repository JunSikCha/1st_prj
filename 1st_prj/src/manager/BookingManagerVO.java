package manager;

public class BookingManagerVO {
	private int bookingNo;
	private String bookingDate;
	private String carName;
	private String faultDetail;
	private String clientId;
	private String clientName;
	private String bookingBoolean;
	
	private String reasons;
	
	public BookingManagerVO() {
		
	}

	public int getBookingNo() {
		return bookingNo;
	}

	public void setBookingNo(int bookingNo) {
		this.bookingNo = bookingNo;
	}

	public String getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(String bookingDate) {
		this.bookingDate = bookingDate;
	}

	public String getCarName() {
		return carName;
	}

	public void setCarName(String carName) {
		this.carName = carName;
	}

	public String getFaultDetail() {
		return faultDetail;
	}

	public void setFaultDetail(String faultDetail) {
		this.faultDetail = faultDetail;
	}

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public String getBookingBoolean() {
		return bookingBoolean;
	}

	public void setBookingBoolean(String bookingBoolean) {
		this.bookingBoolean = bookingBoolean;
	}

	public String getReasons() {
		return reasons;
	}

	public void setReasons(String reasons) {
		this.reasons = reasons;
	}

}
