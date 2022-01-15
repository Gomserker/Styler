package com.semi.review;

import java.sql.Date;

public class Review {
	private String no;
	private String title;
	private String text;
	private String good;
	private String top;
	private String pants;
	private String shoes;
	private String accessary;
	private String hashtag;
	private String img;
	private String item;
	private String comment;
	private String user;
	private Date date;
	private int view_count;
	private String price;
	
	public Review () {}
	
	public Review(String no, String title, String text, String good, String top, String pants, String shoes,
			String accessary, String hashtag, String img, String item, String comment, String user, Date date, int view_count, String price) {
		super();
		this.no = no;
		this.title = title;
		this.text = text;
		this.good = good;
		this.top = top;
		this.pants = pants;
		this.shoes = shoes;
		this.accessary = accessary;
		this.hashtag = hashtag;
		this.img = img;
		this.item = item;
		this.comment = comment;
		this.user = user;
		this.date = date;
		this.view_count = view_count;
		this.price = price;
	}

	
	
	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public int getView_count() {
		return view_count;
	}

	public void setView_count(int view_count) {
		this.view_count = view_count;
	}

	public String getHashtag() {
		return hashtag;
	}

	public void setHashtag(String hashtag) {
		this.hashtag = hashtag;
	}

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getGood() {
		return good;
	}

	public void setGood(String good) {
		this.good = good;
	}

	public String getTop() {
		return top;
	}

	public void setTop(String top) {
		this.top = top;
	}

	public String getPants() {
		return pants;
	}

	public void setPants(String pants) {
		this.pants = pants;
	}

	public String getShoes() {
		return shoes;
	}

	public void setShoes(String shoes) {
		this.shoes = shoes;
	}

	public String getAccessary() {
		return accessary;
	}

	public void setAccessary(String accessary) {
		this.accessary = accessary;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	
}
