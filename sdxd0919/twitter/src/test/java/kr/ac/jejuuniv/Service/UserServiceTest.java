package kr.ac.jejuuniv.Service;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import kr.ac.jejuuniv.Model.User;
import kr.ac.jejuuniv.Repository.UserRepository;
import kr.ac.jejuuniv.Service.Exception.IdNotExistException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {
	
	@Mock
	UserRepository userRepository;
	
	@Test
	public void findUser(){
		UserService userService = new UserServiceImpl(userRepository);
		
		when(userRepository.findByUserNum(1)).thenAnswer(new Answer<User>() {
			public User answer(InvocationOnMock invocation) throws Throwable {
				User user = new User();
				user.setUserNum(Integer.parseInt(invocation.getArguments()[0].toString()));
				user.setName("현소영");
				return user;
			}
		});
		
		User user = userService.getUser(1);
		
		assertThat(user.getUserNum(), is(1));
		assertThat(user.getName(), is("현소영"));
	}
	
	@Test
	public void addUser(){
		UserService userService = new UserServiceImpl(userRepository);
		
		User user = new User(1,"hsy","aaa", "현소영");
		userService.addUser(user);
		
		verify(userRepository).insert(user);
	}
	
	@Test
	public void login(){
		UserService userService = new UserServiceImpl(userRepository);

		when(userRepository.getUserById("hsy")).thenAnswer(new Answer<User>() {
			public User answer(InvocationOnMock invocation) throws Throwable {
				User user = new User(1,"hsy", "abc", "현소영");
				return user;
			}
		});
		
		User user = userService.checkUser("hsy", "abc");
		
		assertThat(user.getUserNum(), is(1));
		assertThat(user.getName(), is("현소영"));
	}
	
	@Test(expected=IdNotExistException.class)
	public void loginFail(){
		UserService userService = new UserServiceImpl(userRepository);
		when(userRepository.getUserById("")).thenThrow(new IdNotExistException());

		User user = userService.checkUser("", "");
	}
}
