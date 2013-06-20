package kr.ac.hyosang.service;

import java.util.List;

import kr.ac.hyosang.model.Comment;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value="classpath:spring/servlet-context.xml")
public class CommentServiceTest {
	
	@Autowired
	private CommentService commentService;
	
	@Test
	public void testGetList() {
		List<Comment> commentList = commentService.getCommentList();
		
		for (Comment comment : commentList) {
			System.out.println("Id:"+comment.getId());
			System.out.println("Comment:"+comment.getComment());
			System.out.println("Password:"+comment.getPassword());
			System.out.println("Regdate:"+comment.getRegdate());
		}
	}

	

}
