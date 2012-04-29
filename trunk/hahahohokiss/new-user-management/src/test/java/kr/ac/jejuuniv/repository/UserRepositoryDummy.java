package kr.ac.jejuuniv.repository;

import java.util.ArrayList;
import java.util.List;

import kr.ac.jejuuniv.model.User;

public class UserRepositoryDummy implements UserRepository {
	
	private List<User> users = new ArrayList<User>();
	
	public UserRepositoryDummy(){
		User user = new User();
		
		users.add(user);
	}

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return users;
	}

	@Override
	public User findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User insert(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User update(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub

	}

}
