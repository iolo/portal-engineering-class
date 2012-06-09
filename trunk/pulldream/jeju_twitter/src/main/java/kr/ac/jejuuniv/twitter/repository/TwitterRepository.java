package kr.ac.jejuuniv.twitter.repository;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import kr.ac.jejuuniv.twitter.model.FollowModel;
import kr.ac.jejuuniv.twitter.model.FollowingModel;
import kr.ac.jejuuniv.twitter.model.TwittModel;

@Repository
public interface TwitterRepository {
	void deleteTwitt(String artid);
	void writeTwitt(TwittModel articleModel);
	void addFollowing(FollowModel followModel);
	
	List<FollowingModel> getFollowingById(String id);
	List<FollowModel> getAllFollower(String id);
	List<TwittModel> getTwittListOderByDate(@Param("id")String id);
}
