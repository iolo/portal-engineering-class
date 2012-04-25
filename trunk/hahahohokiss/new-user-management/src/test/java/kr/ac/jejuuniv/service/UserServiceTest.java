package kr.ac.jejuuniv.service;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import kr.ac.jejuuniv.exception.DataNotFoundException;
import kr.ac.jejuuniv.model.User;
import kr.ac.jejuuniv.repository.UserRepository;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;
import org.springframework.dao.DuplicateKeyException;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {

	@Mock
	UserRepository userRepository;
	
	UserService userService; 
	
	@Before
	public void setup() {
		userService = new UserServiceImpl(userRepository);
	}
	
	@Test
	public void testUserList() {
		List<User> users = new ArrayList<User>();
		when(userRepository.findAll()).thenAnswer(new Answer<List<User>>() {
			public List<User> answer(InvocationOnMock invocation) throws Throwable {
				List<User> users = new ArrayList<User>();
				User user = setUserInfo();
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
		when(userRepository.findById("0")).thenAnswer(new Answer<User>() {
			public User answer(InvocationOnMock invocation) throws Throwable {
				User user = setUserInfo();
				return user;
			}
		});
		
		User user = userService.get("0");
		verifyUserInfo(user);
	}

	@Test(expected=DataNotFoundException.class)
	public void testUserGetFail() {
		when(userRepository.findById("0")).thenAnswer(new Answer<User>() {
			public User answer(InvocationOnMock invocation) throws Throwable {
				return null;
			}
		});
		userService.get("0");
		
	}
	
	
	@Test
	public void testUserAddSuccess() {
		User user = setUserInfo();
		when(userRepository.insert(user)).thenAnswer(new Answer<User>() {
			public User answer(InvocationOnMock invocation) throws Throwable {
				return (User)invocation.getArguments()[0];
			}
			
		});
		
		user = userService.add(user);
		
		verifyUserInfo(user);
	}
	
	@Test(expected=DuplicateKeyException.class)
	public void testUserAddFail() {
		User user = setUserInfo();
		
		when(userRepository.findById(user.getId())).thenAnswer(new Answer<User>() {
			public User answer(InvocationOnMock invocation) throws Throwable {
				User user = setUserInfo();
				return user;
			}
		});
		
		userService.add(user);
	}

	
	@Test()
	public void testUserModifySuccess() {
		User user = setUserInfo();
		
		when(userRepository.findById("0")).thenAnswer(new Answer<User>() {
			public User answer(InvocationOnMock invocation) throws Throwable {
				User user = setUserInfo();
				return user;
			}
		});
		when(userRepository.update(user)).thenAnswer(new Answer<User>() {
			public User answer(InvocationOnMock invocation) throws Throwable {
				return (User)invocation.getArguments()[0];
			}
		});
		
		
		user = userService.modify(user);
		
		verifyUserInfo(user);
	}
	
	@Test(expected=DataNotFoundException.class)
	public void testUserModifyFail() {
		User user = setUserInfo();
		
		when(userRepository.findById(user.getId())).thenAnswer(new Answer<User>() {
			public User answer(InvocationOnMock invocation) throws Throwable {
				return null;
			}
		});
		
		user = userService.modify(user);
	}
	
	@Test
	public void testUserDeleteSuccess() {
		doAnswer(new Answer<User>() {
			public User answer(InvocationOnMock invocation) throws Throwable {
				User user = setUserInfo();
				return user;
			}
		}).when(userRepository).findById("0");
		userService.delete("0");
	}
	
	@Test(expected=DataNotFoundException.class)
	public void testUserDeleteFail() {
		doAnswer(new Answer<User>() {
			public User answer(InvocationOnMock invocation) throws Throwable {
				return null;
			}
		}).when(userRepository).findById("0");
		userService.delete("0");
	}
	

	private User setUserInfo() {
		User user = new User();
		user.setId("0");
		user.setName("한진수");
		user.setPassword("비밀번호");
		return user;
	}
	
	private void verifyUserInfo(User user) {
		assertThat(user.getId(), is("0"));
		assertThat(user.getName(), is("한진수"));
		assertThat(user.getPassword(), is("비밀번호"));
	}
}
