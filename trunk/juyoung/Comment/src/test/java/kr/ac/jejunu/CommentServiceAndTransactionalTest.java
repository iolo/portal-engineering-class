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

	@Test
	public void findAllList() {
		List<Comment> list = service.findAll();
		assertNotNull(list);
	}

	@Test
	public void writeComment() {
		Comment comment = new Comment();
		comment.setUserUrl("http://");
		comment.setWriter("id");
		comment.setCommentText("textTest");
		comment.setPositive(0);
		comment.setNegative(0);
		comment.setRegTime(new Date());

		service.writeComment(comment);
	}

	//
	// @Test
	// public void deleteComment() {
	// mapper.deleteComment(1);
	// }
	//
	// @Test
	// public void dateTest() {
	// List<Comment> list = mapper.selectAll();
	// for (int listCount = 0; listCount < list.size(); listCount++) {
	// Comment comment = list.get(listCount);
	// // System.out.println(comment.getListId() + " : "
	// // + comment.getRegTime());
	// }
	// }
	//
	// @Test
	// public void joinUser() {
	// try {
	// UserInfo user = new UserInfo();
	// user.setId("ju");
	// user.setName("���ֿ�");
	// user.setPassword("1123");
	// user.setProflie("�ȳ��ϼ��� ���ֿ��Դϴ�.");
	// user.setProflie_url("url");
	// mapper.insertUser(user);
	// } catch (DuplicateKeyException e) {
	// System.out.println("���� �Ǿ� �ֽ��ϴ�.");
	// }
	// }
	//
	// @Test
	// public void selectUserInfo() {
	// UserInfo user = mapper.selectUser("kim");
	// assertEquals(user.getName(), "���ֿ�");
	// assertEquals(user.getPassword(), "1123");
	// assertEquals(user.getProflie(), "�ȳ��ϼ��� ���ֿ��Դϴ�.");
	// assertEquals(user.getProflie_url(), "url");
	// }
	//
	// @Test
	// public void getComment() {
	// Comment comment = mapper.selectComment(2);
	// }
	//
	// @Test
	// public void userLikeComment() {
	// // 1. id�� ���õ� �ڸ�� ��������
	// UserInfo user = mapper.selectUser("kim");
	// Comment comment = mapper.selectComment(5);
	// // 2. id�� �ڸ�Ʈ�� �򰡸� �ߴ��� Ȯ���ϱ�
	// try {
	// mapper.selectUserLikeCheck(user.getId(), comment.getListId());
	// // 3-1. �򰡸� ���� �ʾ��� �� �򰡸� �Է�
	// System.out.println("�� �Ұ�");
	// } catch (Exception e) {
	// // 3-2. �򰡸� �� ��� ����
	// System.out.println("�� ����");
	// // ����
	// mapper.updatePositiveUser(comment.getListId());
	// // ����
	// // mapper.negativeUser(comment.getListId());
	// mapper.insertUserLikeCommentCheck(user.getId(), comment.getListId());
	// }
	// }
	//

	//
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
			System.out.println("page end : "+page+"������");
		}
	}
}
