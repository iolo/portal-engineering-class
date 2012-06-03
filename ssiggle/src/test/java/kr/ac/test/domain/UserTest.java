package kr.ac.test.domain;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import static org.mockito.Matchers.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import kr.ac.jejuuniv.mapper.UserMapper;
import kr.ac.jejuuniv.model.user.NotFoundUserException;
import kr.ac.jejuuniv.model.user.User;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;

@RunWith(MockitoJUnitRunner.class)
public class UserTest {
	@Mock
	private UserMapper userMapper;
	User repoUser = new User(userMapper);

	@Before
	public void beforeTest() {
		repoUser.setId("sens");
		repoUser.setPassword("sens");
		repoUser.setName("양진원");

		when(userMapper.selectUserById("sens")).thenAnswer(new Answer<User>() {
			@Override
			public User answer(InvocationOnMock invocation) throws Throwable {
				User user = new User(userMapper);

				user.setId("sens");
				user.setName(repoUser.getName());
				user.setPassword(repoUser.getPassword());

				return user;
			}
		});
	}

	@Test
	public void userLogin() {
		assertThat(new User(userMapper).loginValid("sens", "sens"), is(true));
		assertThat(new User(userMapper).loginValid("sens", "senseeee"),
				is(false));
	}

	@Test(expected = NotFoundUserException.class)
	public void testUserSelectFail() {
		new User(userMapper).findUserById("ㄸㄷㄱㅂㅈㄷㄱㅂㅈ");
	}

	@Test
	public void testUserSelectSucess() {
		when(userMapper.selectUserById("sens")).thenAnswer(new Answer<User>() {
			@Override
			public User answer(InvocationOnMock invocation) throws Throwable {
				User user = new User();

				user.setId("sens");
				user.setPassword("sens");

				return user;
			}
		});

		User newUser = new User(userMapper).findUserById("sens");
		assertThat(newUser.getId(), is("sens"));
	}

	@Test
	public void testUserSave4Insert() {
		when(userMapper.selectUserById("sens")).thenReturn(null);

		doAnswer(new Answer<Void>() {
			@Override
			public Void answer(InvocationOnMock invocation) throws Throwable {
				User user = (User) invocation.getArguments()[0];

				repoUser.setId(user.getId());
				repoUser.setName(user.getName());
				repoUser.setPassword(user.getPassword());

				return null;
			}
		}).when(userMapper).insertUser((User) anyObject());

		User user = new User(userMapper);
		user.setId("sens");
		user.setPassword("sens");
		user.setName("가나다라");

		user.save();

		assertThat(repoUser.getId(), is(user.getId()));
		assertThat(repoUser.getPassword(), is(user.getPassword()));
		assertThat(repoUser.getName(), is(user.getName()));
	}

	@Test
	public void testUser4Update() {
		User user = new User(userMapper);
		user.setId("sens");
		user.setPassword("abcd");
		user.setName("새이름");

		doAnswer(new Answer<Void>() {
			@Override
			public Void answer(InvocationOnMock invocation) throws Throwable {
				User user = (User) invocation.getArguments()[0];

				repoUser.setName(user.getName());
				repoUser.setPassword(user.getPassword());
				repoUser.setName(user.getName());

				return null;
			}
		}).when(userMapper).updateUser(user);

		user.save();

		User newUser = repoUser;
		assertNotNull(newUser);
		assertThat(newUser.getName(), is("새이름"));
	}

	@Test
	public void testAllUser() {
		when(userMapper.selectAllUser()).thenAnswer(new Answer<List<User>>() {
			@Override
			public List<User> answer(InvocationOnMock invocation)
					throws Throwable {
				List<User> item = new ArrayList<>();

				User userOne = new User();
				userOne.setId("sens");
				User userTwo = new User();
				userTwo.setId("yjw2288");

				item.add(userOne);
				item.add(userTwo);

				return item;
			}
		});

		User user = new User(userMapper);
		List<User> userlist = user.findAllUser();

		assertThat(userlist.size(), is(2));
		assertThat(userlist.get(0).getId(), is("sens"));
		assertThat(userlist.get(1).getId(), is("yjw2288"));
	}
}