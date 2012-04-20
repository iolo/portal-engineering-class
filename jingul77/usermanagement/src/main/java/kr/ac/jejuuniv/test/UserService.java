package kr.ac.jejuuniv.test;

import java.util.List;

public interface UserService {

	public User get(String id);

	public void removeById(String Id);

	public void addUser(User user);

	public void modifyUser(User user);
	
	public List<User> findAll();
	
	public void setUserRepository(UserRepository repository);
}
