package kr.ac.jejuuniv.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.jejuuniv.mapper.FollowMapper;
import kr.ac.jejuuniv.model.TotalUserModel;

@Service
public class FollowServiceImpl implements FollowService{

	@Autowired
	FollowMapper followMapper;
	
	@Override
	public List<TotalUserModel> getList(String id) {
		
		List<TotalUserModel> totalUser=followMapper.follower(id);
		List<TotalUserModel> followAll=followMapper.followAll(id);
		
		return null;
	}



	
}
