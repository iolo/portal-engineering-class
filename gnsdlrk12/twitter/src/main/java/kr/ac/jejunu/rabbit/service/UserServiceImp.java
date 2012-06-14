package kr.ac.jejunu.rabbit.service;

import java.util.List;

import kr.ac.jejunu.rabbit.mapper.UserMapper;
import kr.ac.jejunu.rabbit.model.AllFollow;
import kr.ac.jejunu.rabbit.model.AllFollowList;
import kr.ac.jejunu.rabbit.model.AllUser;
import kr.ac.jejunu.rabbit.model.AllUserList;
import kr.ac.jejunu.rabbit.model.Post;
import kr.ac.jejunu.rabbit.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImp implements UserService{
	User user;
	
	@Autowired
	UserMapper usermapper;
	
	@Override
	public void UserInsert(User user) {
		if (UserGet(user.getUserid()) == null){
			usermapper.UserInsert(user);
		}
		else
			usermapper.UserUpdate(user);
	}

	@Override
	public void UserDelete(String userid) {
		usermapper.UserDelete(userid);
	}

	@Override
	public User UserGet(String userid) {
		return usermapper.findById(userid);
	}

	@Override
	public List<User> followingList(String userid) {
		List<User> following = usermapper.followingUserAll(userid);
		return following;
	}

	@Override
	public List<Post> GetUserPost(String userid) {
		List<Post> posts = usermapper.findPostAll(userid);
		return posts;
	}

	@Override
	public void PostInsert(String postid, String content) {
		usermapper.PostInsert(postid, content);
		
	}

	@Override
	public void following(String userid, String followerid) {
		usermapper.followInsert(userid, followerid);
		
	}

	@Override
	public boolean Login(String userid, String password) {
		if(usermapper.Check(userid, password) != null){
			user = usermapper.Check(userid, password);
			return true;
			
		}
		else{
			return false;
		}
	}

	@Override
	public void postDelete(String postid, int post_num) {
		usermapper.postDelete(postid, post_num);
	}

	@Override
	public void UserModify(User user) {
		usermapper.UserUpdate(user);
		
	}

	@Override
	public void UserUnfollow(String userid, String followerid) {
		usermapper.UserUnfollow(userid, followerid);
	}

	@Override
	public List<User> followerList(String userid) {
		List<User> follower = usermapper.followerUserAll(userid);
		return follower;
	}

	@Override
	public List<AllUser> getAllUser(String userid) {
		List<AllUser> allUser = usermapper.getAllUser(userid);
		return allUser;
	}

	@Override
	public List<AllFollow> getAllFollow(String userid) {
		List<AllFollow> allFollow = usermapper.getAllFollow(userid);
		return allFollow;
	}
	
	@Override
	public List<AllFollow> setFollow(List<AllUser> allUsers, List<AllFollow> allFollows) {
		
		for (AllFollow allFollow : allFollows) {
			allFollow.setFollow("Follow");			
		}
		if (!allFollows.isEmpty()) {			
			for (AllUser alluser : allUsers) {
				for (AllFollow allFollow : allFollows) {					
					if (alluser.getFollowerid().equals(allFollow.getUserid())) {
						allFollow.setFollow("UnFollow");
					}
				}
			}
		}		
		return allFollows;
	}

	@Override
	public void userFollow(String userid, String followerid) {
		usermapper.userFollow(userid, followerid);
		
	}

	@Override
	public List<AllUserList> setAllFollow(List<AllUserList> allUserList, List<AllFollowList> allFollowList) {
		
		for (AllUserList allUserList2 : allUserList) {
			allUserList2.setState("Follow");			
		}
		
		if (!allFollowList.isEmpty()) {	
			
			for (AllUserList allUserList2 : allUserList) {
				
				for (AllFollowList allFollowUser : allFollowList) {	
					
					if (allUserList2.getUserid().equals(allFollowUser.getFollowerid())){
						allUserList2.setState("UnFollow");
					}
				}
			}
		}
		
		return allUserList;
	}

	@Override
	public List<AllUserList> getAllUserList(String userid) {
		List<AllUserList> allUser = usermapper.getAllUserList(userid);
		return allUser;
	}

	@Override
	public List<AllFollowList> getAllFollowList(String userid) {
		List<AllFollowList> allFollow = usermapper.getAllFollowList(userid);
		return allFollow;
	}

}
