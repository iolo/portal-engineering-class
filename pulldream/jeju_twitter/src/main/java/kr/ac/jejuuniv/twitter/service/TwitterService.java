package kr.ac.jejuuniv.twitter.service;

import java.util.List;

import kr.ac.jejuuniv.twitter.model.FollowModel;
import kr.ac.jejuuniv.twitter.model.FollowingModel;
import kr.ac.jejuuniv.twitter.model.TwittModel;

public interface TwitterService {
	void writeTwitt(TwittModel twittModel);
	void deleteMyTwitt(int twinum);
	void unFollowingById(String id, String following);
	
	List<FollowingModel> getFollowingList(String id);
	List<TwittModel> getTwittList(String id);
	List<TwittModel> getMyTwittList(String id);
}
