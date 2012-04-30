package kr.ac.jejuuniv.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import kr.ac.jejuuniv.exception.DataNotFoundException;
import kr.ac.jejuuniv.model.User;
import kr.ac.jejuuniv.service.UserService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;
import org.springframework.web.servlet.ModelAndView;

@RunWith(MockitoJUnitRunner.class)
public class UserModifyControllerTest {
	// User 가져오기!
	@Mock
	UserService userService;
	
	UserModifyController userModifyController;

	@Test
	public void testModifySuccess() {
		userModifyController = new UserModifyController(userService);
		
		User user = new User("0", "한진수", "비밀번호");
		when(userService.get(user.getId())).thenAnswer(new Answer<User>() {
			public User answer(InvocationOnMock invocation) throws Throwable {
				User user = new User((String)invocation.getArguments()[0], "한진수", "비밀번호");
				user.setId("0");
				return user;
			}
		});
		userModifyController.modify(user.getId());
	}
	
	@Test
	public void  testModifyFail() {
		userModifyController = new UserModifyController(userService);
		
		User user = new User("0", "한진수", "비밀번호");
		doThrow(new DataNotFoundException()).when(userService).get(user.getId());
		ModelAndView modelAndView = userModifyController.modify(user.getId());
		assertThat(modelAndView.getViewName(), is("redirect:/list"));
	}
}

