package kr.ac.jejunu.model;

import java.util.Date;

public class Comment {
	
	private int id;
	private String comment;
	private String password;
	private Date regdate;
	
	public Comment() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date registDatetime) {
		this.regdate = registDatetime;
	}
	
	@Override
	public String toString() {
		return id + ":" + comment;
	}

}
