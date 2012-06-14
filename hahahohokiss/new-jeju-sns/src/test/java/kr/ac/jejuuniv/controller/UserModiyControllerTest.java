package kr.ac.jejuuniv.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import kr.ac.jejuuniv.exception.UserNotFoundException;
import kr.ac.jejuuniv.model.User;
import kr.ac.jejuuniv.service.UserService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.when;
@RunWith(MockitoJUnitRunner.class)
public class UserModiyControllerTest extends BaseFormControllerTest {
	UserModifyController userModifyController;
	
	@Mock
	UserService userService;
	
	@Test
	public void testUserModifyActionSuccess() {
		userModifyController = new UserModifyController(userService);
		User user = new User();
		String returnViewName = userModifyController.userModifyAction(user);
		assertThat(returnViewName, is("redirect:/service/personalSns"));
	}
	
	@Test
	public void testUserModifyActionFail() {
		userModifyController = new UserModifyController(userService);
		User user = new User();
		when(userService.modifyUser(user)).thenAnswer(new Answer<User>() {
			public User answer(InvocationOnMock invocation) throws Throwable {
				throw new UserNotFoundException();
			}
		});
		String returnViewName = userModifyController.userModifyAction(user);
		assertThat(returnViewName, is("redirect:/service/userform"));
	}
}
