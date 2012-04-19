package kr.ac.jejuuniv.java.userservice;

import java.util.List;

import kr.ac.jejuuniv.java.User;
import kr.ac.jejuuniv.java.userrepository.UserRepository;

public interface UserService {

	UserRepository getRepository();

	void setRepository(UserRepository repository);

	User getUser(String id);

	void add(User user);

	void remove(User user);

	void modify(User user);

	List<User> listUser();
}
