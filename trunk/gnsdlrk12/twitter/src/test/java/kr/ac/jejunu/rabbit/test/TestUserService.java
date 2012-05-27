package kr.ac.jejunu.rabbit.test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.activation.DataSource;

import kr.ac.jejunu.rabbit.model.Post;
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
	public void UserInsert(){	//User 등록 성공 테스트
		User user = new User();
		user.setUserid("white");
		user.setName("rabbit");
		user.setPassword("1234");
		
		userService.UserInsert(user);
		assertThat(userService.UserGet("white").getUserid().isEmpty(), is(false));
	}
	
	@Test
	public void FailUserInsert(){	//기존에 있는 아이디를 입력할 경우 에러
		User user = new User();
		user.setUserid("white");
		user.setName("cat");
		user.setPassword("5678");
		
		userService.UserInsert(user);
	}
	
	@Test
	public void UserUpdate(){	//Userinfo 수정 성공 테스트
		User user = new User();
		user.setUserid("white");
		user.setName("bird");
		user.setPassword("aaaa");
		
		userService.UserInsert(user);
	}
	
	@Test
	public void FailUserUpdate(){	//name 값이 없을 경우 에러
		User user = new User();
		user.setUserid("white");
		user.setPassword("aaaa");
		
		userService.UserInsert(user);
	}
	
	@Test
	public void UserDelete(){	//User 삭제 성공 테스트
		String DeleteUserId = "white";
		userService.UserDelete(DeleteUserId);
	}
	
	@Test
	public void TestList(){	//UserList 성공 테스트
		List<User> users = userService.UserList();
		printUsers(users);
	}
	
	public void printUsers(List<User> users) {
		System.out.println("------------------------------------------");
		for (User user : users) {
			System.out.println("* " + user);
		}
		System.out.println("------------------------------------------");
	}
	
	@Test
	public void Login(){	//Login 성공테스트
		String userid = "snow";
		String password = "5678";
		
		List<Post> posts = userService.Login(userid, password);
		printPosts(posts);
	}
	
	public void printPosts(List<Post> posts) {
		System.out.println("------------------------------------------");
		for (Post post : posts) {
			System.out.println("* " + post);
		}
		System.out.println("------------------------------------------");
	}
	
	@Test
	public void Postinsert(){	//post 등록 성공 테스트
		String userid = "snow";
		String content = "test";
		
		userService.PostInsert(userid, content);
	}
}
