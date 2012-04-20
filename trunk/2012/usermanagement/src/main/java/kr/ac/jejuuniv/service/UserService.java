package kr.ac.jejuuniv.service;

import java.util.List;

public interface UserService {

	public List<User> list();

	public User get(String id);

	public void save(User user);
	
	public void delete(String string);

	
}
