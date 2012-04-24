package kr.ac.jejuuniv.service;

import java.util.List;

import kr.ac.jejuuniv.model.User;
import kr.ac.jejuuniv.repository.UserRepository;

public interface UserService {

	void setRepository(UserRepository repository);

	User getUser(String id);

	void save(User user);

	void remove(String id);

	List<User> listUser();
}
