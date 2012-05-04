package com.jejuuniv.test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import kr.ac.jejununiv.model.User;
import kr.ac.jejuuniv.Repository.UserRepository;
import kr.ac.jejuuniv.Service.UserService;
import kr.ac.jejuuniv.Service.UserServiceImplement;
import static org.hamcrest.CoreMatchers.is;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;


@RunWith(MockitoJUnitRunner.class)
public class TestUserService {
	UserService userService;
	@Mock
	UserRepository userRepository;

	@Test
	public void testList() {

		userService = new UserServiceImplement(userRepository);
		List<User> users = new ArrayList<User>();
		when(userRepository.findAll()).thenAnswer(new Answer<List<User>>() {
			public List<User> answer(InvocationOnMock invocationMock)
					throws Throwable {
				List<User> users = new ArrayList<User>();

				User user = new User();
				user.setId("1");
				user.setName("유대은");
				user.setPassword("1234");

				users.add(user);
				return users;

			}
		});
		users = userService.list();
		assertTrue(users.size() > 0);
	}

	@Test
	public void testGetUserList() {
		userService = new UserServiceImplement(userRepository);

		when(userRepository.findById("1")).thenAnswer(new Answer<User>() {
			public User answer(InvocationOnMock invocation) throws Throwable {
				User user = new User();
				user.setId("1");
				user.setName("������");
				user.setPassword("1234");
				return user;
			}
		});

		User user = userService.findById("1");
		assertThat(user.getId(), is("1"));
		assertThat(user.getName(), is("������"));
		assertThat(user.getPassword(), is("1234"));

	}
	
	
	
	
	@Test
	public void testAddUser(){
		userService = new UserServiceImplement(userRepository);
		User user = new User();
		user.setId("1");
		user.setName("유대은");
		user.setPassword("1234");
		
		userService.userCreate("1", "유대은", "1234");
		assertThat(user.getId(), is("1"));
		assertThat(user.getName(), is("유대은"));
		assertThat(user.getPassword(), is("1234"));
		
		
		
	}
	
	@Test
	public void testDeleteUser(){
		userService = new UserServiceImplement(userRepository);
		User user = new User();
		user.setId("1");
		user.setName("유대은");
		user.setPassword("1234");
		
		
		userService.deleteUserList("1");
		assertThat(user.getId(), is("1"));
		assertThat(user.getName(), is("유대은"));
		assertThat(user.getPassword(), is("1234"));
	}
}
