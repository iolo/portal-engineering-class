package kr.ac.jejunu.repository;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import kr.ac.jejunu.model.Comment;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value="classpath:spring/dao-context.xml")
public class CommentDaoTest {
	
	@Autowired private CommentDao commentDao;

	@Test
	public void testSelectOne() {
		Comment comment = commentDao.getComment(1);
		assertNotNull(comment);
	}
	
	@Test
	public void testSaveComment() {
		Comment comment = new Comment();
		comment.setComment("포털 서비스 개발론");
		comment.setPassword("1234");
		comment.setRegdate(new Date());
		
		int affectedRow = commentDao.saveComment(comment);
		assertEquals(1, affectedRow);
	}
	
	@Test
	public void testGetList() {
		List<Comment> commentList = commentDao.getList("comment");
		
		for (Comment comment : commentList) {
			System.out.println(comment);
		}
	}

}
