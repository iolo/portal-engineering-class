package kr.ac.jejuuniv.Model;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Tweet {
	private int seq;
	private int userNum;
	private String message;
	private Date date;
	
	public Tweet() {
	}
	
	public Tweet(int userNum, String message, Date date) {
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
	public String getDate() {
		SimpleDateFormat formatter = new SimpleDateFormat ( "yyyy.MM.dd", Locale.KOREA );
		String dTime = formatter.format (date);
		return dTime;
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
	
	public String toString() {
		return "Tweet [seq= "+ seq + ", userNum=" + userNum + ", message=" + message + ", date=" + date + "]";
	}
	
}
