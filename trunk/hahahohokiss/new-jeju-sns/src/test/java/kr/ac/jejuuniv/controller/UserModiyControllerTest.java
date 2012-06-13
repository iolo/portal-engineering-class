package kr.ac.jejuuniv.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import kr.ac.jejuuniv.model.User;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class UserModiyControllerTest extends BaseFormControllerTest {
	UserModifyController userModifyController;
	
	
	@Test
	public void testUserModifyAction() {
		userModifyController = new UserModifyController(userService);
		User user = new User();
		String returnViewName = userModifyController.userModifyAction(user);
		assertThat(returnViewName, is("redirect:/service/personalSns"));
	}
}
