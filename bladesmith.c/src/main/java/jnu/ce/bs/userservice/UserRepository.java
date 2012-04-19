package jnu.ce.bs.userservice;

import java.util.ArrayList;
import java.util.List;

public class UserRepository {
	ArrayList<User> users = new ArrayList<User>();
	
	public List<User> List() {
		User user = new User();
		
		user.setId("1");
		user.setName("강우진");
		user.setPassword("password");
		users.add(user);
		
		User user2 = new User();
		user2.setId("2");
		user2.setName("사람임");
		user2.setPassword("1234");
		users.add(user2);
		
		return users;
	}

}
