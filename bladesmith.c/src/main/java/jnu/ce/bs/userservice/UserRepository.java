package jnu.ce.bs.userservice;

import java.util.List;

public interface UserRepository {

	boolean indexedIdCheck(String id);

	List<User> findAll();

	List<User> findById(String userId);

	List<User> deleteById(String userId);

	List<User> modifyById(String userId, String name, String password);

	List<User> createUesr(String userId, String name, String password);
}
