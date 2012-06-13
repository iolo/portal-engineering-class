package kr.ac.jejuuniv.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import kr.ac.jejuuniv.model.User;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.mock.web.MockHttpSession;

@RunWith(MockitoJUnitRunner.class)
public class TweetRemoveControllerTest extends BaseFormControllerTest {

	TweetRemoveController tweetRemoveController;
	
	@Test
	public void testRemoveTweetAction() {
		tweetRemoveController = new TweetRemoveController(userService);
		session = new MockHttpSession();
		
		User user = new User();
		session.setAttribute("loginUser", user);
		int tweetId = 0;
		String returnViewName = tweetRemoveController.removeTweetAction(session, tweetId);
		assertThat(returnViewName, is("redirect:/service/personalSns"));
	}
}
