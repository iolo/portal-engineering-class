package kr.ac.test.domain;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import kr.ac.jejuuniv.mapper.FollowingMapper;
import kr.ac.jejuuniv.mapper.UserMapper;
import kr.ac.jejuuniv.model.user.*;

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

	@Test(expected = NotFollowingException.class)
	public void testFollowFail3() {
		when(followingMapper.countFollowing("sens", "kgb")).thenReturn(1);
		when(userMapper.selectUserById("kgb")).thenReturn(createUser("kbg"));
		when(userMapper.selectUserById("sens")).thenReturn(createUser("sens"));

		User user = createUser("sens");
		user.followUserById("kgb");
	}

	@Test(expected = NotFollowingException.class)
	public void testFollowFail4() {
		when(userMapper.selectUserById("sens")).thenAnswer(new Answer<User>() {
			@Override
			public User answer(InvocationOnMock invocation) throws Throwable {
				return createUser("sens");
			}
		});

		User user = createUser("sens");
		user.followUserById(user.getId());
	}

	@Test
	public void testFollowSucess() {
		final List<User> item = new ArrayList<>();

		when(userMapper.selectUserById("sens")).thenReturn(createUser("sens"));
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

		List<User> followingIdList = userMapper.selectAllFollowingUser("sens");

		assertThat(followingIdList.size(), is(1));
		assertThat(followingIdList.get(0).getId(), is("kgb"));
	}

	@Test(expected = NotFoundUserException.class)
	public void testUnFollowFail() {
		User user = createUser("sens");
		user.unFollowUserById("abcd");
	}

	@Test(expected = NotFoundUserException.class)
	public void testUnFollowFail2() {
		User user = createUser("abcd");
		user.unFollowUserById("sens");
	}

	@Test(expected = NotUnFollowingException.class)
	public void testUnFollowFail3() {
		when(userMapper.selectUserById("sens")).thenReturn(createUser("sens"));
		when(userMapper.selectUserById("kgb")).thenReturn(createUser("kgb"));
		when(followingMapper.countFollowing("sens", "ksb")).thenReturn(0);

		User user = createUser("sens");
		user.unFollowUserById("kgb");
	}

	@Test(expected = NotUnFollowingException.class)
	public void testUnFollowFail4() {
		when(userMapper.selectUserById("sens")).thenReturn(createUser("sens"));

		User user = createUser("sens");
		user.unFollowUserById("sens");
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

		when(userMapper.selectUserById("sens")).thenReturn(createUser("sens"));
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

		List<User> list = user.followingUserList();

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

	@Test(expected = NotFoundUserException.class)
	public void testUserListMarkFollowFail() {
		List<User> userList = new ArrayList<>();

		User user = createUser("abcd");
		user.markFollowUser(userList);
	}

	@Test
	public void testUserListMark() {
		when(userMapper.selectUserById("sens")).thenAnswer(new Answer<User>() {
			@Override
			public User answer(InvocationOnMock invocation) throws Throwable {
				return createUser("sens");
			}
		});

		when(userMapper.selectAllFollowingUser("sens")).thenAnswer(
				new Answer<List<User>>() {
					@Override
					public List<User> answer(InvocationOnMock invocation)
							throws Throwable {
						List<User> item = new ArrayList<>();
						item.add(createUser("abcd"));
						item.add(createUser("defg"));

						return item;
					}
				});

		List<User> userList = new ArrayList<>();
		userList.add(createUser("abcd"));
		userList.add(createUser("defg"));
		userList.add(createUser("가나다"));
		userList.add(createUser("라마바"));

		User user = createUser("sens");
		List<UserRow> testList = user.markFollowUser(userList);

		assertThat(testList.size(), is(4));
		assertThat(testList.get(0).isFollowing(), is(true));
		assertThat(testList.get(1).isFollowing(), is(true));
		assertThat(testList.get(2).isFollowing(), is(false));
		assertThat(testList.get(3).isFollowing(), is(false));
	}

	private User createUser(String id) {
		User user = new User(userMapper);
		user.setFollowMapper(followingMapper);
		user.setId(id);
		return user;
	}
}