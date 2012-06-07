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
	/* 
	 * User 가져오기 - 성공
	 * User 갱신 - 성공
	 * Password 가져오기 - 성공
	 * Tweet을 Id로 가져오기 - 성공
	 * Following User 가져오기 - 성공
	 * Follower 가져오기 - 성공
	 * Following 하기 - 성공
	 * Following User Tweet가져오기 - 성공
	 * All User 가져오기 - 성공
	 * Tweet 쓰기 - 성공 
	 * Tweet 삭제 -
	 * User 등록 - 
	*/
	
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
	public void testModifyUser() {
		UserService userService = new UserServiceImpl(userRepository);
		User user = new User();
		user.setUsername("modfiyUser");
		
		when(userRepository.updateUser(user)).thenAnswer(new Answer<User>() {
			public User answer(InvocationOnMock invocation) throws Throwable {
				return (User) invocation.getArguments()[0];
			}
		});
		user = userService.modifyUser(user);
		assertThat(user.getUsername(), is("modfiyUser"));
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
	public void testAddFollow() {
		UserService userService = new UserServiceImpl(userRepository);
		
		User user = new User();
		User following = new User();
		
		userService.addFollow(user.getLoginId(), following.getLoginId());
	}
	
	@Test
	public void testGetFollowingTweet() {
		UserService userService = new UserServiceImpl(userRepository);
		
		when(userRepository.findFollowingUserByUserId("hahahohokiss")).thenAnswer(new Answer<List<User>>() {
			public List<User> answer(InvocationOnMock invocation) throws Throwable {
				List<User> users = new ArrayList<User>();
				User user = new User();
				user.setLoginId("followingUser");
				users.add(user);
				return users;
			}
		});
		
		when(userRepository.findFollowingUserTweetByFollowingUser("hahahohokiss")).thenAnswer(new Answer<List<Tweet>>() {
			public List<Tweet> answer(InvocationOnMock invocation) throws Throwable {
				List<Tweet> tweets = new ArrayList<Tweet>();
				Tweet tweet = new Tweet();
				User user = new User();
				user.setLoginId("followingUser");
				tweet.setUser(user);
				tweets.add(tweet);
				return tweets;
			}
		});
		List<Tweet> followingUserTweets = userService.getFollowingTweet("hahahohokiss");
		assertTrue(followingUserTweets.size() > 0);
		assertThat(followingUserTweets.get(0).getUser().getLoginId(), is("followingUser"));
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
	
	@Test
	public void testAddTweet() {
		UserService userService = new UserServiceImpl(userRepository);
		
		Tweet tweet = new Tweet();
		User user = new User();
		user.setLoginId("hahahohokiss");
		String userId = user.getLoginId();
		tweet.setUser(user);
		
		when(userRepository.insertTweet(userId, tweet)).thenAnswer(new Answer<Tweet>() {
			public Tweet answer(InvocationOnMock invocation) throws Throwable {
				Tweet tweet = (Tweet) invocation.getArguments()[1];
				tweet.getUser().setLoginId(invocation.getArguments()[0].toString());
				return tweet;
			}
		});
		
		tweet = userService.addTweet(userId, tweet);
		assertThat(tweet.getUser().getLoginId(), is("hahahohokiss"));
	}
}
