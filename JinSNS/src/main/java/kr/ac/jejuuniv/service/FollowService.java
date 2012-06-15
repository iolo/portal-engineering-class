package kr.ac.jejuuniv.service;

import java.util.List;

import kr.ac.jejuuniv.model.FollowModel;
import kr.ac.jejuuniv.model.TotalUserModel;

public interface FollowService {
	
	List<TotalUserModel> totalUser(String id);

	List<TotalUserModel> followerList(String id);

	List<TotalUserModel> followingList(String id);

	void follow(String id, String follow, String followid);
	
	public void setting(List<TotalUserModel> totalUser, List<FollowModel> follow);

}
