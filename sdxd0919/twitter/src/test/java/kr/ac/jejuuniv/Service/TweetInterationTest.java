package kr.ac.jejuuniv.Service;

import static org.junit.Assert.*;
import java.util.List;

import kr.ac.jejuuniv.Model.Tweet;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/mybatis-context.xml")
public class TweetInterationTest {

	@Autowired
	TweetService tweetService;
	
	@Test
	public void getAllTweetByUserNum(){
		List<Tweet> tweets = tweetService.getAllTweetByUserNum(1);

		System.out.println("--- getAllTweet ---");
		printTweet(tweets);
		
		assertNotNull(tweets);
		assertTrue(tweets.size() > 0);
		assertTrue(tweets.size() == 2);
	}

	@Test
	public void addTweet(){
		Tweet tweet = new Tweet(2, "hi");
		tweetService.addTweet(tweet);
		
		List<Tweet> tweets = tweetService.getAllTweet();
		assertTrue(tweets.size() == 3);

		System.out.println("---- addTweet -----");
		printTweet(tweets);
	}
	
	@Test
	public void deleteTweet(){
		tweetService.deleteTweet(3);
		
		List<Tweet> tweets = tweetService.getAllTweet();
		assertTrue(tweets.size() == 2);
		System.out.println("----- delete -----");
		printTweet(tweets);
	}
	
	public void printTweet(List<Tweet> tweets) {
		System.out.println("------------------------------------------");
		for (Tweet tweet : tweets) {
			System.out.println(tweet.toString());
		}
		System.out.println("------------------------------------------");
	}

}
