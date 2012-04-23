import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import kr.ac.jejuuniv.controller.SaveUserController;
import kr.ac.jejuuniv.controller.ModifyUserController;
import kr.ac.jejuuniv.model.User;
import kr.ac.jejuuniv.service.UserService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.ui.ModelMap;

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
		ModelMap map = new ModelMap();
		String jsp = controller.action(map);

		assertThat(User.class, is(map.get("user")));
		assertThat("save", is(jsp));
	}

	@Test
	//TODO : (생각해보기)이 테스트를 이곳에 넣는게 맞을까? 
	public void createControllerTestUsePost() {
		User user = new User("0000", "양진원", "abcd");
		createController.saveUserPost(user);

		User newUser = new User("0000", "양진용", "bbbb");
		createController.saveUserPost(newUser);

		assertUser(newUser, userService.getUser(newUser.getId()));
	}

	private void assertUser(User user1, User user2) {
		assertThat(user1.getId(), is(user2.getId()));
		assertThat(user1.getName(), is(user2.getName()));
		assertThat(user1.getPassword(), is(user2.getPassword()));
	}
}
