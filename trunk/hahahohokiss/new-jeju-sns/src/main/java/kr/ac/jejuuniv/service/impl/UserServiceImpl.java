package kr.ac.jejuuniv.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import kr.ac.jejuuniv.exception.SignupException;
import kr.ac.jejuuniv.exception.UserNotFoundException;
import kr.ac.jejuuniv.model.Tweet;
import kr.ac.jejuuniv.model.User;
import kr.ac.jejuuniv.repository.UserDao;
import kr.ac.jejuuniv.service.UserDto;
import kr.ac.jejuuniv.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	UserDao userRepository;
	
	public UserServiceImpl(UserDao userRepository) {
		this.userRepository = userRepository;
	}

	public UserServiceImpl() {
		
	}
	
	public User getUser(String userId) {
		User user = userRepository.findUserByUserId(userId);
		if(user != null) {
			return userRepository.findUserByUserId(userId);
		} else {
			throw new UserNotFoundException();
		}
	}

	public String getPassword(String userId) {
		if(userRepository.findUserByUserId(userId) != null) {
			return userRepository.findPasswordByUserId(userId);
		} else {
			throw new UserNotFoundException();
		}
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
		
		for(Iterator i = allUser.iterator(); i.hasNext();) {
			User user = (User) i.next();
			if(user.getLoginId().equals(userId)) {
				i.remove();
			}
		}
		
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
		User getUser = userRepository.findUserByUserId(user.getLoginId());
		if(getUser != null) {
			return userRepository.updateUser(user);
		} else {
			throw new UserNotFoundException();
		}
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
		if(user.getLoginId().isEmpty() || user.getPassword().isEmpty() || user.getUsername().isEmpty()) 
			throw new SignupException();
		if(file.isEmpty()) {
			user.setImgUrl("/resources/images/default.jpg");
		} else {
			user.setImgUrl("/resources/images/"+file.getOriginalFilename());
		}
		return userRepository.insertUser(user, file);
	}

	public void removeFollow(String followId, String followingId) {
		userRepository.deleteFollow(followId, followingId);
		
	}

}
