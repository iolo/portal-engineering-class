package kr.ac.jejuuniv.controller;

import kr.ac.jejuuniv.service.UserService;

import org.mockito.Mock;
import org.springframework.mock.web.MockHttpSession;

public class BaseFormControllerTest {
	
	@Mock
	UserService userService;
	
	@Mock
	MockHttpSession session;
}
