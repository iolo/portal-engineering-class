package kr.mg.comment.repository;

import java.util.List;

import kr.mg.comment.model.User;

public interface UserDao {
	
	int insertUser(User user);
	
	User getUser(String id);
	
	List<User> getList(String string);
}
