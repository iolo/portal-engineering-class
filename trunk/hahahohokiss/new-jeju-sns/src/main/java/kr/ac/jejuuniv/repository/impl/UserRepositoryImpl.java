package kr.ac.jejuuniv.repository.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;

import kr.ac.jejuuniv.model.Tweet;
import kr.ac.jejuuniv.model.User;
import kr.ac.jejuuniv.repository.UserRepository;

public class UserRepositoryImpl implements UserRepository {

	private HibernateTemplate hibernateTemplate;
	
	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		hibernateTemplate = new HibernateTemplate(sessionFactory);
	}
	
	public User findUserByUserId(String userId) {
		List<User> users = hibernateTemplate.find("from User where login_id = ?", userId);
		return users.get(0);
	}

	public String findPasswordByUserId(String userId) {
		List<User> users = hibernateTemplate.find("from User where login_id = ?", userId);
		return users.get(0).getPassword();
	}

	public List<Tweet> findTweetByUserId(String userId) {
		List<User> users = hibernateTemplate.find("from User where login_id = ?", userId);
		return users.get(0).getTweets();
	}

	public List<User> findFollowingUserByUserId(String userId) {
		List<User> users = hibernateTemplate.find("from User where login_id = ?", userId);
		return users.get(0).getFollowing();
	}

	public List<User> findFollowerUserByUserId(String userId) {
		List<User> users = hibernateTemplate.find("from User where login_id = ?", userId);
		return users.get(0).getFollower();
	}

	public List<User> findAllUser() {
		return hibernateTemplate.find("from User");
	}

	public List<Tweet> findFollowingUserTweetByFollowingUser(String userId) {
		List<User> users = hibernateTemplate.find("from User where login_id = ?", userId);
		User user = users.get(0);
		List<User> followingUser = user.getFollowing();
		List<Tweet> getTweets = new ArrayList<Tweet>();
		List<Tweet> resultTweets = new ArrayList<Tweet>();
		
		for(int i=0; i<followingUser.size(); i++) {
			getTweets = followingUser.get(i).getTweets();
			for(int j=0; j<getTweets.size(); j++) {
				resultTweets.add(getTweets.get(j));
			}
		}
		Collections.sort(resultTweets);
		Collections.reverse(resultTweets);
		return resultTweets;
	}

	public User updateUser(User user) {
		User getUser = hibernateTemplate.get(User.class, user.getId());
		getUser.setLoginId(user.getLoginId());
		getUser.setPassword(user.getPassword());
		getUser.setUsername(user.getUsername());
		getUser.setExplanation(user.getExplanation());
		getUser.setImgUrl(user.getImgUrl());
		
		hibernateTemplate.merge(getUser);
		return getUser;
	}

	public Tweet insertTweet(String userId, Tweet tweet) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.KOREA);
		String date = simpleDateFormat.format(new Date());
		
		List<User> users = hibernateTemplate.find("from User where login_id = ?", userId);
		User user = users.get(0);
		tweet.setDate(date);
		tweet.setUser(user);
		hibernateTemplate.save(tweet);
		return tweet;
	}

	public User insertUser(User user) {
		hibernateTemplate.save(user);
		return user;
	}

	public void insertFollowing(String followId, String followingId) {
		List<User> followUsers = hibernateTemplate.find("from User where login_id = ?", followId);
		User followerUser = followUsers.get(0);
		
		List<User> followingUsers = hibernateTemplate.find("from User where login_id = ?", followId);
		User followingUser = followingUsers.get(0);
		
		followerUser.getFollowing().add(followingUser);
		hibernateTemplate.merge(followerUser);
		
	}

	public void deleteTweet(String userId, int tweetId) {
		List<User> users = hibernateTemplate.find("from User where login_id = ?", userId);
		User user = users.get(0);
		List<Tweet> tweets = user.getTweets();
		for(Iterator i = tweets.iterator(); i.hasNext();) {
			Tweet tweet =(Tweet) i.next();
			if(tweet.getTweetId() == tweetId) {
				hibernateTemplate.delete(tweet);
			}
		}
	}

}
