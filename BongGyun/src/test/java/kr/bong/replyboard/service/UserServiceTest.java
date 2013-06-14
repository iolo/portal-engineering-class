package kr.bong.replyboard.service;

import static org.junit.Assert.assertEquals;

import java.util.Date;
import java.util.List;

import kr.bong.replyboard.model.Reply;
import kr.bong.replyboard.model.User;
import kr.bong.replyboard.repository.ReplyDao;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 댓글 Service 기능 테스트
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = "classpath:spring/servlet-context.xml")
public class UserServiceTest {

	@Autowired
	private UserService userService;

	@Test
	public void testJoin() {
		User user = new User();
		user.setId("newmin19");
		user.setName("김민건");
		user.setDescription("컴퓨터교육과 4학년");
		user.setPassword("1234");

		int affectedRow = userService.join(user);
		assertEquals(1, affectedRow);
	}

	@Test
	public void testModify() {
		User user = new User();
		user.setId("kbg8926");
		user.setName("강봉균");
		user.setDescription("컴퓨터교육과 4학년 0200737001");
		user.setPassword("1234");

		int affectedRow = userService.modify(user);
		assertEquals(1, affectedRow);
	}

	@Test
	public void testGetUser() {
		User user = userService.getUser("kbg8926");
		
		assertEquals("강봉균", user.getName());
		assertEquals("1234", user.getPassword());
		assertEquals("컴퓨터교육과 4학년 0200737001", user.getDescription());
	}

	@Test
	public void testLogin() {
		boolean ok = userService.loginCheck("kbg8926", "1234");
		
		Assert.assertTrue(ok);
	}
}
