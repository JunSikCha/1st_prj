package manager.inventory;

public class PartInfoVO {
	private String partNo;
	private String partName;
	private int partCost;
	private int laborCost;
	
	private String partStock;
	private String partUnit;
	
	private int historyNo;
	private int empNo;
	private String modelNo;
	private int bookingNo;
	private String carNo;
	
	private int usedPartQuantity;
	
	public int getHistoryNo() {
		return historyNo;
	}
	public void setHistoryNo(int historyNo) {
		this.historyNo = historyNo;
	}
	public int getEmpNo() {
		return empNo;
	}
	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}
	public String getModelNo() {
		return modelNo;
	}
	public void setModelNo(String modelNo) {
		this.modelNo = modelNo;
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
	public int getUsedPartQuantity() {
		return usedPartQuantity;
	}
	public void setUsedPartQuantity(int usedPartQuantity) {
		this.usedPartQuantity = usedPartQuantity;
	}
	public PartInfoVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getPartNo() {
		return partNo;
	}
	public void setPartNo(String partNo) {
		this.partNo = partNo;
	}
	public String getPartName() {
		return partName;
	}
	public void setPartName(String partName) {
		this.partName = partName;
	}
	public int getPartCost() {
		return partCost;
	}
	public void setPartCost(int partCost) {
		this.partCost = partCost;
	}
	public int getLaborCost() {
		return laborCost;
	}
	public void setLaborCost(int laborCost) {
		this.laborCost = laborCost;
	}
	public String getPartStock() {
		return partStock;
	}
	public void setPartStock(String partStock) {
		this.partStock = partStock;
	}
	public String getPartUnit() {
		return partUnit;
	}
	public void setPartUnit(String partUnit) {
		this.partUnit = partUnit;
	}
	@Override
	public String toString() {
		return "PartInfoVO [partNo=" + partNo + ", partName=" + partName + ", partCost=" + partCost + ", laborCost="
				+ laborCost + ", partStock=" + partStock + ", partUnit=" + partUnit + ", usedPartQuantity="
				+ usedPartQuantity + "]";
	}

}
