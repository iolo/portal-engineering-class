package kr.ac.test.domain;

import static org.mockito.Mockito.*;
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
	}
	
	@Test
	public void testFollowSucess() {
		when(userMapper.selectUserById("kbg")).thenAnswer(new Answer<User>() {
			@Override
			public User answer(InvocationOnMock invocation) throws Throwable {
				User user = new User();
				user.setId("kgb");
					
				return user;
			}
		});
		
		User user = new User(userMapper).findUserById("sens");
		user.followUserById("kgb");
	}
}
