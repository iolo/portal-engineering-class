package kr.bong.replyboard.service;

import kr.bong.replyboard.model.Rating;

import org.junit.Assert;
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
		
		int replyNo = 32;
		String id = "kbg8926"; 
		
		Rating rating = new Rating();
		rating.setId(id);
		rating.setReplyNo(replyNo);
		
		int result = ratingService.upRating(rating);
		
		Assert.assertEquals(result, 1);
	}
	
	@Test
	public void testDownRating() {
		
		int replyNo = 31;
		String id = "kbg8926"; 
		
		Rating rating = new Rating();
		rating.setId(id);
		rating.setReplyNo(replyNo);
		
		int result = ratingService.downRating(rating);
		
		Assert.assertEquals(result, 1);
	}
}
