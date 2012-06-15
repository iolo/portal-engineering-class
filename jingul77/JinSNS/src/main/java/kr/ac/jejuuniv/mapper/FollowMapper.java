package kr.ac.jejuuniv.mapper;


import java.util.List;
import java.util.Map;

import kr.ac.jejuuniv.model.FollowModel;
import kr.ac.jejuuniv.model.TotalUserModel;

import org.springframework.stereotype.Repository;

@Repository
public interface FollowMapper {
	
	List<TotalUserModel> TotalUser(String id);

	List<FollowModel> findFollow(String id);

	List<TotalUserModel> followerList(String id);

	List<TotalUserModel> followingList(String id);

	void addFollow(Map<String, String> addFollow);

	void deleteFollow(Map<String, String> addFollow);


}
