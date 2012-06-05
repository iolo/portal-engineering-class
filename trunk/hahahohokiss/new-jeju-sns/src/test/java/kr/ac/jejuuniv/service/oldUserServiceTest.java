//package kr.ac.jejuuniv.service;
//
//import static org.hamcrest.CoreMatchers.is;
//import static org.junit.Assert.assertThat;
//import static org.junit.Assert.assertTrue;
//import static org.mockito.Mockito.when;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import kr.ac.jejuuniv.exception.UserNotFoundException;
//import kr.ac.jejuuniv.model.Follow;
//import kr.ac.jejuuniv.model.User;
//import kr.ac.jejuuniv.repository.FollowRepository;
//import kr.ac.jejuuniv.repository.UserRepository;
//import kr.ac.jejuuniv.service.impl.UserServiceImpl;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.Mock;
//import org.mockito.invocation.InvocationOnMock;
//import org.mockito.runners.MockitoJUnitRunner;
//import org.mockito.stubbing.Answer;
//
//
//@RunWith(MockitoJUnitRunner.class)
//public class UserServiceTest {
//	@Mock
//	UserRepository userRepository;
//	
//	@Mock
//	FollowRepository followRepository;
//	
//	// User ID 로 User 가져오기
//	@Test
//	public void testGetUserByUserIdSuccess() {
//		UserService userService = new UserServiceImpl();
//		userService.setUserRepository(userRepository);
//		
//		when(userRepository.findUserByUserId("hahahohokiss")).thenAnswer(new Answer<User>() {
//			public User answer(InvocationOnMock invocation) throws Throwable {
//				User user = new User();
//				user.setId("hahahohokiss");
//				return user;
//			}
//		});
//		User user = userService.getUserByUserId("hahahohokiss");
//		assertThat(user.getId(), is("hahahohokiss"));
//	}
//	
//	@Test(expected = UserNotFoundException.class)
//	public void testGetUserByUserIdFail() {
//		UserService userService = new UserServiceImpl();
//		userService.setUserRepository(userRepository);
//		when(userRepository.findUserByUserId("hahahohokiss")).thenAnswer(new Answer<User>() {
//			public User answer(InvocationOnMock invocation) throws Throwable {
//				return null;
//			}
//		});
//		userService.getUserByUserId("hahahohokiss");
//	}
//
//	// User Id 로 Password 가져오기 (로그인)
//	@Test
//	public void testGetUserPassword() {
//		UserService userService = new UserServiceImpl();
//		userService.setUserRepository(userRepository);
//		
//		when(userRepository.findPasswordByUserId("hahahohokiss")).thenAnswer(new Answer<String>() {
//			public String answer(InvocationOnMock invocation) throws Throwable {
//				return "hahahohokiss-password";
//			}
//		});
//		String userPassword = userService.getPasswordByUserId("hahahohokiss");
//		assertThat(userPassword, is("hahahohokiss-password"));
//		
//	}
//	
//	
//	// User 추가하기
//	@Test
//	public void testAddUser() {
//		UserService userService = new UserServiceImpl();
//		userService.setUserRepository(userRepository);
//		
//		User user = new User();
//		user.setId("hahahohokiss");
//		user.setPassword("password");
//		user.setName("한진수");
//		user.setExplanation("제주대학교");
//		user.setImageUrl("hahahohokiss-image-url");
//		
//		when(userRepository.insert(user)).thenAnswer(new Answer<User>() {
//			public User answer(InvocationOnMock invocation) throws Throwable {
//				User user = (User)invocation.getArguments()[0];
//				return user;
//			}
//		});
//		when(userRepository.findUserByUserId("hahahohokiss")).thenAnswer(new Answer<User>() {
//			public User answer(InvocationOnMock invocation) throws Throwable {
//				User user = new User();
//				user.setId("hahahohokiss");
//				user.setPassword("password");
//				user.setName("한진수");
//				user.setExplanation("제주대학교");
//				user.setImageUrl("hahahohokiss-image-url");
//				return user;
//			}
//		});
//		userService.add(user);
//		user = userService.getUserByUserId("hahahohokiss");
//		assertThat(user.getId(), is("hahahohokiss"));
//	}
//	
//	
//	// Following 하기
//	@Test
//	public void testRegisterFollowing() {
//		UserService userService = new UserServiceImpl();
//		userService.setFollowRepository(followRepository);
//		when(followRepository.addFollowing("followerUserId", "followingUserId")).thenAnswer(new Answer<Follow>() {
//			public Follow answer(InvocationOnMock invocation) throws Throwable {
//				Follow follow = new Follow();
//				follow.setFollowerUserId((String) invocation.getArguments()[0]);
//				follow.setFollowingUserId((String) invocation.getArguments()[1]);
//				return follow;
//			}
//		});
//
//		String followingUserID = userService.registerFollowing("followerUserId", "followingUserId");
//		assertThat(followingUserID, is("followingUserId"));
//	}
//	
//	@Test
//	public void testGetFollower() {
//		UserService userService = new UserServiceImpl();
//		userService.setFollowRepository(followRepository);
//		userService.setUserRepository(userRepository);
//		
//		when(userService.getFollowersId("hahahohokiss")).thenAnswer(new Answer<List<String>>() {
//			public List<String> answer(InvocationOnMock invocation) throws Throwable {
//				List<String> followersId = new ArrayList<String>();
//				followersId.add("follower_1");
//				followersId.add("follower_2");
//				return followersId;
//			}
//		});
//		
//		when(userRepository.findUserByUserId("follower_1")).thenAnswer(new Answer<User>() {
//			public User answer(InvocationOnMock invocation) throws Throwable {
//				User user = new User();
//				user.setId((String)invocation.getArguments()[0]);
//				return user;
//			}
//		});
//		when(userRepository.findUserByUserId("follower_2")).thenAnswer(new Answer<User>() {
//			public User answer(InvocationOnMock invocation) throws Throwable {
//				User user = new User();
//				user.setId((String)invocation.getArguments()[0]);
//				return user;
//			}
//		});
//		List<User> followers =  userService.getFollower("hahahohokiss");
//		assertThat(followers.get(0).getId(), is("follower_1"));
//		assertThat(followers.get(1).getId(), is("follower_2"));
//	}
//	
//	
//	@Test
//	public void testGetFollowersId() {
//		UserService userService = new UserServiceImpl();
//		userService.setFollowRepository(followRepository);
//		
//		when(followRepository.getFollowerId("hahahohokiss")).thenAnswer(new Answer<List<String>>() {
//			public List<String> answer(InvocationOnMock invocation) throws Throwable {
//				List<String> followersId = new ArrayList<String>();
//				followersId.add("follower_1");
//				followersId.add("follower_2");
//				return followersId;
//			}
//		});
//		when(userRepository.findUserByUserId("follower_1")).thenAnswer(new Answer<User>() {
//			public User answer(InvocationOnMock invocation) throws Throwable {
//				User user = new User();
//				user.setId((String)invocation.getArguments()[0]);
//				return user;
//			}
//			
//		});
//		when(userRepository.findUserByUserId("follower_2")).thenAnswer(new Answer<User>() {
//			public User answer(InvocationOnMock invocation) throws Throwable {
//				User user = new User();
//				user.setId((String)invocation.getArguments()[0]);
//				return user;
//			}
//			
//		});
//		List<String> followersId = userService.getFollowersId("hahahohokiss");
//		assertThat(followersId.get(0), is("follower_1"));
//		assertThat(followersId.get(1), is("follower_2"));
//	}
//	
//	@Test
//	public void testGetFollowingUser() {
//		UserService userService = new UserServiceImpl();
//		userService.setUserRepository(userRepository);
//		userService.setFollowRepository(followRepository);
//		
//		when(followRepository.getFollowingUserId("hahahohokiss")).thenAnswer(new Answer<List<String>>() {
//			public List<String> answer(InvocationOnMock invocation)	throws Throwable {
//				List<String> followingUserId = new ArrayList<String>();
//				followingUserId.add("followingUser_1");
//				followingUserId.add("followingUser_2");
//				return followingUserId;
//			}
//		});
//		when(userRepository.findUserByUserId("followingUser_1")).thenAnswer(new Answer<User>() {
//			public User answer(InvocationOnMock invocation) throws Throwable {
//				User user = new User();
//				user.setId((String)invocation.getArguments()[0]);
//				return user;
//			}
//		});
//		when(userRepository.findUserByUserId("followingUser_2")).thenAnswer(new Answer<User>() {
//			public User answer(InvocationOnMock invocation) throws Throwable {
//				User user = new User();
//				user.setId((String)invocation.getArguments()[0]);
//				return user;
//			}
//		});
//		
//		List<User> followingUser = userService.getFollowingUser("hahahohokiss");
//
//		assertThat(followingUser.get(0).getId(), is("followingUser_1"));
//		assertThat(followingUser.get(1).getId(), is("followingUser_2"));
//	}
//	
//	@Test
//	public void testGetAllUser() {
//		UserService userService = new UserServiceImpl();
//		userService.setUserRepository(userRepository);
//		
//		when(userRepository.findAllUser()).thenAnswer(new Answer<List<User>>() {
//			public List<User> answer(InvocationOnMock invocation) throws Throwable {
//				List<User> userList = new ArrayList<User>();
//				User user = new User();
//				user.setId("hahahohokiss");
//				userList.add(user);
//				return userList;
//			}
//			
//		});
//		
//		List<User> userList = userService.getAllUser();
//		
//		assertTrue(userList.size() > 0);
//		assertThat(userList.get(0).getId(), is("hahahohokiss"));
//	}
//	
//}
