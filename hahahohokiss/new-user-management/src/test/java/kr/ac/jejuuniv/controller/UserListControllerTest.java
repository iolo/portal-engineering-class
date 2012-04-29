package kr.ac.jejuuniv.controller;

import java.util.List;

import kr.ac.jejuuniv.model.User;
import kr.ac.jejuuniv.service.UserService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class UserListControllerTest {
	
	
	@Mock
	UserService userService;
	
	UserListController userListController;
	
	@Test
	public void testList() {
		UserListController userListController = new UserListController(userService);
		List<User> users = userListController.list();
	}
}
