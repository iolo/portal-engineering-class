package kr.ac.jejuuniv.service;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import kr.ac.jejuuniv.model.Tweet;
import kr.ac.jejuuniv.repository.TweetRepository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;

@RunWith(MockitoJUnitRunner.class)
public class PersonalPageServiceTest {
	
	@Mock
	TweetRepository tweetRepository;
	
	PersonalPageService personalPageService;
	
	@Test
	public void testGetPersonalList() {
		personalPageService = new PersonalPageServiceImpl(tweetRepository);
		List<Tweet> personalList = new ArrayList<Tweet>();
		when(tweetRepository.findByUserId("hahahohokiss")).thenAnswer(new Answer<List<Tweet>>() {
			public List<Tweet> answer(InvocationOnMock invocation) throws Throwable {
				List<Tweet> personalList = new ArrayList<Tweet>();
				Tweet tweet = new Tweet();
				tweet.setUserId("hahahohokiss");
				tweet.setContentId(1);
				tweet.setImageUrl("hahahohokiss-image-url");
				tweet.setDate("2012-5-24");
				personalList.add(tweet);
				return personalList;
			}
		});
		personalList = personalPageService.getPersonalList("hahahohokiss");
		assertTrue(personalList.size() > 0);
		assertThat(personalList.get(0).getUserId(), is("hahahohokiss"));
	}
}