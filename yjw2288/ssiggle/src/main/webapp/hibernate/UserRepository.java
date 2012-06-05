package kr.ac.jejuuniv.repository;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import kr.ac.jejuuniv.model.User;

//TODO : 물어보기 Repository? Dao?
@Transactional
public interface UserRepository {
	@Transactional(readOnly = true)
	User selectUserById(String id);

	@Transactional
	void updateUser(User user);

	@Transactional
	void insertUser(User user);

	@Transactional(readOnly = true)
	List<User> selectAllUser();
}
