package kr.ac.jejuuniv.model.user;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface UserTransaction {
	@Transactional
	void save();

	@Transactional
	UserTransaction findUserById(String loginId);

	@Transactional(readOnly = true)
	List<User> findAllUser();

	@Transactional
	void followUserById(String targetId);

	@Transactional
	void unFollowUserById(String targetId);

	@Transactional
	List<User> followingUserList();

	@Transactional
	List<User> followUserList();
}
