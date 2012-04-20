package kr.ac.jejunu.kdi.service;

import java.util.List;

import kr.ac.jejunu.kdi.model.User;
import kr.ac.jejunu.kdi.repository.UserRepository;

public interface UserService {
	public User get(String id);

	public void romoveById(String id);

	public void addUser(User user);

	public void modifyUser(User user);

	public List<User> findAll();

	public void setUserRepository(UserRepository repository);
}
