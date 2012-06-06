package kr.ac.jejuuniv.Service;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import kr.ac.jejuuniv.Model.Tweet;
import kr.ac.jejuuniv.Repository.TweetRepository;

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
	public void getAllTweet() {
		TweetService tweetService = new TweetServiceImpl(tweetRepository);

		when(tweetRepository.getAllTweet()).thenAnswer(
				new Answer<List<Tweet>>() {
					public List<Tweet> answer(InvocationOnMock invocation)
							throws Throwable {
						List<Tweet> tweets = new ArrayList<Tweet>();
						tweets.add(new Tweet(1, "1번임"));
						tweets.add(new Tweet(2, "2번임"));
						tweets.add(new Tweet(1, "3번임"));

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
						tweets.add(new Tweet(userNum, "1번임"));
						tweets.add(new Tweet(userNum, "2번임"));
						tweets.add(new Tweet(userNum, "3번임"));

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
		
		Tweet tweet = new Tweet(1, "우와와-축제!");
		tweetService.addTweet(tweet);
		
		
		tweet.setDate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		verify(tweetRepository).insert(tweet);

	}

	@Test
	public void deleteTweet() {
		TweetService tweetService = new TweetServiceImpl(tweetRepository);
		tweetService.deleteTweet(1);

		verify(tweetRepository).delete(1);
	}

}
