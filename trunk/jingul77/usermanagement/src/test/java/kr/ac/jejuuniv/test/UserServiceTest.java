package kr.ac.jejuuniv.test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import static org.mockito.Mockito.*;
import static org.mockito.Matchers.*;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = "/root-context.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class UserServiceTest {     
	
	UserServiceImpl service = new UserServiceImpl();      
	private Map<String, User> users = new HashMap<String, User>();
	
	@Mock
	private UserRepository repository;
	
	@Before
	public void SettingRepository(){
		setting();
		prepareRepository();
	}
	private void prepareRepository() {
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

		service.setUserRepository(repository);
	}
	
	private void setting() {
		User user = new User();
		user.setId("jingul");
		user.setName("양진걸");
		user.setPassword("1234");
		users.put(user.getId(), user);

		User user2 = new User();
		user2.setId("hahaha");
		user2.setName("연구실");
		user2.setPassword("4321");
		users.put(user2.getId(), user2);
	}

	@Test
	public void findall(){
		List<User> foundUser = service.findAll();
		Assert.assertSame(2, foundUser.size());
		}
	} 
