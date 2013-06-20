package kr.ac.hyosang.repository;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import kr.ac.hyosang.model.Comment;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value="classpath:spring/dao-context.xml")
public class CommentDaoTest {
	
	@Autowired private CommentDao commentDao;

//	@Test
//	public void testSelectOne() {
//		Comment comment = commentDao.getComment(1);
//		assertNotNull(comment);
//	}
//	
//	@Test
//	public void testSaveComment() {
//		Comment comment = new Comment();
//		comment.setComment("테스트 입니다!");
//		comment.setPassword("1234");
//		comment.setRegdate(new Date());
//		
//		int affectedRow = commentDao.saveComment(comment);
//		assertEquals(1, affectedRow);
//	}
	
	@Test
	public void testGetList() {
		List<Comment> commentList = commentDao.getList();
		
		for (Comment comment : commentList) {
			System.out.println("Id:"+comment.getId());
			System.out.println("Comment:"+comment.getComment());
			System.out.println("Password:"+comment.getPassword());
			System.out.println("Regdate:"+comment.getRegdate());
		}
	}

}
