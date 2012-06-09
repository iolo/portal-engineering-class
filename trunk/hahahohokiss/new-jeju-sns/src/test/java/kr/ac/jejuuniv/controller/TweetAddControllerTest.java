package kr.ac.jejuuniv.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import kr.ac.jejuuniv.model.User;
import kr.ac.jejuuniv.service.UserService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.mock.web.MockHttpSession;

@RunWith(MockitoJUnitRunner.class)
public class TweetAddControllerTest {
	
	TweetAddController tweetAddController;
	
	@Mock
	UserService userService;
	
	@Mock
	MockHttpSession session;
	
	@Test
	public void testAddTweet() {
		session  = new MockHttpSession();
		tweetAddController = new TweetAddController(userService);
		
		String tweet = "tweet_text";
		
		String url = "localhost:8080/url";
		
		User user = new User();
		user.setLoginId("userId");
		session.setAttribute("loginUser", user);
		
		
		String returnViewName= tweetAddController.addTweetAction(tweet, url, session);
		assertThat(returnViewName, is("redirect:/url"));
		
	
	}
}
