package kr.ac.jejunu.sj.test;

import java.util.ArrayList;
import java.util.List;

import kr.ac.jejunu.sj.model.User;
import kr.ac.jejunu.sj.repository.UserRepository;
import kr.ac.jejunu.sj.service.UserService;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import static org.mockito.Mockito.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/root-context.xml")
public class UserServiceTest {

	@Autowired
	private UserService userService;
	@Mock
	private UserRepository userRepository;

	private User user;
	private String id;
	private List<User> userList = new ArrayList<User>();

	@Before
	public void Init() {
		userRepository = mock(UserRepository.class);
		doAnswer(new Answer<Void>() {

			@Override
			public Void answer(InvocationOnMock invocation) throws Throwable {
				userList.add((User) invocation.getArguments()[0]);
				return null;
			}
		}).when(userRepository).insert(user);

		doAnswer(new Answer<Void>() {

			@Override
			public Void answer(InvocationOnMock invocation) throws Throwable {
				// TODO: Modify 작성해야됨
				return null;
			}
		}).when(userRepository).update(user);

		doAnswer(new Answer<Void>() {

			@Override
			public Void answer(InvocationOnMock invocation) throws Throwable {
				// TODO: Delete 작성해야 됨
				return null;
			}
		}).when(userRepository).delete(id);

		when(userRepository.findAll()).thenAnswer(new Answer<List<User>>() {

			@Override
			public List<User> answer(InvocationOnMock invocation)
					throws Throwable {
				return userList;
			}
		});
		
		when(userRepository.findById(id)).thenAnswer(new Answer<User>() {

			@Override
			public User answer(InvocationOnMock invocation) throws Throwable {
				// TODO: user 구현하기
				return null;
			}
		});
	}

	@Test
	public void add() {
		userRepository.insert(user);
	}

	@Test
	public void addFail() {
		userRepository.insert(user);
	}

	@Test
	public void modify() {
		userRepository.update(user);

	}

	@Test
	public void modifyFail() {
		userRepository.update(user);
	}

	@Test
	public void delete() {
		userRepository.delete(id);
	}

	@Test
	public void deleteFail() {
		userRepository.delete(id);

	}

	@Test
	public void get() {
		userRepository.findById(id);
	}

	@Test
	public void getFail() {
		userRepository.findById(id);

	}

	@Test
	public void list() {
		userRepository.findAll();
	}

	@Test
	public void listFail() {
		userRepository.findAll();
	}

}
