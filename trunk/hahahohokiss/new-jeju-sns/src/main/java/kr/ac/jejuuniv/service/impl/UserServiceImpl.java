package kr.ac.jejuuniv.service.impl;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


import kr.ac.jejuuniv.model.Tweet;
import kr.ac.jejuuniv.model.User;
import kr.ac.jejuuniv.repository.UserRepository;
import kr.ac.jejuuniv.service.UserDto;
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

	public List<UserDto> getFollowerUser(String userId) {
		List<UserDto> resultUsers = new ArrayList<UserDto>();
		List<User> followers = userRepository.findFollowerUserByUserId(userId);
		List<User> followingUsers = userRepository.findFollowingUserByUserId(userId);
		
		for(int i=0; i<followers.size(); i++) {
			boolean flag = false;
			for(int j=0; j<followingUsers.size(); j++) {
				if(followers.get(i).getId() == followingUsers.get(j).getId()) {
					flag = true;
					break;
				}
			}
			if(flag==true) {
				resultUsers.add(new UserDto(followers.get(i), true));
			} else {
				resultUsers.add(new UserDto(followers.get(i), false));
			}
		}
		
		return resultUsers;
	}

	public List<UserDto> getAllUser(String userId) {
		List<UserDto> resultUsers = new ArrayList<UserDto>();
		List<User> followingUsers = userRepository.findFollowingUserByUserId(userId);
		List<User> allUser = userRepository.findAllUser();
		
		for(int i=0; i<allUser.size(); i++) {
			boolean flag = false;
			for(int j=0; j<followingUsers.size(); j++) {
				if(allUser.get(i).getId() == followingUsers.get(j).getId()) {
					flag =true;
					break;
				}
			}
			if(flag==true) {
				resultUsers.add(new UserDto(allUser.get(i), true));
			} else {
				resultUsers.add(new UserDto(allUser.get(i), false));
			}
		}
		
		return resultUsers;
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

	public User addUser(User user, MultipartFile file) throws IOException {
		return userRepository.insertUser(user, file);
	}

	public void removeFollow(String followId, String followingId) {
		userRepository.deleteFollow(followId, followingId);
		
	}

}
