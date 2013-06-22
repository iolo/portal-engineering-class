package kr.mg.comment.repository;


import kr.mg.comment.model.User;

import org.springframework.stereotype.Repository;

@Repository
public interface UserDao {
	
	int insertUser(User user);
	
	User getUser(String id);
	
}
