package kr.ac.jejuuniv.Model;

public class UserTweet {
	private User user;
	private Tweet tweet;
	
	public UserTweet() {
	}
	
	public UserTweet(Tweet tweet, User user) {
		this.user = user;
		this.tweet = tweet;
	}
	public User getUser() {
		return user;
	}
	public Tweet getTweet() {
		return tweet;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public void setTweet(Tweet tweet) {
		this.tweet = tweet;
	}
	
}
