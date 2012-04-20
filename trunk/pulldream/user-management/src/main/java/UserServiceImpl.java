import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;


public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;


	@Override
	public User get(String id) {
		return userRepository.findById(id);
	}

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}

	@Override
	public User findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(User user) {
		// TODO Auto-generated method stub
		if (get(user.getId()) == null)
			userRepository.insert(user);
		else
			userRepository.update(user);
		
	}

//	@Override
//	public void update(User user) {
//		// TODO Auto-generated method stub
//		
//	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		userRepository.delete(id);
		
	}

	@Override
	public void update(User user) {
		// TODO Auto-generated method stub
		
	}
}
