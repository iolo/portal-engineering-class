package jnu.ce.bs.repository;

import java.util.List;

import jnu.ce.bs.service.User;

public interface UserRepository {

	boolean indexedIdCheck(String id);

	List<User> findAll();

	List<User> findById(String userId);

	List<User> deleteById(String userId);

	List<User> modifyById(String userId, String name, String password);

	List<User> createUesr(String userId, String name, String password);
}
