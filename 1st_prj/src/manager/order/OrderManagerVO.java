package manager.order;

public class OrderManagerVO {
	private int orderNo;
	private String orderDate;
	private String partNo;
	private String partName;
	private int orderQuantity;
	private String partUnit;
	private int partCost;
	
	private int partStork;

	public OrderManagerVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
	}

	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
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

	public int getOrderQuantity() {
		return orderQuantity;
	}

	public void setOrderQuantity(int orderQuantity) {
		this.orderQuantity = orderQuantity;
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

	public int getPartStork() {
		return partStork;
	}

	public void setPartStork(int partStork) {
		this.partStork = partStork;
	}

	@Override
	public String toString() {
		return "OrderManagerVO [orderNo=" + orderNo + ", orderDate=" + orderDate + ", partNo=" + partNo + ", partName="
				+ partName + ", orderQuantity=" + orderQuantity + ", partUnit=" + partUnit + ", partCost=" + partCost
				+ ", partStork=" + partStork + "]";
	}
	
	
	

}
