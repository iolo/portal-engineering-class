import java.util.List;

import kr.ac.jejunniv.Exception.DataNotFoundException;


public class UserServiceImpl implements UserService {
	UserRepository userRepository;
	
	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public List<User> list() {
		return userRepository.findAll();
	}

	public User get(String id) {
		if(userRepository.findById(id) == null){
			throw new DataNotFoundException();
		}else{
			return userRepository.findById(id);
		}
	}

	public void add(User user) {
		userRepository.insert(user);
	}
	public void remove(String id) {
		userRepository.delete(id);
	}

	public void update(User user) {
		userRepository.update(user);
	}

}
