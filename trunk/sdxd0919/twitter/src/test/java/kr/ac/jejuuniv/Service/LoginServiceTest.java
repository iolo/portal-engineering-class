package kr.ac.jejuuniv.Service;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import kr.ac.jejuuniv.Model.User;
import org.junit.Test;

public class LoginServiceTest {
	
	@Test
	public void action(){
		LoginService loginService = new LoginServiceImpl();
		User user = loginService.checkUser("hsy", "abc");
		
		assertThat(user.getUserNum(), is(1));
		assertThat(user.getName(), is("현소영"));
	}
}
