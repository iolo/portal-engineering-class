package kr.ac.jejuuniv;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class UserRepositoryImpl implements UserRepository {

	private List<User> users = new ArrayList<User>();

	public UserRepositoryImpl() {
		super();
		users.add(new User("1", "이석준", "1234"));
		users.add(new User("2", "강동인", "4321"));
	}

	public List<User> findAll() {
		return users;
	}

	public void insert(User user) {
		users.add(user);
	}

	public void delete(String id) {

	}

	public User findById(String id) {
		for (User user : users) {
			if(user.getId().equals(id))
				return user;			
		}
		throw new UserNotFoundExcpetion(id);
	}

	public void update(User user) {

	}

}
