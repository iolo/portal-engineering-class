package kr.ac.jejuuniv.Service;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import org.junit.Assert;
import java.util.List;

import kr.ac.jejuuniv.Model.User;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/mybatis-context.xml")
public class UserInterationTest {

	@Autowired
	UserService userService;
	
	@Test
	public void getAllUser() {
		List<User> users = userService.getAllUser();
		System.out.println("---getAllUser---");
		printUsers(users);
		
		assertNotNull(users);
		assertTrue(users.size() > 0);
	}
	
	@Test
	public void getUser(){
		User user = userService.getUser(1);
		
		assertThat(user.getId(), is("hsy"));
		assertThat(user.getName(), is("HyunSoYoung"));
		
		System.out.println("--- getUser ---");
		System.out.println(user.toString());
	}
	
	@Test
	public void getUserById(){
		User user = userService.getUserById("han");

		assertThat(user.getUserNum(), is(2));
		assertThat(user.getName(), is("HanSoYoung"));
		
		System.out.println("--- getUserById ---");
		System.out.println(user.toString());
	}
	
	@Test
	public void insert(){
		User user = new User("kim","aabbc","kim","","");
		
		userService.addUser(user);
		
		List<User>users = userService.getAllUser();
		assertTrue(users.size() == 3);
	}
	
	@Test
	public void update(){
		User user = userService.getUser(3);
		user.setName("KimSY");
		user.setPassword("kkk");
		userService.update(user);
		
		user = userService.getUser(3);
		assertThat(user.getName(), is("KimSY"));
		assertThat(user.getPassword(), is("kkk"));
	}
	
	public void printUsers(List<User> users) {
		System.out.println("------------------------------------------");
		for (User user : users) {
			System.out.println(user.toString());
		}
		System.out.println("------------------------------------------");
	}

	
}
