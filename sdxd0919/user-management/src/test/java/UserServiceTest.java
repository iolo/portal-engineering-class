
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

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {
	
	@Mock
	UserRepository userRepository;
	
	@Test
	public void list_success(){
		when(userRepository.findAll()).thenAnswer(new Answer<List<User>>() {
			public List<User> answer(InvocationOnMock invocation) throws Throwable {
				List<User> users = new ArrayList<User>();
				User user = new User();
				user.setId("0");
				user.setName("HSY");
				user.setPassword("abc");
				
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
		when(userRepository.findById("0")).thenAnswer(new Answer<User>() {
			public User answer(InvocationOnMock invocation) throws Throwable {
				User user = new User();
				user.setId(invocation.getArguments()[0].toString());
				user.setName("HSY");
				user.setPassword("abc");

				return user;
			}
		});
		UserService userService = new UserServiceImpl(userRepository);
		User user = userService.get("0");
	
		assertNotNull(user);
		assertThat(user.getId(), is("0"));
		assertThat(user.getName(), is("HSY"));
		assertThat(user.getPassword(), is("abc"));
	}
	
	@Test(expected=DataNotFoundException.class)
	public void get_fail(){
		when(userRepository.findById("0")).thenAnswer(new Answer<User>() {
			public User answer(InvocationOnMock invocation) throws Throwable {
				return null;
			}
			
		});
		UserService userService = new UserServiceImpl(userRepository);
		User user = userService.get("0");
	}
	
	@Test
	public void add_success(){
		UserService userService = new UserServiceImpl(userRepository);
		
		User user = new User();
		user.setId("0");
		user.setName("HSY");
		user.setPassword("abc");
		
		userService.add(user);
		
	}
	
	@Test(expected=DuplicateKeyException.class)
	public void add_fail(){
		when(userRepository.findById("0")).thenAnswer(new Answer<User>() {
			public User answer(InvocationOnMock invocation) throws Throwable {
				User user = new User();
				user.setId(invocation.getArguments()[0].toString());
				user.setName("HSY");
				user.setPassword("abc");
				
				return user;
			}
		});
		
		User user = new User();
		user.setId("0");
		user.setName("aaa");
		user.setPassword("bbb");
		
		UserService userService = new UserServiceImpl(userRepository);
		userService.add(user);
	}
	
	@Test
	public void update_success(){
		UserService userService = new UserServiceImpl(userRepository);
		
		User user = new User();
		user.setId("0");
		user.setName("SY");
		user.setPassword("123");
		
		userService.update(user);
	}
	
	@Test
	public void delete(){
		UserService userService = new UserServiceImpl(userRepository);
		userService.remove("0");
	}
	
}
