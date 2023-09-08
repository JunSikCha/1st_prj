package kr.co.sist.user.vo;

import java.util.Date;

public class RecallVO {
	
	private String carName, recallReason;
	private Date recallDate;

	public RecallVO() {
		super();
	}

	public RecallVO(String carName, String recallReason, Date recallDate) {
		super();
		this.carName = carName;
		this.recallReason = recallReason;
		this.recallDate = recallDate;
	}

	public String getCarName() {
		return carName;
	}

	public String getRecallReason() {
		return recallReason;
	}

	public Date getRecallDate() {
		return recallDate;
	}

	@Override
	public String toString() {
		return "RecallVO [carName=" + carName + ", recallReason=" + recallReason + ", recallDate=" + recallDate + "]";
	}

}
