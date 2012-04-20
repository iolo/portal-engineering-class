package kr.ac.jejunu.kdi;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.HashMap;
import java.util.Map;

import kr.ac.jejunu.kdi.model.User;
import kr.ac.jejunu.kdi.repository.UserRepository;
import kr.ac.jejunu.kdi.service.UserService;
import kr.ac.jejunu.kdi.service.UserServiceimplements;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.mockito.Mockito.*;
import static org.mockito.Matchers.*;
import org.mockito.Mock;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/root-context.xml")
public class UserServiceTest {
	private UserService service = new UserServiceimplements();
	private Map<String, User> users = new HashMap<String, User>();
	@Mock
	private UserRepository repository;
	
	@Before
	public void settingService() {
		prepareRepository();
		setting();
	}
	
	private void setting() {
		User user = new User();
		user.setId("kdi");
		user.setName("kdi0373");
		user.setPasswrod("1234");
		users.put(user.getId(), user);
	}
	private void prepareRepository(){
		repository = mock(UserRepository.class);
		when(repository.findById(anyString())).thenAnswer(new Answer<User>() {

			@Override
			public User answer(InvocationOnMock invocation) throws Throwable {
					return users.get(invocation.getArguments()[0]);
				
			}
		});
		doAnswer(new Answer<Void>() {

			@Override
			public Void answer(InvocationOnMock invocation) throws Throwable {
				User user = (User) invocation.getArguments()[0];
				users.put(user.getId(), user);
				return null;
			}
		}).when(repository).insert(any(User.class));
		service.setUserRepository(repository);
		}
	@Test
	public void testUserGet() {
		User user = service.get("kdi");
		System.out.println(user.getId());
		
		assertNotNull(user);
		assertEquals("kdi0373", user.getName());
		
	}
}
