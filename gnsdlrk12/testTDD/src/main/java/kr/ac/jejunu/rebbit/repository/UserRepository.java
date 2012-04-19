package kr.ac.jejunu.rebbit.repository;

import java.util.List;

import kr.ac.jejunu.rabbit.model.User;
public interface UserRepository {

	void insert(User user);

	void update(User user);	
	
	void delete(String id);
	
	User findById(String id);
	
	List<User> findAll();

}
