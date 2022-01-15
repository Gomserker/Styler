package com.semi.qna;

import java.util.Date;

public class Comment {

	private String c_no;
	private String c_text;
	private Date c_date;
	private String c_users;
	private String c_post;
	
	public Comment() {
		// TODO Auto-generated constructor stub
	}

	public Comment(String c_no, String c_text, Date c_date, String c_users, String c_post) {
		super();
		this.c_no = c_no;
		this.c_text = c_text;
		this.c_date = c_date;
		this.c_users = c_users;
		this.c_post = c_post;
	}

	public String getC_no() {
		return c_no;
	}

	public void setC_no(String c_no) {
		this.c_no = c_no;
	}

	public String getC_text() {
		return c_text;
	}

	public void setC_text(String c_text) {
		this.c_text = c_text;
	}

	public Date getC_date() {
		return c_date;
	}

	public void setC_date(Date c_date) {
		this.c_date = c_date;
	}

	public String getC_users() {
		return c_users;
	}

	public void setC_users(String c_users) {
		this.c_users = c_users;
	}

	public String getC_post() {
		return c_post;
	}

	public void setC_post(String c_post) {
		this.c_post = c_post;
	}
}
