package kr.ac.jejuuniv.test;

import static org.junit.Assert.fail;
import kr.ac.jejuuniv.service.user.UserService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/root-context.xml", "classpath:applicationContext-*.xml"})
public class UserServiceTest {
	@Autowired
	UserService userService;

	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
