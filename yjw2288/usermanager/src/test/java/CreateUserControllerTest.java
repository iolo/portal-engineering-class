import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import kr.ac.jejuuniv.controller.CreateUser;
import kr.ac.jejuuniv.model.User;
import kr.ac.jejuuniv.service.UserService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.ui.ModelMap;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/test-servlet-context.xml")
public class CreateUserControllerTest {
	@Autowired
	private CreateUser controller;
	@Autowired
	private UserService service;

	@Test
	public void testController() {
		String id = "1";
		String name = "양진원";
		String password = "abcd";

		ModelMap mm = new ModelMap();

		assertThat("list", is(controller.action(id, name, password, mm)));

		User user = service.getUser(id);

		assertThat(id, is(user.getId()));
		assertThat(name, is(user.getName()));
		assertThat(password, is(user.getPassword()));
	}
}
