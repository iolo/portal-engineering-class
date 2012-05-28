package kr.ac.jejuuniv.service;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;
import kr.ac.jejuuniv.exception.UserNotFoundException;
import kr.ac.jejuuniv.model.User;
import kr.ac.jejuuniv.repository.UserRepository;
import kr.ac.jejuuniv.service.impl.UserServiceImpl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {
	@Mock
	UserRepository userRepositoy;
	
	@Test
	public void testGetUserByUserIdSuccess() {
		UserService userService = new UserServiceImpl(userRepositoy);
		when(userRepositoy.findUserByUserId("hahahohokiss")).thenAnswer(new Answer<User>() {
			public User answer(InvocationOnMock invocation) throws Throwable {
				User user = new User();
				user.setId("hahahohokiss");
				return user;
			}
		});
		User user = userService.getUserByUserId("hahahohokiss");
		assertThat(user.getId(), is("hahahohokiss"));
	}
	
	@Test
	public void testGetUserPassword() {
		UserService userService = new UserServiceImpl(userRepositoy);
		when(userRepositoy.findPasswordByUserId("hahahohokiss")).thenAnswer(new Answer<String>() {
			public String answer(InvocationOnMock invocation) throws Throwable {
				return "hahahohokiss-password";
			}
		});
		String userPassword = userService.getPasswordByUserId("hahahohokiss");
		assertThat(userPassword, is("hahahohokiss-password"));
		
	}
	
	@Test(expected = UserNotFoundException.class)
	public void testGetUserByUserIdFail() {
		UserService userService = new UserServiceImpl(userRepositoy);
		when(userRepositoy.findUserByUserId("hahahohokiss")).thenAnswer(new Answer<User>() {
			public User answer(InvocationOnMock invocation) throws Throwable {
				return null;
			}
		});
		userService.getUserByUserId("hahahohokiss");
	}
	
	@Test
	public void testAddUser() {
		UserService userService = new UserServiceImpl(userRepositoy);
		
		User user = new User();
		user.setId("hahahohokiss");
		user.setPassword("password");
		user.setName("한진수");
		user.setExplanation("제주대학교");
		user.setImageUrl("hahahohokiss-image-url");
		
		when(userRepositoy.insert(user)).thenAnswer(new Answer<User>() {
			public User answer(InvocationOnMock invocation) throws Throwable {
				User user = (User)invocation.getArguments()[0];
				return user;
			}
		});
		when(userRepositoy.findUserByUserId("hahahohokiss")).thenAnswer(new Answer<User>() {
			public User answer(InvocationOnMock invocation) throws Throwable {
				User user = new User();
				user.setId("hahahohokiss");
				user.setPassword("password");
				user.setName("한진수");
				user.setExplanation("제주대학교");
				user.setImageUrl("hahahohokiss-image-url");
				return user;
			}
		});
		userService.add(user);
		user = userService.getUserByUserId("hahahohokiss");
		assertThat(user.getId(), is("hahahohokiss"));
	}
}
