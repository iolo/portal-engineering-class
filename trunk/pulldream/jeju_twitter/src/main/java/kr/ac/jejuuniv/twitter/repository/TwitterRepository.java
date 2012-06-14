package kr.ac.jejuuniv.twitter.repository;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import kr.ac.jejuuniv.twitter.model.FollowingModel;
import kr.ac.jejuuniv.twitter.model.FollowModel;
import kr.ac.jejuuniv.twitter.model.FollowingModel;
import kr.ac.jejuuniv.twitter.model.TwittModel;
import kr.ac.jejuuniv.twitter.model.UserModel;

@Repository
public interface TwitterRepository {
	void deleteMyTwitt(int twitnum);
	void writeTwitt(TwittModel articleModel);
	void unFollowingById(@Param("id")String id,@Param("following")String following);
	void addFollowingById(@Param("id")String id,@Param("following")String following);
	
	List<FollowModel> getFollowingById(String id);
	List<FollowModel> getAllFollower(String id);
	List<TwittModel> getTwittListOderByDate(@Param("id")String id);
	List<TwittModel> getMyTwittOrderByDate(String id);
	List<FollowModel> getFollowerById(String id);
	List<String> getFollowingList(String id);
}
