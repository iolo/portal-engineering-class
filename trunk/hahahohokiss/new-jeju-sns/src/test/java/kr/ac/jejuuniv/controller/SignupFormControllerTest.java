package kr.ac.jejuuniv.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import org.junit.Test;
public class SignupFormControllerTest {
	
	SignupFormController signupFormController;
	@Test
	public void testSignupFormAction() {
		signupFormController = new SignupFormController();
		String returnViewName = signupFormController.singupformAction();
		assertThat(returnViewName, is("signupform"));
	}
}
