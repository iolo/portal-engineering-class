package kr.ac.test.service;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import kr.ac.jejuuniv.service.UserService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"file:src/main/webapp/WEB-INF/servlet-context.xml",
		"file:src/main/webapp/WEB-INF/hibernate-data-access-context.xml" })
public class UserServiceIntegralTest {
	@Autowired
	private UserService service;

	@Test
	public void serviceTest() {
		assertThat(service.userList().size() > 0, is(true));
	}
}
