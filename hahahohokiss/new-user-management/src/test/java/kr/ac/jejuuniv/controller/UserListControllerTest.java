package kr.ac.jejuuniv.controller;

import static org.junit.Assert.assertNotNull;

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
	
	UserListController userListController = new UserListController();
	
	@Test
	public void testList() {
		List<User> users = userListController.list();
		assertNotNull(users);
	}
}
