package kr.ac.jejuuniv.controller;

import static org.mockito.Mockito.when;
import kr.ac.jejuuniv.model.User;
import kr.ac.jejuuniv.service.UserService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;

@RunWith(MockitoJUnitRunner.class)
public class UserUpdateControllerTest {
	UserUpdateController userUpdataController;
	@Mock
	UserService userService;
	
	@Test
	public void testUpdateSuccess() {
		userUpdataController = new UserUpdateController(userService);
		User user = new User("0", "한진수", "비밀번호");
		when(userService.modify(user)).thenAnswer(new Answer<User>() {
			public User answer(InvocationOnMock invocation) throws Throwable {
				return (User)invocation.getArguments()[0];
			}
		});
		
		userUpdataController.update(user);
	}
}
