package kr.ac.jejunu.rabbit.repository;

import java.util.List;

import kr.ac.jejunu.rabbit.model.Post;
import kr.ac.jejunu.rabbit.model.User;

import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository {
	
	void insert(User user);
	
	void update(User user);
	
	void delete(String userid);

	User findById(String userid);
	
	List<User> findUserAll();
	
	List<Post> findPostAll(String userid);
	
}
