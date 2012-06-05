package kr.ac.test.service;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import kr.ac.jejuuniv.mapper.SsiggleMapper;
import kr.ac.jejuuniv.mapper.UserMapper;
import kr.ac.jejuuniv.model.User;
import kr.ac.jejuuniv.model.Ssiggle;
import kr.ac.jejuuniv.model.UserImpl;
import kr.ac.jejuuniv.service.SsiggleService;
import kr.ac.jejuuniv.service.impl.SsiggleServiceImpl;
import kr.ac.jejuuniv.service.ssiggle.NotExistSsiggleException;
import kr.ac.jejuuniv.service.ssiggle.NotRemoveSsiggleException;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;

@RunWith(MockitoJUnitRunner.class)
public class SsiggleServiceTest {
	private SsiggleService ssiggleService;

	@Mock
	private SsiggleMapper ssiggleRepository;

	private User user;
	private Ssiggle ssiggle;

	@Before
	public void beforeTest() {
		ssiggleService = new SsiggleServiceImpl();
		ssiggleService.setSsiggleMapper(ssiggleRepository);

		user = new UserImpl();
		user.setId("sens");
		user.setIntroduce("테스트 입니다.");
		user.setName("양진원");
		user.setImage("DefaultUserImage.jpg");

		ssiggle = new Ssiggle();
		ssiggle.setId(0);
		ssiggle.setText("잘 되는가?");
		ssiggle.setTime(new Timestamp(500000000));
		ssiggle.setUser(user.getId());
	}

	// getSsiggle 실패 테스트등록되어 있지 않은 Ssiggle을 얻어내로 고 함
	@Test(expected = NotExistSsiggleException.class)
	public void testGetSsiggleByIdFail() {
		ssiggleService.getSsiggleBy(0);
	}

	// getSsiggle 성공 테스트
	@Test
	public void testgetSsiggleByIdSucess() {
		Timestamp ts = new Timestamp(500000000);
		when(ssiggleRepository.selectSsiggleById(0)).thenReturn(ssiggle);

		Ssiggle ssiggle = ssiggleService.getSsiggleBy(0);
		assertSsiggle(ts, ssiggle);
	}

	// removeSsiggle 실패테스트, 등록되어있지 않은 Ssiggle을 삭제하려함
	@Test(expected = NotRemoveSsiggleException.class)
	public void testSsiggleRemoveByIdFail() {
		ssiggleService.removeSsiggleById(0);
	}

	// removeSsiggle 성공테스트
	@Test(expected = NotExistSsiggleException.class)
	public void testSsiggleRemoveByIdSucess() {
		when(ssiggleRepository.selectSsiggleById(0)).thenAnswer(
				new Answer<Ssiggle>() {
					@Override
					public Ssiggle answer(InvocationOnMock invocation)
							throws Throwable {
						return ssiggle;
					}
				});
		doAnswer(new Answer<Void>() {
			@Override
			public Void answer(InvocationOnMock invocation) throws Throwable {
				ssiggle = null;
				return null;
			}
		}).when(ssiggleRepository).deleteSsiggleById(0);

		ssiggleService.removeSsiggleById(0);
		ssiggleService.getSsiggleBy(0);
	}

	// Ssiggle add 성공 테스트
	@Test
	public void addSsiggleAddSuccess() {
		ssiggle = null;

		Ssiggle s = new Ssiggle();
		s.setId(1);
		s.setText("테스트임");
		s.setTime(new Timestamp(500000));
		s.setUser(user.getId());

		doAnswer(new Answer<Void>() {
			@Override
			public Void answer(InvocationOnMock invocation) throws Throwable {
				ssiggle = (Ssiggle) invocation.getArguments()[0];
				return null;
			}
		}).when(ssiggleRepository).insertSsiggle(s);

		when(ssiggleRepository.selectSsiggleById(1)).thenAnswer(
				new Answer<Ssiggle>() {
					@Override
					public Ssiggle answer(InvocationOnMock invocation)
							throws Throwable {
						return ssiggle;
					}
				});

		ssiggleService.saveSsiggle(s);
		Ssiggle returnS = ssiggleService.getSsiggleBy(s.getId());
		assertSsiggle(s, returnS);
	}

	// Ssiggle 변경 성공 테스트
	@Test
	public void modifySsiggleSaveSuccess() {
		Ssiggle s = new Ssiggle();
		s.setId(0);
		s.setText("다른 Ssiggle 임");
		s.setTime(new Timestamp(500000));
		s.setUser(user.getId());

		when(ssiggleRepository.selectSsiggleById(0)).thenAnswer(
				new Answer<Ssiggle>() {
					@Override
					public Ssiggle answer(InvocationOnMock invocation)
							throws Throwable {
						return ssiggle;
					}
				});

		doAnswer(new Answer<Void>() {
			@Override
			public Void answer(InvocationOnMock invocation) throws Throwable {
				ssiggle = (Ssiggle) invocation.getArguments()[0];
				return null;
			}
		}).when(ssiggleRepository).updateSsiggle(s);

		ssiggleService.saveSsiggle(s);
		assertSsiggle(s, ssiggleService.getSsiggleBy(0));
	}

