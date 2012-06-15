package kr.ac.jejuuniv.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import kr.ac.jejuuniv.model.User;

public interface FollowMapper {
	List<User> checkFollow(String userId);
	List<User> selectFollowingUser(String userId);
	List<User> selectFollowerUser(String userId);
	int checkFollowing(@Param("userId") String userId, @Param("followId") String followId);
	void deleteFollowingUser(@Param("userId") String userId, @Param("followId") String followId);
	void insertFollowUser(@Param("userId") String userId, @Param("followId") String followId);

}
