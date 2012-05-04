package kr.ac.jejunu.rabbit.service;

import java.util.List;

import kr.ac.jejunu.rabbit.model.User;
import kr.ac.jejunu.rabbit.repository.UserRepository;

public interface UserService {
	public User get(String id);

	public void removeById(String Id);

	public void modifyUser(User user);
	
	public List<User> list();
	
	public void setUserRepository(UserRepository repository);

	public void addUser(String id, String name, String password);

	public User findById(String id);

	public void userModify(String id, String name, String password);

}