	// 팔로우의 Ssiggle을 얻어오는 것이 아닌, 내가 쓴 Ssiggle이 잘 읽어지는지에 대한 테스트
	@Test
	public void listSsiggleSucessNoFollow() {
		final Ssiggle ssiggle3 = new Ssiggle();
		ssiggle3.setId(2);
		ssiggle3.setText("이런이런?");
		ssiggle3.setTime(new Timestamp(500000003));
		ssiggle3.setUser(user.getId());

		final Ssiggle ssiggle1 = new Ssiggle();
		ssiggle1.setId(0);
		ssiggle1.setText("잘 되는가?");
		ssiggle1.setTime(new Timestamp(500000000));
		ssiggle1.setUser(user.getId());

		final Ssiggle ssiggle2 = new Ssiggle();
		ssiggle2.setId(1);
		ssiggle2.setText("잘 되는건가?");
		ssiggle2.setTime(new Timestamp(500000002));
		ssiggle2.setUser(user.getId());

		when(ssiggleRepository.selectSsiggleListByUserIdDescTime(user.getId()))
				.thenAnswer(new Answer<List<Ssiggle>>() {
					@Override
					public List<Ssiggle> answer(InvocationOnMock invocation)
							throws Throwable {
						List<Ssiggle> list = new ArrayList<>();

						list.add(ssiggle1);
						list.add(ssiggle2);
						list.add(ssiggle3);

						return list;
					}
				});

		List<Ssiggle> ssiggleList = ssiggleService
				.ssiggleListByUserIdDesTime(user.getId());

		assertThat(ssiggleList.size(), is(3));

		assertThat(ssiggleList.get(0).getId(), is((long) 0));
		assertThat(ssiggleList.get(1).getId(), is((long) 1));
		assertThat(ssiggleList.get(2).getId(), is((long) 2));

		for (Ssiggle s : ssiggleList) {
			System.out.println(s.getTime());
		}
	}

	// 팔로우 한 사람들의 Ssiggle 까지 다 읽어낼 수 있는지 테스트
	@Test
	public void followList() {
		UserImpl userOne = new UserImpl();
		userOne.setId("one");

		UserImpl userTwo = new UserImpl();
		userTwo.setId("two");

		userOne.getFollowingUser().add(userTwo);

		final Ssiggle ssiggle1 = new Ssiggle();
		ssiggle1.setId(0);
		ssiggle1.setText("잘 되는가?");
		ssiggle1.setTime(new Timestamp(500000000));
		ssiggle1.setUser(userOne.getId());

		final Ssiggle ssiggle2 = new Ssiggle();
		ssiggle2.setId(1);
		ssiggle2.setText("잘 되는건가?");
		ssiggle2.setTime(new Timestamp(500000002));
		ssiggle2.setUser(userTwo.getId());

		final Ssiggle ssiggle3 = new Ssiggle();
		ssiggle3.setId(2);
		ssiggle3.setText("이런이런?");
		ssiggle3.setTime(new Timestamp(500000003));
		ssiggle3.setUser(userTwo.getId());

		when(
				ssiggleRepository.selectSsiggleListByUserIdDescTime(userOne
						.getId())).thenAnswer(new Answer<List<Ssiggle>>() {
			@Override
			public List<Ssiggle> answer(InvocationOnMock invocation)
					throws Throwable {
				List<Ssiggle> list = new ArrayList<>();

				list.add(ssiggle1);

				return list;
			}
		});

		when(
				ssiggleRepository.selectSsiggleListByUserIdDescTime(userTwo
						.getId())).thenAnswer(new Answer<List<Ssiggle>>() {
			@Override
			public List<Ssiggle> answer(InvocationOnMock invocation)
					throws Throwable {
				List<Ssiggle> list = new ArrayList<>();

				list.add(ssiggle3);
				list.add(ssiggle2);

				return list;
			}
		});

		UserMapper userRepository = mock(UserMapper.class);
		ssiggleService.setUserMapper(userRepository);
		when(userRepository.selectUserById(userOne.getId()))
				.thenReturn(userOne);

		List<Ssiggle> ssiggleList = ssiggleService
				.ssiggleListFollowingAndUserByUserIdDescTime(userOne.getId());

		assertThat(ssiggleList.size(), is(3));

		assertThat(ssiggleList.get(0).getId(), is((long) 0));
		assertThat(ssiggleList.get(1).getId(), is((long) 1));
		assertThat(ssiggleList.get(2).getId(), is((long) 2));

		for (Ssiggle s : ssiggleList) {
			System.out.println(s.getTime());
		}
	}

	private void assertSsiggle(Timestamp ts, Ssiggle ssiggle) {
		assertThat(ssiggle.getId(), is((long) 0));
		assertThat(ssiggle.getText(), is("잘 되는가?"));
		assertThat(ssiggle.getTime().equals(ts), is(true));
		assertThat(ssiggle.getUser(), is("sens"));
	}

	private void assertSsiggle(Ssiggle one, Ssiggle two) {
		assertThat(one.getId(), is(two.getId()));
		assertThat(one.getText(), is(two.getText()));
		assertThat(one.getTime().equals(two.getTime()), is(true));
		assertThat(one.getUser(), is(two.getUser()));
	}

	// 팔로잉, 언팔로잉에 대한 테스트는 UserServiceFollowingTest로 넘긴다.
}