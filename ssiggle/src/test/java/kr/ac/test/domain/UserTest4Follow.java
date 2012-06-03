package kr.ac.test.domain;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import kr.ac.jejuuniv.mapper.FolloMapper;
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
public class UserTest4Follow {
	@Mock
	private UserMapper userMapper;
	@Mock
	private FolloMapper followMapper;

	@Before
	public void beforeTest() {
		when(userMapper.selectUserById("sens")).thenAnswer(new Answer<User>() {
			@Override
			public User answer(InvocationOnMock invocation) throws Throwable {
				User user = new User(userMapper);
				user.setId("sens");

				return user;
			}
		});
	}

	@Test(expected = NotFoundUserException.class)
	public void testFollowFail() {
		User user = new User(userMapper).findUserById("sens");
		user.followUserById("abcd");

		User user2 = createUser("dddd");
		user2.followUserById("aaaa");
	}

	@Test(expected = NotFoundUserException.class)
	public void testFollowFail2() {
		User user = createUser("dddd");
		user.setUserMapper(userMapper);
		user.followUserById("sens");
	}

	@Test
	public void testFollowSucess() {
		final List<String> item = new ArrayList<>();

		when(userMapper.selectUserById("kgb")).thenReturn(createUser("kbg"));
		doAnswer(new Answer<Void>() {
			@Override
			public Void answer(InvocationOnMock invocation) throws Throwable {
				item.add((String) invocation.getArguments()[1]);
				return null;
			}
		}).when(followMapper).insertFollow("sens", "kgb");
		when(followMapper.selectFollowById("sens")).thenReturn(item);

		User user = new User(userMapper).findUserById("sens");
		user.setFollowMapper(followMapper);
		user.followUserById("kgb");

		List<String> followingIdList = followMapper.selectFollowById("sens");

		assertThat(followingIdList.size(), is(1));
		assertThat(followingIdList.get(0), is("kgb"));
	}

	private User createUser(String id) {
		User user = new User();
		user.setId(id);
		return user;
	}
}
