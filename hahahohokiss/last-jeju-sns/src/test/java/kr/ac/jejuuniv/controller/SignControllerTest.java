package kr.ac.jejuuniv.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;

@RunWith(MockitoJUnitRunner.class)
public class SignControllerTest extends BaseFormControllerTest {
	
	SignController signController;
	
	@Test
	public void testLoginSuccess() {
		signController = new SignController(userService);
		String userId = "hahahohokiss";
		String password = "password";
		when(userService.getPassword(userId)).thenAnswer(new Answer<String>() {
			public String answer(InvocationOnMock invocation) throws Throwable {
				return "password";
			}
		});
		String  returnViewName  = signController.singAction(userId, password, session);
		assertThat(returnViewName, is("redirect:/service/mainSns"));
	}
	
	@Test
	public void testLoginFail() {
		signController = new SignController(userService);
		String userId = "hahahohokiss";
		String password = "password";
		when(userService.getPassword(userId)).thenAnswer(new Answer<String>() {
			public String answer(InvocationOnMock invocation) throws Throwable {
				return "";
			}
		});
		String  returnViewName  = signController.singAction(userId, password, session);
		assertThat(returnViewName, is("redirect:/"));
	}
}
