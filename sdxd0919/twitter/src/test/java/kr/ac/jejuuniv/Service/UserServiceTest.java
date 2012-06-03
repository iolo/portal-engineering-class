package kr.ac.jejuuniv.Service;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import kr.ac.jejuuniv.Model.User;
import kr.ac.jejuuniv.Repository.UserRepository;
import kr.ac.jejuuniv.Service.Exception.UserNotFoundException;

import org.aspectj.weaver.ArrayAnnotationValue;
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
	public void getAllUser(){
		UserService userService = new UserServiceImpl(userRepository);
		
		when(userRepository.getAllUser()).thenAnswer(new Answer<List<User>>() {
			public List<User> answer(InvocationOnMock invocation)
					throws Throwable {
				List<User> users = new ArrayList<User>();
				users.add(new User(1,"hsy","aaa","현소영"));
				users.add(new User(2,"hsy2","aaa2","한소영"));
				users.add(new User(3,"hsy3","aaa3","김소영"));
				return users;
			}
		});
		
		List<User> users = userService.getAllUser();
		
		assertTrue(users.size() == 3);
		assertThat(users.get(0).getUserNum(), is(1));
	}
	
	
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
	public void updateUser(){
		UserService userService = new UserServiceImpl(userRepository);
		
		when(userRepository.findByUserNum(1)).thenAnswer(new Answer<User>() {
			public User answer(InvocationOnMock invocation) throws Throwable {
				return new User(1,"hsy","aaa","현소영");
			}
			
		});
		
		User user = new User(1, "hsy", "abc", "현소영");
		userService.update(user);
		
		assertNotNull(userRepository.findByUserNum(1));
		verify(userRepository).update(user);
		
	}
	
	@Test(expected=UserNotFoundException.class)
	public void updateFail(){
		UserService userService = new UserServiceImpl(userRepository);
		
		when(userRepository.findByUserNum(1) == null).thenThrow(new UserNotFoundException());
		
		User user = new User(1, "hsy", "abc", "현소영");
		userService.update(user);
		
		verify(userRepository).update(user);
	}
	
	@Test
	public void checkUser(){
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
	
}
