package kr.ac.jejuuniv.test;

import java.util.List;


public interface UserService {
	
	List<User> list();

	public User get(String id);

	public void removeById(String id);

	public void addUser(User user);
	
	public void addUser(String id, String name, String password);

	public void modifyUser(String id, String name, String password);
	
	public List<User> findAll();
	
	public void setUserRepository(UserRepository repository);	
}
