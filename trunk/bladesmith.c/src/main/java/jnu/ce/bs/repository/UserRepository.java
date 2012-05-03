package jnu.ce.bs.repository;

import java.util.List;

import jnu.ce.bs.service.User;

public interface UserRepository {

	boolean indexedIdCheck(String id);

	List<User> findAll();

	User findById(String userId);

	void deleteById(String userId);

	void modifyById(String userId, String name, String password);

	void createUesr(String userId, String name, String password);
}
