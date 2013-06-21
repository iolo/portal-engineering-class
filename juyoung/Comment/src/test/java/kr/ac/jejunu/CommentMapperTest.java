package kr.ac.jejunu;

import java.net.BindException;
import java.util.Date;
import java.util.List;

import kr.ac.jejunu.model.Comment;
import kr.ac.jejunu.model.UserInfo;
import kr.ac.jejunu.repositry.SqlMapper;

import static org.junit.Assert.*;

import org.apache.taglibs.standard.tag.common.core.NullAttributeException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = "classpath:spring/mapper-context.xml")
public class CommentMapperTest {
	@Autowired
	private SqlMapper mapper;

	@Test
	public void getlist() {
		List<Comment> list = mapper.getAllList();
		assertNotNull(list);
	}

	@Test
	public void insertComment() {
		Comment comment = new Comment();
		comment.setUserUrl("http://");
		comment.setWriter("id");
		comment.setCommentText("textTest");
		comment.setPositive(0);
		comment.setNegative(0);
		comment.setRegTime(new Date());

		mapper.insertComment(comment);
	}

	@Test
	public void deleteComment() {
		mapper.deleteComment(1);
	}

	@Test
	public void dateTest() {
		List<Comment> list = mapper.getAllList();
		for (int listCount = 0; listCount < list.size(); listCount++) {
			Comment comment = list.get(listCount);
			System.out.println(comment.getListId() + " : "
					+ comment.getRegTime());
		}
	}

	@Test
	public void joinUser() {
		try {
			UserInfo user = new UserInfo();
			user.setId("ju");
			user.setName("���ֿ�");
			user.setPassword("1123");
			user.setProflie("�ȳ��ϼ��� ���ֿ��Դϴ�.");
			user.setProflie_url("url");
			mapper.joinUser(user);
		} catch (DuplicateKeyException e) {
			System.out.println("���� �Ǿ� �ֽ��ϴ�.");
		}
	}

	@Test
	public void selectUserInfo() {
		UserInfo user = mapper.selectUser("kim");
		assertEquals(user.getName(), "���ֿ�");
		assertEquals(user.getPassword(), "1123");
		assertEquals(user.getProflie(), "�ȳ��ϼ��� ���ֿ��Դϴ�.");
		assertEquals(user.getProflie_url(), "url");
	}

	@Test
	public void getComment() {
		Comment comment = mapper.getComment(2);
	}

	@Test
	public void userLikeComment() {
		// 1. id�� ���õ� �ڸ�� ��������
		UserInfo user = mapper.selectUser("kim");
		Comment comment = mapper.getComment(5);
		// 2. id�� �ڸ�Ʈ�� �򰡸� �ߴ��� Ȯ���ϱ�
		try {
			mapper.checkPositiveAndNegative(user.getId(), comment.getListId());
			// 3-1. �򰡸� ���� �ʾ��� �� �򰡸� �Է�
			System.out.println("�� �Ұ�");
		} catch (Exception e) {
			// 3-2. �򰡸� �� ��� ����
			System.out.println("�� ����");
			// ����
			mapper.positiveUser(comment.getListId());
			// ����
			// mapper.negativeUser(comment.getListId());
			mapper.userLikeComment(user.getId(), comment.getListId());
		}
	}

	@Test
	public void pagingParamsExtr(){
		//��ü ���ù� ��
		int count = mapper.countlist();
		//������ ��� �������� 10��
		int page = count / 10;
		//������ ����
		for(int pageNum = 0; pageNum < page; pageNum ++){
			int pageEndNum = ;
			//Ư�� ������ ȣ��
			List<Comment> pageOne = mapper.getSelectPage(pageEndNum);
			//������ ��� Ȯ�ο�
			for(int comment = 0; comment < 9; comment++){
				Comment co = pageOne.get(comment);
				System.out.println(comment+" : "+co.getCommentText());
			}
		}
		//�� ������ ����
		System.out.println("������ ���� : "+page);
		
	}
}
