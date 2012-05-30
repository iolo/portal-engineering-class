package kr.ac.jejuuniv.model;

import org.apache.ibatis.type.Alias;

@Alias("AllUsers")
public class AllUsers {
	
	private String imageURI;
	private String name;
	private String information;
	private String follow;
	private String id;
	
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getInformation() {
		return information;
	}
	public void setInformation(String information) {
		this.information = information;
	}
	public String getFollow() {
		return follow;
	}
	public void setFollow(String follow) {
		this.follow = follow;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getImageURI() {
		return imageURI;
	}
	public void setImageURI(String imageURI) {
		this.imageURI = imageURI;
	}
	
}
