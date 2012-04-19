package kr.ac.jejunu.rabbit.test;

import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import kr.ac.jejunu.rabbit.model.User;
import kr.ac.jejunu.rebbit.repository.UserRepository;

import org.apache.taglibs.standard.tag.common.xml.WhenTag;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/root-context.xml")
public class UserServiceTest {
	@Autowired
	private UserServiceTest userservice;
	@Mock
	private UserRepository userRepository;
	private User user;
	private String Id;
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
				// TODO : modify 미구현
				return null;
			}

		}).when(userRepository).update(user);

		doAnswer(new Answer<Void>() {

			@Override
			public Void answer(InvocationOnMock invocation) throws Throwable {
				// TODO : delete 미구현
				return null;
			}

		}).when(userRepository).delete(Id);

		when(userRepository.findAll()).thenAnswer(new Answer<List<User>>() {

			@Override
			public List<User> answer(InvocationOnMock invocation)
					throws Throwable {
				return userList;
			}
		});
		
		when(userRepository.findById(Id)).thenAnswer(new Answer<User>() {

			@Override
			public User answer(InvocationOnMock invocation) throws Throwable {
				//TODO findById 구현
				return null;
			}
		});
	}

	@Test
	public void insert() {
		userRepository.insert(user);
	}

	@Test
	public void insertfail() {
		userRepository.insert(user);
	}

	@Test
	public void modify() {
		userRepository.update(user);
	}

	@Test
	public void modifyfail() {
		userRepository.update(user);
	}

	@Test
	public void delete() {
		userRepository.delete(Id);
	}

	@Test
	public void deleteFail() {
		userRepository.delete(Id);
	}

	@Test
	public void get() {
		userRepository.findById(Id);
	}

	@Test
	public void getFail() {
		userRepository.findById(Id);
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
