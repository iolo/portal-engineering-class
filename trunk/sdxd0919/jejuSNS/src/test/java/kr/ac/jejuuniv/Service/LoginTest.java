package kr.ac.jejuuniv.Service;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;

import kr.ac.jejuuniv.Model.User;
import kr.ac.jejuuniv.Repository.UserRepository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;
import org.omg.CosNaming.NamingContextPackage.NotFound;
import org.springframework.dao.DuplicateKeyException;

@RunWith(MockitoJUnitRunner.class)
public class LoginTest {
	@Mock
	private UserRepository userRepository;

	
	@Test
	public void LoginSuccess(){
		when(userRepository.checkUser("aaa", "bbb")).thenAnswer(new Answer<User>() {
			public User answer(InvocationOnMock invocation) throws Throwable {
				List<User> users = new ArrayList<User>();
				users.add(new User("aaa", "bbb"));
				users.add(new User("bbb", "ccc"));
				
				User user = null;
				for(int i=0; i<users.size(); i++){
					if(users.get(i).getId().equals("aaa")){
						user = users.get(i);
					}
				}

				return user;
			}
		});
		
		LoginService loginService = new LoginServiceImpl(userRepository);
		Boolean flag = loginService.checkUser("aaa","bbb");

		assertTrue(flag);
	}
	
	
}
