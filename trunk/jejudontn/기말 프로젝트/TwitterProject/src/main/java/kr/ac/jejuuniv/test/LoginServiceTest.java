package kr.ac.jejuuniv.test;

import static org.junit.Assert.*;
import kr.ac.jejuuniv.service.LoginService;
import kr.ac.jejuuniv.service.LoginServiceImplement;

import org.junit.Test;


public class LoginServiceTest {
	LoginService loginService = new LoginServiceImplement();
	
	@Test
	public void loginCheckTest(){
		
		String id = "111";
		String password = "222";
		boolean idAndPasswordCheck;
		
		idAndPasswordCheck = loginService.checkIdAndPassword(id, password);
		assertTrue(idAndPasswordCheck);
		
	}
}
