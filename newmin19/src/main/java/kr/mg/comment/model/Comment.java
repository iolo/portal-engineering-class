package kr.mg.comment.model;

import java.util.Date;

public class Comment {

	private String id;
	private String name;
	private String image;
	private String comment;
	private Date regdate;
	private int likeCount;
	private int unlikeCount;
	private String strRegdate;
	
	public String getStrRegdate() {
		return strRegdate;
	}
	public void setStrRegdate(String strRegdate) {
		this.strRegdate = strRegdate;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	public int getLikeCount() {
		return likeCount;
	}
	public void setLikeCount(int likeCount) {
		this.likeCount = likeCount;
	}
	public int getUnlikeCount() {
		return unlikeCount;
	}
	public void setUnlikeCount(int unlikeCount) {
		this.unlikeCount = unlikeCount;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
}
