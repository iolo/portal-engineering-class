package kr.ac.jejuuniv.service;

import java.util.List;

import kr.ac.jejuuniv.mapper.FollowMapper;
import kr.ac.jejuuniv.mapper.TwitMapper;
import kr.ac.jejuuniv.model.TwitModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FollowService {

	@Autowired
	private FollowMapper followMapper;
	
	public List<String> getFollower(String target) {
		return followMapper.getFollower(target);		
	}
	
	public List<String> getFollowing(String target){
		return followMapper.getFollowing(target);
	}
	
	public void follow(String target, String follower){
		followMapper.follow(target, follower);
	}
	
	public void unfollow(String target, String follower) {
		followMapper.unfollow(target, follower);
	}
	
}
