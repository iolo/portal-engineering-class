package kr.ac.jejuuniv.repository;

import java.util.ArrayList;
import java.util.List;

import kr.ac.jejuuniv.model.User;

import org.springframework.stereotype.Repository;

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
		if (!userList.isEmpty() && index != -1) {
			throw new IdExistException("같은 아이디를 가지고 있는 User가 이미 존재하고 있습니다.");
		}

		userList.add(user);
	}

	@Override
	public void deleteUserById(String id) {
		int i = findIndex(id);

		if (i >= 0) {
			userList.remove(i);
		}else {
			throw new RowNotExistException();
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
		userList.set(index, user);
	}

	@Override
	public List<User> findAllUser() {
		return null;
	}
}
