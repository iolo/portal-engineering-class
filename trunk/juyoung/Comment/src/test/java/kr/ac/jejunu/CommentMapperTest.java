package kr.ac.jejunu;

import java.util.Date;
import java.util.List;

import kr.ac.jejunu.model.Comment;
import kr.ac.jejunu.model.IndexList;
import kr.ac.jejunu.model.UserInfo;
import kr.ac.jejunu.repositry.SqlMapper;

import static org.junit.Assert.*;

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
//			System.out.println(comment.getListId() + " : "
//					+ comment.getRegTime());
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

	private int up(double num) {
		double tmp = num / 10;
		//System.out.println(tmp);
		return (int) (Math.ceil(tmp) * 10);
	}

	//����¡ ó���� �ʿ��� ���� ����
	@Test
	public void pagingParamsExtr() {
		// comment�� listId�� ������ ����
		List<IndexList> index = mapper.indexlist();
		// ������ ��� �������� 10��
		int pageCount = up(index.size()) / 10;
		// �������� ����ϴ� comments ������
		for (int count = pageCount -1 ; count >= 0; count--) {
			int pageLastListId = -99;
			System.out.println("page stat : "+count);
			//������ ������ �Խù� ��������
			try {
				int in= count * 10 - 1;
				if(in != -1 ){
					pageLastListId = index.get(in).getListId();
				}else{
					pageLastListId = index.get(0).getListId();
				}
			//������ �������� ���� ó��
			} catch (ArrayIndexOutOfBoundsException e) {
				pageLastListId = index.get(index.size() - 1).getListId();
			}
			
			//�ش� ������ ��������
			List<Comment> pageResult = mapper.getSelectPage(pageLastListId);
			for(int pageComment = 0; pageComment < pageResult.size(); pageComment++){
				Comment tmp = pageResult.get(pageComment);
				System.out.println(" : "+tmp.getListId()+" : "+ tmp.getWriter());
			}
			System.out.println("page end : "+count);
		}

		// �� ������ ����
		System.out.println("������ ���� : " + pageCount);
	}
}
