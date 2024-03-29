package kr.ac.jejuuniv.Service;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import kr.ac.jejuuniv.Model.User;
import kr.ac.jejuuniv.Repository.UserRepository;
import kr.ac.jejuuniv.Service.Exception.UserNotFoundException;

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
				users.add(new User("hsy","aaa","현소영"));
				users.add(new User("hsy2","aaa2","한소영"));
				users.add(new User("hsy3","aaa3","김소영"));
				return users;
			}
		});
		
		List<User> users = userService.getAllUser();
		
		assertTrue(users.size() == 3);
		assertThat(users.get(0).getName(), is("현소영"));
	}
	
	@Test
	public void getUserById(){
		UserService userService = new UserServiceImpl(userRepository);
		
		when(userRepository.getUserById("hsy")).thenAnswer(new Answer<User>() {
			public User answer(InvocationOnMock invocation) throws Throwable {
				User user = new User("hsy", "abc", "현소영");
				return user;
			}
		});
		
		User user = userService.getUserById("hsy");
		
		assertThat(user.getName(), is("현소영"));
	}
	
	
	@Test
	public void findUser(){
		UserService userService = new UserServiceImpl(userRepository);
		
		when(userRepository.getUserByUserNum(1)).thenAnswer(new Answer<User>() {
			public User answer(InvocationOnMock invocation) throws Throwable {
				User user = new User();
				user.setUserNum(Integer.parseInt(invocation.getArguments()[0].toString()));
				user.setName("현소영");
				return user;
			}
		});
		
		User user = userService.getUserByUserNum(1);
		
		assertThat(user.getUserNum(), is(1));
		assertThat(user.getName(), is("현소영"));
	}
	
	@Test
	public void addUser() throws IOException{
		UserService userService = new UserServiceImpl(userRepository);
		
		User user = new User("hsy","aaa", "현소영");
		userService.addUser(user, null);
		
		verify(userRepository).insert(user);
	}
	
	@Test
	public void updateUser() throws IOException{
		UserService userService = new UserServiceImpl(userRepository);
		
		when(userRepository.getUserByUserNum(1)).thenAnswer(new Answer<User>() {
			public User answer(InvocationOnMock invocation) throws Throwable {
				return new User(1, "hsy","aaa","현소영");
			}
		});
		
		User user = new User(1, "hsy", "abc", "현소영");
		userService.update(user,null);
		
		assertNotNull(userRepository.getUserByUserNum(1));
		verify(userRepository).update(user);
		
	}
	
	@Test(expected=UserNotFoundException.class)
	public void updateFail() throws IOException{
		UserService userService = new UserServiceImpl(userRepository);
		
		when(userRepository.getUserByUserNum(1) == null).thenThrow(new UserNotFoundException());
		
		User user = new User("hsy", "abc", "현소영");
		userService.update(user,null);
		
		verify(userRepository).update(user);
	}
	
	@Test
	public void checkUser(){
		UserService userService = new UserServiceImpl(userRepository);

		when(userRepository.getPassword("hsy")).thenAnswer(new Answer<String>() {
			public String answer(InvocationOnMock invocation) throws Throwable {
				String password = "abc";
				return password;
			}
		});
		
		when(userRepository.getUserById("hsy")).thenAnswer(new Answer<User>() {
			public User answer(InvocationOnMock invocation) throws Throwable {
				User user = new User("hsy", "abc", "현소영");
				return user;
			}
		});
		
		User user = userService.checkUser("hsy", "abc");
		
		assertThat(user.getId(), is("hsy"));
		assertThat(user.getPassword(), is("abc"));
	}
	
	@Test
	public void getUserNum(){
		UserService userService = new UserServiceImpl(userRepository);

		when(userRepository.getUserNumById("hsy")).thenAnswer(new Answer<Integer>() {
			public Integer answer(InvocationOnMock invocation) throws Throwable {
				int userNum = 1;
				return userNum;
			}
		});
		
		int userNum = userService.getUserNum("hsy"); 
		
		assertThat(userNum, is(1));
	}
}
