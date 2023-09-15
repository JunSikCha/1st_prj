package kr.co.sist.user.vo;

public class RegistCarVO {
	
	private String carModel, carNo, modelNo;
	private int distance;

	public RegistCarVO() {
		super();
	}

	public RegistCarVO(String carModel, String carNo, String modelNo, int distance) {
		super();
		this.carModel = carModel;
		this.carNo = carNo;
		this.modelNo = modelNo;
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

	public int getDistance() {
		return distance;
	}

	public void setCarModel(String carModel) {
		this.carModel = carModel;
	}

	public void setCarNo(String carNo) {
		this.carNo = carNo;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

	@Override
	public String toString() {
		return "RegistCarVO [carModel=" + carModel + ", carNo=" + carNo + ", modelNo=" + modelNo + ", distance="
				+ distance + "]";
	}

	
	
}
