package kr.ac.jejunu.rabbit.model;

public class Follow {
	private String followerimageURL;
	private String followername;
	private String userid;
	private String followerintroduce;
	private String followerid;
	
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getFollowerimageURL() {
		return followerimageURL;
	}
	public void setFollowerimageURL(String followerimageURL) {
		this.followerimageURL = followerimageURL;
	}
	public String getFollowername() {
		return followername;
	}
	public void setFollowername(String followername) {
		this.followername = followername;
	}
	public String getFollowerintroduce() {
		return followerintroduce;
	}
	public void setFollowerintroduce(String followerintroduce) {
		this.followerintroduce = followerintroduce;
	}
	public String getFollowerid() {
		return followerid;
	}
	public void setFollowerid(String followerid) {
		this.followerid = followerid;
	}
}
