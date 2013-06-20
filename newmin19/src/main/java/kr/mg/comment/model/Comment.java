package kr.mg.comment.model;

import java.util.Date;

public class Comment {

	private String id;
	private String comment;
	private Date regdate;
	private int likeCount;
	private int unlikeCount;
	
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
	
}
