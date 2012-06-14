package kr.ac.jejuuniv.model;

import java.util.Date;

public class Post {
	private int index;
	private User user;
	private String content;
	private Date date;
	
	/**
	 * 생성자
	 * @param index 번호
	 * @param user 글쓴이
	 * @param content 내용
	 * @param date 글쓴날짜
	 */
	public Post(int index, User user, String content, Date date) {
		this.index = index;
		this.user = user;
		this.content = content;
		this.date = date;
	}
		
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
}
