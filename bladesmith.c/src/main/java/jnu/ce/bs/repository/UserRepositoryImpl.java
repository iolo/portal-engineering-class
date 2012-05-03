package jnu.ce.bs.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import jnu.ce.bs.service.User;
import jnu.ce.bs.service.UserServiceImpl;

@Repository
public class UserRepositoryImpl implements UserRepository {

	public static List<User> users;

	public UserRepositoryImpl() {
		users = new ArrayList<User>();
		users.add(new User("1", "강우진", "비번"));
		users.add(new User("2", "사람임", "비밀번"));
		users.add(new User("3", "우진님", "비번호"));
	}

	@Override
	public boolean indexedIdCheck(String id) {
		for (User user : users) {
			if (user.getId().equals(id))
				return false;
		}
		return true;
	}

	@Override
	public List<User> findAll() {
		return users;
	}

	@Override
	public User findById(String userId) {
		List<User> foundUser = new ArrayList<User>();

		for (User user : users) {
			if (user.getId().equals(userId))
				return user;
		}

		return null;
	}

	@Override
	public void deleteById(String userId) {
		List<User> deleteUserFound = new ArrayList<User>();

		for (User user : users) {
			if (user.getId().equals(userId))
				deleteUserFound.add(user);
		}
		users.removeAll(deleteUserFound);
	}

	@Override
	public void modifyById(String userId, String name, String password) {
		for (User user : users) {
			if (user.getId().equals(userId)) {
				user.setName(name);
				user.setPassword(password);
			}
		}
	}

	@Override
	public void createUesr(String userId, String name, String password) {
		users.add(new User(userId, name, password));
	}

}
