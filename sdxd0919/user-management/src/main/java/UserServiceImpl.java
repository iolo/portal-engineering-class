import java.util.List;

import org.springframework.dao.DuplicateKeyException;

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
			throw new DataNotFoundException("id = " + id +"인 데이타가 없습니다.");
		}else{
			return userRepository.findById(id);
		}
	}

	public void add(User user) {
		if(userRepository.findById(user.getId()) == null){
			userRepository.insert(user);
		}else{
			System.out.println("user = " + userRepository.findById(user.getId()).getId());
			throw new DuplicateKeyException("id가 중복되어, 저장할 수 없습니다.");
		}
	}
	public void remove(String id) {
		userRepository.delete(id);
	}

	public void update(User user) {
		if(userRepository.findById(user.getId()) != null){
			userRepository.update(user);
			System.out.println(user.getId() + " " + user.getName() + "  " + user.getPassword());
		}
	}

}
