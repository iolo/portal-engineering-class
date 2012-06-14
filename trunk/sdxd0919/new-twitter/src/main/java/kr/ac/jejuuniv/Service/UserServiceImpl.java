package kr.ac.jejuuniv.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import kr.ac.jejuuniv.Model.User;
import kr.ac.jejuuniv.Repository.UserRepository;
import kr.ac.jejuuniv.Service.Exception.UserNotFoundException;
import kr.ac.jejuuniv.Service.Exception.dateIsNullException;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;

	public UserServiceImpl() {
	}
	
	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public User checkUser(String id, String password) {
		String userPassword = userRepository.getPassword(id);
		
		if(userPassword.equals(password)){
			return userRepository.getUserById(id);
		}
		return null;
	}

	public User getUserByUserNum(int userNum) {
		return userRepository.getUserByUserNum(userNum);
	}

	public void addUser(User user) {
		if(userRepository.getUserByUserNum(user.getUserNum()) != null){
			throw new DuplicateKeyException("동일한 id가 있습니다.");
		}else{
			if(!(user.getId().equals("")) && !(user.getName().equals("")) && !(user.getPassword().equals(""))){
				userRepository.insert(user);
			}else{
				throw new dateIsNullException();
			}
		}
	}

	public void update(User newUser) {
		User user = userRepository.getUserByUserNum(newUser.getUserNum()); 
		if(user == null){
			throw new UserNotFoundException();
		}else{
			if(newUser.getName().equals("")) newUser.setName(user.getName());
			if(newUser.getPassword().equals("")) newUser.setPassword(user.getPassword());
			userRepository.update(newUser);
		}
	}

	public List<User> getAllUser() {
		return userRepository.getAllUser();
	}

	public User getUserById(String id) {
		return userRepository.getUserById(id);
	}

	public int getUserNum(String id) {
		return userRepository.getUserNumById(id);
	}

}
