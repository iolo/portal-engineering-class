import java.util.ArrayList;
import java.util.List;

import org.hamcrest.CoreMatchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {

	@Mock
	private UserRepository userRepository;
	
	@Test
	public void list_sucsess() {
		//모키토?
		when(userRepository.findAll()).thenAnswer(new Answer<List<User>>() {
		@Override
		public List<User> answer(InvocationOnMock invocation)
				throws Throwable {
			List<User> users = new ArrayList<User>();
			User user = new User();
			user.setId("1");
			user.setName("DreamTheater");
			user.setPassword("1234");
			users.add(user);
			return users;
		}
			
		});
		
		UserService userService = new UserServiceImpl(userRepository);
		List<User> users = userService.list();
		assertTrue(users.size() > 0);
		User user =users.get(0);
		assertThat(user.getId(), is("1"));
		assertThat(user.getName(), is("DreamTheater"));
		assertThat(user.getPassword(), is("1234"));
	}
}
