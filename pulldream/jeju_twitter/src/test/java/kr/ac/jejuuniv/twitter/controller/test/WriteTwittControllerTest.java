package kr.ac.jejuuniv.twitter.controller.test;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.util.ReflectionTestUtils.*;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import kr.ac.jejuuniv.twitter.controller.WriteTwittController;
import kr.ac.jejuuniv.twitter.model.UserModel;
import kr.ac.jejuuniv.twitter.service.UserService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.web.servlet.ModelAndView;

@RunWith(MockitoJUnitRunner.class)
public class WriteTwittControllerTest {
	
	@Mock
	private UserService userService;
	
	@InjectMocks
	private WriteTwittController writeTwittController;
	
	private ModelAndView model;
	
	
	@Test
	public void WriteTwittControllerTester(){
		
	}
}
