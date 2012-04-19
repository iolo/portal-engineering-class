package kr.ac.jejuuniv.test.service;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import kr.ac.jejuuniv.java.User;
import kr.ac.jejuuniv.java.userrepository.UserRepository;
import kr.ac.jejuuniv.java.userservice.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/root-context.xml")
public class UserServiceTest {

	@Autowired
	private UserService service;

	@Test
	public void springWorkTest() {
		assertThat(service, notNullValue());
	}

	@Test(expected = UserNotFoundException.class)
	public void getFail() {
		UserRepository mockRepository = mock(UserRepository.class);
		when(mockRepository.findUserById("1")).thenAnswer(new Answer<User>() {
			@Override
			public User answer(InvocationOnMock invocation) throws Throwable {
				return null;
			}
		});

		service.setRepository(mockRepository);
		service.getUser("1");
	}

	@Test
	public void getSuccess() {
		UserRepository mockRepository = mock(UserRepository.class);
		when(mockRepository.findUserById("1")).thenReturn(
				new User("1", "양진원", "abcd"));

		service.setRepository(mockRepository);
		User user = service.getUser("1");

		assertThat("1", is(user.getId()));
		assertThat("양진원", is(user.getName()));
		assertThat("abcd", is(user.getPassword()));
	}

	@Test(expected = UserExistException.class)
	public void addFail() {
		String id = "3";

		UserRepository mockRepository = mock(UserRepository.class);
		when(mockRepository.findUserById(id)).thenAnswer(new Answer<User>() {
			public User answer(InvocationOnMock invocation) throws Throwable {
				User user = new User();
				user.setId((String) invocation.getArguments()[0]);
				user.setName("가나다");
				user.setPassword("abcd");

				return user;
			}
		});
		service.setRepository(mockRepository);

		User user = new User();
		user.setId(id);
		user.setName("양진원");
		user.setPassword("1234");

		service.add(user);
	}

	@Test
	public void addSuccsess() {
		UserRepository mockRepository = mock(UserRepository.class);
		service.setRepository(mockRepository);
		final List<User> userList = new ArrayList<>();

		User user = new User();
		user.setId("3");
		user.setName("양진원");
		user.setPassword("abcd");

		doAnswer(new Answer<Void>() {
			public Void answer(InvocationOnMock invocation) throws Throwable {
				User user = (User) invocation.getArguments()[0];
				userList.add(user);
				return null;
			}
		}).when(mockRepository).insertUser(user);

		when(mockRepository.findUserById("3")).thenAnswer(new Answer<User>() {
			@Override
			public User answer(InvocationOnMock invocation) throws Throwable {
				String id = (String) invocation.getArguments()[0];

				for (User user : userList) {
					if (user.getId().equals(id)) {
						return user;
					}
				}

				return null;
			}
		});

		service.add(user);

		User returnUser = service.getUser("3");
		assertThat(user.getId(), is(returnUser.getId()));
		assertThat(user.getName(), is(returnUser.getName()));
		assertThat(user.getPassword(), is(returnUser.getPassword()));
	}

	@Test(expected = UserNotRemoveException.class)
	public void removeFail() {
		UserRepository repository = mock(UserRepository.class);
		service.setRepository(repository);

		final List<User> userList = new ArrayList<>();
		userList.add(new User("1", "가다나", "abc"));
		userList.add(new User("2", "마바사", "def"));
		userList.add(new User("3", "아자차", "ghi"));

		when(repository.findUserById("4")).thenAnswer(new Answer<User>() {
			@Override
			public User answer(InvocationOnMock invocation) throws Throwable {
				for (User user : userList) {
					if (user.getId().equals(
							(String) invocation.getArguments()[0])) {
						return user;
					}
				}

				return null;
			}
		});

		User user = new User("4", "양진원", "bbb");
		service.remove(user);
	}

