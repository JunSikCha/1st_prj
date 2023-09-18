package kr.co.sist.user.vo;

public class RegistCarVO {
	
	private String carModel, carNo, modelNo, id;
	private int distance;

	public RegistCarVO() {
		super();
	}
	
	public RegistCarVO(String carNo, String modelNo, String id) {
		this.carNo = carNo;
		this.modelNo = modelNo;
		this.id = id;
	}

	public RegistCarVO(String carModel, String carNo, String modelNo, String id, int distance) {
		super();
		this.carModel = carModel;
		this.carNo = carNo;
		this.modelNo = modelNo;
		this.id = id;
		this.distance = distance;
	}

	public String getCarModel() {
		return carModel;
	}

	public String getCarNo() {
		return carNo;
	}

	public String getModelNo() {
		return modelNo;
	}

	public String getId() {
		return id;
	}

	public int getDistance() {
		return distance;
	}

	public void setCarModel(String carModel) {
		this.carModel = carModel;
	}

	public void setCarNo(String carNo) {
		this.carNo = carNo;
	}

	public void setModelNo(String modelNo) {
		this.modelNo = modelNo;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

	@Override
	public String toString() {
		return "RegistCarVO [carModel=" + carModel + ", carNo=" + carNo + ", modelNo=" + modelNo + ", id=" + id
				+ ", distance=" + distance + "]";
	}
	
	
	
}

