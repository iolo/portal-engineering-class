import java.util.List;


public class UserServiceImpl implements UserService {
	
	private UserRepository userRepository;
	
	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public List<User> list() {
		List<User> users = userRepository.findAll();
		return users;
	}
}
