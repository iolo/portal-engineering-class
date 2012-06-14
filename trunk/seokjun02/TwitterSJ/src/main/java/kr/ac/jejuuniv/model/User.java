package kr.ac.jejuuniv.model;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;

@Alias("User")
public class User implements Serializable{
	private static final long serialVersionUID = -732288218857259643L;
	
	private String userId;
	private String password;
	private String userName;
	private String introduce;
	private String photo;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getIntroduce() {
		return introduce;
	}
	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
}
