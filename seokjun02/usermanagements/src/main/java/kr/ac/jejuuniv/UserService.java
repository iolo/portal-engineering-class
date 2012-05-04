package kr.ac.jejuuniv;

import java.util.List;

public interface UserService {

	List<User> list();
	User get(String id);
	void create(User user);
	void remove(String id);

	

}
