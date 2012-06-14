package kr.ac.jejunu.rabbit.service;

import java.util.List;

import kr.ac.jejunu.rabbit.model.AllFollow;
import kr.ac.jejunu.rabbit.model.AllFollowList;
import kr.ac.jejunu.rabbit.model.AllUser;
import kr.ac.jejunu.rabbit.model.AllUserList;
import kr.ac.jejunu.rabbit.model.Post;
import kr.ac.jejunu.rabbit.model.User;

public interface UserService {
	
	void UserInsert(User user);
	
	void UserDelete(String userid);
	
	User UserGet(String userid);
	
	List<User> followingList(String userid);

	List<Post> GetUserPost(String loginid);

	void PostInsert(String postid, String content);
	
	void postDelete(String postid, int post_num);
	
	void following(String userid, String followerid);

	boolean Login(String userid, String password);

	void UserModify(User user);
	
	void UserUnfollow(String userid, String followerid);

	List<User> followerList(String userid);
	
	List<AllUser> getAllUser(String userid);
	
	List<AllFollow> getAllFollow(String userid);

	List<AllFollow> setFollow(List<AllUser> allUsers, List<AllFollow> allFollows);

	void userFollow(String userid, String followerid);

	List<AllUserList> setAllFollow(List<AllUserList> allUserList, List<AllFollowList> allFollowList);

	List<AllUserList> getAllUserList(String userid);

	List<AllFollowList> getAllFollowList(String userid);

}
