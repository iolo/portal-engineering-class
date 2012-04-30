package kr.ac.jejuuniv;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepositoryImpl implements UserRepository {

	static public List<User> users;
	
	public UserRepositoryImpl() {
		users = new ArrayList<User>();
		users.add(new User("1", "aaa", "123"));
		users.add(new User("2", "bbb", "1234"));
		users.add(new User("3", "ccc", "1234"));
	}
	
	
	public List<User> findAll() {
		return users;
	}


	public void deleteById(String id) {
		for(int i=0; i<users.size(); i++){
			if(users.get(i).getId().equals(id)){
				users.remove(i);
			}
		}
	}


	public void insert(User user) {
		users.add(user);
	}

}
