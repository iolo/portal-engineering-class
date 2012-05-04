package kr.juntheater.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.juntheater.model.User;
import kr.juntheater.repository.UserRepository;

//애가 서비스 역할을 한다는 것을 알려주기 위한 어노테이션
@Service
public class UserServiceImp implements UserService {
	
	@Autowired
	private UserRepository	userRepository;
	
	public List<User> getList() {
		return userRepository.findAll();
	}

	public void create(User user) {
		userRepository.insert(user.getId(), user.getName(), user.getPassword());
	}

	public void remove(String id) {
		userRepository.delete(id);
	}

	public User readId(String id) {
		return userRepository.read(id);
	}
	
	public void modify(User user){
		userRepository.modify(user);
	}
}
