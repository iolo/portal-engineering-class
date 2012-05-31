package kr.ac.jejuuniv.Service;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;
import kr.ac.jejuuniv.Model.User;
import kr.ac.jejuuniv.Repository.UserRepository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;

@RunWith(MockitoJUnitRunner.class)
public class LoginServiceTest {

	@Mock
	UserRepository userRepository;

	@Test
	public void action(){
		LoginService loginService = new LoginServiceImpl(userRepository);

		when(userRepository.getUserById("hsy")).thenAnswer(new Answer<User>() {
			public User answer(InvocationOnMock invocation) throws Throwable {
				User user = new User(1,"hsy", "abc", "현소영");
				return user;
			}
			
		});
		
		User user = loginService.checkUser("hsy", "abc");
		
		assertThat(user.getUserNum(), is(1));
		assertThat(user.getName(), is("현소영"));
	}
}
