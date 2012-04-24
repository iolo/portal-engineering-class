package kr.ac.jejuuniv.service;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import kr.ac.jejuuniv.exception.DataNotFoundException;
import kr.ac.jejuuniv.model.User;
import kr.ac.jejuuniv.repository.UserRepository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {
	/*
	 * User List 가져오기(실패)
	 * User id 로 가져오기(실패)
	 * User 추가하기 (실패)
	 * User 수정하기 (실패)
	 * User 삭제하기 (실패)
	 */

	@Mock
	UserRepository userRepository;
	
	UserService userService; 
	
	
	@Test
	public void testUserList() {
		// UserList를 가져오고 list 에 값이 있는지, 첫번째 id 가 0인지 확인
		List<User> users = new ArrayList<User>();
		userService = new UserServiceImpl(userRepository);
		when(userRepository.findAll()).thenAnswer(new Answer<List<User>>() {
			public List<User> answer(InvocationOnMock invocation) throws Throwable {
				List<User> users = new ArrayList<User>();
				User user = new User();
				user.setId("0");
				user.setName("한진수");
				user.setPassword("비밀번호");
				users.add(user);
				return users;
			}
		});
		users = userService.list();
		assertTrue(users.size() > 0);
		assertThat(users.get(0).getId(), is("0"));
	}
	
	@Test
	public void testUserGetSuccess() {
		userService = new UserServiceImpl(userRepository);
		when(userRepository.findById("0")).thenAnswer(new Answer<User>() {
			public User answer(InvocationOnMock invocation) throws Throwable {
				User user = new User();
				user.setId("0");
				user.setName("한진수");
				user.setPassword("비밀번호");
				return user;
			}
		});
		
		User user = userService.get("0");
		assertThat(user.getId(), is("0"));
		assertThat(user.getName(), is("한진수"));
		assertThat(user.getPassword(), is("비밀번호"));
	}
	
	@Test(expected=DataNotFoundException.class)
	public void testUserGetFail() {
		userService = new UserServiceImpl(userRepository);
		when(userRepository.findById("0")).thenAnswer(new Answer<User>() {
			public User answer(InvocationOnMock invocation) throws Throwable {
				return null;
			}
		});
		User user = userService.get("0");
		
	}
	
	
	@Test
	public void testUserAdd() {
		userService = new UserServiceImpl(userRepository);
		User user = new User();
		user.setId("0");
		user.setName("한진수");
		user.setPassword("비밀번호");
		when(userRepository.insert(user)).thenAnswer(new Answer<User>() {
			public User answer(InvocationOnMock invocation) throws Throwable {
				return (User)invocation.getArguments()[0];
			}
			
		});
		
		user = userService.add(user);
		
		assertThat(user.getId(), is("0"));
		assertThat(user.getName(), is("한진수"));
		assertThat(user.getPassword(), is("비밀번호"));
	}
	
	@Test
	public void testUserModify() {
		userService = new UserServiceImpl(userRepository);
		User user = new User();
		user.setId("0");
		user.setName("한진수");
		user.setPassword("비밀번호");
		
		when(userRepository.update(user)).thenAnswer(new Answer<User>() {
			public User answer(InvocationOnMock invocation) throws Throwable {
				return (User)invocation.getArguments()[0];
			}
		});
		
		
		user = userService.modify(user);
		
		assertThat(user.getId(), is("0"));
		assertThat(user.getName(), is("한진수"));
		assertThat(user.getPassword(), is("비밀번호"));
	}
	
	@Test
	public void testUserDelete() {
		userService = new UserServiceImpl(userRepository);
		userService.delete("0");
	}
}
