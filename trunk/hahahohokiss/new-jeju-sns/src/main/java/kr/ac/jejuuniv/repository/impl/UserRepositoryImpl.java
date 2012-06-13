package kr.ac.jejuuniv.repository.impl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
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
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import kr.ac.jejuuniv.exception.UserNotFoundException;
import kr.ac.jejuuniv.model.Tweet;
import kr.ac.jejuuniv.model.User;
import kr.ac.jejuuniv.repository.UserRepository;

@Repository
public class UserRepositoryImpl implements UserRepository {

	private HibernateTemplate hibernateTemplate;
	
	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		hibernateTemplate = new HibernateTemplate(sessionFactory);
	}
	
	public User findUserByUserId(String userId) {
		List<User> users = hibernateTemplate.find("from User where login_id = ?", userId);
		if(users.size()==0) {
			return null;
		} else {
			return users.get(0);
		}
	}

	public String findPasswordByUserId(String userId) {
		return findUserByUserId(userId).getPassword();
	}

	public List<Tweet> findTweetByUserId(String userId) {
		List<Tweet> tweets = findUserByUserId(userId).getTweets();
		Collections.sort(tweets);
		Collections.reverse(tweets);
		return tweets;
	}

	public List<User> findFollowingUserByUserId(String userId) {
		return findUserByUserId(userId).getFollowing();
	}

	public List<User> findFollowerUserByUserId(String userId) {
		List<User> users = hibernateTemplate.find("from User where login_id = ?", userId);
		return users.get(0).getFollower();
	}

	public List<User> findAllUser() {
		return hibernateTemplate.find("from User");
	}

	public List<Tweet> findFollowingUserTweetByFollowingUser(String userId) {
		User user = findUserByUserId(userId);
		List<User> followingUser = user.getFollowing();
		List<Tweet> getTweets = new ArrayList<Tweet>();
		List<Tweet> resultTweets = new ArrayList<Tweet>();
		
		for(int i=0; i<followingUser.size(); i++) {
			getTweets = followingUser.get(i).getTweets();
			for(int j=0; j<getTweets.size(); j++) {
				resultTweets.add(getTweets.get(j));
			}
		}
		
		resultTweets.addAll(user.getTweets());
		Collections.sort(resultTweets);
		Collections.reverse(resultTweets);
		return resultTweets;
	}

	public User updateUser(User user) {
		User getUser = findUserByUserId(user.getLoginId());
		getUser.setLoginId(user.getLoginId());
		getUser.setPassword(user.getPassword());
		getUser.setUsername(user.getUsername());
		getUser.setExplanation(user.getExplanation());
		getUser.setImgUrl(getUser.getImgUrl());
		   
		hibernateTemplate.merge(getUser);
		return getUser;
	}

	public Tweet insertTweet(String userId, Tweet tweet) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.KOREA);
		String date = simpleDateFormat.format(new Date());
		
		User user = findUserByUserId(userId);
		tweet.setDate(date);
		tweet.setUser(user);
		hibernateTemplate.save(tweet);
		return tweet;
	}

	public User insertUser(User user, MultipartFile file) throws IOException {
		byte[] byteFile = file.getBytes();
		File imgFile = new File("/Users/jinsoohan/Documents/Projects/new-jeju-sns/src/main/webapp/resources/images/"+file.getOriginalFilename());
		FileOutputStream fos;
		fos = new FileOutputStream(imgFile);
		fos.write(byteFile);
		fos.close();
		hibernateTemplate.save(user);
		return user;
	}

	public void insertFollowing(String followId, String followingId) {
		User followerUser = findUserByUserId(followId);
		
		User followingUser = findUserByUserId(followingId);
		
		followerUser.getFollowing().add(followingUser);
		hibernateTemplate.merge(followerUser);
		
	}

	public void deleteTweet(String userId, int tweetId) {
		User user = findUserByUserId(userId);
		List<Tweet> tweets = user.getTweets();
		for(Iterator i = tweets.iterator(); i.hasNext();) {
			Tweet tweet =(Tweet) i.next();
			if(tweet.getTweetId() == tweetId) {
				hibernateTemplate.delete(tweet);
			}
		}
	}

	public void deleteFollow(String followId, String followingId) {
		User followerUser = findUserByUserId(followId);
		List<User> users = followerUser.getFollowing();
		
		User followingUser = findUserByUserId(followingId);
		
		for(Iterator i = users.iterator(); i.hasNext();) {
			User user = (User) i.next();
			if(user.getId() == followingUser.getId()) {
				i.remove();
			}
		}
		hibernateTemplate.merge(followerUser);
	}

}
