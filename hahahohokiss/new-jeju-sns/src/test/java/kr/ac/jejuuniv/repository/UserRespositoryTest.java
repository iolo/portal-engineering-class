package kr.ac.jejuuniv.repository;

import kr.ac.jejuuniv.model.User;

import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
		locations = {"classpath:/applicationContext-resources.xml",
					"classpath:/applicationContext-repository.xml",
					 "classpath:/hibernate.cfg.xml"
		})
@Transactional
public class UserRespositoryTest {
	private HibernateTemplate hibernateTemplate;
	@Autowired
	public void setSesstionFactory(SessionFactory sessionFactory) {
		hibernateTemplate = new HibernateTemplate(sessionFactory);
	}
	@Test
	public void testFindUserByUserId() {
		
	}
	
	@Test
	public void testFindPasswordByUserId() {
		
	}
	
	@Test
	public void testFindTweetByUserId()	{
		
	}
	
	@Test
	public void testFindFollowingUserByUserId() {
		
	}
	
	@Test
	public void testFindFollowerUserByUserId() {
		
	}
	
	@Test
	public void testFindAllUser() {
		
	}
	
	@Test
	public void testFindFollowingUserTweetByFollowingUser() {
		
	}
	
	@Test
	public void testUpdateUser() {
		
	}
}
