package kr.ac.jejunu.rabbit.service;

import java.util.List;

import kr.ac.jejunu.rabbit.model.User;
import kr.ac.jejunu.rabbit.repository.UserRepository;

public interface UserService {
	public User get(String id);

	public void removeById(String Id);

	public void addUser(User user);

	public void modifyUser(User user);
	
	public List<User> list();
	
	public void setUserRepository(UserRepository repository);

}
