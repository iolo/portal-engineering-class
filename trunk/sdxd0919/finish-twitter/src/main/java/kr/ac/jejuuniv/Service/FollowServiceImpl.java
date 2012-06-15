package kr.ac.jejuuniv.Service;

import java.util.ArrayList;
import java.util.List;

import kr.ac.jejuuniv.Model.Follow;
import kr.ac.jejuuniv.Model.User;
import kr.ac.jejuuniv.Repository.FollowRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FollowServiceImpl implements FollowService {
	
	@Autowired
	private FollowRepository followRepository;
	@Autowired
	private UserService userService;

	public FollowServiceImpl() {
	}
	
	public FollowServiceImpl(FollowRepository followRepository) {
		this.followRepository = followRepository;
	}

	public List<User> getFollowingUserNum(int userNum) {
		List<Integer> followingUserNumList = followRepository.getFollowingUserNumList(userNum); 
		List<User> followingUsers = new ArrayList<User>();
		
		for(int i=0; i<followingUserNumList.size(); i++){
			int num = followingUserNumList.get(i);
			followingUsers.add(userService.getUserByUserNum(num));
		}
		
		return followingUsers;
	}

	public List<User> getFollowerUserNum(int userNum) {
		List<Integer> followerUserNumList = followRepository.getFollowerUserNumList(userNum); 
		List<User> followerUsers = new ArrayList<User>();
		
		for(int i=0; i<followerUserNumList.size(); i++){
			int num = followerUserNumList.get(i);
			followerUsers.add(userService.getUserByUserNum(num));
		}
		
		return followerUsers;
	}

	public List<Follow> checkFollowerUsers(int userNum) {
		List<Integer> followingUserNumList = followRepository.getFollowingUserNumList(userNum); 
		List<Integer> followerUserNumList = followRepository.getFollowerUserNumList(userNum);
		
		List<Follow> followerLists = new ArrayList<Follow>();
		
		int k = 0; boolean flag;
		for(int i=0; i<followerUserNumList.size(); i++){
			int followerUserNum = followerUserNumList.get(i);
			flag = false;
			for(int j=k; j<followingUserNumList.size(); j++){
				int followingUserNum = followingUserNumList.get(j);
				
				if(followerUserNum == followingUserNum){
					flag = true;
					k++;
					break;
				}
			}
			if(flag == true){
				followerLists.add(new Follow(userService.getUserByUserNum(followerUserNum), true));
			}else{
				followerLists.add(new Follow(userService.getUserByUserNum(followerUserNum), false));
			}
		}
		
		return followerLists;
	}

	public void unfollowUser(int userNum, int followingUserNum) {
		followRepository.unfollow(userNum, followingUserNum);
	}

	public void followUser(int userNum, int followingUserNum) {
		followRepository.follow(userNum, followingUserNum);
	}

	public List<Follow> checkAllUsers(int userNum) {
		List<Integer> followingUserNumList = followRepository.getFollowingUserNumList(userNum); 
		List<User> allUsers = userService.getAllUser();
		
		List<Follow> allUserLists = new ArrayList<Follow>();
		int k = 0; boolean flag;
		for(int i=0; i<allUsers.size(); i++){
			int selectedUserNum = allUsers.get(i).getUserNum();
			
			flag = false;
			for(int j=k; j<followingUserNumList.size(); j++){
				int followingUserNum = followingUserNumList.get(j);
				
				if(selectedUserNum == followingUserNum){
					flag = true;
					k++;
					break;
				}
			}
			if(flag == true){
				allUserLists.add(new Follow(allUsers.get(i), true));
			}else{
				allUserLists.add(new Follow(allUsers.get(i), false));
			}
			
			if(userNum == selectedUserNum){
				allUserLists.remove(new Follow(allUsers.get(i), false));
			}
			
		}
		
		return allUserLists;
	}

}
