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
		User user = null;
		for(int i=0; i<users.size(); i++){
			if(users.get(i).getId().equals(id)){
				user = users.get(i);
			}
		}
		users.remove(user);
	}


	public void insert(User user) {
		users.add(user);
	}

	public User findUser(String id) {
		User user = null;
		for(int i=0; i<users.size(); i++){
			if(users.get(i).getId().equals(id)){
				user = users.get(i);
			}
		}
		user.setId(user.getId());
		user.setName(user.getName());
		user.setPassword(user.getPassword());
		return user;
	}


	public User findById(String id) {
		User user = null;
		for(int i=0; i<users.size(); i++){
			if(users.get(i).getId().equals(id)){
				return users.get(i);
			}
		}
		return user;
	}


	public void update(User modifiedUser) {
		User user = findById(modifiedUser.getId());
		user.setName(modifiedUser.getName());
		user.setPassword(modifiedUser.getPassword());
	}

}
