package kr.ac.jejuuniv.Service;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import kr.ac.jejuuniv.Model.Tweet;
import kr.ac.jejuuniv.Model.User;
import kr.ac.jejuuniv.Repository.TweetRepository;
import kr.ac.jejuuniv.Repository.UserRepository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;

@RunWith(MockitoJUnitRunner.class)
public class PersonalSnsServiceTest {
	@Mock
	TweetRepository tweetRepository;

	@Mock
	UserRepository userRepository;
	
	//userNum 받아서, name과 user의 tweet 정보 가져오기.
	@Test
	public void findUser(){
		PersonalSnsService personalSnsSerivce = new PersonalSnsServiceImpl(userRepository);
		
		when(userRepository.findByUserNum(1)).thenAnswer(new Answer<User>() {
			public User answer(InvocationOnMock invocation) throws Throwable {
				User user = new User();
				user.setUserNum(Integer.parseInt(invocation.getArguments()[0].toString()));
				user.setName("현소영");
				return user;
			}
		});
		
		User user = personalSnsSerivce.getUser(1);
		
		assertThat(user.getUserNum(), is(1));
		assertThat(user.getName(), is("현소영"));
	}
	
	@Test
	public void findAllTweet(){
		PersonalSnsService personalSnsService = new PersonalSnsServiceImpl(tweetRepository);
		
		when(tweetRepository.findTweetByUserNum(1)).thenAnswer(new Answer<List<Tweet>>() {
			public List<Tweet> answer(InvocationOnMock invocation)
					throws Throwable {
				List<Tweet> tweets = new ArrayList<Tweet>();
				int userNum = Integer.parseInt(invocation.getArguments()[0].toString());
				tweets.add(new Tweet(1, userNum, "1번임", new Date(20120528)));
				tweets.add(new Tweet(2, userNum, "2번임",new Date(20120528)));
				tweets.add(new Tweet(3, userNum, "3번임",new Date(2012529)));
				
				return tweets;
			}
		});
		
		List<Tweet> tweets = personalSnsService.getTweet(1);
		
		assertTrue(tweets.size() == 3);
		assertThat(tweets.get(1).getUserNum(), is(1));
		assertThat(tweets.get(0).getMessage(), is("1번임"));
	
	}
	
	//tweet 삭제
	@Test
	public void deleteTweet(){
		PersonalSnsService personalSnsService = new PersonalSnsServiceImpl(tweetRepository);
		personalSnsService.deleteTweet(1);
	}
	
}
