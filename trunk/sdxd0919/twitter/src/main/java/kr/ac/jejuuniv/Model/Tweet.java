package kr.ac.jejuuniv.Model;

import java.sql.Date;

public class Tweet {
	private int seq;
	private int userNum;
	private String message;
	private Date date;
	
	public Tweet() {
	}
	
	public Tweet(int seq, int userNum, String message, Date date) {
		this.seq = seq;
		this.userNum = userNum;
		this.message = message;
		this.date = date;
	}
	public int getSeq() {
		return seq;
	}
	public int getUserNum() {
		return userNum;
	}
	public String getMessage() {
		return message;
	}
	public Date getDate() {
		return date;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public void setUserNum(int userNum) {
		this.userNum = userNum;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	
}
