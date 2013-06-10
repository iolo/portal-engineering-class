package kr.ac.jejunu.service;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value="classpath:spring/servlet-context.xml")
public class CommentServiceTest {
	
	@Autowired private CommentService commentService;

	@Test
	public void addLikeCount() {
		System.out.println(commentService);
		commentService.likeComment(1);
		assertTrue(true);
	}

}
