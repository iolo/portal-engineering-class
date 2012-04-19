package kr.ac.jejunu.rabbit.test;

import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import kr.ac.jejunu.rabbit.model.User;
import kr.ac.jejunu.rabbit.service.UserService;
import kr.ac.jejunu.rebbit.repository.UserRepository;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/root-context.xml")
public class UserServiceTestBak {
	@Autowired
	private UserService userservice;
	@Mock
	private UserRepository userRepository;
	private User user;
	private String Id;
	private List<User> userList = new ArrayList<User>();

	@Before
	public void Init() {
		userRepository = mock(UserRepository.class);
		doAnswer(new Answer<Void>() {

			@Override
			public Void answer(InvocationOnMock invocation) throws Throwable {
				userList.add((User) invocation.getArguments()[0]);
				return null;
			}

		}).when(userRepository).insert(user);

		doAnswer(new Answer<Void>() {

			@Override
			public Void answer(InvocationOnMock invocation) throws Throwable {
				// TODO : modify 미구현
				return null;
			}

		}).when(userRepository).update(user);

		doAnswer(new Answer<Void>() {

			@Override
			public Void answer(InvocationOnMock invocation) throws Throwable {
				// TODO : delete 미구현
				return null;
			}

		}).when(userRepository).delete(Id);

		when(userRepository.findAll()).thenAnswer(new Answer<List<User>>() {

			@Override
			public List<User> answer(InvocationOnMock invocation)
					throws Throwable {
				return userList;
			}
		});

		when(userRepository.findById(Id)).thenAnswer(new Answer<User>() {
			public User answer(InvocationOnMock invocation) throws Throwable {
				// TODO findById 구현
				return null;
			}
		});

		User user = new User();
		user.setId("1");
		user.setName("rabbit");
		user.setPassword("1234");
		userRepository.insert(user);
		user.setId("2");
		user.setName("hunter");
		user.setPassword("5678");
		userRepository.insert(user);
	}

//	@Test
//	public void insert() {
//		userRepository.insert(user);
//	}
//
//	@Test(expected = UserDupleExeption.class)
//	public void insertfail() {
//		userRepository.insert(user);
//	}
//
//	@Test
//	public void modify() {
//		userRepository.update(user);
//	}
//
//	@Test(expected = UserIdDupleExeption.class)
//	public void modifyfail() {
//		userRepository.update(user);
//	}
//
//	@Test
//	public void delete() {
//		userRepository.delete(Id);
//	}
//
//	@Test(expected = DuplicateKeyException.class)
//	public void deleteFail() {
//		userRepository.delete(Id);
//	}
//
//	@Test
//	public void get() {
//		userRepository.findById(Id);
//	}
//
//	@Test()
//	public void getFail() {
//		userRepository.findById(Id);
//	}

	@Test
	public void list() {
		List<User> userList = userRepository.findAll();
		User user = userList.get(0);
		Assert.assertEquals("0", user.getId());
	}

//	@Test(expected = )
//	public void listFail() {
//		userRepository.findAll();
//	}
}
