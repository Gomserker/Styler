package com.semi.daily;

public class AllLikeCount {

	
	private String postNo;
	private String numberOfLike;
	
	public AllLikeCount() {
		// TODO Auto-generated constructor stub
	}

	public AllLikeCount(String postNo, String numberOfLike) {
		super();
		this.postNo = postNo;
		this.numberOfLike = numberOfLike;
	}

	public String getPostNo() {
		return postNo;
	}

	public void setPostNo(String postNo) {
		this.postNo = postNo;
	}

	public String getNumberOfLike() {
		return numberOfLike;
	}

	public void setNumberOfLike(String numberOfLike) {
		this.numberOfLike = numberOfLike;
	}
	
	
	
}
