package kr.ac.jejuuniv.model;

public class Follow {
	private String followerUserId;
	private String followingUserId;
	
	public Follow() {
		
	}
	
	public String getFollowerUserId() {
		return followerUserId;
	}
	
	public void setFollowerUserId(String followerUserId) {
		this.followerUserId = followerUserId;
	}
	
	public String getFollowingUserId() {
		return followingUserId;
	}
	
	public void setFollowingUserId(String followingUserId) {
		this.followingUserId = followingUserId;
	}
}
