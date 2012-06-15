package kr.ac.jejuuniv.twitter.service;

import java.util.List;

import kr.ac.jejuuniv.twitter.model.FollowModel;

public interface FollowService {
	//언팔로잉하기
	void unFollowingById(String id, String following);
	//팔로잉 등록
	void addFollowingById(String id,String following);
	
	//팔로워 리스트 가지고오기
	List<FollowModel> getFollowerList(String id);
	//팔로잉 리스트 가지고 오기
	List<FollowModel> getFollowingList(String id);
	//모든 사용자에 대한 정보 가지고 오기
	List<FollowModel> getAllUserList(String id);
}
