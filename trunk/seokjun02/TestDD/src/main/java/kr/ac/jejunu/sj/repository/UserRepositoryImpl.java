package kr.ac.jejunu.sj.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import kr.ac.jejunu.sj.model.User;

@Repository
public class UserRepositoryImpl implements UserRepository {
	
	@Override
	public List<User> findAll() {
		List<User> users = new ArrayList<User>();
		User user = new User();
		user.setId("1");
		user.setName("가나다라마바사");
		user.setPassword("1233");
		
		users.add(user);
		
		return users;
	}

	@Override
	public User findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

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

}
