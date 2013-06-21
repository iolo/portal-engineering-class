package kr.bong.replyboard.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.multipart.MultipartResolver;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = "classpath:spring/servlet-context.xml")
public class RatingServiceTest {

	@Autowired
	RatingService ratingService;
	
	@Test
	public void testUpRating() {
		
		int replyNo = 0;
		String id = "kbg8926"; 
		ratingService.upRating(replyNo, id);
	}
}
