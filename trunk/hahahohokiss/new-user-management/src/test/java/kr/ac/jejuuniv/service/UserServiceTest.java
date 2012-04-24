package kr.ac.jejuuniv.service;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;


import java.util.ArrayList;
import java.util.List;

import kr.ac.jejuuniv.model.User;
import kr.ac.jejuuniv.repository.UserRepository;

import org.junit.Test;
import org.mockito.Mock;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class UserServiceTest {
	/*
	 * User List 가져오기
	 * User 추가하기
	 * User 삭제하기
	 * User 수정하기
	 */

	@Mock
	UserRepository userRepository;
	
	UserService userService = new UserServiceImpl(); 
	
	
	@Test
	public void testUserList() {
		// UserList를 가져오고 list 에 값이 있는지, 첫번째 id 가 0인지 확인
		List<User> users = new ArrayList<User>();
		when(userRepository.findAll()).thenAnswer(new Answer<List<User>>() {
			public List<User> answer(InvocationOnMock invocation) throws Throwable {
				List<User> users = new ArrayList<User>();
				User user = new User();
				user.setId("0");
				user.setName("한진수");
				user.setPassword("비밀번호");
				users.add(user);
				return users;
			}
		});
		users = userService.list();
		assertTrue(users.size() > 0);
		assertThat(users.get(0).getId(), is("0"));
	}
}
