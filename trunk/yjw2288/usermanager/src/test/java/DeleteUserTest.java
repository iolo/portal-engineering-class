import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.List;

import kr.ac.jejuuniv.model.User;
import kr.ac.jejuuniv.service.UserNotRemoveException;
import kr.ac.jejuuniv.service.UserService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.ui.ModelMap;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/test-servlet-context.xml")
public class DeleteUserTest {
	@Autowired
	private DeleteUserController deleteController;
	@Autowired
	private UserService userService;

	@Test(expected = UserNotRemoveException.class)
	public void deleteUserFailTest() {
		String id = "0000";
		deleteController.action(id, new ModelMap());
	}

	@Test
	public void deleteUserSuccessTest() {
		String targetId = "0000";

		User user1 = new User(targetId, "양진원", "abcd");
		User user2 = new User("0001", "양진용", "abcd");
		User user3 = new User("0002", "양진훈", "abcd");

		userService.save(user1);
		userService.save(user2);
		userService.save(user3);

		ModelMap model = new ModelMap();
		String name = deleteController.action(targetId, model);
		assertThat(name, is("list"));

		@SuppressWarnings("unchecked")
		List<User> users = (List<User>)model.get("userList");
		
		boolean flag = true;
		for(User user:users) {
			if(user.getId().equals(targetId)){
				flag = false;
			}
		}
		
		assertThat(flag, is(true));
	}
}
