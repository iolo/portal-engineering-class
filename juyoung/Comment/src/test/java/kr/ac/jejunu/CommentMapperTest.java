package kr.ac.jejunu;

import java.util.Date;
import java.util.List;

import kr.ac.jejunu.model.Comment;
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
}
