package kr.ac.jejuuniv.Service;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import kr.ac.jejuuniv.Model.Tweet;
import kr.ac.jejuuniv.Repository.TweetRepository;

import org.junit.Test;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

public class WriteTweetServiceTest {
	
	@Test
	public void write(){
		WriteTweetService writeTweetService = new WriteTweetServiceImpl();
		
		Tweet tweet = new Tweet();
		tweet.setSeq(2);
		tweet.setUserNum(1);
		tweet.setMessage("우와와-축제!");
		tweet.setDate(new Date());
		
		writeTweetService.addTweet(tweet);
	}
	
}
