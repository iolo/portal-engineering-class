package kr.bong.replyboard.repository;

import static org.junit.Assert.assertEquals;

import java.util.Date;
import java.util.List;

import kr.bong.replyboard.model.Reply;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = "classpath:spring/dao-context.xml")
public class ReplyDaoTest {

	@Autowired
	private ReplyDao replyDao;

	@Test
	public void testInsertReply() {
		Reply reply = new Reply();
		reply.setId("kbg8926");
		reply.setContent("댓글댓글 댓글");
		reply.setRegiDate(new Date());

		int affectedRow = replyDao.insertReply(reply);
		assertEquals(1, affectedRow);
	}

	@Test
	public void testSelectReply() {

		Reply reply = replyDao.selectReplyByReplyNo(1);
		
		System.out.println(reply.getId() + ":" + reply.getContent() + "-" + reply.getRegiDate());
		
		assertEquals("kbg8926", reply.getId());
	}

	@Test
	public void testSelectReplyList() {

		List<Reply> replyList = replyDao.selectReplyList();
		
		for (Reply reply : replyList) {
			System.out.println(reply.getId() + ":" + reply.getContent() + "-" + reply.getRegiDate());
		}
		assertEquals(1, 1);
	}
}
