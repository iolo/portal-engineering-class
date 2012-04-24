package kr.ac.jejuuniv.service;

import java.util.List;

import kr.ac.jejuuniv.model.User;
import kr.ac.jejuuniv.repository.UserRepository;

public interface UserService {

	void setRepository(UserRepository repository);

	User getUser(String id);

	//TODO :(나중에하기) modify에서 하는 일을 save에서 할 수 있도록 만든다.
	void save(User user);

	void remove(User user);

	List<User> listUser();
}
