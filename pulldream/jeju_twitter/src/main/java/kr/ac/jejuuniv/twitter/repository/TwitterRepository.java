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

	List<TwittModel> getTwittListOderByDate(@Param("id")String id);
	List<TwittModel> getMyTwittOrderByDate(String id);
}
