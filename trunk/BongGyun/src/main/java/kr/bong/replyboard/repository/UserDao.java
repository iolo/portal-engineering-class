package kr.bong.replyboard.repository;

import org.springframework.stereotype.Repository;

import kr.bong.replyboard.model.User;

@Repository
public interface UserDao {
	int insertUser(User user);

	int updateUser(User user);

	int deleteUser(String id);

	User selectUser(String id);
}
