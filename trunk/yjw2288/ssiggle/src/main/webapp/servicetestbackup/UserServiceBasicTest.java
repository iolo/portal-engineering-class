package kr.ac.test.service;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import kr.ac.jejuuniv.mapper.UserMapper;
import kr.ac.jejuuniv.model.NotFoundUserException;
import kr.ac.jejuuniv.model.User;
import kr.ac.jejuuniv.model.UserImpl;
import kr.ac.jejuuniv.service.UserService;
import kr.ac.jejuuniv.service.impl.UserServiceImpl;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceBasicTest {
	private UserService userService;

	@Mock
	private UserMapper repository;

	@Before
	public void beforeTest() {
		userService = new UserServiceImpl();
		userService.setMapper(repository);
	}

	// User Find 실패 테스트, 존재하지 않은 User를 find 하려 함
	@Test(expected = NotFoundUserException.class)
	public void testFindUserFail() {
		userService.findUserById("sens");
	}

	// User find 성공 테스트
	@Test
	public void testFindUserSucess() {
		UserImpl user = new UserImpl();
		user.setId("sens");

		when(repository.selectUserById("sens")).thenReturn(user);

		User returnUser = userService.findUserById("sens");
		assertThat(returnUser.getId(), is(user.getId()));
	}

	// User 삽입 성공 테스트
	// 존재하지 않은 User를 save요청으로 넘긴 경우
	@Test
	public void testSaveUserForInsert() {
		final List<UserImpl> userList = new ArrayList<>();
		User user = new UserImpl();
		user.setId("sens");

		doAnswer(new Answer<Void>() {
			@Override
			public Void answer(InvocationOnMock invocation) throws Throwable {
				userList.add((UserImpl) invocation.getArguments()[0]);
				return null;
			}
		}).when(repository).insertUser(user);

		assertThat(userList.size(), is(0));

		userService.saveUser(user);
		assertThat(userList.get(0).getId(), is(user.getId()));
	}

	// User 정보 갱신 성공 테스트
	// 존재하고 있는 User를 save하려고 하면 이전에 있던 정보를 갱신한다.
	@Test
	public void testSaveUSerForUpdate() {
		final UserImpl user = new UserImpl();
		user.setId("sens");
		user.setName("양진원");

		User newUser = new UserImpl();
		newUser.setId("sens");
		newUser.setName("아무거나");

		when(repository.selectUserById("sens")).thenReturn(user);

		doAnswer(new Answer<Void>() {
			@Override
			public Void answer(InvocationOnMock invocation) throws Throwable {
				User paramUser = (User) invocation.getArguments()[0];
				user.setName(paramUser.getName());

				return null;
			}
		}).when(repository).updateUser(newUser);

		userService.saveUser(newUser);
		assertThat(userService.findUserById("sens").getName(), is("아무거나"));
	}

	@Test
	public void testUserList() {
		List<User> value = new ArrayList<>();

		User user1 = new UserImpl();
		user1.setId("abc");
		User user2 = new UserImpl();
		user2.setId("def");
		User user3 = new UserImpl();
		user3.setId("ghi");

		value.add(user1);
		value.add(user2);
		value.add(user3);

		when(repository.selectAllUser()).thenReturn(value);

		List<User> userList = userService.userList();
		assertThat(userList.size(), is(3));

		assertThat(userList.get(0).getId(), is(user1.getId()));
		assertThat(userList.get(1).getId(), is(user2.getId()));
		assertThat(userList.get(2).getId(), is(user3.getId()));
	}
}