package kr.ac.jejuuniv;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class UserRepositoryImpl implements UserRepository {

	public static List<User> users;
	
	public UserRepositoryImpl() {
		users = new ArrayList<User>();
		//users.add(new User("0", "name", "password"));
	}
	
	public List<User> findAll() {

		return users;
	}

	//<<2>> insert와 delete 메소드 구현
	public void insert(String id, String name, String password) {
		users.add(new User(id, name, password));
	}

	public void delete(String id) {
/*		for(int i=0;i<users.size();i++) {
			if(users.get(i).getId().equals(id)) {
				users.remove(i);
				break;
			}			
		}*/
		
		users.remove(read(id));
	}

	// <<10>> read 메소드 구현
	public User read(String id) {
		for(int i=0;i<users.size();i++) {
			if(users.get(i).getId().equals(id)) {
				return users.get(i);
			}			
		}
		return null;
	}

	// <<15>> modify 메소드 구현
	public void modify(User user) {
		User modifyUser = read(user.getId());
		modifyUser.setName(user.getName());
		modifyUser.setPassword(user.getPassword());		
	}

}
