package kr.ac.jejuuniv.repository;

import kr.ac.jejuuniv.model.Follow;

public interface FollowRepository {

	Follow addFollowing(String followerUserId, String followingUserId);

	Follow addFollower(String followingId, String followerId);
}
