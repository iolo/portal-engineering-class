package kr.ac.jejuuniv.twitter.repository;

import java.util.List;

import kr.ac.jejuuniv.twitter.model.FollowModel;
import kr.ac.jejuuniv.twitter.model.TwittModel;

public interface TwitterRepository {
	void deleteTwitt(String artid);
	void writeTwitt(TwittModel articleModel);
	void addFollowing(FollowModel followModel);
	
	List<FollowModel> getAllFollower(String followerId);
}
