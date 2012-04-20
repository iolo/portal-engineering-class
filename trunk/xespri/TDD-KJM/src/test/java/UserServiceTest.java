import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.HashMap;
import java.util.Map;

import kr.ac.jejunu.xespri.model.User;
import kr.ac.jejunu.xespri.repository.UserRepository;
import kr.ac.jejunu.xespri.service.UserService;
import kr.ac.jejunu.xespri.service.UserServiceImp;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;


public class UserServiceTest {
	private UserService service = new UserServiceImp();
	private Map<String, User> users = new HashMap<String, User>();
	
	@Mock
	private UserRepository repository;
	
	@Before
	public void settingService(){
		prepareRepository();
		setting();
	}

	private void prepareRepository() {
		repository = mock(UserRepository.class);
		when(repository.findById(anyString())).thenAnswer(new Answer<User>() {

			public User answer(InvocationOnMock invocation) throws Throwable {
				return users.get(invocation.getArguments()[0]);
			}
		});
		doAnswer(new Answer<Void>() {

			public Void answer(InvocationOnMock invocation) throws Throwable {
				User user = (User) invocation.getArguments()[0];
				users.put(user.getId(), user);
				return null;
			}
		}).when(repository).insert(any(User.class));
		service.setRepository(repository);
	}
	
	private void setting(){
		User user = new User();
		user.setId("2009108181");
		user.setName("김정민");
		user.setPassword("1234");
		users.put(user.getId(), user);
	}

	@Test
	public void test() {
		User user = service.get("2009108181");
		
		Assert.assertNotNull(user);
		Assert.assertEquals("김정민", user.getName());
	}

}
