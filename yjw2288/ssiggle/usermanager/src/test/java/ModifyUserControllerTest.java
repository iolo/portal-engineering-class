import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import kr.ac.jejuuniv.controller.ModifyUserController;
import kr.ac.jejuuniv.controller.SaveUserController;
import kr.ac.jejuuniv.model.User;
import kr.ac.jejuuniv.service.UserService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;

//TODO : (생각해보기)test하고 실전에서 쓰이는 컨텍스트를 분리할 수 있겠네... 어떻게?
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/test-servlet-context.xml")
public class ModifyUserControllerTest {
	@Autowired
	private ModifyUserController controller;
	@Autowired
	private SaveUserController createController;
	@Autowired
	private UserService userService;

	@Test
	public void modifyController() {
		String id = "0000";
		User user = new User(id, "양진원", "abcd");
		userService.save(user);

		ModelMap map = new ModelMap();
		String jsp = controller.action(id, map);

		User returnUser = (User) map.get("user");

		assertThat("modify", is(jsp));
		assertUser(user, returnUser);
	}

	@Test
	// TODO : (생각해보기)이 테스트를 이곳에 넣는게 맞을까?
	public void saveControllerTestUsePost() {
		BindingResult result = mock(BindingResult.class);
		when(result.hasErrors()).thenReturn(false);

		String name;

		User user = new User("0000", "양진원", "abcd");
		name = createController.saveUserPost(user, new ModelMap(), result);
		assertThat(name, is("list"));

		User newUser = new User("0000", "양진용", "bbbb");
		name = createController.saveUserPost(newUser, new ModelMap(), result);
		assertThat(name, is("list"));

		assertUser(newUser, userService.getUser(newUser.getId()));
	}

	private void assertUser(User user1, User user2) {
		assertThat(user1.getId(), is(user2.getId()));
		assertThat(user1.getName(), is(user2.getName()));
		assertThat(user1.getPassword(), is(user2.getPassword()));
	}
}
