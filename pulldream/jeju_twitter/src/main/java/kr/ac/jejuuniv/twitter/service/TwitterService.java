package kr.ac.jejuuniv.twitter.service;

import java.util.List;

import kr.ac.jejuuniv.twitter.model.FollowingModel;
import kr.ac.jejuuniv.twitter.model.FollowModel;
import kr.ac.jejuuniv.twitter.model.FollowingModel;
import kr.ac.jejuuniv.twitter.model.TwittModel;

public interface TwitterService {
	void writeTwitt(TwittModel twittModel);
	void deleteMyTwitt(int twinum);
	void unFollowingById(String id, String following);
	void addFollowingById(String id,String following);
	
	List<FollowModel> getFollowingList(String id);
	List<TwittModel> getTwittList(String id);
	List<TwittModel> getMyTwittList(String id);
	List<FollowModel> getFollowerList(String id);
	
	List<FollowModel> getAllUserList(String id);
}
