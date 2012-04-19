import java.util.List;


public interface UserService {

	List<User> list();

	User get(String id);

	void add(User user);

	void remove(String id);

	void update(User user);


}
