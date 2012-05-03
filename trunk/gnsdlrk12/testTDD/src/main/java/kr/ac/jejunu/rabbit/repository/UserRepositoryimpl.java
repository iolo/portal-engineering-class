package kr.ac.jejunu.rabbit.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import kr.ac.jejunu.rabbit.model.User;

@Repository
public class UserRepositoryimpl implements UserRepository {

	@Override
	public void insert(User user) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(User user) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub

	}

	@Override
	public User findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> findAll() {
		List<User> users = new ArrayList<User>();
		User user = new User("1", "가나다라마바사", "1233");
		
		users.add(user);
		
		return users;
	}

}
