package kr.ac.jejunu.rabbit.repository;

import kr.ac.jejunu.rabbit.model.User;

import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository {
	
	void insert(User user);
	
	void update(User user);
	
	void delete(String userid);

	User findById(String userid);
	
}
