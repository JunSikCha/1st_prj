package kr.co.sist.user.vo;

public class RegistCarVO {
	
	private String carModel, carNo;
	private int distance;

	public RegistCarVO() {
		super();
	}

	public RegistCarVO(String carModel, String carNo, int distance) {
		super();
		this.carModel = carModel;
		this.carNo = carNo;
		this.distance = distance;
	}

	public String getCarModel() {
		return carModel;
	}

	public String getCarNo() {
		return carNo;
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
		return "RegistCarVO [carModel=" + carModel + ", carNo=" + carNo + ", distance=" + distance + "]";
	}
	
}
