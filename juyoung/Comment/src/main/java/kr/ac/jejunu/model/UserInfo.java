package kr.ac.jejunu.model;

public class UserInfo {
	private String id;
	private String password;
	private String name;
	private String profile;
	private String profile_url;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getProflie() {
		return profile;
	}
	public void setProflie(String proflie) {
		this.profile = proflie;
	}
	public String getProflie_url() {
		return profile_url;
	}
	public void setProflie_url(String proflie_url) {
		this.profile_url = proflie_url;
	}
	
}
