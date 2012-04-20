package kr.ac.jejunu.xespri.service;

import java.util.List;

import kr.ac.jejunu.xespri.model.User;
import kr.ac.jejunu.xespri.repository.UserRepository;


public interface UserService {
	public User get(String id);

	public void removeById(String id);

	public void addUser(User user);

	public void modifyUser(User user);

	public List<User> listUser();
	
	public void setRepository(UserRepository repository);
}
