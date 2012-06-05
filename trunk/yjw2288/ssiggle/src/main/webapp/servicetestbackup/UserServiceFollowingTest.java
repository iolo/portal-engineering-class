package kr.ac.test.service;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import static org.mockito.Matchers.*;
import static org.mockito.Mockito.*;
import kr.ac.jejuuniv.mapper.UserMapper;
import kr.ac.jejuuniv.model.User;
import kr.ac.jejuuniv.model.UserImpl;
import kr.ac.jejuuniv.service.UserService;
import kr.ac.jejuuniv.service.impl.UnFollowingUserNotFoundException;
import kr.ac.jejuuniv.service.impl.UserServiceImpl;
import kr.ac.jejuuniv.service.user.FollowingUserNotFoundException;
import kr.ac.jejuuniv.service.user.NotFollowingUserException;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceFollowingTest {
	private UserService userService;

	@Mock
	private UserMapper repository;

	private UserImpl userOne;
	private UserImpl userTwo;
	private UserImpl userThree;

	@Before
	public void beforeTest() {
		userService = new UserServiceImpl();
		userService.setMapper(repository);

		userOne = new UserImpl();
		userTwo = new UserImpl();
		userThree = new UserImpl();

		userOne.setId("aaa");
		userTwo.setId("bbb");
		userThree.setId("ccc");

		when(repository.selectUserById("aaa")).thenAnswer(new Answer<UserImpl>() {
			@Override
			public UserImpl answer(InvocationOnMock invocation) throws Throwable {
				return userOne;
			}
		});
		when(repository.selectUserById("bbb")).thenAnswer(new Answer<UserImpl>() {
			@Override
			public UserImpl answer(InvocationOnMock invocation) throws Throwable {
				return userTwo;
			}
		});
		when(repository.selectUserById("ccc")).thenAnswer(new Answer<UserImpl>() {
			@Override
			public UserImpl answer(InvocationOnMock invocation) throws Throwable {
				return userThree;
			}
		});

		doAnswer(new Answer<Void>() {
			@Override
			public Void answer(InvocationOnMock invocation) throws Throwable {
				saveUser(invocation);
				return null;
			}
		}).when(repository).insertUser((User) anyObject());

		doAnswer(new Answer<Void>() {
			@Override
			public Void answer(InvocationOnMock invocation) throws Throwable {
				saveUser(invocation);
				return null;
			}
		}).when(repository).updateUser((User) anyObject());
	}

	//팔로잉 실패 테스트, 존재하지 않은 유저를 팔로잉 하려고 함
	@Test(expected = FollowingUserNotFoundException.class)
	public void testFollowFail() {
		User user = new UserImpl();
		UserImpl targetUser = new UserImpl();

		user.setId("sens");
		targetUser.setId("aaa");

		userService.followingUser(user, targetUser);
	}

	//팔로잉 성공 테스트
	@Test
	public void testFollowSuccses() {
		UserImpl user = new UserImpl();
		UserImpl targetUser = new UserImpl();

		user.setId("sens");
		targetUser.setId("aaa");

		when(repository.selectUserById("sens")).thenReturn(user);
		when(repository.selectUserById("aaa")).thenReturn(targetUser);

		userService.followingUser(user, targetUser);
		User newUser = userService.findUserById(user.getId());

		boolean flag = false;
		for (User u : newUser.getFollowingUser()) {
			if (u.getId().equals("aaa")) {
				flag = true;
			}
		}

		assertThat(flag, is(true));
		verify(repository).updateUser(user);
	}

	//언팔로잉 실패 테스트, 존재하지 않은 사람을 언팔로잉 하려고 함
	//언팔로잉을 하려고 하는 User 역시 존재하지 않음
	//추후 등록된 User가 등록되지 않은 사람을 언팔로잉 하려 했을 경우의
	//테스트가 필요하면 작성하기로 함.
	@Test(expected = UnFollowingUserNotFoundException.class)
	public void testUnfollowFail() {
		User userOne = new UserImpl();
		userOne.setId("eeee");
		User userTwo = new UserImpl();
		userOne.setId("dddd");

		userService.unFollowingUser(userOne, userTwo);
	}

	//언팔로잉 실패테스트
	//팔로잉 하고 있지 않은 User를 언팔로잉 하려 한 경우
	@Test(expected = NotFollowingUserException.class)
	public void testFollowFailNotFallowing() {
		userService.unFollowingUser(userOne, userTwo);
	}

	//언팔로잉 성공 테스트;
	@Test
	public void testFollowingUserSuccess() {
		User userOne = userService.findUserById("aaa");
		User userTwo = userService.findUserById("bbb");

		userService.followingUser(userOne, userTwo);
		userService.unFollowingUser(userOne, userTwo);

		boolean flag = false;
		for (User u : repository.selectUserById("aaa").getFollowingUser()) {
			if (u.getId().equals(userTwo.getId())) {
				flag = true;
			}
		}

		assertThat(flag, is(false));
	}

	private void saveUser(InvocationOnMock invocation) {
		UserImpl u = (UserImpl) invocation.getArguments()[0];

		switch (u.getId()) {
		case "aaa":
			userOne = u;
		case "bbb":
			userTwo = u;
		case "ccc":
			userThree = u;
		}
	}
}
