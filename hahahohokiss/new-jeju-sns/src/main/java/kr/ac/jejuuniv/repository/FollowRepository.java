package kr.ac.jejuuniv.repository;

import java.util.List;

import kr.ac.jejuuniv.model.Follow;

public interface FollowRepository {

	Follow addFollowing(String followerUserId, String followingUserId);

	Follow addFollower(String followingId, String followerId);

	List<String> getFollowerId(String id);

	List<String> getFollowingUserId(String id);
}
