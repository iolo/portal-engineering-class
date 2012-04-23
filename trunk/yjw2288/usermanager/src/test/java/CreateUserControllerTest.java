import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.List;

import kr.ac.jejuuniv.controller.SaveUserController;
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
	private SaveUserController controller;
	@Autowired
	private UserService service;

	@Test
	public void testController() {
		String id = "1";
		String name = "양진원";
		String password = "abcd";

		ModelMap model = new ModelMap();
		assertThat("list", is(controller.saveUserGet(id, name, password, model)));

		User user2 = service.getUser(id);
		User user1 = new User(id, name, password);
		assertUser(user1, user2);

		List<User> users = service.listUser();
		@SuppressWarnings("unchecked")
		List<User> getUsers = (List<User>) model.get("userList");

		assertThat(users.size(), is(getUsers.size()));
		for (int i = 0; i < users.size(); i++) {
			assertUser(users.get(i), getUsers.get(i));
		}
	}

	private void assertUser(User user1, User user2) {
		assertThat(user1.getId(), is(user2.getId()));
		assertThat(user1.getName(), is(user2.getName()));
		assertThat(user1.getPassword(), is(user2.getPassword()));
	}
}