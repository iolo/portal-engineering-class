package kr.ac.jejuuniv.mapper;

import java.util.List;

public interface FolloMapper {
	List<String> selectFollowById(String id);

	void insertFollow(String id, String targetId);

	int countFollowing(String id, String targetId);

	void deleteFollowing(String id, String targetId);
}
