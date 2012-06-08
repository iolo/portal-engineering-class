package kr.ac.jejuuniv.mapper;

import java.util.List;

public interface FollowMapper {
	public List<String> getFollower(String target);
	public List<String> getFollowing(String target);
	public void follow(String target, String follower);
	public void unfollow(String target, String follower);
}
