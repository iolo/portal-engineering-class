package kr.ac.jejunu.rabbit;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import kr.ac.jejunu.rabbit.service.UserService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/root-context.xml")
public class UserListTest {
	@Autowired
	private UserService userService;

	@Test
	public void springWorkTest() {
		assertTrue(true);
		assertThat(userService, notNullValue());
	}
}
