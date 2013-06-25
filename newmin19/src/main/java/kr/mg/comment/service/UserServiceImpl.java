package kr.mg.comment.service;

import kr.mg.comment.model.User;
import kr.mg.comment.repository.UserDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao userdao;

	@Override
	public int join(User user) {
		return userdao.insertUser(user);
	}

	@Override
	public User login(User user) {
		User user1 = userdao.getUser(user.getId());

		if (user1 != null && user.getPassword().equals(user1.getPassword())) {
			return user1;
		} else {
			return null;
		}
	}

	@Override
	public int modify(User user) {
		return userdao.modify(user);
	}

	@Override
	public int getData(User user) {
		// TODO DATA가져오기 로직
		return 0;
	}

}
