package kr.ac.jejuuniv.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.jejuuniv.model.AllFollow;
import kr.ac.jejuuniv.model.AllUsers;
import kr.ac.jejuuniv.repository.UserMapper;

@Service
public class FollowServiceImplement implements FollowService {
	
	@Autowired
	UserMapper userMapper;

	@Override
	public List<AllUsers> getFollower(String id) {
		List<AllUsers> allUsers = userMapper.getFollower(id);
		List<AllFollow> allFollows;
		allFollows = userMapper.findAllFollow(id);
		
		for (AllUsers alluser : allUsers) {
			alluser.setFollow("Follow");	
		}
		if (!allFollows.isEmpty()) {
			for (AllUsers alluser : allUsers) {
				for (AllFollow allFollower : allFollows) {
					if (alluser.getId().equals(allFollower.getFollowing())) {
						alluser.setFollow("UnFollow");
					}
				}
			}
		}
		
		return allUsers;
	}

	@Override
	public List<AllUsers> getFollowing(String id) {
		List<AllUsers> allUsers = userMapper.getFollowing(id);
		List<AllFollow> allFollows;
		
		allFollows = userMapper.findAllFollow(id);
		for (AllUsers alluser : allUsers) {
			alluser.setFollow("Follow");
		}
		if (!allFollows.isEmpty()) {
			for (AllUsers alluser : allUsers) {
				for (AllFollow allFollower : allFollows) {
					if (alluser.getId().equals(allFollower.getFollowing())) {
						alluser.setFollow("UnFollow");
					}
				}
			}
		}
		
		return allUsers;		
	}

}
