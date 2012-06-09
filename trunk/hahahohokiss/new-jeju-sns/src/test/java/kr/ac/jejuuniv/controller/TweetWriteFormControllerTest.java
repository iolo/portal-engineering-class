package kr.ac.jejuuniv.controller;

import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
public class TweetWriteFormControllerTest {

	TweetWriteFormController tweetWriteFormController;
	
	@Test
	public void testAction() {
		tweetWriteFormController = new TweetWriteFormController();
		String returnViewName = tweetWriteFormController.action();
		assertThat(returnViewName, is("/service/tweetWriteForm"));
	}
}
