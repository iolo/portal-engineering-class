package kr.ac.jejuuniv.repository.user;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Repository;

import kr.ac.jejuuniv.model.User;
import kr.ac.jejuuniv.repository.exception.UserNotFoundException;

@Repository
public class UserRepositoryHashMapImpl implements UserRepository {

	HashMap<String, User> users = new HashMap<String, User>();

	@Override
	public User findById(String id) {
		User user = users.get(id);
		if (user == null)
			throw new UserNotFoundException(id);
		else
			return user;
	}

	@Override
	public List<User> findAll() {
		ArrayList<User> foundUsers = new ArrayList<User>();
		for (String userId : users.keySet()) {
			foundUsers.add(users.get(userId));
		}

		return foundUsers;
	}

	@Override
	public void saveUser(User user) {
		users.put(user.getId(), user);
	}

}
