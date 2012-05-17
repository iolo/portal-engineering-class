package kr.ac.jejuuniv.mapper;

import java.util.List;

import kr.ac.jejuuniv.model.User;

public interface UserMapper {

	List<User> findAll();

	List<User> findAllOrderByIdDesc();

	void addUser(User user);

	void deleteUser(String deleteUserId);

}
