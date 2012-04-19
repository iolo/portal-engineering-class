package kr.ac.jejuuniv.service;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import kr.ac.jejuuniv.model.User;
import kr.ac.jejuuniv.repository.UserRepository;

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

	@Test
	public void testListSuccess() {
		UserService userService = setUserService();
		List<User> users = new ArrayList<User>();
		when(userRepository.findAll()).thenAnswer(new Answer<List<User>>() {
			public List<User> answer(InvocationOnMock invocation)
					throws Throwable {
				List<User> users = new ArrayList<User>();
				User user = setTestUser();

				users.add(user);
				return users;
			}

		});
		users = userService.list();
		assertTrue(users.size() > 0);
		assertThat(users.get(0).getId(), is("0"));
	}
	
	@Test
	public void testGetUserSuccess() {
		UserService userService = setUserService();
		when(userRepository.findById("0")).thenAnswer(new Answer<User>() {
			public User answer(InvocationOnMock invocation) throws Throwable {
				User user = new User();
				user.setId(invocation.getArguments()[0].toString());
				user.setName("한진수");
				user.setPassword("password");
				return user;
			}
		});
		User user = userService.get("0");
		assertThat(user.getId(), is("0"));
		assertThat(user.getName(), is("한진수"));
		assertThat(user.getPassword(), is("password"));
	}
	
	
	@Test(expected=DataNotFoundException.class)
	public void testGetUserFail() throws DataNotFoundException{
		UserService userService = setUserService();
		when(userRepository.findById("0")).thenAnswer(new Answer<User>() {
			public User answer(InvocationOnMock invocation) throws Throwable {
				return null;
			}
		});
		userService.get("0");
	}

	@Test
	public void testAddUserSuccess() {
		UserService userService = setUserService();
		User user = setTestUser();
		when(userRepository.create(user)).thenAnswer(new Answer<User>() {
			public User answer(InvocationOnMock invocation) throws Throwable {
				return (User) invocation.getArguments()[0];
			}
		});
		user = userService.add(user);

		assertThat(user.getId(), is("0"));
		assertThat(user.getName(), is("한진수"));
		assertThat(user.getPassword(), is("password"));
	}
	
	@Test(expected=DuplicateKeyException.class)
	public void testAddUserFail() {
		UserService userService = setUserService();
		
		User user = setTestUser();
		
		when(userRepository.create(user)).thenAnswer(new Answer<User>() {
			public User answer(InvocationOnMock invocation) throws Throwable {
				return null;
			}
		});
		
		userService.add(user);
		
	}

	
	@Test
	public void testModifyUserSuccess() {
		UserService userService = setUserService();
		User user = setTestUser();
		when(userRepository.update(user)).thenAnswer(new Answer<User>() {
			public User answer(InvocationOnMock invocation) throws Throwable {
				User user = (User) invocation.getArguments()[0];
				return user;
			}
		});
		user = userService.modify(user);

		assertThat(user.getId(), is("0"));
		assertThat(user.getName(), is("한진수"));
		assertThat(user.getPassword(), is("password"));

	}
	
	@Test(expected=DataNotFoundException.class)
	public void testModifyUserFail() {
		UserService userService = setUserService();
		User user = setTestUser();
		
		when(userRepository.update(user)).thenAnswer(new Answer<User>() {
			public User answer(InvocationOnMock invocation) throws Throwable {
				return null;
			}
		});
		userService.modify(user);
	}

	private User setTestUser() {
		User user = new User();
		user.setId("0");
		user.setName("한진수");
		user.setPassword("password");
		return user;
	}
	
	@Test
	public void testDeleteUser() {
		UserService userService = setUserService();
		userService.remove("0");
	}
	
	private UserService setUserService() {
		UserService userService = new UserServiceImpl(userRepository);
		return userService;
	}
}