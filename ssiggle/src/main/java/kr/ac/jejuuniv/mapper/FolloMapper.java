package kr.ac.jejuuniv.mapper;

import java.util.List;

public interface FolloMapper {
	List<String> selectFollowById(String id);

	void insertFollow(String id, String targetId);
}
