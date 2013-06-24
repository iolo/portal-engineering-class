package kr.ac.hyosang.repository;

import org.springframework.stereotype.Repository;

import kr.ac.hyosang.model.User;

@Repository
public interface UserDao {
	int insertUser(User user);

	int updateUser(User user);

	int deleteUser(String userId);

	User selectUser(String userId);
}
