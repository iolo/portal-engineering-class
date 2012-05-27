package kr.ac.jejuuniv.service;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import kr.ac.jejuuniv.model.Tweet;
import kr.ac.jejuuniv.repository.TweetRepository;
import kr.ac.jejuuniv.service.impl.TweetServiceImpl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;

@RunWith(MockitoJUnitRunner.class)
public class TweetServiceTest {
	
	@Mock
	TweetRepository tweetRepository;
	
	@Test
	public void testGetTweetByUserId() {
		TweetService tweetService = new TweetServiceImpl(tweetRepository);
		when(tweetRepository.findByUserId("hahahohokiss")).thenAnswer(new Answer<List<Tweet>>() {
			public List<Tweet> answer(InvocationOnMock invocation) throws Throwable {
				List<Tweet> tweets = new ArrayList<Tweet>();
				Tweet tweet = new Tweet();
				tweet.setUserId("hahahohokiss");
				tweets.add(tweet);
				return tweets;
			}
		});
		List<Tweet> tweets = tweetService.getTweetByUserId("hahahohokiss");
		assertTrue(tweets.size() > 0);
		assertThat(tweets.get(0).getUserId(), is("hahahohokiss"));
	}
	
	@Test
	public void testSaveTweet() {
		TweetService tweetService = new TweetServiceImpl(tweetRepository);
		Tweet tweet = new Tweet();
		
		when(tweetRepository.save(tweet)).thenAnswer(new Answer<Tweet>() {
			public Tweet answer(InvocationOnMock invocation) throws Throwable {
				Tweet tweet = (Tweet)invocation.getArguments()[0];
				return tweet;
			}
			
		});
		tweet.setUserId("hahahohokiss");
		tweet = tweetService.saveTweet(tweet);
		assertThat(tweet.getUserId(), is("hahahohokiss"));
	}
}
