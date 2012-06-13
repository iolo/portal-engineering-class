package com.jejuuniv.test;

import static org.junit.Assert.assertEquals;
import kr.ac.jejuuniv.controller.AllUserController;
import kr.ac.jejuuniv.model.User;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;




@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:webapp/WEB-INF/web.xml"})
public class ControllerTest {

	
	@Autowired
	AllUserController allUserController;
	
	@Test
	public void AllUserControllerTest(){

		User user = new User();
		user.setId("123");
		user.setimageURI("default.png");
		user.setInformation("TestInfo");
		user.setName("test");
		user.setPassword("TestPassword");
		
		allUserController.findalluser(user);

		
		String result = allUserController.followuser(user, "Follow", "aaa");
		
		assertEquals(result, "redirect:/alluser");
		
	}

}
