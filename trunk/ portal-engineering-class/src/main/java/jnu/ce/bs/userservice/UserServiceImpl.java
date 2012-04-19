package jnu.ce.bs.userservice;

import java.util.ArrayList;
import java.util.List;

public class UserServiceImpl implements UserService {

	private static List<User> users = new ArrayList<User>();
	UserRepository userRepository = new UserRepository();
	
	public List<User> findAll() {
		users = userRepository.List();
		
		return users;
	}

	public List<User> findById(String userId) {
		users = userRepository.List();
		List<User> foundUsers = new ArrayList<User>();

		for (User user : users) {
			if (user.getId().equals(userId))
				foundUsers.add(user);
		}

		return foundUsers;
	}

	public List<User> createUser(String id, String name, String password) {
		User user = new User();
		user.setId(id);
		user.setName(name);
		user.setPassword(password);

		users.add(user);

		return users;
	}

	public List<User> deleteByID(String userId) {
		users = userRepository.List();
		List<User> deleteUser = new ArrayList<User>();
		
		for (User user : users) {
			if (user.getId().equals(userId))
				deleteUser.add(user);
		}
		
		users.removeAll(deleteUser);
		
		return users;
	}

	public List<User> modifyUserById(String userId, String modifyName,
			String modifyPassword) {
		
		users = userRepository.List();
		
		for (User user : users) {
			if (user.getId().equals(userId)){
				user.setName(modifyName);
				user.setPassword(modifyPassword);
			}
		}
		
		return users;
	}

}
