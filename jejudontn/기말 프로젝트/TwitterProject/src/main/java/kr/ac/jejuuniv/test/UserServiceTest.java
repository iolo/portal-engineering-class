package kr.ac.jejuuniv.test;

import static org.junit.Assert.*;
import kr.ac.jejuuniv.service.UserService;
import kr.ac.jejuuniv.service.UserServiceImplement;

import org.junit.Test;
import org.springframework.web.multipart.MultipartFile;


public class UserServiceTest {

	@Test
	public void userCreate() {
		UserService userservice = new UserServiceImplement();
		
		String id = "1";
		String password="1234";
		String name = "aaa";
		String information ="bbb";
		MultipartFile profileImage = null;
		
		userservice.createUser(id, password, name, information, profileImage);
			
	}
	
	@Test
	public void imageValidationExtTest(){
		
		UserServiceImplement userServiceImplement = new UserServiceImplement();
		
		assertTrue(userServiceImplement.validationImageExt("img.png"));
		assertTrue(userServiceImplement.validationImageExt("img.jpg"));
		assertTrue(userServiceImplement.validationImageExt("img.jpeg"));
		assertTrue(userServiceImplement.validationImageExt("img.gif"));
		
		assertFalse(userServiceImplement.validationImageExt("img.exe"));
		assertFalse(userServiceImplement.validationImageExt("img.text"));
		assertFalse(userServiceImplement.validationImageExt("img.dll"));
		
	}
	
}
