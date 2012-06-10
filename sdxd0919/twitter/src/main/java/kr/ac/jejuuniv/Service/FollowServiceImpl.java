package kr.ac.jejuuniv.Service;

import java.util.ArrayList;
import java.util.List;

import kr.ac.jejuuniv.Model.Follow;
import kr.ac.jejuuniv.Model.User;
import kr.ac.jejuuniv.Repository.FollowRepository;

import org.springframework.beans.factory.annotation.Autowired;

public class FollowServiceImpl implements FollowService {

	private FollowRepository followRepository;
	
	private UserService userService;

	public FollowServiceImpl(FollowRepository followRepository) {
		this.followRepository = followRepository;
	}

	public List<User> getFollowingUserNum() {
		List<Integer> followingUserNumList = followRepository.getFollowingUserNumList(); 
		List<User> followingUsers = new ArrayList<User>();
		
		for(int i=0; i<followingUserNumList.size(); i++){
			int userNum = followingUserNumList.get(i);
			followingUsers.add(userService.getUser(userNum));
		}
		
		return followingUsers;
	}

	public List<User> getFollowerUserNum() {
		List<Integer> followerUserNumList = followRepository.getFollowingUserNumList(); 
		List<User> followerUsers = new ArrayList<User>();
		
		for(int i=0; i<followerUserNumList.size(); i++){
			int userNum = followerUserNumList.get(i);
			followerUsers.add(userService.getUser(userNum));
		}
		
		return followerUsers;
	}

	public List<Follow> checkFollowerUsers() {
		List<Integer> followingUserNumList = followRepository.getFollowingUserNumList(); 
		List<Integer> followerUserNumList = followRepository.getFollowingUserNumList();
		List<Follow> followerLists = new ArrayList<Follow>();
		
		int k = 0; 
		for(int i=0; i<followerUserNumList.size(); i++){
			int followerUserNum = followerUserNumList.get(i);
			boolean flag = false;
			for(int j=k; j<followingUserNumList.size(); j++){
				int followingUserNum = followingUserNumList.get(j);
				
				if(followerUserNum == followingUserNum){
					flag = true;
					k++;
				}
			}
			if(flag == true){
				followerLists.add(new Follow(userService.getUser(followerUserNum), true));
			}else{
				followerLists.add(new Follow(userService.getUser(followerUserNum), false));
			}
		}
		
		return followerLists;
	}

	public List<Follow> checkAllUsers() {
		return null;
	}
	
	
}
