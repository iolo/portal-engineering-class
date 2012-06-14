package kr.ac.jejuuniv.twitter.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.jejuuniv.twitter.model.FollowModel;
import kr.ac.jejuuniv.twitter.model.FollowModel;
import kr.ac.jejuuniv.twitter.model.TwittModel;
import kr.ac.jejuuniv.twitter.model.UserModel;
import kr.ac.jejuuniv.twitter.repository.TwitterRepository;
import kr.ac.jejuuniv.twitter.repository.UserRepository;
import kr.ac.jejuuniv.twitter.service.TwitterService;

@Service
public class TwitterServiceImpl implements TwitterService{

	@Autowired
	private TwitterRepository twitterRepoistory;
	
	@Autowired
	private UserRepository userRepository;
	
	public void writeTwitt(TwittModel twittModel) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
		twittModel.setWrite_date(dateFormat.format(new Date()));
		twitterRepoistory.writeTwitt(twittModel);
	}
	
	public void deleteMyTwitt(int twinum) {
		twitterRepoistory.deleteMyTwitt(twinum);
	}
	
	public List<FollowModel> getFollowingList(String id){
		return twitterRepoistory.getFollowingById(id);
	}


	public List<TwittModel> getTwittList(String id) {
		return twitterRepoistory.getTwittListOderByDate(id);
	}


	public List<TwittModel> getMyTwittList(String id) {
		return twitterRepoistory.getMyTwittOrderByDate(id);
	}

	public void unFollowingById(String id, String following) {
		twitterRepoistory.unFollowingById(id, following);
	}

	public void addFollowingById(String id, String following) {
		twitterRepoistory.addFollowingById(id, following);
	}
	
	public List<FollowModel> getFollowerList(String id) {
		
		List<String> getFollowingList = twitterRepoistory.getFollowingList(id);
		List<FollowModel> follower = new ArrayList<FollowModel>();
		
		for (FollowModel followerModel : twitterRepoistory.getFollowerById(id)) {
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
		List<String> getFollowingList = twitterRepoistory.getFollowingList(id);
		
		for (FollowModel followModel : getAllUser) {
			if(getFollowingList.contains(followModel.getId())){
				followModel.setFollowing(true);
			}else followModel.setFollowing(false);
			allFollower.add(followModel);
		}
		return allFollower;
	}
	
}
