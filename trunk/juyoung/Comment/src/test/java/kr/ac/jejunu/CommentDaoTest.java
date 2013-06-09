package kr.ac.jejunu;

import java.util.List;

import kr.ac.jejunu.model.comment;
import kr.ac.jejunu.repositry.CommentDao;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value="classpath:spring/dao-context.xml")
public class CommentDaoTest {
	@Autowired
	private CommentDao dao;
	
	@Test
	public void getlist(){
		List<comment> list = dao.getList();
		Assert.assertNull(list);
	}

}
