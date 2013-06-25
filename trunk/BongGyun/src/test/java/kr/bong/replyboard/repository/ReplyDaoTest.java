package kr.bong.replyboard.repository;

import static org.junit.Assert.assertEquals;

import java.util.Date;
import java.util.List;

import kr.bong.replyboard.model.Reply;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 댓글 DAO 기능 테스트
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = "classpath:spring/servlet-context.xml")
public class ReplyDaoTest {

	@Autowired
	private ReplyDao replyDao;

	@Test
	public void testInsertReply() {
		Reply reply = new Reply();
		reply.setId("newmin19");
		reply.setContent("댓글을 달자!");

		int affectedRow = replyDao.insertReply(reply);
		assertEquals(1, affectedRow);
	}
	
	@Test
	public void testDeleteReply() {
		int affectedRow = replyDao.deleteReply(3);
		assertEquals(1, affectedRow);
	}

	@Test
	public void testSelectReply() {
		Reply reply = replyDao.selectReplyByReplyNo(2);
		
		System.out.println("-------select Test------");
		System.out.println(reply.getId() + ":" + reply.getContent() + "-" + reply.getRegiDate());
		
		assertEquals("kbg8926", reply.getId());
	}

	@Test
	public void testSelectReplyList() {
		List<Reply> replyList = replyDao.selectReplyList(0);
		
		System.out.println("-------List Test------");
		for (Reply reply : replyList) {
			System.out.println(reply.getId() + ":" + reply.getContent() + "-" + reply.getRegiDate());
		}
		Assert.assertTrue(replyList.size() > 0);
	}
}
