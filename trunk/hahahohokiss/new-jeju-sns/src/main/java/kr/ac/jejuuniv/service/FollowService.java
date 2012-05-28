package kr.ac.jejuuniv.service;

public interface FollowService {

	String registerFollowing(String followerId, String followingId);

	String registerFollower(String followingId, String followerId);


}
