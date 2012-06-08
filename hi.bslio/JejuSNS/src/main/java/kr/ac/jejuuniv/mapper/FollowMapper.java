package kr.ac.jejuuniv.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface FollowMapper {
	public List<String> getFollower(String target);
	public List<String> getFollowing(String target);
	public void follow(@Param("target")String target, @Param("follower")String follower);
	public void unfollow(@Param("target")String target, @Param("follower")String follower);
}
