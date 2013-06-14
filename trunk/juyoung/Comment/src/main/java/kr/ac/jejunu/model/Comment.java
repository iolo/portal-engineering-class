package kr.ac.jejunu.model;

import java.util.Date;

public class Comment {
	private int listId;
	private String userUrl;
	private String writer;
	private String commentText;
	private int positive;
	private int negative;
	private Date regTime;
	
	public int getListId() {
		return listId;
	}
	public void setListId(int listId) {
		this.listId = listId;
	}
	public String getUserUrl() {
		return userUrl;
	}
	public void setUserUrl(String userUrl) {
		this.userUrl = userUrl;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getCommentText() {
		return commentText;
	}
	public void setCommentText(String commentText) {
		this.commentText = commentText;
	}
	public int getPositive() {
		return positive;
	}
	public void setPositive(int positive) {
		this.positive = positive;
	}
	public int getNegative() {
		return negative;
	}
	public void setNegative(int negative) {
		this.negative = negative;
	}
	public Date getRegTime() {
		return regTime;
	}
	public void setRegTime(Date regTime) {
		this.regTime = regTime;
	}


}
