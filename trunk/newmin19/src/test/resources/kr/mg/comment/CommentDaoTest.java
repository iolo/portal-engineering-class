package kr.mg.comment;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import kr.mg.comment.model.Comment;
import kr.mg.comment.repository.CommentDao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value="classpath:spring/servlet-context.xml")
public class CommentDaoTest {
	@Autowired private CommentDao dao;

	@Test
	public void insertTest() {
		Comment comment = new Comment();
		comment.setComment("aaaaaaaaaaaaaa");
		comment.setId("MG");
		comment.setRegdate(new Date());
		comment.setLikeCount(1);
		comment.setUnlikeCount(10);
		
		int affectedRow = dao.insertComment(comment);
		assertEquals(1, affectedRow);
	}

	
	@Test
	public void selectTest() {
		Comment comment = dao.getComment(3);
		assertEquals("MG", comment.getId());
	}
}
