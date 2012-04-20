package kr.ac.jejuuniv.repository;

import java.util.List;

import kr.ac.jejuuniv.service.User;

public interface UserRepository {

	public List<User> findAll();

	public User findById(String id);

	public void insert(User user);

	public void update(User user);

	public void delete(String id);

}
