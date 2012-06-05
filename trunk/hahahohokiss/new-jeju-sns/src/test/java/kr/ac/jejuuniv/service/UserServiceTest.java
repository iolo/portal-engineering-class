package kr.ac.jejuuniv.service;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;

import kr.ac.jejuuniv.model.Tweet;
import kr.ac.jejuuniv.model.User;
import kr.ac.jejuuniv.repository.UserRepository;
import kr.ac.jejuuniv.service.impl.UserServiceImpl;


@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {
	
	@Mock
	UserRepository userRepository;
	
	@Test
	public void testGetUser() {
		UserService userService = new UserServiceImpl(userRepository);
		when(userRepository.findUserByUserId("hahahohokiss")).thenAnswer(new Answer<User>() {
			public User answer(InvocationOnMock invocation) throws Throwable {
				User user = new User();
				user.setLoginId("hahahohokiss");
				return user;
			}
		});
		User user = userService.getUser("hahahohokiss");
		assertThat(user.getLoginId(), is("hahahohokiss"));
	}
	
	@Test
	public void testGetPassword() {
		UserService userService = new UserServiceImpl(userRepository);
		when(userRepository.findPasswordByUserId("hahahohokiss")).thenAnswer(new Answer<String>() {
			public String answer(InvocationOnMock invocation) throws Throwable {
				return "password";
			}
		});
		String password = userService.getPassword("hahahohokiss");
		assertThat(password, is("password"));
	}
	
	@Test
	public void testGetTweets() {
		UserService userService = new UserServiceImpl(userRepository);
		
		when(userRepository.findTweetByUserId("hahahohokiss")).thenAnswer(new Answer<List<Tweet>>() {
			public List<Tweet> answer(InvocationOnMock invocation) throws Throwable {
				List<Tweet> tweets = new ArrayList<Tweet>();
				User user = new User();
				user.setLoginId("hahahohokiss");
				Tweet tweet = new Tweet();
				tweet.setContents("contents");
				tweet.setUser(user);
				tweets.add(tweet);
				return tweets;
			}
		});
		
		List<Tweet> tweets = userService.getTweets("hahahohokiss");
		assertTrue(tweets.size() > 0);
		assertThat(tweets.get(0).getUser().getLoginId(), is("hahahohokiss"));
	}
	
	@Test
	public void testGetFollowingUser() {
		UserService userService = new UserServiceImpl(userRepository);
		
		when(userRepository.findFollowingUserByUserId("hahahohokiss")).thenAnswer(new Answer<List<User>>() {
			public List<User> answer(InvocationOnMock invocation) throws Throwable {
				List<User> followingUser = new ArrayList<User>();
				User user = new User();
				user.setLoginId("followingUser");
				followingUser.add(user);
				return followingUser;
			}
		});
		
		List<User> following = userService.getFollowingUser("hahahohokiss");
		assertTrue(following.size() > 0);
		assertThat(following.get(0).getLoginId(), is("followingUser"));
	}
	@Test
	public void testGetFollowerUser() {
		UserService userService = new UserServiceImpl(userRepository);
		
		when(userRepository.findFollowerUserByUserId("hahahohokiss")).thenAnswer(new Answer<List<User>>() {
			public List<User> answer(InvocationOnMock invocation) throws Throwable {
				List<User> followingUser = new ArrayList<User>();
				User user = new User();
				user.setLoginId("followerUser");
				followingUser.add(user);
				return followingUser;
			}
		});
		
		List<User> followerUser = userService.getFollowerUser("hahahohokiss");
		assertTrue(followerUser.size() > 0);
		assertThat(followerUser.get(0).getLoginId(), is("followerUser"));
	}
	
	@Test
	public void testGetAllUser() {
		UserService userService = new UserServiceImpl(userRepository);
		
		when(userRepository.findAllUser()).thenAnswer(new Answer<List<User>>() {
			public List<User> answer(InvocationOnMock invocation) throws Throwable {
				List<User> users = new ArrayList<User>();
				User user = new User();
				user.setLoginId("hahahohokiss");
				users.add(user);
				return users;
			}
			
		});
		List<User> users = userService.getAllUser();
		assertTrue(users.size() > 0);
		assertThat(users.get(0).getLoginId(), is("hahahohokiss"));
	}
}
