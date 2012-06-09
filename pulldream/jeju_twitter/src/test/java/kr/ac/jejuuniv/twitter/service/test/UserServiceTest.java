package kr.ac.jejuuniv.twitter.service.test;

import java.awt.event.FocusEvent;
import java.util.ArrayList;
import java.util.List;

import kr.ac.jejuuniv.twitter.model.FollowModel;
import kr.ac.jejuuniv.twitter.model.UserModel;
import kr.ac.jejuuniv.twitter.repository.UserRepository;
import kr.ac.jejuuniv.twitter.service.UserService;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/mybatis/repository.xml")
public class UserServiceTest {

	@Autowired
	private UserService userService;
	
	@Autowired
	private UserRepository userRepository;
	
//	@Test
//	public void checkUser(){
//		UserModel user = new UserModel();
//
//		try {
//			user.setId("juntheater");
//			user.setPassword("asdf");
//			userService.checkUser(user);
//			
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
//		assertThat(userService.checkUser(user).getId(), is("juntheater"));
//	}
	
	@Test
	public void checkUserTest(){
		try {
			UserModel user = new UserModel();
			user.setId("juntheater");
			user.setPassword(("asdf"));
			
			UserModel userReuslt = userRepository.checkUser(user);
			assertThat(userReuslt.getName(), is("Young Jun Moon"));
			
			if(userReuslt==null){
				System.out.println("Try again");
			}
			else {
				System.out.println("Login!!!");
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("error");
		}
	}
}
