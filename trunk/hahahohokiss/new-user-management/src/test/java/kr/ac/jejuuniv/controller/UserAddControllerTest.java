package kr.ac.jejuuniv.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;
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
public class UserAddControllerTest {
	UserAddController userAddController;

	
	@Mock
	UserService userService;
	
	@Test
	public void testAdd() {
		// User 값 입력
		// redirect:list
		userAddController = new UserAddController(userService);
		User user = new User();
		user.setId("0");
		user.setName("한진수");
		user.setPassword("비밀번호");
		
		ModelAndView modelAndView = userAddController.add(user);
		when(userService.add(user)).thenAnswer(new Answer<User>() {
			public User answer(InvocationOnMock invocation) throws Throwable {
				return (User)invocation.getArguments()[0];
			}
		});
		user = (User)modelAndView.getModel().get("user");
		assertThat(user.getId(), is("0"));
		assertThat(user.getName(), is("한진수"));
		assertThat(user.getPassword(), is("비밀번호"));
		assertThat(modelAndView.getViewName(), is("/list"));
		
	}
}
