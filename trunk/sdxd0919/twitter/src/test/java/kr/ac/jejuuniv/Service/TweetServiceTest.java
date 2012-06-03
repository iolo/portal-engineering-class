package kr.ac.jejuuniv.Service;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import kr.ac.jejuuniv.Model.Tweet;
import kr.ac.jejuuniv.Repository.TweetRepository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(MockitoJUnitRunner.class)
public class TweetServiceTest {
	@Mock
	TweetRepository tweetRepository;

	@Test
	public void getAllTweet() {
		TweetService tweetService = new TweetServiceImpl(tweetRepository);

		when(tweetRepository.getAllTweet()).thenAnswer(
				new Answer<List<Tweet>>() {
					public List<Tweet> answer(InvocationOnMock invocation)
							throws Throwable {
						List<Tweet> tweets = new ArrayList<Tweet>();
						tweets.add(new Tweet(1, "1번임", new Date(
								20120528)));
						tweets.add(new Tweet(2, "2번임", new Date(
								20120528)));
						tweets.add(new Tweet(1, "3번임", new Date(
								2012529)));

						return tweets;
					}
				});

		List<Tweet> tweets = tweetService.getAllTweet();

		assertTrue(tweets.size() == 3);
	}

	@Test
	public void findAllTweetByUserNum() {
		TweetService tweetService = new TweetServiceImpl(tweetRepository);

		when(tweetRepository.findTweetByUserNum(1)).thenAnswer(
				new Answer<List<Tweet>>() {
					public List<Tweet> answer(InvocationOnMock invocation)
							throws Throwable {
						List<Tweet> tweets = new ArrayList<Tweet>();
						int userNum = Integer.parseInt(invocation
								.getArguments()[0].toString());
						tweets.add(new Tweet(userNum, "1번임", new Date(
								20120528)));
						tweets.add(new Tweet(userNum, "2번임", new Date(
								20120528)));
						tweets.add(new Tweet(userNum, "3번임", new Date(
								2012529)));

						return tweets;
					}
				});

		List<Tweet> tweets = tweetService.getAllTweetByUserNum(1);

		assertTrue(tweets.size() == 3);
		assertThat(tweets.get(1).getUserNum(), is(1));
		assertThat(tweets.get(0).getMessage(), is("1번임"));

	}

	@Test
	public void write() {
		TweetService tweetService = new TweetServiceImpl(tweetRepository);

		Tweet tweet = new Tweet();
		tweet.setUserNum(1);
		tweet.setMessage("우와와-축제!");
		tweet.setDate(new Date());

		tweetService.addTweet(tweet);

		verify(tweetRepository).insert(tweet);
	}

	@Test
	public void deleteTweet() {
		TweetService tweetService = new TweetServiceImpl(tweetRepository);
		tweetService.deleteTweet(1);

		verify(tweetRepository).delete(1);
	}

}
