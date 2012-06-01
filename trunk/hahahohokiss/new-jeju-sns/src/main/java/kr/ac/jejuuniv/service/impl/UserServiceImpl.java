package kr.ac.jejuuniv.service.impl;

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
		// TODO Auto-generated method stub
		return null;
	}

	public List<String> getFollowersId(String id) {
		return followRepository.getFollowerId(id);
	}
}
