package kr.ac.jejuuniv.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.jejuuniv.mapper.FollowMapper;
import kr.ac.jejuuniv.model.FollowModel;
import kr.ac.jejuuniv.model.TotalUserModel;

@Service
public class FollowServiceImpl implements FollowService{

	@Autowired
	FollowMapper followMapper;
	
	@Override
	public List<TotalUserModel> followingList(String id) {
		
		List<TotalUserModel> totalUsers=followMapper.followingList(id);
		List<FollowModel> follows=followMapper.findFollow(id);

		this.setting(totalUsers, follows);
		
		return totalUsers;
	}
	

	@Override
	public List<TotalUserModel> followerList(String id) {
		
		
		List<TotalUserModel> totalUsers=followMapper.followerList(id);
		List<FollowModel> follows=followMapper.findFollow(id);

		this.setting(totalUsers, follows);
		
		return totalUsers;
	}
	
	
	@Override
	public List<TotalUserModel> totalUser(String id) {
		
		List<TotalUserModel> totalUsers=followMapper.TotalUser(id);
		List<FollowModel> follows=followMapper.findFollow(id);

		this.setting(totalUsers, follows);
		
		return totalUsers;
	}


	
	//아래 메소드는 도움받아서 작성하였음.... 
	@Override
	public void follow(String id, String follow, String followid) {
		
		Map<String, String> addFollow = new HashMap<String, String>();
		addFollow.put("userId", id);
		addFollow.put("followId", followid);
		
		if (follow.equals("Follow")) {
			followMapper.addFollow(addFollow);
		} else {
			followMapper.deleteFollow(addFollow);
		}
		
	}
	
	@Override
	public void setting(List<TotalUserModel> totalUsers, List<FollowModel> follows) {

		for (TotalUserModel totalUser : totalUsers) {
			totalUser.setFollow("Follow");
			
		}
		if (!follows.isEmpty()) {
			for (TotalUserModel totalUser : totalUsers) {
				for (FollowModel allFollower : follows) {
					if (totalUser.getId().equals(allFollower.getFollow())) {
						totalUser.setFollow("UnFollow");
					}
				}
			}
		}

	}



}
