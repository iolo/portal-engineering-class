package kr.ac.jejuuniv.twitter.repository;

import java.util.List;

import kr.ac.jejuuniv.twitter.model.FollowModel;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface FollowRepository {
	
	void unFollowingById(@Param("id")String id,@Param("following")String following);
	void addFollowingById(@Param("id")String id,@Param("following")String following);

	List<FollowModel> getFollowingById(String id);
	List<FollowModel> getAllFollower(String id);
	List<FollowModel> getFollowerById(String id);
	List<String> getFollowingList(String id);
}
