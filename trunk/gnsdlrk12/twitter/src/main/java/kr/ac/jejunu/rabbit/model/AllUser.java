package kr.ac.jejunu.rabbit.model;

public class AllUser {
	private String userid;
	private String name;
	private String password;
	private String image;
	private String introduce;
	private String follow;
	private String followerid;
	
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getIntroduce() {
		return introduce;
	}
	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}
	public String getFollow() {
		return follow;
	}
	public void setFollow(String follow) {
		this.follow = follow;
	}
	public String getFollowerid() {
		return followerid;
	}
	public void setFollowerid(String followerid) {
		this.followerid = followerid;
	}
	
}
