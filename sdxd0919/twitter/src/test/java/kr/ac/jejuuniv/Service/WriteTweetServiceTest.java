package kr.ac.jejuuniv.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

import kr.ac.jejuuniv.Model.Tweet;

import org.junit.Test;

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
