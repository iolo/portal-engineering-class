package kr.ac.jejuuniv.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import kr.ac.jejuuniv.service.UserService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class UserRemoveControllerTest {
	@Mock
	UserService userService;
	
	UserRemoveController userRemoveController;
	
	@Test
	public void testRemoveSuccess() {
		userRemoveController = new UserRemoveController();
		String redirectUrl = userRemoveController.remove("0");
		assertThat(redirectUrl, is("redirect/:list"));
	}
}
