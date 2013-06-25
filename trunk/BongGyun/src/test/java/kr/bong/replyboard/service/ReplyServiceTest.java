package kr.bong.replyboard.service;

import static org.junit.Assert.assertEquals;

import java.util.Date;
import java.util.List;

import kr.bong.replyboard.model.Reply;
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
public class ReplyServiceTest {

	@Autowired
	private ReplyService replyService;

	@Test
	public void testInsertReply() {
		Reply reply = new Reply();
		reply.setId("bbong8926");
		reply.setContent("개발개발 ");
		reply.setRegiDate(new Date());

		int affectedRow = replyService.write(reply);
		assertEquals(1, affectedRow);
	}
	
	@Test
	public void testDeleteReply() {
		int affectedRow = replyService.delete(4);
		assertEquals(1, affectedRow);
	}

	@Test
	public void testSelectReply() {
		Reply reply = replyService.getByReplyNo(2);
		
		System.out.println("-------select Test------");
		System.out.println(reply.getId() + ":" + reply.getContent() + "-" + reply.getRegiDate());
		
		assertEquals("kbg8926", reply.getId());
	}

	@Test
	public void testSelectReplyList() {
		List<Reply> replyList = replyService.getList(1);
		
		System.out.println("-------List Test------");
		for (Reply reply : replyList) {
			System.out.println(reply.getId() + ":" + reply.getContent() + "-" + reply.getRegiDate());
		}
		Assert.assertTrue(replyList.size() > 0);
	}
}
