package kr.ac.jejuuniv.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.jejuuniv.model.Tweet;
import kr.ac.jejuuniv.model.User;
import kr.ac.jejuuniv.repository.UserRepository;
import kr.ac.jejuuniv.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	UserRepository userRepository;
	
	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public UserServiceImpl() {
		
	}
	
	public User getUser(String userId) {
		return userRepository.findUserByUserId(userId);
	}

	public String getPassword(String userId) {
		return userRepository.findPasswordByUserId(userId);
	}

	public List<Tweet> getTweets(String userId) {
		return userRepository.findTweetByUserId(userId);
	}

	public List<User> getFollowingUser(String userId) {
		return userRepository.findFollowingUserByUserId(userId);
	}

	public List<User> getFollowerUser(String userId) {
		return userRepository.findFollowerUserByUserId(userId);
	}

	public List<User> getAllUser() {
		return userRepository.findAllUser();
	}

	public List<Tweet> getFollowingTweet(String userId) {
		return userRepository.findFollowingUserTweetByFollowingUser(userId);
		 
	}

	public User modifyUser(User user) {
		return userRepository.updateUser(user);
	}

	public void addFollow(String followId, String followingId) {
		userRepository.insertFollowing(followId, followingId);
	}

	public Tweet addTweet(String userId, Tweet tweet) {
		return userRepository.insertTweet(userId, tweet);
	}

	public void removeTweet(String userId, int tweetId) {
		userRepository.deleteTweet(userId, tweetId);
	}

	public User addUser(User user) {
		return userRepository.insertUser(user);
	}

	public void removeFollow(String followId, String followingId) {
		userRepository.deleteFollow(followId, followingId);
		
	}

}
