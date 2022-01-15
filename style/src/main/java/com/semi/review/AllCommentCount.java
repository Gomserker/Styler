package com.semi.review;

public class AllCommentCount {
private String postNo;
private String numberOfComment;

public AllCommentCount() {
	// TODO Auto-generated constructor stub
}

public AllCommentCount(String postNo, String numberOfComment) {
	super();
	this.postNo = postNo;
	this.numberOfComment = numberOfComment;
}

public String getPostNo() {
	return postNo;
}

public void setPostNo(String postNo) {
	this.postNo = postNo;
}

public String getNumberOfComment() {
	return numberOfComment;
}

public void setNumberOfComment(String numberOfComment) {
	this.numberOfComment = numberOfComment;
}


}
