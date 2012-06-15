package kr.ac.jejuuniv.twitter.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.jejuuniv.twitter.model.FollowModel;
import kr.ac.jejuuniv.twitter.repository.FollowRepository;
import kr.ac.jejuuniv.twitter.repository.TwitterRepository;
import kr.ac.jejuuniv.twitter.repository.UserRepository;
import kr.ac.jejuuniv.twitter.service.FollowService;

@Service
public class FollowServiceImpl implements FollowService{

	@Autowired
	private FollowRepository followRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	
	
	public List<FollowModel> getFollowingList(String id){
		return followRepository.getFollowingById(id);
	}

	public void unFollowingById(String id, String following) {
		followRepository.unFollowingById(id, following);
	}

	public void addFollowingById(String id, String following) {
		followRepository.addFollowingById(id, following);
	}
	
	public List<FollowModel> getFollowerList(String id) {
		
		List<String> getFollowingList = followRepository.getFollowingList(id);
		List<FollowModel> follower = new ArrayList<FollowModel>();
		
		//가지고 온 데이터를 리스트에 담으면서 팔로를 한 사람과 자신의 정보와 비료를 해서 그 정보에 대한 참 값을 넣고 판단을 함
		//만약 거짓을 경우 넣지 않으며, 참일 경우 모델에 설정을 해준다.
		for (FollowModel followerModel : followRepository.getFollowerById(id)) {
			if(getFollowingList.contains(followerModel.getId())){
				followerModel.setFollowing(true);
			}else followerModel.setFollowing(false);
			follower.add(followerModel);
		}
		return follower;
	}

	public List<FollowModel> getAllUserList(String id) {
		
		List<FollowModel> getAllUser = userRepository.getAllUser();
		List<FollowModel> allFollower = new ArrayList<FollowModel>();
		List<String> getFollowingList = followRepository.getFollowingList(id);
		
		for (FollowModel followModel : getAllUser) {
			if(getFollowingList.contains(followModel.getId())){
				followModel.setFollowing(true);
			}else followModel.setFollowing(false);
			allFollower.add(followModel);
		}
		return allFollower;
	}	

}
