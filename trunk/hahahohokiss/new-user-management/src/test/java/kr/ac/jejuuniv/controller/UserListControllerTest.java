package kr.ac.jejuuniv.controller;

import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;
import static org.mockito.Mockito.*;
import kr.ac.jejuuniv.model.User;
import kr.ac.jejuuniv.service.UserService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;

@RunWith(MockitoJUnitRunner.class)
public class UserListControllerTest {
	
	
	@Mock
	UserService userService;
	
	
	UserListController userListController;
	@Test
	public void testList() {
		userListController = new UserListController(userService);
		when(userService.list()).thenAnswer(new Answer<List<User>>() {
			public List<User> answer(InvocationOnMock invocation) throws Throwable {
				List<User> users = new ArrayList<User>();
				User user = new User();
				user.setId("0");
				user.setName("한진수");
				user.setPassword("비밀번호");
				users.add(user);
				return users;
			}
		});
		List<User> users = userListController.list();
		assertNotNull(users);
	}
}
