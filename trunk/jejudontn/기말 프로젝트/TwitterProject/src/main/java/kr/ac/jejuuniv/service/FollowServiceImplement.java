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
	
	@Autowired
	ServiceUtility serviceUtility;

	@Override
	public List<AllUsers> getFollower(String id) {
		List<AllUsers> allUsers = userMapper.getFollower(id);
		List<AllFollow> allFollows = userMapper.findAllFollow(id);
		
		serviceUtility.setFollow(allUsers, allFollows);
		
		return allUsers;
	}
	
	

	@Override
	public List<AllUsers> getFollowing(String id) {
		List<AllUsers> allUsers = userMapper.getFollowing(id);
		List<AllFollow> allFollows = userMapper.findAllFollow(id);
				
		serviceUtility.setFollow(allUsers, allFollows);
		
		return allUsers;		
	}

}
