package kr.ac.jejuuniv.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="tweet")
public class Tweet {
	
	private Long tweetId;
	private User user = new User();
	private String contents;
	private Date date;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getTweetId() {
		return tweetId;
	}
	
	@Column
	public User getUser() {
		return user;
	}
	
	@Column
	public String getContents() {
		return contents;
	}
	
	@Column
	public Date getDate() {
		return date;
	}
	
	
	public void setTweetId(Long tweetId) {
		this.tweetId = tweetId;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public void setDate(Date date) {
		this.date = date;
	}
}
