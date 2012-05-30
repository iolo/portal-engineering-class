package kr.ac.jejuuniv.model;

import org.apache.ibatis.type.Alias;

@Alias("AllFollow")
public class AllFollow {
	
	private String Following;
	private String id;
	
	

	public String getFollowing() {
		return Following;
	}
	public void setFollowing(String following) {
		Following = following;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

}
