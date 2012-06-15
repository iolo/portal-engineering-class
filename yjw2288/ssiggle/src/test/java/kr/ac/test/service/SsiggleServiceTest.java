package kr.ac.test.service;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import static org.mockito.Matchers.*;
import static org.mockito.Mockito.*;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import kr.ac.jejuuniv.mapper.SsiggleMapper;
import kr.ac.jejuuniv.mapper.UserMapper;
import kr.ac.jejuuniv.model.ssiggle.Ssiggle;
import kr.ac.jejuuniv.model.user.User;
import kr.ac.jejuuniv.service.SsiggleService;
import kr.ac.jejuuniv.service.SsiggleServiceImpl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;

@RunWith(MockitoJUnitRunner.class)
public class SsiggleServiceTest {
	@Mock
	private SsiggleMapper ssiggleMapper;
	@Mock
	private UserMapper userMapper;

	@Test
	public void testSsiggle() {
		when(userMapper.selectUserById(anyString())).thenAnswer(
				new Answer<User>() {
					@Override
					public User answer(InvocationOnMock invocation)
							throws Throwable {
						return createUser((String) invocation.getArguments()[0]);
					}
				});

		when(userMapper.selectAllFollowingUser("sens")).thenAnswer(
				new Answer<List<User>>() {
					@Override
					public List<User> answer(InvocationOnMock invocation)
							throws Throwable {
						List<User> item = new ArrayList<>();
						item.add(createUser("kbg"));
						
						return item;
					}
				});

		when(ssiggleMapper.selectSsiggleListByUserIdDescTime("sens"))
				.thenAnswer(new Answer<List<Ssiggle>>() {
					@Override
					public List<Ssiggle> answer(InvocationOnMock invocation)
							throws Throwable {
						List<Ssiggle> item = new ArrayList<>();

						Ssiggle ssiggle1, ssiggle2, ssiggle3;

						ssiggle3 = createSsiggle(5, 50005);
						ssiggle2 = createSsiggle(3, 50003);
						ssiggle1 = createSsiggle(1, 50001);

						item.add(ssiggle3);
						item.add(ssiggle2);
						item.add(ssiggle1);

						return item;
					}
				});

		when(ssiggleMapper.selectSsiggleListByUserIdDescTime("kbg"))
				.thenAnswer(new Answer<List<Ssiggle>>() {
					@Override
					public List<Ssiggle> answer(InvocationOnMock invocation)
							throws Throwable {
						List<Ssiggle> item = new ArrayList<>();

						Ssiggle ssiggle1, ssiggle2;

						ssiggle2 = createSsiggle(4, 50004);
						ssiggle1 = createSsiggle(2, 50002);

						item.add(ssiggle2);
						item.add(ssiggle1);

						return item;
					}
				});

		SsiggleService service = new SsiggleServiceImpl();

		Ssiggle s = new Ssiggle(ssiggleMapper);
		s.setUserMapper(userMapper);
		
		User user = new User(userMapper).findUserById("sens");
		List<Ssiggle> list = service.readAllSsiggleByFollowingUser(user,
				s);

		assertThat(list.size(), is(5));
		for (int i = 0; i < 5; i++) {
			assertThat(list.get(i).getId(), is(5L - i));
		}

		for (int i = 0; i < 4; i++) {
			assertThat(
					list.get(i).getTime().compareTo(list.get(i + 1).getTime()) > 0,
					is(true));
		}
	}

	private User createUser(String id) {
		User user = new User(userMapper);
		user.setId(id);
		return user;
	}

	private Ssiggle createSsiggle(long id, long time) {
		Ssiggle ssiggle1;
		ssiggle1 = new Ssiggle(ssiggleMapper);
		ssiggle1.setId(id);
		ssiggle1.setTime(new Timestamp(time));
		return ssiggle1;
	}
}
