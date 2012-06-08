package kr.ac.jejunu.rabbit.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import kr.ac.jejunu.rabbit.model.Post;
import kr.ac.jejunu.rabbit.model.User;

@Repository
public interface UserMapper {
	
	void UserInsert(User user);
	
	void UserUpdate(User user);
	
	void UserDelete(String userid);

	User findById(String userid);
	
	List<User> findUserAll();
	
	List<Post> findPostAll(String userid);

	void PostInsert(String userid, String content);

	User Check(User user);

	void Follow(String userid, String followerid);
	
}
