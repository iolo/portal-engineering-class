package kr.juntheater.repository;

import java.util.List;

import kr.juntheater.model.User;

public interface UserRepository {

	List<User> findAll();
	public void insert(String id, String name, String password);
	public void delete(String id);
	public User read(String id);
	public void modify(User user);
}
