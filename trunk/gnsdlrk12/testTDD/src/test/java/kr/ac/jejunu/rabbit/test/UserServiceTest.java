package kr.ac.jejunu.rabbit.test;

import static org.junit.Assert.*;
import static org.mockito.Matchers.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.ac.jejunu.rabbit.model.User;
import kr.ac.jejunu.rabbit.repository.UserRepository;
import kr.ac.jejunu.rabbit.repository.UserRepositoryEmptyException;
import kr.ac.jejunu.rabbit.service.DuplicatedUserIdException;
import kr.ac.jejunu.rabbit.service.UserAlreadyDeleteException;
import kr.ac.jejunu.rabbit.service.UserNotFoundException;
import kr.ac.jejunu.rabbit.service.UserService;
import kr.ac.jejunu.rabbit.service.UserServiceImpl;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = "/root-context.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class UserServiceTest {

	private UserService service = new UserServiceImpl();
	private Map<String, User> users = new HashMap<String, User>();

	@Mock
	private UserRepository repository;

	@Before
	public void settingService() {
		prepareMockRepository();
		settingMockRepositoryData();
	}


	private void prepareMockRepository() {
		repository = mock(UserRepository.class);		
		when(repository.findById(anyString())).thenAnswer(new Answer<User>() {
			@Override
			public User answer(InvocationOnMock invocation) throws Throwable {
				return users.get(invocation.getArguments()[0]);
			}
		});
		
		when(repository.findAll()).thenAnswer(new Answer<List<User>>() {
			@Override
			public List<User> answer(InvocationOnMock invocation)
					throws Throwable {
				List<User> foundUser = new ArrayList<User>();
				Collection<User> usersCollection = users.values();
				
				for (User current : usersCollection) {
					foundUser.add(current);
				}
				
				return foundUser;
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

		doAnswer(new Answer<Void>() {
			@Override
			public Void answer(InvocationOnMock invocation) throws Throwable {
				String userId = (String) invocation.getArguments()[0];
				users.remove(userId);
				return null;
			}
		}).when(repository).delete(anyString());
		
		doAnswer(new Answer<Void>() {
			@Override
			public Void answer(InvocationOnMock invocation) throws Throwable {
				User user = (User) invocation.getArguments()[0];
				users.put(user.getId(), user);
				return null;
			}
		}).when(repository).update(any(User.class));
		service.setUserRepository(repository);
	}
	
	private void settingMockRepositoryData() {
		User user = new User("mac", "애플", "abcd");
		users.put(user.getId(), user);

		User user2 = new User("google", "안드로이드", "허니콤");
		users.put(user2.getId(), user2);
	}

	@Test
	public void testUserGet() {
		User user = service.get("mac");

		assertNotNull(user);
		assertEquals("애플", user.getName());
	}

	@Test(expected = UserNotFoundException.class)
	public void testUserGetFail() {
		service.get("mac1");
	}

	@Test
	public void addUserTest() {
		User user = new User("google", "안드로이드", "허니콤");
		service.addUser(user);
	}

	@Test(expected = DuplicatedUserIdException.class)
	public void addUserTestFail() {
		User user = new User("google", "안드로이드", "허니");

		service.addUser(user);
	}

	@Test(expected=UserNotFoundException.class)
	public void deleteTestFail1() {
		service.removeById("google");
		service.get("google");
	}
	
	@Test(expected=UserAlreadyDeleteException.class)
	public void deleteTestFail2() {
		service.removeById("google");
		service.removeById("google");
	}
	
	@Test
	public void deleteTest() {
		service.removeById("google");
	}
	
	@Test
	public void modifyTest() {
		User user = new User("google", "야인시대", "1234");
		
		service.modifyUser(user);
		
		user = service.get("google");
		assertEquals("야인시대", user.getName());
	}
	
	@Test(expected=UserNotFoundException.class)
	public void modifyFailTest() {
		User user = new User("google2", "야인시대", "1234");
		
		service.modifyUser(user);
	}
	
	@Test
	public void findAllTest() {
		List<User> foundUsers = service.list();
		assertSame(2, foundUsers.size());
	}
	
	@Test(expected=UserRepositoryEmptyException.class)
	public void findAllFailTest() {
		users.clear();
		service.list();
	}
}