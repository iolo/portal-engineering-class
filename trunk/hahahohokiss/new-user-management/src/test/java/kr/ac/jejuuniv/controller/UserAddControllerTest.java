package kr.ac.jejuuniv.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import kr.ac.jejuuniv.model.User;
import kr.ac.jejuuniv.service.UserService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.servlet.ModelAndView;

@RunWith(MockitoJUnitRunner.class)
public class UserAddControllerTest {
	UserAddController userAddController;
	@Mock
	UserService userService;
	@Test
	public void testAddSuccess() {
		userAddController = new UserAddController(userService);
		User user = new User();
		when(userService.add(user)).thenAnswer(new Answer<User>() {
			public User answer(InvocationOnMock invocation) throws Throwable {
				return (User)invocation.getArguments()[0];
			}
		});
		ModelAndView modelAndView = userAddController.add(user);
	}
	
	@Test
	public void testAddFail() {
		userAddController = new UserAddController(userService);
		User user = new User();
		doThrow(new DuplicateKeyException(null)).when(userService).add(user);
		ModelAndView modelAndView = userAddController.add(user);
		assertThat(modelAndView.getViewName(), is("create"));
	}
}
