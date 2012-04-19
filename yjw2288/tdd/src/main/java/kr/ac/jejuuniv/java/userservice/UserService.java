package kr.ac.jejuuniv.java.userservice;

import java.util.List;

import kr.ac.jejuuniv.java.User;
import kr.ac.jejuuniv.java.userrepository.UserRepository;

public interface UserService {

	UserRepository getRepository();

	void setRepository(UserRepository repository);

	User getUser(String id);

	void addUser(User user);

	void removeUser(User user);

	void modifyUser(User user);

	List<User> listUser();
}
