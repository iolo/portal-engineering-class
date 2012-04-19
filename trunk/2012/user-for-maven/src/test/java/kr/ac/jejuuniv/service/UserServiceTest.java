package kr.ac.jejuuniv.service;

import java.util.List;

import kr.ac.jejuuniv.model.User;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="file:src/main/webapp/WEB-INF/servlet-context.xml")
public class UserServiceTest {
	
	@Autowired
	private UserService userService;
	
	@Test
	public void list() {
		List<User> users = userService.list();
		assertTrue(users.size() > 0);
	}
}
