package kr.ac.jejuuniv;

import java.util.ArrayList;
import java.util.List;


import org.springframework.stereotype.Repository;

@Repository
public class UserRepositoryImplement implements UserRepository {
	public static List<User> users;

	public UserRepositoryImplement() {
		users = new ArrayList<User>();
		users.add(new User("1", "허윤호", "1234"));
		users.add(new User("2", "유대은", "1234"));

	}

	@Override
	public List<User> findAll() {
		return users;
	}

	@Override
	public void deleteUser(String id) {
		for(int index=0; index < users.size(); index++) {
			if(users.get(index).getId().equals(id)) {
				users.remove(index);
			}
		}
	}

	@Override
	public void createUser(String id, String name, String password) {
		users.add(new User(id, name, password));
	}

	@Override
	public User findById(String id) {
		int temp = 0;
		for(int index=0; index < users.size(); index++) {
			if(users.get(index).getId().equals(id)) {
				temp = index;
			}
		}
		
		return users.get(temp);
	}

	@Override
	public void modifyUser(String id, String name, String password) {
		for(int index=0; index < users.size(); index++) {
			if(users.get(index).getId().equals(id)) {
				users.get(index).setId(id);
				users.get(index).setName(name);
				users.get(index).setPassword(password);
			}
		}
		
	}

}
