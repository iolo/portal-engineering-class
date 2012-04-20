package jnu.ce.bs.service;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import jnu.ce.bs.repository.UserRepository;
import jnu.ce.bs.service.User;
import jnu.ce.bs.service.UserService;
import jnu.ce.bs.service.UserServiceImpl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {
	@Mock
	UserRepository userRepository;

	@Test
	public void userFindAllTest() {
		UserService userService = new UserServiceImpl(userRepository);
		List<User> users = new ArrayList<User>();

		when(userRepository.findAll()).thenAnswer(new Answer<List<User>>() {
			public List<User> answer(InvocationOnMock invocation)
					throws Throwable {
				List<User> users = mockDummyRepositoryDataSet();
				return users;
			}
		});
		users = userService.findAll();
		assertNotNull(users);
		assertThat(users.get(0).getId(), is("1"));
		assertThat(users.get(1).getId(), is("2"));
	}

	@Test
	public void indexedIdCehckTest() {

		when(userRepository.indexedIdCheck("1")).thenAnswer(
				new Answer<Object>() {
					public Object answer(InvocationOnMock invocation)
							throws Throwable {
						List<User> users = mockDummyRepositoryDataSet();
						for (User user : users) {
							if (user.getId().equals("1"))
								return true;
						}
						return false;
					}
				});

		assertTrue(userRepository.indexedIdCheck("1"));
	}

	@Test
	public void findUserByIdTest() {
		UserService userService = new UserServiceImpl(userRepository);
		List<User> users = new ArrayList<User>();

		when(userRepository.findById("2")).thenAnswer(new Answer<List<User>>() {
			public List<User> answer(InvocationOnMock invocation)
					throws Throwable {
				List<User> users = mockDummyRepositoryDataSet();
				List<User> foundUser = new ArrayList<User>();
				for (User user : users) {
					if (user.getId().equals("2"))
						foundUser.add(user);
				}

				return foundUser;
			}
		});
		users = userService.get("2");
		assertNotNull(users);
		assertThat(users.get(0).getId(), is("2"));
		assertThat(users.get(0).getName(), is("사람임"));
	}

	@Test
	public void userAddTest() {
		UserService userService = new UserServiceImpl(userRepository);
		List<User> users = new ArrayList<User>();

		final String id;
		final String name;
		final String password;
		id = "3";
		name = "사람";
		password = "멍청이";

		when(userRepository.createUesr(id, name, password)).thenAnswer(
				new Answer<List<User>>() {
					public List<User> answer(InvocationOnMock invocation)
							throws Throwable {
						List<User> users = mockDummyRepositoryDataSet();
						User user = new User();
						user.setId(id);
						user.setName(name);
						user.setPassword(password);
						users.add(user);
						return users;
					}
				});

		users = userService.add(id, name, password);
		assertNotNull(users);
		assertThat(users.get(users.size() - 1).getId(), is(id));
		assertThat(users.get(users.size() - 1).getName(), is(name));
		assertThat(users.get(users.size() - 1).getPassword(), is(password));
	}

	@Test
	public void userDeleteTest() {
		UserService userService = new UserServiceImpl(userRepository);
		List<User> users = new ArrayList<User>();

		when(userRepository.deleteById("1")).thenAnswer(
				new Answer<List<User>>() {
					public List<User> answer(InvocationOnMock invocation)
							throws Throwable {
						List<User> users = mockDummyRepositoryDataSet();
						List<User> deleteUser = new ArrayList<User>();

						for (User user : users) {
							if (user.getId().equals("1")) {
								deleteUser.add(user);
							}
						}

						users.removeAll(deleteUser);

						return users;
					}
				});

		users = userService.delete("1");
		assertNotNull(users);
		assertThat(users.get(0).getId(), is("2"));
		assertThat(users.get(0).getName(), is("사람임"));
	}

	@Test
	public void userModifyTest() {
		UserService userService = new UserServiceImpl(userRepository);
		List<User> users = new ArrayList<User>();
		final String userId;
		final String modifyName;
		final String modifyPassword;
		userId = "1";
		modifyName = "사람";
		modifyPassword = "멍청이";
		
		when(userRepository.modifyById(userId, modifyName, modifyPassword)).thenAnswer(new Answer<List<User>>() {
			public List<User> answer(InvocationOnMock invocation)
					throws Throwable {
				List<User> users = mockDummyRepositoryDataSet();
				
				for (User user : users) {
					if (user.getId().equals(userId)){
						user.setName(modifyName);
						user.setPassword(modifyPassword);
					}
				}

				return users;
			}
		});
		
		users = userService.modify(userId, modifyName, modifyPassword);
		
		assertNotNull(users);
		assertThat(users.get(0).getId(), is(userId));
		assertThat(users.get(0).getName(), is(modifyName));
		assertThat(users.get(0).getPassword(), is(modifyPassword));
	}

	private List<User> mockDummyRepositoryDataSet() {
		List<User> users = new ArrayList<User>();
		User user = new User();
		User user2 = new User();
		user.setId("1");
		user.setName("강우진");
		user.setPassword("비밀번호");
		user2.setId("2");
		user2.setName("사람임");
		user2.setPassword("비번");
		users.add(user);
		users.add(user2);
		return users;
	}
}
