package kr.ac.jejuuniv.mapper;

import java.util.List;

import kr.ac.jejuuniv.model.user.User;

public interface FollowingMapper {
	List<String> selectFollowingById(String id);

	void insertFollowing(String id, String targetId);

	int countFollowing(String id, String targetId);

	void deleteFollowing(String id, String targetId);

	List<User> selelcAllFollowing(String id);

	List<User> selectAllFollowerById(String id);
}
