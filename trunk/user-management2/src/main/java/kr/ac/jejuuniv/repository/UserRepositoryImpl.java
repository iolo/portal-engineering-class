package kr.ac.jejuuniv.repository;
import java.util.ArrayList;
import java.util.List;

import kr.ac.jejuuniv.model.User;

import org.springframework.stereotype.Repository;

@Repository
public class UserRepositoryImpl implements UserRepository {

	static public List<User> users;
	
	public UserRepositoryImpl() {
		users = new ArrayList<User>();
		users.add(new User("1", "aaa", "123"));
		users.add(new User("2", "bbb", "1234"));
		users.add(new User("3", "ccc", "1234"));
	}
	
	
	public List<User> findAll() {
		return users;
	}


	public void delete(String id) {
		User user = findById(id);
		users.remove(user);
	}


	public void insert(User user) {
		users.add(user);
	}


	public User findById(String id) {
		User user = null;
		for(int i=0; i<users.size(); i++){
			if(users.get(i).getId().equals(id)){
				return users.get(i);
			}
		}
		return user;
	}


	public void update(User modifiedUser) {
		User user = findById(modifiedUser.getId());
		user.setName(modifiedUser.getName());
		user.setPassword(modifiedUser.getPassword());
	}

}
