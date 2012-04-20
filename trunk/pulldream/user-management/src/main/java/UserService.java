import java.util.List;

public interface UserService {
	List<User> findAll();
	
	User findById(String id);
	
	void insert(User user);
	void update(User user);
	void delete(String id);
	User get(String id);
}
