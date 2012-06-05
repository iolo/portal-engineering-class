package kr.ac.jejuuniv.mapper;

import org.apache.ibatis.annotations.Param;

public interface FollowingMapper {
	void insertFollowing(@Param("id") String id,
			@Param("targetId") String targetId);

	int countFollowing(@Param("id") String id,
			@Param("targetId") String targetId);

	void deleteFollowing(@Param("id") String id,
			@Param("targetId") String targetId);
}
