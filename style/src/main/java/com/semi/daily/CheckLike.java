package com.semi.daily;

public class CheckLike {

	private String luser;
	private String lcheckStatus;
	
	public CheckLike() {
		// TODO Auto-generated constructor stub
	}

	public CheckLike(String luser, String lcheckStatus) {
		super();
		this.luser = luser;
		this.lcheckStatus = lcheckStatus;
	}

	public String getLuser() {
		return luser;
	}

	public void setLuser(String luser) {
		this.luser = luser;
	}

	public String getLcheckStatus() {
		return lcheckStatus;
	}

	public void setLcheckStatus(String lcheckStatus) {
		this.lcheckStatus = lcheckStatus;
	}
	
	
	
}