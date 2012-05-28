package kr.ac.jejuuniv.service.impl;

import kr.ac.jejuuniv.model.Follow;
import kr.ac.jejuuniv.repository.FollowRepository;
import kr.ac.jejuuniv.service.FollowService;

public class FollowServiceImpl implements FollowService {
	
	private FollowRepository followRepository;
	
	public FollowServiceImpl() {

	}
	
	public FollowServiceImpl(FollowRepository followRepository) {
		this.followRepository = followRepository;
	}
	

	public String registerFollowing(String followerId, String followingId) {
		Follow follow = followRepository.addFollowing(followerId, followingId);
		return follow.getFollowingUserId();
	}

	public String registerFollower(String followingId, String followerId) {
		Follow follow = followRepository.addFollower(followingId, followerId);
		return follow.getFollowerUserId();
	}

}
