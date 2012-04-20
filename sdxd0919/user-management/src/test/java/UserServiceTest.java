
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import kr.ac.jejunniv.Exception.DataNotFoundException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.test.AssertThrows;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {
	@Mock
	UserRepository userRepository;
	
	@Test
	public void list_success(){
		when(userRepository.findAll()).thenAnswer(new Answer<List<User>>() {
			public List<User> answer(InvocationOnMock invocation) throws Throwable {
				List<User> users = new ArrayList<User>();
				User user = userInput();
				
				users.add(user);
				return users;
			}
		});
		UserService userService = new UserServiceImpl(userRepository);
		List<User> users = userService.list();
		
		assertNotNull(users);
		assertTrue(users.size() > 0);
		assertThat(users.get(0).getId(), is("0"));
	}
	
	
	@Test
	public void get_success(){
		String id = "0";
		when(userRepository.findById(id)).thenAnswer(new Answer<User>() {
			public User answer(InvocationOnMock invocation) throws Throwable {
				int findId = 0;
				User user = new User();
				user.setId(invocation.getArguments()[findId].toString());
				user.setName("HSY");
				user.setPassword("abc");

				return user;
			}
		});
		UserService userService = new UserServiceImpl(userRepository);
		User user = userService.get(id);
	
		assertNotNull(user);
		assertThat(user.getId(), is(id));
		assertThat(user.getName(), is("HSY"));
		assertThat(user.getPassword(), is("abc"));
	}
	
	
	@Test(expected=DataNotFoundException.class)
	public void get_fail(){
		String id = "0";
		when(userRepository.findById(id)).thenAnswer(new Answer<User>() {
			public User answer(InvocationOnMock invocation) throws Throwable {
				return null;
			}
			
		});
		UserService userService = new UserServiceImpl(userRepository);
		User user = userService.get(id);
	}
	
	
	@Test
	public void add_success(){
		UserService userService = new UserServiceImpl(userRepository);
		User user = userInput();
		
		userService.add(user);
		
	}
	
	
	@Test(expected=DuplicateKeyException.class)
	public void add_fail(){
		when(userRepository.findById("0")).thenAnswer(new Answer<User>() {
			public User answer(InvocationOnMock invocation) throws Throwable {
				int findId = 0;
				User user = new User();
				user.setId(invocation.getArguments()[findId].toString());
				user.setName("aaa");
				user.setPassword("bbb");
				
				return user;
			}
		});
		UserService userService = new UserServiceImpl(userRepository);
		User user = userInput();
		
		userService.add(user);
	}
	
	
	@Test
	public void update_success(){
		when(userRepository.findById("0")).thenAnswer(new Answer<User>() {
			public User answer(InvocationOnMock invocation) throws Throwable {
				int findId = 0;
				User user = new User();
				user.setId(invocation.getArguments()[findId].toString());
				user.setName("aaa");
				user.setPassword("bbb");
				
				return user;
			}
		});
		
		UserService userService = new UserServiceImpl(userRepository);
		User user = userInput();
		
		userService.update(user);
	}
	
	
	@Test(expected=DataNotFoundException.class)
	public void update_fail(){
		when(userRepository.findById("0")).thenAnswer(new Answer<User>() {
			public User answer(InvocationOnMock invocation) throws Throwable {
				return null;
			}
			
		});
		UserService userService = new UserServiceImpl(userRepository);
		User user = userInput();
		
		userService.update(user);
	}
	
	
	@Test
	public void delete(){
		UserService userService = new UserServiceImpl(userRepository);
		String id = "0";
		userService.remove(id);
	}

	
	public User userInput() {
		User user = new User();
		user.setId("0");
		user.setName("HSY");
		user.setPassword("abc");
		return user;
	}
	
	
}
