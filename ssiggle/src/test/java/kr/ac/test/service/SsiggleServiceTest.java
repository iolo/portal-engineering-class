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
						User user = new User(userMapper);
						user.setId((String) invocation.getArguments()[0]);

						return user;
					}
				});

		when(userMapper.selectAllFollowingUser("sens")).thenAnswer(
				new Answer<List<User>>() {
					@Override
					public List<User> answer(InvocationOnMock invocation)
							throws Throwable {
						List<User> item = new ArrayList<>();

						User user = new User(userMapper);
						user.setId("kbg");
						item.add(user);

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

						ssiggle1 = new Ssiggle(ssiggleMapper);
						ssiggle1.setId(1);
						ssiggle1.setTime(new Timestamp(50000));

						ssiggle2 = new Ssiggle(ssiggleMapper);
						ssiggle2.setId(3);
						ssiggle2.setTime(new Timestamp(50003));

						ssiggle3 = new Ssiggle(ssiggleMapper);
						ssiggle3.setId(5);
						ssiggle3.setTime(new Timestamp(50005));

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

						ssiggle1 = new Ssiggle(ssiggleMapper);
						ssiggle1.setId(2);
						ssiggle1.setTime(new Timestamp(50002));

						ssiggle2 = new Ssiggle(ssiggleMapper);
						ssiggle2.setId(4);
						ssiggle2.setTime(new Timestamp(50004));

						item.add(ssiggle2);
						item.add(ssiggle1);

						return item;
					}
				});

		SsiggleService service = new SsiggleServiceImpl();

		User user = new User(userMapper).findUserById("sens");
		List<Ssiggle> list = service.readAllSsiggleByFollowingUser(user,
				new Ssiggle(ssiggleMapper));

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
}
