package kr.mg.comment.repository;


import org.springframework.stereotype.Repository;

import kr.mg.comment.model.User;

@Repository
public interface UserDao {
	
	int insertUser(User user);
	
	User getUser(String id);
	
}
