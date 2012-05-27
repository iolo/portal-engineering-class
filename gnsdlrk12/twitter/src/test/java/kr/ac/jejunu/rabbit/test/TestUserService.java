package kr.ac.jejunu.rabbit.test;

import kr.ac.jejunu.rabbit.model.User;
import kr.ac.jejunu.rabbit.service.UserService;

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
	public void insert(){ //성공 테스트
		User user = new User();
		user.setUserid("white");
		user.setName("rabbit");
		user.setPassword("1234");
		
		userService.insert(user);
	}
	
	@Test
	public void failinsert(){	//기존에 있는 아이디를 입력할 경우 에러
		User user = new User();
		user.setUserid("white");
		user.setName("cat");
		user.setPassword("5678");
		
		userService.insert(user);
	}
	
	@Test
	public void update(){
		User user = new User();
		user.setUserid("white");
		user.setName("bird");
		user.setPassword("aaaa");
		
		userService.insert(user);
	}
	
}