	@Test(expected = UserNotFoundException.class)
	public void removeSuccess() {
		UserRepository mockRepository = mock(UserRepository.class);
		service.setRepository(mockRepository);

		User target = new User("3", "아자차", "ghi");

		final List<User> userList = new ArrayList<>();
		userList.add(new User("1", "가다나", "abc"));
		userList.add(new User("2", "마바사", "def"));
		userList.add(target);

		when(mockRepository.findUserById(target.getId())).thenAnswer(
				new Answer<User>() {
					@Override
					public User answer(InvocationOnMock invocation)
							throws Throwable {
						for (User user : userList) {
							if (user.getId().equals(
									(String) invocation.getArguments()[0])) {
								return user;
							}
						}

						return null;
					}
				});

		doAnswer(new Answer<Void>() {
			public Void answer(InvocationOnMock invocation) throws Throwable {
				String id = (String) invocation.getArguments()[0];

				for (int i = 0; i < userList.size(); i++) {
					if (userList.get(i).getId().equals(id)) {
						userList.remove(i);
						break;
					}
				}

				return null;
			}
		}).when(mockRepository).deleteUserById(target.getId());

		service.remove(target);
		assertNull(mockRepository.findUserById(target.getId()));
		service.getUser(target.getId());
	}

	@Test(expected = ModifyNotUserExistException.class)
	public void modifyFail() {
		UserRepository mockRepository = mock(UserRepository.class);
		service.setRepository(mockRepository);
		User user = new User("3", "양진원", "abcd");
		service.modify(user);
	}

	@Test
	public void modifySuccess() {
		UserRepository mockRepository = mock(UserRepository.class);
		service.setRepository(mockRepository);

		String id = "3";
		final User preUser = new User(id, "양진원", "abcd");
		final User newUser = new User(id, "고정욱", "abcd");
		when(mockRepository.findUserById(id)).thenReturn(preUser);

		doAnswer(new Answer<Void>() {
			public Void answer(InvocationOnMock invocation) throws Throwable {
				User param = (User) invocation.getArguments()[0];

				preUser.setName(param.getName());
				preUser.setPassword(param.getPassword());

				return null;
			}
		}).when(mockRepository).updateUser(newUser);

		User answerUser = service.getUser(id);

		assertThat(preUser.getId(), is(answerUser.getId()));
		assertThat(preUser.getName(), is(answerUser.getName()));
		assertThat(preUser.getPassword(), is(answerUser.getPassword()));

		service.modify(newUser);
		answerUser = service.getUser(id);

		assertThat(newUser.getId(), is(answerUser.getId()));
		assertThat(newUser.getName(), is(answerUser.getName()));
		assertThat(newUser.getPassword(), is(answerUser.getPassword()));
	}

	@Test(expected = UserEmptyException.class)
	public void listEmptyFail() {
		UserRepository mockRepository = mock(UserRepository.class);
		service.setRepository(mockRepository);

		when(mockRepository.findAllUser()).thenReturn(new ArrayList<User>());

		service.listUser();
	}

	@Test(expected = UserEmptyException.class)
	public void listNullFail() {
		UserRepository mockRepository = mock(UserRepository.class);
		service.setRepository(mockRepository);

		when(mockRepository.findAllUser()).thenReturn(null);

		service.listUser();
	}

	@Test
	public void listSuccess() {
		UserRepository mockRepository = mock(UserRepository.class);
		service.setRepository(mockRepository);

		List<User> users = new ArrayList<>();
		users.add(new User("0", "가나다", "abcd"));
		users.add(new User("1", "라바사", "efgh"));
		users.add(new User("2", "아자차", "ijkl"));

		when(mockRepository.findAllUser()).thenReturn(users);

		List<User> wanted = service.listUser();

		assertEquals(users.size(), wanted.size());
		for (int i = 0; i < users.size(); i++) {
			assertThat(users.get(i).getId(), is(wanted.get(i).getId()));
			assertThat(users.get(i).getName(), is(wanted.get(i).getName()));
			assertThat(users.get(i).getPassword(), is(wanted.get(i)
					.getPassword()));
		}
	}
}