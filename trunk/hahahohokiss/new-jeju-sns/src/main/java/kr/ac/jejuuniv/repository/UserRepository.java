package kr.ac.jejuuniv.repository;

import kr.ac.jejuuniv.model.User;

public interface UserRepository {

	public User findUserByUserId(String id);

	public String findPasswordByUserId(String id);

	public User insert(User user);

}
