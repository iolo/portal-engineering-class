package kr.ac.jejuuniv.test;

import kr.ac.jejuuniv.service.UserService;
import kr.ac.jejuuniv.service.UserServiceImplement;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.web.multipart.MultipartFile;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {
	
	UserService userservice;

	@Test
	public void userCreate() {
		userservice = new UserServiceImplement();
		
		String id = "1";
		String password="1234";
		String name = "aaa";
		String information ="bbb";
		MultipartFile profileImage = null;
		
		userservice.createUser(id, password, name, information, profileImage);
			
	}
	
}
