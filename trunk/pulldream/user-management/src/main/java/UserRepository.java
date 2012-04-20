import java.util.List;

import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository {
	List<User> findAll();
	
	User findById(String id);
	
	void insert(User user);
	void update(User user);
	void delete(String id);
	void modify(User user);
}
