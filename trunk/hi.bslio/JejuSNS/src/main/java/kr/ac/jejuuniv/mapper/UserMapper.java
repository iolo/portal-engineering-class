package kr.ac.jejuuniv.mapper;

import java.util.List;

import kr.ac.jejuuniv.model.UserModel;

public interface UserMapper {
	void insertUser(UserModel user);
	List<UserModel> findAll();
	UserModel findById(String id);
}
