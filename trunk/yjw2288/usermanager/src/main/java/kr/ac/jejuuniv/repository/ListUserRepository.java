package kr.ac.jejuuniv.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Repository;

import kr.ac.jejuuniv.model.User;

@Repository
public class ListUserRepository implements UserRepository {

	private List<User> userList = new ArrayList<>();

	@Override
	public User findUserById(String id) {
		for (User user : userList) {
			if (user.getId().equals(id)) {
				return user;
			}
		}

		return null;
	}

	@Override
	public void insertUser(User user) {
		int index = findIndex(user.getId());
		if (index <= userList.size() - 1 && index >= 0) {
			throw new DuplicateKeyException("같은 키를 가지는 User가 이미 존재하고 있습니다.");
		}

		userList.add(user);
	}

	@Override
	public void deleteUserById(String id) {
		int i = findIndex(id);

		if (i >= 0) {
			userList.remove(i);
		}
	}

	private int findIndex(String id) {
		for (int i = 0; i < userList.size(); i++) {
			if (userList.get(i).getId().equals(id)) {
				return i;
			}
		}
		return -1;
	}

	@Override
	public void updateUser(User user) {
		int index = findIndex(user.getId());

		User newUser = userList.get(index);
		newUser.setName(user.getName());
		newUser.setPassword(user.getPassword());
	}

	@Override
	public List<User> findAllUser() {
		return new ArrayList<>();
	}
}
