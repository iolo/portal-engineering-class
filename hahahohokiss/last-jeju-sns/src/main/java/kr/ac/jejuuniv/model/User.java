package kr.ac.jejuuniv.model;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="user")
public class User {
	private int id;
	private String loginId;
	private String password;
	private String username;
	private String explanation;
	private String imgUrl;
	private List<User> following = new ArrayList<User>();
	private List<User> follower = new ArrayList<User>();
	private List<Tweet> tweets = new ArrayList<Tweet>();
	
	public User() {
		
	}
	
	public User(String loginId, String password, String username, String explanation, String imgUrl){
		this.loginId = loginId;
		this.password = password;
		this.username = username;
		this.explanation = explanation;
		this.imgUrl = imgUrl;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@Column(name="login_id")
	public String getLoginId() {
		return loginId;
	}
	
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}
	
	@Column(name="username")
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	@Column(name="password")
	public String getPassword(){
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Column(name="explanation")
	public String getExplanation() {
		return explanation;
	}
	
	public void setExplanation(String explanation) {
		this.explanation = explanation;
	}
	
	@Column(name="img_url")
	public String getImgUrl() {
		return imgUrl;
	}
	
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	
	@OneToMany(cascade={CascadeType.ALL}, fetch=FetchType.LAZY)
	@JoinTable(
		name="follow",
		joinColumns={@JoinColumn(name="id")},
		inverseJoinColumns = @JoinColumn(name="following_id")
	)
	public List<User> getFollowing() {
		return following;
	}
	
	public void setFollowing(List<User> following) {
		this.following = following;
	}
	@OneToMany(cascade={CascadeType.ALL}, fetch=FetchType.LAZY)
	@JoinTable(
		name="follow",
		joinColumns={@JoinColumn(name="following_id")},
		inverseJoinColumns = @JoinColumn(name="id")
	)
	public List<User> getFollower() {
		return follower;
	}

	public void setFollower(List<User> follower) {
		this.follower = follower;
	}
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy ="user")
	public List<Tweet> getTweets() {
		return tweets;
	}

	public void setTweets(List<Tweet> tweets) {
		this.tweets = tweets;
	}
	
	
}
