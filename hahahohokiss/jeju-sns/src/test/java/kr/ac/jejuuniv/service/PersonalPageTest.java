package kr.ac.jejuuniv.service;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import kr.ac.jejuuniv.model.Tweet;

import org.junit.Test;
import org.mockito.Mock;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;


public class PersonalPageTest {
	
	@Mock
	private TweetRepository tweetRepository;
	
	private PersonalPage personalPage; 
	@Test
	public void testGetList() {
		// user id -> user 에 해당하는 image url, contents id , contents, date
		personalPage = new PersonalPage(tweetRepository);
		List<Tweet> personalList = personalPage.getList("hahahohokiss");
		when(tweetRepository.getPersonalTweet("hahahohokiss")).thenAnswer(new Answer<List<Tweet>>() {
			public List<Tweet> answer(InvocationOnMock invocation) throws Throwable {
				List<Tweet> personalList = new ArrayList<Tweet>();
				Tweet tweet = new Tweet();
				tweet.setUserId("hahahohokiss");
				tweet.setContentId("1");
				tweet.setImageUrl("hahahohokiss-image-url");
				tweet.setContent("report 하는중");
				tweet.setDate("2012-5-24");
				personalList.add(tweet);
				return personalList;
			}
		});
		assertTrue(personalList.size() > 0);
		assertThat(personalList.get(0).getUserId(), is("hahahohokiss"));
	}
}
