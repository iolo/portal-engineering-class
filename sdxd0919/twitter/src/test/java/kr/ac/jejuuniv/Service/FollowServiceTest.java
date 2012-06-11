package kr.ac.jejuuniv.Service;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import kr.ac.jejuuniv.Model.Follow;
import kr.ac.jejuuniv.Model.User;
import kr.ac.jejuuniv.Repository.FollowRepository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;

@RunWith(MockitoJUnitRunner.class)
public class FollowServiceTest {
	
	@Mock
	private FollowRepository followRepository;

	@Test
	public void getFollowingUser(){
		FollowService followService = new FollowServiceImpl(followRepository);

		when(followRepository.getFollowingUserNumList()).thenAnswer(new Answer<List<Integer>>() {
			public List<Integer> answer(InvocationOnMock invocation){
				List<Integer> users = new ArrayList<Integer>();
				users.add(2);
				users.add(3);
				return users;
			}
		});
		
		List<User> followingUsers = followService.getFollowingUserNum(); 
		
		assertThat(followingUsers.size(), is(2));
	}
	
	@Test
	public void getFolowerUser(){
		FollowService followService = new FollowServiceImpl(followRepository);

		when(followRepository.getFollowerUsers()).thenAnswer(new Answer<List<Integer>>() {
			public List<Integer> answer(InvocationOnMock invocation){
				List<Integer> users = new ArrayList<Integer>();
				users.add(3);
				return users;
			}
		});
		
		List<User> followerUsers = followService.getFollowerUserNum();
		
		assertThat(followerUsers.size(), is(1));
	}
	
	@Test
	public void checkFollowerUser(){
		FollowService followService = new FollowServiceImpl(followRepository);
		
		when(followRepository.getFollowingUserNumList()).thenAnswer(new Answer<List<Integer>>() {
			public List<Integer> answer(InvocationOnMock invocation){
				List<Integer> users = new ArrayList<Integer>();
				users.add(2);
				users.add(3);
				return users;
			}
		});
		
		when(followRepository.getFollowerUsers()).thenAnswer(new Answer<List<Integer>>() {
			public List<Integer> answer(InvocationOnMock invocation){
				List<Integer> users = new ArrayList<Integer>();
				users.add(3);
				return users;
			}
		});
		
		List<Follow> followerLists = followService.checkFollowerUsers();
		
		assertTrue(followerLists.get(0).getState());
		assertFalse(followerLists.get(1).getState());
	}
	
	@Test
	public void getAllUser(){
		FollowService followService = new FollowServiceImpl(followRepository);
		
		List<Follow> allUserLists = followService.checkAllUsers();
		
	}
	
}