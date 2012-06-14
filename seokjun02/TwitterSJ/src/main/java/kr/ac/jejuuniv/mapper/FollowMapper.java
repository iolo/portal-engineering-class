package kr.ac.jejuuniv.mapper;

import java.util.List;

import kr.ac.jejuuniv.model.User;

public interface FollowMapper {
	List<String> checkFollow(String userId);
	List<User> selectFollowingUser(String userId);
	List<User> selectFollowerUser(String userId);

}
