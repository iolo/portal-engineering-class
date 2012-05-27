package kr.ac.jejunu.rabbit.test;

import kr.ac.jejunu.rabbit.model.User;
import kr.ac.jejunu.rabbit.service.UserService;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/root-context.xml")
public class TestUserService {
	
	@Autowired
	UserService userService;
	
	@Test
	public void insert(){
		User user = new User();
		user.setUserid("white");
		user.setName("rabbit");
		user.setPassword("1234");
		
		userService.insert(user);
		Assert.assertTrue(true);
	}
}
