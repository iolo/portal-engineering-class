package kr.ac.jejunu.rabbit.service;

import java.util.List;

import kr.ac.jejunu.rabbit.model.Post;
import kr.ac.jejunu.rabbit.model.User;

public interface UserService {
	
	void UserInsert(User user);
	
	void UserDelete(String userid);
	
	User UserGet(String userid);
	
	List<User> UserList();

	List<Post> GetUserPost(String loginid);

	void PostInsert(String userid, String content);
	
	void following(String userid, String followerid);

	boolean Login(String userid, String password);
}
