package kr.ac.jejuuniv.Service;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import org.junit.Assert;
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
	public void getAllTweet(){
		List<Tweet> tweets = tweetService.getAllTweet(1);

		System.out.println("--- getAllTweet ---");
		printTweet(tweets);
		
		assertNotNull(tweets);
		assertTrue(tweets.size() > 0);
	}
	
	
	public void printTweet(List<Tweet> tweets) {
		System.out.println("------------------------------------------");
		for (Tweet tweet : tweets) {
			System.out.println(tweet.toString());
		}
		System.out.println("------------------------------------------");
	}

}
