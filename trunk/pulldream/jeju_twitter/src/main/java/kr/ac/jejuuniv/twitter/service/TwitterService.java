package kr.ac.jejuuniv.twitter.service;

import java.util.List;

import kr.ac.jejuuniv.twitter.model.FollowModel;
import kr.ac.jejuuniv.twitter.model.FollowingModel;
import kr.ac.jejuuniv.twitter.model.TwittModel;

public interface TwitterService {
	void writeTwitt(TwittModel twittModel);
	List<FollowingModel> getFollowingList(String id);
	List<TwittModel> getTwittList(String id);
}
