package kr.ac.jejuuniv.mapper;

import java.util.List;

import kr.ac.jejuuniv.model.UserModel;

public interface UserMapper {
	void insertUser(UserModel user);
	List<UserModel> findAll(String id);
	UserModel findById(String id);
	void updateUser(UserModel user);
	List<UserModel> findFollowing(String id);
	List<UserModel> findFollower(String id);
}
