package kr.ac.jejuuniv;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class UserRepositoryImpl implements UserRepository {

	public static List<User> users = new ArrayList<User>();
	
	public List<User> findAll() {
		users.add(new User("1", "이석준", "1234"));
		users.add(new User("2", "강동인", "4321"));
		return users;
	}

	@Override
	public void insert(User user) {
		users.add(user);
	}

	@Override
	public void delete(String id) {
		
		
	}

	@Override
	public User findById(String id) {
		// TODO Auto-generated method stub
		return (User) users;
	}

}

