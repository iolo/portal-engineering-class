package kr.ac.jejuuniv.service;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import kr.ac.jejuuniv.exception.EmptyDataException;
import kr.ac.jejuuniv.repository.UserRepository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;
import org.springframework.dao.DuplicateKeyException;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {
	
	@Mock
	private UserRepository userRepository;
	@InjectMocks
	private UserService userService = new UserServiceImpl();

	
	public User getTestUser() {
		User user = new User();
		user.setKey(1);
		user.setId("1");
		user.setName("허윤호");
		user.setPassword("1234");
		return user;
	}

	public void assertTestUser(User user, String id) {
		assertThat(user.getId(), is(id));
		assertThat(user.getName(), is("허윤호"));
		assertThat(user.getPassword(), is("1234"));
	}

	@Test
	public void list() {
		when(userRepository.findAll()).thenAnswer(new Answer<List<User>>() {
			public List<User> answer(InvocationOnMock invocation)
					throws Throwable {
				List<User> users = new ArrayList<User>();
				User user = getTestUser();
				users.add(user);
				return users;
			}
		});
		List<User> users = userService.list();
		assertTrue(users.size() > 0);
		User user = users.get(0);
		String id = "1";
		assertTestUser(user, id);
	}
	
	
	@Test
	public void get() {
		String id = "1";
		when(userRepository.findById(id)).thenAnswer(new Answer<User>() {
			public User answer(InvocationOnMock invocation) throws Throwable {
				return getTestUser();
			}
		});
		User user = userService.get(id);
		assertThat(user, notNullValue());
		assertTestUser(user, id);
		
	}
	
	@Test(expected=EmptyDataException.class)
	public void get_empty() {
		String id = "0";
		when(userRepository.findById(id)).thenAnswer(new Answer<User>() {
			public User answer(InvocationOnMock invocation) throws Throwable {
				return null;
			}
		});
		User user = userService.get(id);
	}
	
	@Test
	public void add() {
		User user = new User();
		user.setId("2");
		user.setName("유대은");
		user.setPassword("2345");
		userService.save(user);
	}
	
	@Test(expected=DuplicateKeyException.class)
	public void add_duplicate() {
		String id = "1";
		when(userRepository.findById(id)).thenAnswer(new Answer<User>() {
			public User answer(InvocationOnMock invocation) throws Throwable {
				return getTestUser();
			}
		});
		User user = new User();
		user.setId("1");
		user.setName("유대은");
		user.setPassword("2345");
		userService.save(user);
	}
	
	@Test
	public void modify() {
		String id = "1";
		when(userRepository.findById(id)).thenAnswer(new Answer<User>() {
			public User answer(InvocationOnMock invocation) throws Throwable {
				return getTestUser();
			}
		});
		User user = getTestUser();
		user.setName("하하하");
		userService.save(user);
	}

	@Test
	public void delete() {
		userService.delete("1");
	}
}
