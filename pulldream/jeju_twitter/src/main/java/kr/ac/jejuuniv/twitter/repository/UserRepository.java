package kr.ac.jejuuniv.twitter.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import kr.ac.jejuuniv.twitter.model.FollowModel;
import kr.ac.jejuuniv.twitter.model.TwittModel;
import kr.ac.jejuuniv.twitter.model.UserModel;

@Repository
public interface UserRepository {
	
	void addUser(UserModel user);
	void writeTwitt(TwittModel article);
	void deleteUser(String id);
	void updateUser(UserModel user);
	
	UserModel checkUser(UserModel user);
	UserModel findUserById(String id);
	
	List<FollowModel> getAllUser();
}
