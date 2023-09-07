package manager.inventory;

public class InventoryManagerVO {
	private String partNo;
	private String partName;
	private int partStock;
	private String partUnit;
	private int partCost;
	private int laborCost;
	private String inputDate;
	public InventoryManagerVO() {
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
	public int getPartStock() {
		return partStock;
	}
	public void setPartStock(int partStock) {
		this.partStock = partStock;
	}
	public String getPartUnit() {
		return partUnit;
	}
	public void setPartUnit(String partUnit) {
		this.partUnit = partUnit;
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
	public String getInputDate() {
		return inputDate;
	}
	public void setInputDate(String inputDate) {
		this.inputDate = inputDate;
	}
	
	

}
