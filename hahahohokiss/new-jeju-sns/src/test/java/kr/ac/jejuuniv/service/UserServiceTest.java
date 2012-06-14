package kr.ac.jejuuniv.service;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import kr.ac.jejuuniv.exception.SignupException;
import kr.ac.jejuuniv.exception.UserNotFoundException;
import kr.ac.jejuuniv.model.Tweet;
import kr.ac.jejuuniv.model.User;
import kr.ac.jejuuniv.repository.UserDao;
import kr.ac.jejuuniv.service.impl.UserServiceImpl;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;


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
	 * Tweet 삭제 - 성공
	 * User 등록 - 성공
	 * unfollowing
	*/
	@Mock
	MockMultipartFile file;
	
	@Mock
	UserDao userRepository;
	
	UserService userService;
	
	@Before
	public void setUserService() {
		userService = new UserServiceImpl(userRepository);
	}
	
	@Test
	public void testGetUserSuccess() {
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
	
	@Test(expected=UserNotFoundException.class)
	public void testGetUserFail() {
		when(userRepository.findUserByUserId("unknow")).thenAnswer(new Answer<User>() {
			public User answer(InvocationOnMock invocation) throws Throwable {
				return null;
			}
		});
		User user = userService.getUser("unknow");
	}
	
	@Test
	public void testModifyUserSuccess() {
		User user = new User();
		user.setLoginId("hahahohokiss");
		user.setUsername("changeUsername");
		when(userRepository.findUserByUserId("hahahohokiss")).thenAnswer(new Answer<User>() {
			public User answer(InvocationOnMock invocation) throws Throwable {
				User user = new User();
				user.setLoginId((String)invocation.getArguments()[0]);
				return user;
			}
		});
		
		when(userRepository.updateUser(user)).thenAnswer(new Answer<User>() {
			public User answer(InvocationOnMock invocation) throws Throwable {
				return (User) invocation.getArguments()[0];
			}
		});
		
		
		user = userService.modifyUser(user);
		assertThat(user.getLoginId(), is("hahahohokiss"));
		assertThat(user.getUsername(), is("changeUsername"));
	}
	
	@Test(expected=UserNotFoundException.class)
	public void testModifyUserFail() {
		User user = new User();
		user.setLoginId("hahahohokiss");
		
		when(userRepository.findUserByUserId("hahahohokiss")).thenAnswer(new Answer<User>() {
			public User answer(InvocationOnMock invocation) throws Throwable {
				return null;
			}
		});
		
		userService.modifyUser(user);
	}
	
	@Test
	public void testGetPassword() {
		when(userRepository.findUserByUserId("hahahohokiss")).thenAnswer(new Answer<User>() {
			public User answer(InvocationOnMock invocation) throws Throwable {
				User user = new User();
				user.setLoginId((String)invocation.getArguments()[0]);
				return user;
			}
			
		});
		
		when(userRepository.findPasswordByUserId("hahahohokiss")).thenAnswer(new Answer<String>() {
			public String answer(InvocationOnMock invocation) throws Throwable {
				return "password";
			}
		});
		assertThat(userService.getPassword("hahahohokiss"), is("password"));
	}
	
	@Test(expected=UserNotFoundException.class)
	public void testGetPasswordFail() {
		when(userRepository.findUserByUserId("hahahohokiss")).thenAnswer(new Answer<User>() {
			public User answer(InvocationOnMock invocation) throws Throwable {
				return null;
			}
		});
		userService.getPassword("hahahohokiss");
	}
	
	@Test
	public void testGetTweets() {
		
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
		
		when(userRepository.findFollowerUserByUserId("hahahohokiss")).thenAnswer(new Answer<List<User>>() {
			public List<User> answer(InvocationOnMock invocation) throws Throwable {
				List<User> followingUser = new ArrayList<User>();
				User user = new User();
				user.setLoginId("followerUser");
				followingUser.add(user);
				return followingUser;
			}
		});
		
		List<UserDto> followerUser = userService.getFollowerUser("hahahohokiss");
		assertTrue(followerUser.size() > 0);
		assertThat(followerUser.get(0).getUser().getLoginId(), is("followerUser"));
	}

	@Test
	public void testAddFollow() {
		
		User user = new User();
		User following = new User();
		
		userService.addFollow(user.getLoginId(), following.getLoginId());
	}
	
	@Test
	public void testGetFollowingTweet() {
		
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
		
		when(userRepository.findAllUser()).thenAnswer(new Answer<List<User>>() {
			public List<User> answer(InvocationOnMock invocation) throws Throwable {
				List<User> users = new ArrayList<User>();
				User user = new User();
				user.setLoginId("hahahohokiss");
				users.add(user);
				User user1 = new User();
				user1.setLoginId("followingUser");
				users.add(user1);
				
				return users;
			}
		});
		when(userRepository.findFollowingUserByUserId("hahahohokiss")).thenAnswer(new Answer<List<User>>() {
			public List<User> answer(InvocationOnMock invocation) throws Throwable {
				List<User> users = new ArrayList<User>();
				User user = new User();
				user.setLoginId("followingUser");
				users.add(user);
				return users;
			}
		});
		String userId = "hahahohokiss";
		
		List<UserDto> users = userService.getAllUser(userId);
		assertTrue(users.size() > 0);
		assertThat(users.get(0).getUser().getLoginId(), is("followingUser"));
	}
	
	@Test
	public void testAddTweet() {
		
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
	
	@Test
	public void testRemoveTweet() {
		User user = new User();
		Tweet tweet = new Tweet();
		String userId = user.getLoginId();
		int tweetId = tweet.getTweetId();
		userService.removeTweet(userId, tweetId);
	}
	
	@Test
	public void tsetAddUser() throws IOException {
		User user = new User();
		user.setLoginId("hahahohokiss");
		user.setPassword("password");
		user.setUsername("한진수");
		
		when(userRepository.insertUser(user, file)).thenAnswer(new Answer<User>() {
			public User answer(InvocationOnMock invocation) throws Throwable {
				return (User) invocation.getArguments()[0];
			}
		});
		user = userService.addUser(user, file);
		assertThat(user.getLoginId(), is("hahahohokiss"));
	}
	
	@Test(expected=SignupException.class)
	public void testAddUserFail() throws IOException {
		User user = new User();
		user.setLoginId("hahahohokiss");
		user.setPassword("password");
		user.setUsername("");
		user = userService.addUser(user, file);
	}
	
	@Test
	public void testUnFollow() {
		User user = new User();
		User followingUser = new User();
		userService.removeFollow(user.getLoginId(), followingUser.getLoginId());
	}
}
