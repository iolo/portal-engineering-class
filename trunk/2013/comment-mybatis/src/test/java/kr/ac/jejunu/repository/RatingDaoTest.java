package kr.ac.jejunu.repository;

import static org.junit.Assert.*;
import kr.ac.jejunu.model.Rating;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value="classpath:spring/dao-context.xml")
public class RatingDaoTest {
	
	@Autowired private RatingDao ratingDao;

	@Test
	public void add() {
		Rating rating = new Rating();
		rating.setCommentId(1);
		rating.setUserId("testUser");
		
		int affectedRow = ratingDao.addRating(rating);
		assertEquals(1, affectedRow);
	}

}
