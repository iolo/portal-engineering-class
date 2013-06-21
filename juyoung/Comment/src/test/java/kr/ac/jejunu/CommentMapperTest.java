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
			user.setName("김주영");
			user.setPassword("1123");
			user.setProflie("안녕하세요 김주영입니다.");
			user.setProflie_url("url");
			mapper.joinUser(user);
		} catch (DuplicateKeyException e) {
			System.out.println("가입 되어 있습니다.");
		}
	}

	@Test
	public void selectUserInfo() {
		UserInfo user = mapper.selectUser("kim");
		assertEquals(user.getName(), "김주영");
		assertEquals(user.getPassword(), "1123");
		assertEquals(user.getProflie(), "안녕하세요 김주영입니다.");
		assertEquals(user.getProflie_url(), "url");
	}

	@Test
	public void getComment() {
		Comment comment = mapper.getComment(2);
	}

	@Test
	public void userLikeComment() {
		// 1. id와 선택된 코멘드 가져오기
		UserInfo user = mapper.selectUser("kim");
		Comment comment = mapper.getComment(5);
		// 2. id로 코멘트에 평가를 했는지 확인하기
		try {
			mapper.checkPositiveAndNegative(user.getId(), comment.getListId());
			// 3-1. 평가를 하지 않았을 때 평가를 입력
			System.out.println("평가 불가");
		} catch (Exception e) {
			// 3-2. 평가를 한 경우 정지
			System.out.println("평가 가능");
			// 긍정
			mapper.positiveUser(comment.getListId());
			// 부정
			// mapper.negativeUser(comment.getListId());
			mapper.userLikeComment(user.getId(), comment.getListId());
		}
	}

	private int up(double num) {
		double tmp = num / 10;
		//System.out.println(tmp);
		return (int) (Math.ceil(tmp) * 10);
	}

	//페이징 처리에 필요한 정보 추출
	@Test
	public void pagingParamsExtr() {
		// comment의 listId만 추출한 정보
		List<IndexList> index = mapper.indexlist();
		// 페이지 계산 페이지당 10개
		int pageCount = up(index.size()) / 10;
		// 페이지가 담당하는 comments 가지기
		for (int count = pageCount -1 ; count >= 0; count--) {
			int pageLastListId = -99;
			System.out.println("page stat : "+count);
			//페이지 마지막 게시물 가져오기
			try {
				int in= count * 10 - 1;
				if(in != -1 ){
					pageLastListId = index.get(in).getListId();
				}else{
					pageLastListId = index.get(0).getListId();
				}
			//마지막 페이지에 대한 처리
			} catch (ArrayIndexOutOfBoundsException e) {
				pageLastListId = index.get(index.size() - 1).getListId();
			}
			
			//해당 페이지 가져오기
			List<Comment> pageResult = mapper.getSelectPage(pageLastListId);
			for(int pageComment = 0; pageComment < pageResult.size(); pageComment++){
				Comment tmp = pageResult.get(pageComment);
				System.out.println(" : "+tmp.getListId()+" : "+ tmp.getWriter());
			}
			System.out.println("page end : "+count);
		}

		// 총 페이지 개수
		System.out.println("페이지 개수 : " + pageCount);
	}
}
