package kr.ac.jejunu;

import java.util.Date;
import java.util.List;

import kr.ac.jejunu.model.Comment;
import kr.ac.jejunu.model.UserInfo;
import kr.ac.jejunu.repositry.SqlMapper;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value="classpath:spring/mapper-context.xml")
public class CommentMapperTest {
	@Autowired
	private SqlMapper mapper;
	
	@Test
	public void getlist(){
		List<Comment> list = mapper.getList();
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
	public void deleteComment(){
		mapper.deleteComment(1);
	}
	
	@Test
	public void dateTest(){
		List<Comment> list = mapper.getList();
		for(int listCount = 0; listCount < list.size(); listCount++){
			Comment comment = list.get(listCount);
			System.out.println(comment.getListId()+" : "+comment.getRegTime());
		}
	}

	@Test
	public void joinUser(){
		UserInfo user = new UserInfo();
		user.setId("kim");
		user.setName("김주영");
		user.setPassword("1123");
		user.setProflie("안녕하세요 김주영입니다.");
		user.setProflie_url("url");
		mapper.joinUser(user);
	}
	
	@Test
	public void selectUserInfo(){
		UserInfo user = mapper.selectUser("kim");
		assertEquals(user.getName(), "김주영");
		assertEquals(user.getPassword(), "1123");
		assertEquals(user.getProflie(), "안녕하세요 김주영입니다.");
		assertEquals(user.getProflie_url(), "url");
	}
	
	@Test
	public void getComment(){
		Comment comment = mapper.getComment(2);
	}
	
	@Test
	public void userLikeComment(){
		//1. id와 선택된 코멘드 가져오기
		UserInfo user = mapper.selectUser("kim");
		Comment comment = mapper.getComment(2);
		//2. id로 코멘트에 평가를 했는지 확인하기
		
		//3-1. 평가를 하지 않았을 때 평가를 입력
		//3-2. 평가를 한 경우 정지
		//4. userLikeComment에 평가를 한 것을 입력
		//문제점 1. id와 listId가 둘다 일치하는 경우 처리
		//2.id나 listId가 하나만 일치하는 하는 경우 제외
		//인젝션을 이용한 처리는 나중에 당장은 순서대로 쿼리문을 사용
		//mapper.userLikeComment("kim", "2");
	}
}
