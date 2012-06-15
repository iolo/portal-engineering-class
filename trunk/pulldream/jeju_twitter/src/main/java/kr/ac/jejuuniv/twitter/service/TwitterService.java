package kr.ac.jejuuniv.twitter.service;

import java.util.List;

import kr.ac.jejuuniv.twitter.model.FollowingModel;
import kr.ac.jejuuniv.twitter.model.FollowModel;
import kr.ac.jejuuniv.twitter.model.FollowingModel;
import kr.ac.jejuuniv.twitter.model.TwittModel;

public interface TwitterService {
	
	//자신의 글 쓰기
	void writeTwitt(TwittModel twittModel);
	//자신의 글 지우기
	void deleteMyTwitt(int twinum);
	
	//트윗리스트 가지고 옴...
	List<TwittModel> getTwittList(String id);
	//자신의 트윗리스트만 가지고옴.
	List<TwittModel> getMyTwittList(String id);

}
