package kr.ac.jejunu.sj.test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import kr.ac.jejunu.sj.model.User;
import kr.ac.jejunu.sj.repository.UserRepository;
import kr.ac.jejunu.sj.service.DuplicateUserException;
import kr.ac.jejunu.sj.service.UserEmptyException;
import kr.ac.jejunu.sj.service.UserNotExistException;
import kr.ac.jejunu.sj.service.UserService;

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
	private UserService userService;
	@Mock
	private UserRepository userRepository;

	private List<User> userList = new ArrayList<User>();

	@Before
	public void init() {

		userRepository = mock(UserRepository.class);

		when(userRepository.findAll()).thenAnswer(new Answer<List<User>>() {

			@Override
			public List<User> answer(InvocationOnMock invocation)
					throws Throwable {
				return userList;
			}
		});

		userService.setRepository(userRepository);

	}

	@Test
	public void userListTest() {
		User user1 = new User();
		user1.setId("1");
		user1.setName("이석준");
		user1.setPassword("1234");

		User user2 = new User();
		user2.setId("2");
		user2.setName("정재훈");
		user2.setPassword("1233");

		userList.add(user1);
		userList.add(user2);

		List<User> answerList = userService.listUser();
		assertEquals(answerList.size(), userList.size());
		for (int i = 0; i < answerList.size(); i++) {
			User listUser = userList.get(i);
			User answerUser = answerList.get(i);

			equalUser(listUser, answerUser);
		}
	}

	private void equalUser(User user, User answerUser) {
		assertEquals(user.getId(), answerUser.getId());
		assertEquals(user.getName(), answerUser.getName());
		assertEquals(user.getPassword(), answerUser.getPassword());
	}

	@Test(expected = UserEmptyException.class)
	public void userListTestFail() {
		userList.clear();
		userService.listUser();
	}

	@Test
	public void getUserTest() {
		userList.clear();

		String id = "1";

		when(userRepository.findById(id)).thenAnswer(new Answer<User>() {
			@Override
			public User answer(InvocationOnMock invocation) throws Throwable {
				for (User user : userList) {
					if (user.getId().equals(
							(String) invocation.getArguments()[0])) {
						return user;
					}
				}
				return null;
			}
		});

		User user = new User();
		user.setId(id);
		user.setName("이석준");
		user.setPassword("1234");

		userList.add(user);

		User answerUser = userService.get(id);
		equalUser(user, answerUser);
	}

	@Test(expected = UserNotExistException.class)
	public void getFail() {
		userList.clear();

		String id = "1";

		when(userRepository.findById(id)).thenAnswer(new Answer<User>() {
			@Override
			public User answer(InvocationOnMock invocation) throws Throwable {
				for (User user : userList) {
					if (user.getId().equals(
							(String) invocation.getArguments()[0])) {
						return user;
					}
				}
				return null;
			}
		});

		User user1 = new User();
		user1.setId("2");
		user1.setName("이석준");
		user1.setPassword("1234");

		User user2 = new User();
		user2.setId("3");
		user2.setName("이석준");
		user2.setPassword("1234");

		User user3 = new User();
		user3.setId("4");
		user3.setName("이석준");
		user3.setPassword("1234");

		userList.add(user1);
		userList.add(user2);
		userList.add(user3);

		userService.get(id);

	}

	@Test
	public void addUserTest() {
		userList.clear();

		String id = "4";
		when(userRepository.findById(id)).thenAnswer(new Answer<User>() {
			@Override
			public User answer(InvocationOnMock invocation) throws Throwable {
				for (User user : userList) {
					if (user.getId().equals(
							(String) invocation.getArguments()[0])) {
						return user;
					}
				}
				return null;
			}
		});

		User user = new User();
		user.setId("5");
		user.setName("이석준");
		user.setPassword("1234");
		userList.add(user);

		doAnswer(new Answer<Void>() {
			@Override
			public Void answer(InvocationOnMock invocation) throws Throwable {
				userList.add((User) invocation.getArguments()[0]);
				return null;
			}
		}).when(userRepository).insert(user);

		userService.addUser(user);
		equalUser(user, userList.get(0));
	}

	@Test(expected = DuplicateUserException.class)
	public void addUserTestFail() {
		userList.clear();
		String id = "4";

		when(userRepository.findById(id)).thenAnswer(new Answer<User>() {
			@Override
			public User answer(InvocationOnMock invocation) throws Throwable {
				for (User user : userList) {
					if (user.getId().equals(
							(String) invocation.getArguments()[0])) {
						return user;
					}
				}
				return null;
			}
		});

		User user = new User();
		user.setId(id);
		user.setName("이석준");
		user.setPassword("1234");
		userList.add(user);

		User newUser = new User();
		newUser.setId("4");
		newUser.setName("석준");
		newUser.setPassword("134");

		userService.addUser(newUser);
	}

	@Test
	public void modify() {
		String id = "4";

		userList.clear();
		User user = new User();
		user.setId(id);
		user.setName("이석준");
		user.setPassword("abcd");
		userList.add(user);

		when(userRepository.findById(id)).thenAnswer(new Answer<User>() {
			@Override
			public User answer(InvocationOnMock invocation) throws Throwable {
				for (User user : userList) {
					if (user.getId().equals(
							(String) invocation.getArguments()[0])) {
						return user;
					}
				}
				return null;
			}
		});

		User user2 = new User();
		user2.setId(id);
		user2.setName("석준");
		user2.setPassword("abcd");

		doAnswer(new Answer<User>() {
			@Override
			public User answer(InvocationOnMock invocation) throws Throwable {
				User newUser = (User) invocation.getArguments()[0];

				for (User user : userList) {
					if (user.getId().equals(newUser.getId())) {
						user.setName(newUser.getName());
						user.setPassword(newUser.getPassword());
					}
				}

				return null;
			}
		}).when(userRepository).update(user2);

		userService.modifyUser(user2);
		equalUser(user2, userList.get(0));
	}
	
	@Test(expected=UserNotExistException.class)
	public void modifyFail() {
		String id = "4";

		when(userRepository.findById(id)).thenReturn(null);

		User user2 = new User();
		user2.setId(id);
		user2.setName("석준");
		user2.setPassword("abcd");

		doAnswer(new Answer<User>() {
			@Override
			public User answer(InvocationOnMock invocation) throws Throwable {
				User newUser = (User) invocation.getArguments()[0];

				for (User user : userList) {
					if (user.getId().equals(newUser.getId())) {
						user.setName(newUser.getName());
						user.setPassword(newUser.getPassword());
					}
				}

				return null;
			}
		}).when(userRepository).update(user2);

		userService.modifyUser(user2);
	}
	
	@Test
	public void deleteTest(){
		String id = "4";

		userList.clear();
		User user = new User();
		user.setId(id);
		user.setName("이석준");
		user.setPassword("abcd");
		userList.add(user);

		when(userRepository.findById(id)).thenReturn(user);
		
		doAnswer(new Answer<User>() {
			@Override
			public User answer(InvocationOnMock invocation) throws Throwable {
				int index = 0;
				
				for(index = 0;index < userList.size();index++){
					if(userList.get(index).getId().equals((String)invocation.getArguments()[0])){
						break;
					}
				}
				
				if(index < userList.size()){
					userList.remove(index);
				}
				
				return null;
			}
		}).when(userRepository).delete(id);
		
		userService.removeById(id);
		
		for(User u:userList){
			if(u.getId().equals(id)){
				assertTrue(false);
				return;
			}
		}
		
		assertTrue(true);
	}

	@Test(expected=UserNotExistException.class)
	public void deleteTestFail(){
		String id = "4";

		userList.clear();
		User user = new User();
		user.setId(id);
		user.setName("이석준");
		user.setPassword("abcd");
		userList.add(user);

		when(userRepository.findById(id)).thenReturn(null);
		
		userService.removeById(id);
	}
}
