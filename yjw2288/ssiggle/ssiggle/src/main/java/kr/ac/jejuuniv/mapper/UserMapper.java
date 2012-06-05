package kr.ac.jejuuniv.mapper;

import java.util.List;

import kr.ac.jejuuniv.model.User;

public interface UserMapper {
	User selectUserById(String id);

	void updateUser(User user);

	void insertUser(User user);

	List<User> selectAllUser();
	
	void deleteUser(String id);
}
