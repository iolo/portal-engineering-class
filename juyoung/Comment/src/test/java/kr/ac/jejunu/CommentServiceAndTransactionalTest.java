package kr.ac.jejunu;

import java.util.Date;
import java.util.List;

import javax.crypto.spec.OAEPParameterSpec;

import kr.ac.jejunu.model.Comment;
import kr.ac.jejunu.model.IndexList;
import kr.ac.jejunu.model.UserInfo;
import kr.ac.jejunu.repositry.CommentService;
import kr.ac.jejunu.repositry.SqlMapper;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = "classpath:spring/servlet-context.xml")
public class CommentServiceAndTransactionalTest {

	@Autowired
	CommentService service;

//	@Test
//	public void findAllList() {
//		List<Comment> list = service.findAll();
//		assertNotNull(list);
//	}
//
//	@Test
//	public void writeComment() {
//		Comment comment = new Comment();
//		comment.setUserUrl("http://");
//		comment.setWriter("id");
//		comment.setCommentText("textTest");
//		comment.setPositive(0);
//		comment.setNegative(0);
//		comment.setRegTime(new Date());
//
//		service.writeComment(comment);
//	}
//
//	@Test
//	public void deleteComment() {
//		service.removeComment(1);
//	}
//
//	@Test
//	public void joinUser() {
//		try {
//			UserInfo user = new UserInfo();
//			user.setId("ju");
//			user.setName("���ֿ�");
//			user.setPassword("1123");
//			user.setProflie("�ȳ��ϼ��� ���ֿ��Դϴ�.");
//			user.setProflie_url("url");
//			service.joinUser(user);
//		} catch (DuplicateKeyException e) {
//			System.out.println("���� �Ǿ� �ֽ��ϴ�.");
//		}
//	}
//
//	@Test
//	public void selectUserInfo() {
//		UserInfo user = service.findUserInfoById("kim");
//		assertEquals(user.getName(), "���ֿ�");
//		assertEquals(user.getPassword(), "1123");
//		assertEquals(user.getProflie(), "�ȳ��ϼ��� ���ֿ��Դϴ�.");
//		assertEquals(user.getProflie_url(), "url");
//	}
//
//	@Test
//	public void getComment() {
//		Comment comment = service.findCommentByListId(2);
//	}
//
//	@Test
//	public void userLikeComment() {
//		// 1. id�� ���õ� �ڸ�� ��������
//		String user = service.findUserInfoById("kim").getId();
//		int comment = service.findCommentByListId(5).getListId();
//		// 2. id�� �ڸ�Ʈ�� �򰡸� �ߴ��� Ȯ���ϱ�
//		service.addUserLikeComment(user, comment, "ne");
//	}

	// ����¡ ó���� �ʿ��� ���� ����
	@Test
	public void pagingParamsExtr() {
		int pageCount = service.pageCount();
		System.out.println("pageCount : " + pageCount);

		for (int page = 1; page <= pageCount; page++) {
			List<Comment> pageComments = service.showPageOne(page);
			for (int Count = 0; Count < pageComments.size(); Count++) {
				System.out.println(pageComments.get(Count).getListId());
			}
			System.out.println("page end : " + page + "������");
		}
	}
}
