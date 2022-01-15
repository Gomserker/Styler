package com.semi.qna;

import java.util.Date;

public class Post {

	String p_no;
	String P_title;
	String p_text;
	String p_top;
	String p_pants;
	String p_shoes;
	String p_accessary;
	String p_hashtag;
	String p_img;
	Date p_date;
	String p_good;
	String p_item;
	String p_comment;
	String p_user;
	int p_view_count;
	
	

	public Post() {
		// TODO Auto-generated constructor stub
	}

	public String getP_no() {
		return p_no;
	}

	public void setP_no(String p_no) {
		this.p_no = p_no;
	}

	public String getP_title() {
		return P_title;
	}

	public void setP_title(String p_title) {
		P_title = p_title;
	}

	public String getP_text() {
		return p_text;
	}

	public void setP_text(String p_text) {
		this.p_text = p_text;
	}

	public String getP_top() {
		return p_top;
	}

	public void setP_top(String p_top) {
		this.p_top = p_top;
	}

	public String getP_pants() {
		return p_pants;
	}

	public void setP_pants(String p_pants) {
		this.p_pants = p_pants;
	}

	public String getP_shoes() {
		return p_shoes;
	}
	
	public String getP_good() {
		return p_good;
	}

	public void setP_good(String p_good) {
		this.p_good = p_good;
	}

	public void setP_shoes(String p_shoes) {
		this.p_shoes = p_shoes;
	}

	public String getP_accessary() {
		return p_accessary;
	}

	public void setP_accessary(String p_accessary) {
		this.p_accessary = p_accessary;
	}

	public String getP_hashtag() {
		return p_hashtag;
	}

	public void setP_hashtag(String p_hashtag) {
		this.p_hashtag = p_hashtag;
	}

	public String getP_img() {
		return p_img;
	}

	public void setP_img(String p_img) {
		this.p_img = p_img;
	}

	public Date getP_date() {
		return p_date;
	}

	public void setP_date(Date p_date) {
		this.p_date = p_date;
	}

	public String getP_item() {
		return p_item;
	}

	public void setP_item(String p_item) {
		this.p_item = p_item;
	}

	public String getP_comment() {
		return p_comment;
	}

	public void setP_comment(String p_comment) {
		this.p_comment = p_comment;
	}

	public String getP_user() {
		return p_user;
	}

	public void setP_user(String p_user) {
		this.p_user = p_user;
	}
	
	public int getP_view_count() {
		return p_view_count;
	}

	public void setP_view_count(int p_view_count) {
		this.p_view_count = p_view_count;
	}


	public Post(String p_no, String p_title, String p_text, String p_top, String p_pants, String p_shoes,
			String p_accessary, String p_hashtag, String p_img, Date p_date, String p_good, String p_item,
			String p_comment, String p_user, int p_view_count) {
		super();
		this.p_no = p_no;
		P_title = p_title;
		this.p_text = p_text;
		this.p_top = p_top;
		this.p_pants = p_pants;
		this.p_shoes = p_shoes;
		this.p_accessary = p_accessary;
		this.p_hashtag = p_hashtag;
		this.p_img = p_img;
		this.p_date = p_date;
		this.p_good = p_good;
		this.p_item = p_item;
		this.p_comment = p_comment;
		this.p_user = p_user;
		this.p_view_count = p_view_count;
	}

	
	
	
	
}
	
	
	/*
	p_no varchar2(20 char) primary key,
	p_title varchar2(20 char) not null,
	p_text varchar2(20 char) not null,
	p_good varchar2(20 char) not null,
	p_top varchar2(200 char) not null,
	p_pants varchar2(200 char) not null,
	p_shoes varchar2(200 char) not null,
	p_accessary varchar2(300 char) not null,
	p_hashtag varchar2(300 char) not null,
	p_img varchar2(300 char) not null,
	p_date date not null,
	p_item varchar2(300 char) not null,
	p_comment varchar2(300 char) not null,
	p_user varchar2(300 char) not null
	*/
	

