package kr.ac.jejuuniv;

import java.util.List;

import static org.junit.Assert.*;
import org.junit.Test;

public class UserList {

	@Test
	public void findAll() {
		List<User> users = new User("jeju_").list();
		assertNotNull(users);
		assertTrue(users.size() > 0);
		assertEquals("jeju_", users.get(0).getId().substring(0, 5));
	}

	@Test
	public void findAllOrderByIdDesc() {
		List<User> users2 = new User("jeju_").listOrderByIdDesc();
		for (User user : users2) {
			System.out.println("*** id : " + user.getId());
			System.out.println("*** name : " + user.getName());
			System.out.println("*** password : " + user.getPassword());
		}
	}

}
