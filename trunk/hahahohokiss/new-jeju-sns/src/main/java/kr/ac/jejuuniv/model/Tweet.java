package kr.ac.jejuuniv.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="tweets")
public class Tweet {
	private int tweetId;
	private String contents;
	private String date;
	private User user = new User();
	
	public Tweet() {
		
	}
	
	public Tweet(String contents, String date) {
		this.contents = contents;
		this.date = date;
	}
	@Id
	@GeneratedValue
	@Column(name="tweet_id")
	public int getTweetId() {
		return tweetId;
	}
	
	public void setTweetId(int tweetId) {
		this.tweetId = tweetId;
	}
	
	@Column(name="contents")
	public String getContents() {
		return contents;
	}
	
	public void setContents(String contents) {
		this.contents = contents;
	}
	
	@Column(name="create_date") 
	public String getDate() {
		return date;
	}
	
	public void setDate(String date) {
		this.date = date;
	}
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id")
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}	
}
