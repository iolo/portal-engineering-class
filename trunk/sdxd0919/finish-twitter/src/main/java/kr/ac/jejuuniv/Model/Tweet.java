package kr.ac.jejuuniv.Model;

public class Tweet {
	private int seq;
	private int userNum;
	private String message;
	private String date;

	public Tweet() {
	}
	
	public Tweet(int userNum, String message) {
		this.userNum = userNum;
		this.message = message;
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
	public String getDate() {
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
	public void setDate(String date) {
		this.date = date;
	}
	
	public String toString() {
		return "Tweet [seq= "+ seq + ", userNum=" + userNum + ", message=" + message + ", date=" + date + "]";
	}
	
}
