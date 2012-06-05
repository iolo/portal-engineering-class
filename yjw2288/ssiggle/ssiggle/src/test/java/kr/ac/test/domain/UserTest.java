package kr.ac.test.domain;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import kr.ac.jejuuniv.mapper.UserMapper;
import kr.ac.jejuuniv.model.NotFoundUserException;
import kr.ac.jejuuniv.model.User;
import kr.ac.jejuuniv.model.UserImpl;

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
	User repoUser = new UserImpl(userMapper);

	@Before
	public void beforeTest() {
		repoUser.setId("sens");
		repoUser.setPassword("sens");
		repoUser.setName("양진원");

		when(userMapper.selectUserById("sens")).thenAnswer(new Answer<User>() {
			@Override
			public User answer(InvocationOnMock invocation) throws Throwable {
				User user = new UserImpl(userMapper);

				user.setId("sens");
				user.setName(repoUser.getName());
				user.setPassword(repoUser.getPassword());

				return user;
			}
		});
	}

	@Test(expected = NotFoundUserException.class)
	public void testUserSelectFail() {
		User user = new UserImpl(userMapper);
		user.findUser("abcd", "edef");
	}

	@Test
	public void testUserSelectFailPassword() {
		when(userMapper.selectUserById("sens")).thenAnswer(new Answer<User>() {
			@Override
			public User answer(InvocationOnMock invocation) throws Throwable {
				User user = new UserImpl();

				user.setId("sens");
				user.setPassword("abcd");
				return user;
			}
		});

		User newUser = new UserImpl(userMapper).findUser("sens", "sens");
		assertNull(newUser);
	}

	@Test
	public void testUserSelectSucess() {
		when(userMapper.selectUserById("sens")).thenAnswer(new Answer<User>() {
			@Override
			public User answer(InvocationOnMock invocation) throws Throwable {
				User user = new UserImpl();

				user.setId("sens");
				user.setPassword("sens");
				return user;
			}
		});

		User newUser = new UserImpl(userMapper).findUser("sens", "sens");
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

		User user = new UserImpl(userMapper);
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
		doAnswer(new Answer<Void>() {
			@Override
			public Void answer(InvocationOnMock invocation) throws Throwable {
				User user = (User) invocation.getArguments()[0];

				repoUser.setName(user.getName());
				repoUser.setPassword(user.getPassword());
				repoUser.setName(user.getName());

				return null;
			}
		}).when(userMapper).updateUser((User) anyObject());

		User user = new UserImpl(userMapper).findUser("sens", "sens");
		user.setPassword("abcd");
		user.setName("새이름");
		user.save();

		User newUser = new UserImpl(userMapper).findUser("sens", "abcd");
		assertNotNull(newUser);
		assertThat(newUser.getName(), is("새이름"));
	}
	
	
}