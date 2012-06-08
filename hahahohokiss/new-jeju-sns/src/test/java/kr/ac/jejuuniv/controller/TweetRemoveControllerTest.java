package kr.ac.jejuuniv.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import org.junit.Test;
import org.mockito.Mock;
import org.springframework.mock.web.MockHttpSession;

public class TweetRemoveControllerTest {

	@Mock
	MockHttpSession session;
	
	TweetRemoveController tweetRemoveController;
	
	@Test
	public void testRemoveTweetAction() {
		session = new MockHttpSession();
		tweetRemoveController = new TweetRemoveController();
		int tweetId = 0;
		String returnViewName = tweetRemoveController.removeTweetAction(session, tweetId);
		assertThat(returnViewName, is("redirect:/service/personalSns"));
	}
}
