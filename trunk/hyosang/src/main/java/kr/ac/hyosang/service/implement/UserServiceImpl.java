package kr.ac.hyosang.service.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.hyosang.model.User;
import kr.ac.hyosang.repository.UserDao;
import kr.ac.hyosang.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	UserDao userdao;

	@Override
	public int userJoin(User user) {
		return userdao.insertUser(user);
	}
	
	@Override
	public User loginCheck(String userId, String password) {
		User user = userdao.selectUser(userId);
		if(user != null && user.getPassword().equals(password))
			return user;
		else
			return null;
	}
 
}
