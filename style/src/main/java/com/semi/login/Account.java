package com.semi.login;

public class Account {
	private String id;
	private String pw;
	private String name;
	private String nickname;
	private String email;
	private String gender;
	private String style;
	private String profileImg;
	private String typeOfManger;
	private String checkPoint;
	private String checkDate;
	
	public String getCheckDate() {
		return checkDate;
	}

	public void setCheckDate(String checkDate) {
		this.checkDate = checkDate;
	}

	public Account() {
		// TODO Auto-generated constructor stub
	}

	public Account(String id, String pw, String name, String nickname, String email, String gender, String style,
			String profileImg, String typeOfManger, String checkPoint) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.nickname = nickname;
		this.email = email;
		this.gender = gender;
		this.style = style;
		this.profileImg = profileImg;
		this.typeOfManger = typeOfManger;
		this.checkPoint = checkPoint;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getStyle() {
		return style;
	}

	public void setStyle(String style) {
		this.style = style;
	}

	public String getProfileImg() {
		return profileImg;
	}

	public void setProfileImg(String profileImg) {
		this.profileImg = profileImg;
	}

	public String getTypeOfManger() {
		return typeOfManger;
	}

	public void setTypeOfManger(String typeOfManger) {
		this.typeOfManger = typeOfManger;
	}

	public String getCheckPoint() {
		return checkPoint;
	}

	public void setCheckPoint(String checkPoint) {
		this.checkPoint = checkPoint;
	}
	
	
	
}
