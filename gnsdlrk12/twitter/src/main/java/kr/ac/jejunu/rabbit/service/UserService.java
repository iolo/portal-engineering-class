package kr.ac.jejunu.rabbit.service;

import java.util.List;

import kr.ac.jejunu.rabbit.model.Post;
import kr.ac.jejunu.rabbit.model.User;

public interface UserService {
	
	void insert(User user);
	
	void delete(String userid);
	
	User get(String userid);
	
	List<User> UserList();

	List<Post> GetUserPost(String loginid);
}
