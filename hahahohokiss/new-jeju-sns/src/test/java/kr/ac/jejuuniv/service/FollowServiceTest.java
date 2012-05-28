package kr.ac.jejuuniv.service;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;
import kr.ac.jejuuniv.model.Follow;
import kr.ac.jejuuniv.repository.FollowRepository;
import kr.ac.jejuuniv.service.impl.FollowServiceImpl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;

@RunWith(MockitoJUnitRunner.class)
public class FollowServiceTest {
	
	FollowService followService;
	
	@Mock
	FollowRepository followRepository;

	@Test
	public void testRegisterFollowing() {
		followService = new FollowServiceImpl(followRepository);

		when(followRepository.addFollowing("followerUserId", "followingUserId")).thenAnswer(new Answer<Follow>() {
			public Follow answer(InvocationOnMock invocation) throws Throwable {
				Follow follow = new Follow();
				follow.setFollowerUserId((String) invocation.getArguments()[0]);
				follow.setFollowingUserId((String) invocation.getArguments()[1]);
				return follow;
			}
		});

		String followingUserID = followService.registerFollowing("followerUserId", "followingUserId");
		assertThat(followingUserID, is("followingUserId"));
	}

	@Test
	public void testRegisterFollower() {
		followService = new FollowServiceImpl(followRepository);
		when(followRepository.addFollower("followingUserId", "followerUserId")).thenAnswer(new Answer<Follow>() {
			public Follow answer(InvocationOnMock invocation) throws Throwable {
				Follow follow = new Follow();
				follow.setFollowerUserId((String)invocation.getArguments()[0]);
				follow.setFollowingUserId((String)invocation.getArguments()[1]);
				return follow; 
			}
		});
		String followerUserId = followService.registerFollower("followingUserId", "followerUserId");
		assertThat(followerUserId, is("followingUserId"));
	}
}
