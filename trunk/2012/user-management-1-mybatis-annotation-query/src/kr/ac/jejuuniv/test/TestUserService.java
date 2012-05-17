package kr.ac.jejuuniv.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import kr.ac.jejuuniv.model.User;
import kr.ac.jejuuniv.service.UserService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/root-context.xml")
public class TestUserService  {
	
	@Autowired
	UserService userService;

	@Test
	public void findAll() {
		List<User> users = userService.getList();
		printUsers(users);
		assertNotNull(users);
		assertTrue(users.size() > 0);
	}

	@Test
	public void findAllOrderByIdDesc() {
		List<User> users = userService.getListOrderByIdDesc();
		printUsers(users);
	}
	
	public void printUsers(List<User> users) {
		System.out.println("------------------------------------------");
		for (User user : users) {
			System.out.println("* " + user);
		}
		System.out.println("------------------------------------------");
	}

}
