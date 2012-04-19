package kr.ac.jejuuniv.service;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import kr.ac.jejuuniv.model.User;
import kr.ac.jejuuniv.repository.UserRepository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;
import org.springframework.dao.DuplicateKeyException;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {
	@Mock
	UserRepository userRepository;

	@Test
	public void testListSuccess() {
		/*
		 * UserList를 가져와서 List 의 size 가 0 이상이면 성공
		 */
		UserService userService = setUserService();
		List<User> users = new ArrayList<User>();
		when(userRepository.findAll()).thenAnswer(new Answer<List<User>>() {
			public List<User> answer(InvocationOnMock invocation)
					throws Throwable {
				List<User> users = new ArrayList<User>();
				User user = setTestUser();

				users.add(user);
				return users;
			}
		});
		users = userService.list();
		assertTrue(users.size() > 0);
		assertThat(users.get(0).getId(), is("0"));
	}
	
	@Test
	public void testGetUserSuccess() {
		/*
		 * id 로 User 를 가져온다. 그 id 의 User 를 가져오면 성공
		 */
		UserService userService = setUserService();
		String id = "0";
		when(userRepository.findById(id)).thenAnswer(new Answer<User>() {
			public User answer(InvocationOnMock invocation) throws Throwable {
				User user = new User();
				user.setId(invocation.getArguments()[0].toString());
				user.setName("한진수");
				user.setPassword("password");
				return user;
			}
		});
		User user = userService.get(id);
		checkUserResult(user);
	}
	
	
	@Test(expected=DataNotFoundException.class)
	public void testGetUserFail() throws DataNotFoundException{
		/*
		 * Id 로 User 를 가져올 때 그 id 의 User 가 없을 때 실패
		 */
		UserService userService = setUserService();
		String id = "0";
		when(userRepository.findById(id)).thenAnswer(new Answer<User>() {
			public User answer(InvocationOnMock invocation) throws Throwable {
				return null;
			}
		});
		userService.get(id);
	}
	

	@Test
	public void testAddUserSuccess() {
		/*
		 * User 를 추가
		 * 추가된 User 를 check 
		 */
		UserService userService = setUserService();
		User user = setTestUser();
		when(userRepository.create(user)).thenAnswer(new Answer<User>() {
			public User answer(InvocationOnMock invocation) throws Throwable {
				return (User) invocation.getArguments()[0];
			}
		});
		user = userService.add(user);

		checkUserResult(user);
	}
	
	
	@Test(expected=DuplicateKeyException.class)
	public void testAddUserFail() {
		/*
		 * id 로 User 를 추가 했을 때 키값 중복 오류 
		 */
		UserService userService = setUserService();
		
		User user = setTestUser();
		
		when(userRepository.create(user)).thenAnswer(new Answer<User>() {
			public User answer(InvocationOnMock invocation) throws Throwable {
				return null;
			}
		});
		userService.add(user);
	}

	
	@Test
	public void testModifyUserSuccess() {
		/*
		 * User 의 값을 수정 할 때 수정 성공
		 */
		UserService userService = setUserService();
		User user = setTestUser();
		when(userRepository.update(user)).thenAnswer(new Answer<User>() {
			public User answer(InvocationOnMock invocation) throws Throwable {
				User user = (User) invocation.getArguments()[0];
				return user;
			}
		});
		user = userService.modify(user);

		checkUserResult(user);
	}

	@Test(expected=DataNotFoundException.class)
	public void testModifyUserFail() {
		/*
		 * User 를 추가 할 때 실패 
		 */
		UserService userService = setUserService();
		User user = setTestUser();
		
		when(userRepository.update(user)).thenAnswer(new Answer<User>() {
			public User answer(InvocationOnMock invocation) throws Throwable {
				return null;
			}
		});
		userService.modify(user);
	}
	
	@Test
	public void testDeleteUser() {
		/* 
		 * User 삭제
		 */
		UserService userService = setUserService();
		userService.remove("0");
	}

	
	private User setTestUser() {
		/*
		 * Test 에 사용할 User 값 설정
		 */
		User user = new User();
		user.setId("0");
		user.setName("한진수");
		user.setPassword("password");
		return user;
	}
	
	private void checkUserResult(User user) {
		/*
		 * User 값 확인을 함
		 */
		assertThat(user.getId(), is("0"));
		assertThat(user.getName(), is("한진수"));
		assertThat(user.getPassword(), is("password"));
	}
	
	private UserService setUserService() {
		/*
		 * Service 를 설정함
		 */
		UserService userService = new UserServiceImpl(userRepository);
		return userService;
	}
}