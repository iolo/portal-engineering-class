package kr.ac.jejuuniv.model;

import org.apache.ibatis.type.Alias;



@Alias("FollowIdTemp")
public class FollowIdTemp {
	
	private String userId;
	private String followId;
	
	

	public FollowIdTemp(String id, String followid) {
		this.setFollowId(followid);
		this.setUserId(id);
	}
	
	public FollowIdTemp(){}
	public String getFollowId() {
		return followId;
	}
	public void setFollowId(String followId) {
		this.followId = followId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}

}
