package kr.co.sist.user.vo;

import java.util.Date;

public class NotificateVO {
	
	private String userName, bookResult;
	private Date outDate;
	
	public NotificateVO() {
		super();
	}

	public NotificateVO(String userName, String bookResult, Date outDate) {
		super();
		this.userName = userName;
		this.bookResult = bookResult;
		this.outDate = outDate;
	}

	public String getUserName() {
		return userName;
	}

	public String getBookResult() {
		return bookResult;
	}

	public Date getOutDate() {
		return outDate;
	}

	@Override
	public String toString() {
		return "NotificateVO [userName=" + userName + ", bookResult=" + bookResult + ", outDate=" + outDate + "]";
	}
	
	
	
}
