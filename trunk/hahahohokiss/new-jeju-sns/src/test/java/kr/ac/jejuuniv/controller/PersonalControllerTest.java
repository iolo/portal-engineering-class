package kr.ac.jejuuniv.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import kr.ac.jejuuniv.model.Tweet;
import kr.ac.jejuuniv.model.User;
import kr.ac.jejuuniv.service.UserService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.web.servlet.ModelAndView;

@RunWith(MockitoJUnitRunner.class)
public class PersonalControllerTest {
	
	PersonalController personalController;
	
	@Mock
	UserService userService;
	
	@Mock
	MockHttpSession session;
	
	@Test
	public void testAction() {
		session = new MockHttpSession();
		personalController = new PersonalController(userService);
		User user = new User();
		String userId = "userId";
		user.setLoginId("userId");
		session.setAttribute("loginUser", user);
		when(userService.getTweets(userId)).thenAnswer(new Answer<List<Tweet>>() {
			public List<Tweet> answer(InvocationOnMock invocation) throws Throwable {
				List<Tweet> tweets = new ArrayList<Tweet>();
				Tweet tweet = new Tweet();
				tweets.add(tweet);
 				return tweets;
			}
		});
		ModelAndView returnModelAndView = personalController.action(session);
		String returnViewName = returnModelAndView.getViewName();
		List<Tweet> returnTweets = (List<Tweet>)returnModelAndView.getModel().get("tweets");
		assertThat(returnViewName, is("/service/personalSns"));
		assertTrue(returnTweets.size() > 0);
	}
}
