package kr.ac.test.domain;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import kr.ac.jejuuniv.controller.user.NotFollowException;
import kr.ac.jejuuniv.mapper.FollowingMapper;
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
	private FollowingMapper followingMapper;

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
		final List<User> item = new ArrayList<>();

		when(userMapper.selectUserById("kgb")).thenReturn(createUser("kbg"));
		doAnswer(new Answer<Void>() {
			@Override
			public Void answer(InvocationOnMock invocation) throws Throwable {
				item.add(createUser((String) invocation.getArguments()[1]));
				return null;
			}
		}).when(followingMapper).insertFollowing("sens", "kgb");
		when(userMapper.selectAllFollowingUser("sens")).thenReturn(item);

		User user = new User(userMapper).findUserById("sens");
		user.setFollowMapper(followingMapper);
		user.followUserById("kgb");

		List<User> followingIdList = userMapper
				.selectAllFollowingUser("sens");

		assertThat(followingIdList.size(), is(1));
		assertThat(followingIdList.get(0).getId(), is("kgb"));
	}

	@Test(expected = NotFoundUserException.class)
	public void testUnFollowFail() {
		User user = createUser("sens");
		user.unFollowUserById("abcd");
	}

	// TODO : 이런 테스트 할 필요가 있었을까????
	@Test(expected = NotFoundUserException.class)
	public void testUnFollowFail2() {
		User user = createUser("abcd");
		user.unFollowUserById("sens");
	}

	// TODO : 굳이 만들 필요가 있었는가? 또한 이렇게 만드는 것이 맞았을꺄....
	@Test(expected = NotFollowException.class)
	public void testUnFollowFailBecauseNotFollow() {
		when(userMapper.selectUserById("kgb")).thenReturn(createUser("kgb"));
		when(followingMapper.countFollowing("sens", "ksb")).thenReturn(0);

		User user = createUser("sens");
		user.unFollowUserById("kgb");
	}

	@Test
	public void testUnFollowSucess() {
		final List<String> item = new ArrayList<>();
		item.add("kgb");
		doAnswer(new Answer<Void>() {
			@Override
			public Void answer(InvocationOnMock invocation) throws Throwable {
				item.remove(0);
				return null;
			}
		}).when(followingMapper).deleteFollowing("sens", "kgb");

		when(userMapper.selectUserById("kgb")).thenReturn(createUser("kgb"));
		when(followingMapper.countFollowing("sens", "kgb")).thenReturn(1);

		assertThat(item.size(), is(1));
		assertThat(item.get(0), is("kgb"));

		User sens = createUser("sens");
		sens.unFollowUserById("kgb");

		assertThat(item.size(), is(0));
	}

	@Test
	public void testFollowList() {
		User user = createUser("sens");

		when(userMapper.selectAllFollowingUser("sens")).thenAnswer(
				new Answer<List<User>>() {
					@Override
					public List<User> answer(InvocationOnMock invocation)
							throws Throwable {
						List<User> list = new ArrayList<>();

						list.add(createUser("kgb"));
						list.add(createUser("lsj"));

						return list;
					}
				});

		List<User> list = user.followUserList();

		assertThat(list.size(), is(2));
		assertThat(list.get(0).getId(), is("kgb"));
		assertThat(list.get(1).getId(), is("lsj"));
	}

	@Test
	public void testFollowerList() {
		User user = createUser("sens");

		when(userMapper.selectAllFollowerUser("sens")).thenAnswer(
				new Answer<List<User>>() {
					@Override
					public List<User> answer(InvocationOnMock invocation)
							throws Throwable {
						List<User> list = new ArrayList<>();
						list.add(createUser("aaa"));
						list.add(createUser("bbb"));

						return list;
					}
				});

		List<User> followerList = user.followerUserList();

		assertThat(followerList.size(), is(2));
		assertThat(followerList.get(0).getId(), is("aaa"));
		assertThat(followerList.get(1).getId(), is("bbb"));
	}

	private User createUser(String id) {
		User user = new User(userMapper);
		user.setFollowMapper(followingMapper);
		user.setId(id);
		return user;
	}
}
