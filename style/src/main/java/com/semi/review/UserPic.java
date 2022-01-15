package com.semi.review;

public class UserPic {

	private String nickname;
	private String u_img;
	
	public UserPic() {
		// TODO Auto-generated constructor stub
	}

	public UserPic(String nickname, String u_img) {
		super();
		this.nickname = nickname;
		this.u_img = u_img;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getU_img() {
		return u_img;
	}

	public void setU_img(String u_img) {
		this.u_img = u_img;
	}
	
	
}
