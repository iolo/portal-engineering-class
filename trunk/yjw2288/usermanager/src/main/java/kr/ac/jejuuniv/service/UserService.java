package kr.ac.jejuuniv.service;

import java.util.List;

import kr.ac.jejuuniv.model.User;
import kr.ac.jejuuniv.repository.UserRepository;

public interface UserService {

	void setRepository(UserRepository repository);

	User getUser(String id);

	void add(User user);

	void remove(User user);

	void modify(User user);

	List<User> listUser();
}
