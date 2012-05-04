package kr.ac.jejuuniv;

import java.util.List;

public interface UserService {
	List<User> list();
	User get(String id);
	void remove(String id);
	void save(User user);
}
