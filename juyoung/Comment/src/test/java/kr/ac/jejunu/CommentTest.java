package kr.ac.jejunu;


import java.util.List;

import kr.ac.jejunu.model.comment;
import kr.ac.jejunu.repositry.CommentDao;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value="classpath:/spring/dao-context.xml")
public class CommentTest {
	
	//@Autowired
	//private CommentDao dao;
	
	@Test
	public void listCall(){
		//List<comment> list = dao.getList();
		assertNull(null);
	}
}
