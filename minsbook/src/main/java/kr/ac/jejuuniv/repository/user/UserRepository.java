package kr.ac.jejuuniv.repository.user;

import java.util.List;

import org.springframework.stereotype.Repository;

import kr.ac.jejuuniv.model.User;

public interface UserRepository {
		
	User findById(String id);
	
	List<User> findAll();
	
	void saveUser(User user);

}
