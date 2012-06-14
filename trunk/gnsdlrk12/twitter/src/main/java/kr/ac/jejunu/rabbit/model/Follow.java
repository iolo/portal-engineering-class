package kr.ac.jejunu.rabbit.model;

import org.apache.ibatis.type.Alias;

@Alias("Follow")
public class Follow {
	private String followerimageURL;
	private String followername;
	private String userid;
	private String followerintroduce;
	private String followerid;
	private String state;
	private String follow;
	
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
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getFollow() {
		return follow;
	}
	public void setFollow(String follow) {
		this.follow = follow;
	}
}
