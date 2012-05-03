package kr.ac.jejuuniv.controller;

import kr.ac.jejuuniv.service.UserService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class HomeControllerTest {
	@Mock
	UserService userService;
	
	HomeController homeController;
	
	@Test
	public void testAction() {
		homeController = new HomeController(userService);
		homeController.action();
		
	}
}
