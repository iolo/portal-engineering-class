package kr.ac.jejuuniv.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import kr.ac.jejuuniv.model.User;

@Repository
public class UserRepositoryImpl implements UserRepository {

	static List<User> users;
	
	public UserRepositoryImpl() {
		users = new ArrayList<User>();
		users.add(new User("1", "abc", "1234"));
	}
	
	public List<User> findAll() {
		return users;
	}

	public List<User> findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	public void insert(User user) {
		// TODO Auto-generated method stub

	}

	public void update(User user) {
		// TODO Auto-generated method stub

	}

	public void remove(String id) {
		// TODO Auto-generated method stub

	}

}
