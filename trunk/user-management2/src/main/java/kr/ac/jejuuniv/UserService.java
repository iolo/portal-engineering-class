package kr.ac.jejuuniv;

import java.util.List;

public interface UserService {

	List<User> list();

	void remove(String id);

	
}