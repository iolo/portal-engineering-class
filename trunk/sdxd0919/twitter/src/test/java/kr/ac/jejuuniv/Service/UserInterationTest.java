package kr.ac.jejuuniv.Service;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import kr.ac.jejuuniv.Model.User;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/mybatis-context.xml")
public class UserInterationTest {

	@Autowired
	UserService userService;
	
	@Test
	public void getAllUser() {
		List<User> users = userService.getAllUser();
		printUsers(users);
		
		assertNotNull(users);
		assertTrue(users.size() > 0);
	}
	
	public void printUsers(List<User> users) {
		System.out.println("------------------------------------------");
		for (User user : users) {
			System.out.println(user.toString());
		}
		System.out.println("------------------------------------------");
	}

	
}
