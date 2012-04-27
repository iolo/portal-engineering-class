package jnu.ce.bs.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import jnu.ce.bs.service.User;

@Repository
public class UserRepositoryImpl implements UserRepository{

	@Override
	public boolean indexedIdCheck(String id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<User> findAll() {
		List<User> users = new ArrayList<User>();
		User user = new User();
		user.setId("1");
		user.setName("강우진");
		user.setPassword("password");
		users.add(user);
		
		return users;
	}

	@Override
	public List<User> findById(String userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> deleteById(String userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> modifyById(String userId, String name, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> createUesr(String userId, String name, String password) {
		// TODO Auto-generated method stub
		return null;
	}

}
