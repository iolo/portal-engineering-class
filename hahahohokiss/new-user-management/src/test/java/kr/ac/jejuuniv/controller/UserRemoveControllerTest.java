package kr.ac.jejuuniv.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;

import kr.ac.jejuuniv.exception.DataNotFoundException;
import kr.ac.jejuuniv.model.User;
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
		userRemoveController = new UserRemoveController(userService);
		String redirectUrl = userRemoveController.remove("0");
		assertThat(redirectUrl, is("redirect:/list"));
	}
	
	@Test
	public void testRemoveFail() {
		userRemoveController = new UserRemoveController(userService);
		User user = new User("0", "한진수","비밀번호");
		
		userRemoveController.remove(user.getId());
		doThrow(new DataNotFoundException()).when(userService).remove(user.getId());
		assertThat(userRemoveController.remove(user.getId()), is("redirect:/list"));
	}
}
