package kr.mg.comment;

import static org.junit.Assert.*;
import kr.mg.comment.model.Comment;
import kr.mg.comment.model.User;
import kr.mg.comment.repository.CommentDao;
import kr.mg.comment.repository.UserDao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value="classpath:spring/servlet-context.xml")
public class UserDaoTest {
	
	@Autowired private UserDao dao;

	@Test
	public void insertTest() {
		User user = new User();
		user.setId("b3");
		user.setName("MG");
		user.setPassword("1111");
		user.setDescription("first user");
		user.setImage("c://~~~");
		
		int affectedRow = dao.insertUser(user);
		assertEquals(1, affectedRow);
	}

	
	@Test
	public void selectTest() {
		User user = dao.getUser("aaaa");
		assertEquals("MG", user.getName());
	}

}
