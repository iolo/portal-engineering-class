package kr.ac.jejunu.rabbit.service;

import java.util.List;

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
}
