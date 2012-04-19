package kr.ac.jejuuniv.java.userservice;

import java.util.List;

import kr.ac.jejuuniv.java.User;
import kr.ac.jejuuniv.java.userrepository.UserRepository;

import org.springframework.stereotype.Component;

@Component
public class DefaultUserService implements UserService {
	private UserRepository repository;

	@Override
	public void add(User user) {
		User oldUser = repository.findUserById(user.getId());
		if (oldUser != null) {
			throw new UserExistException(user.getId() + " (이)가 이미 존재하고 있습니다");
		}

		repository.insertUser(user);
	}

	@Override
	public UserRepository getRepository() {
		return repository;
	}

	@Override
	public User getUser(String id) {
		User user = repository.findUserById(id);
		if (user == null) {
			throw new UserNotFoundException();
		}

		return user;
	}

	@Override
	public void remove(User user) {
		User target = repository.findUserById(user.getId());
		if (target == null) {
			throw new UserNotRemoveException(user.getId() + " 이(가) 존재하지 않습니다.");
		}

		repository.deleteUserById(user.getId());
	}

	@Override
	public void setRepository(UserRepository repository) {
		this.repository = repository;
	}

	@Override
	public void modify(User user) {
		User target = repository.findUserById(user.getId());
		if (target == null) {
			throw new ModifyNotUserExistException(user.getId()
					+ " 이(가) 존재하지 않습니다.");
		}

		repository.updateUser(user);
	}

	@Override
	public List<User> listUser() {
		List<User> users = repository.findAllUser();
		if (users == null || users.isEmpty()) {
			throw new UserEmptyException("사용자가 한명도 존재하지 않습니다. 사용자를 추가해주세요");
		}

		return users;
	}
}