package kr.ac.jejuuniv.service.impl;

import java.util.List;

import kr.ac.jejuuniv.model.Tweet;
import kr.ac.jejuuniv.model.User;
import kr.ac.jejuuniv.repository.UserRepository;
import kr.ac.jejuuniv.service.UserService;

public class UserServiceImpl implements UserService {

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
		
	}

	public Tweet addTweet(String userId, Tweet tweet) {
		return userRepository.insertTweet(userId, tweet);
	}

}
