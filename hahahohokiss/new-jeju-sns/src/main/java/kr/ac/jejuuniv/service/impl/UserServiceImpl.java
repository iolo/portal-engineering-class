package kr.ac.jejuuniv.service.impl;

import java.util.ArrayList;
import java.util.List;

import kr.ac.jejuuniv.exception.UserNotFoundException;
import kr.ac.jejuuniv.model.Follow;
import kr.ac.jejuuniv.model.User;
import kr.ac.jejuuniv.repository.FollowRepository;
import kr.ac.jejuuniv.repository.UserRepository;
import kr.ac.jejuuniv.service.UserService;

public class UserServiceImpl implements UserService {

	UserRepository userRepository;
	FollowRepository followRepository;
	
	public UserServiceImpl() {
		
	}
	
	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	public void setFollowRepository(FollowRepository followRepository) {
		this.followRepository = followRepository;
	}
	
	public User getUserByUserId(String id) {
		if(userRepository.findUserByUserId(id) != null) {
			return userRepository.findUserByUserId(id);
		}
		throw new UserNotFoundException();
	}

	public String getPasswordByUserId(String id) {
		return userRepository.findPasswordByUserId(id);
	}

	public User add(User user) {
		return	userRepository.insert(user);
	}

	public String registerFollowing(String followerId, String followingId) {
		Follow follow = followRepository.addFollowing(followerId, followingId);
		return follow.getFollowingUserId();
	}

	public List<User> getFollower(String id) {
		List<String> followersId = getFollowersId(id);
		List<User> followers = new ArrayList<User>();
		for(int i=0; i<followersId.size(); i++) {
			followers.add(userRepository.findUserByUserId(followersId.get(i)));
		}
		return followers;
	}

	public List<String> getFollowersId(String id) {
		return followRepository.getFollowerId(id);
	}

	public List<User> getFollowingUser(String id) {
		List<String> followingUserId = getFollowingUserId(id);
		List<User> followingUser = new ArrayList<User>();
		for(int i=0; i<followingUserId.size(); i++) {
			followingUser.add(userRepository.findUserByUserId(followingUserId.get(i)));
		}
		return followingUser;
	}

	public List<String> getFollowingUserId(String id) {
		return followRepository.getFollowingUserId(id);
	}

	public List<User> getAllUser() {
		return userRepository.findAllUser();
	}
}
