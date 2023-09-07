package manager.carmanager;

public class CarManagerVO {
	private int historyNo;
	private String clientName;
	private String clientPhone;
	private String carNo;
	private String clientEmail;
	private int carMileage;
	private String carName;
	private int maintenanceNo;
	private String empName;
	private String receivedDay;
	private String releaseDay;
	
	private String faultDetail;
	
	private String maintenanceDetail;
	
	private String note;
	
	




	public int getHistoryNo() {
		return historyNo;
	}



	public void setHistoryNo(int historyNo) {
		this.historyNo = historyNo;
	}



	public CarManagerVO() {
		super();
	}



	public String getClientName() {
		return clientName;
	}



	public void setClientName(String clientName) {
		this.clientName = clientName;
	}



	public String getClientPhone() {
		return clientPhone;
	}



	public void setClientPhone(String clientPhone) {
		this.clientPhone = clientPhone;
	}



	public String getCarNo() {
		return carNo;
	}



	public void setCarNo(String carNo) {
		this.carNo = carNo;
	}



	public String getClientEmail() {
		return clientEmail;
	}



	public void setClientEmail(String clientEmail) {
		this.clientEmail = clientEmail;
	}



	public int getCarMileage() {
		return carMileage;
	}



	public void setCarMileage(int carMileage) {
		this.carMileage = carMileage;
	}



	public String getCarName() {
		return carName;
	}



	public void setCarName(String carName) {
		this.carName = carName;
	}



	public int getMaintenanceNo() {
		return maintenanceNo;
	}



	public void setMaintenanceNo(int maintenanceNo) {
		this.maintenanceNo = maintenanceNo;
	}



	public String getEmpName() {
		return empName;
	}



	public void setEmpName(String empName) {
		this.empName = empName;
	}



	public String getReceivedDay() {
		return receivedDay;
	}



	public void setReceivedDay(String receivedDay) {
		this.receivedDay = receivedDay;
	}



	public String getReleaseDay() {
		return releaseDay;
	}



	public void setReleaseDay(String releaseDay) {
		this.releaseDay = releaseDay;
	}



	public String getFaultDetail() {
		return faultDetail;
	}



	public void setFaultDetail(String faultDetail) {
		this.faultDetail = faultDetail;
	}



	public String getMaintenanceDetail() {
		return maintenanceDetail;
	}



	public void setMaintenanceDetail(String maintenanceDetail) {
		this.maintenanceDetail = maintenanceDetail;
	}



	public String getNote() {
		return note;
	}



	public void setNote(String note) {
		this.note = note;
	}



	@Override
	public String toString() {
		return "CarManagerVO [historyNo=" + historyNo + ", clientName=" + clientName + ", clientPhone=" + clientPhone
				+ ", carNo=" + carNo + ", clientEmail=" + clientEmail + ", carMileage=" + carMileage + ", carName="
				+ carName + ", maintenanceNo=" + maintenanceNo + ", empName=" + empName + ", receivedDay=" + receivedDay
				+ ", releaseDay=" + releaseDay + ", faultDetail=" + faultDetail + ", maintenanceDetail="
				+ maintenanceDetail + ", note=" + note + "]";
	}



	
	



	
	
	
	
}
