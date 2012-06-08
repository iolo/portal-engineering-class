package kr.ac.jejunu.rabbit.test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.List;

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
	public void UserInsert(){	//User 등록
		User user = new User();
		user.setUserid("white");
		user.setName("rabbit");
		user.setPassword("1234");
		
		userService.UserInsert(user);
		assertThat(userService.UserGet("white").getUserid().isEmpty(), is(false));
	}
	
	@Test
	public void UserUpdate(){	//Userinfo 수정
		User user = new User();
		user.setUserid("white");
		user.setName("bird");
		user.setPassword("aaaa");
		
		userService.UserInsert(user);
	}
	
	@Test
	public void UserDelete(){	//User 삭제
		String DeleteUserId = "white";
		userService.UserDelete(DeleteUserId);
	}
	
	@Test
	public void TestList(){	//UserList
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
	public void Login(){	//Login
		User user = new User();
		user.setUserid("white");
		user.setName("rabbit");
		user.setPassword("1234");
		
		userService.Login(user);
		
	}
	
	public void printPosts(List<Post> posts) {
		System.out.println("------------------------------------------");
		for (Post post : posts) {
			System.out.println("* " + post);
		}
		System.out.println("------------------------------------------");
	}
	
	@Test
	public void Postinsert(){	//post 등록
		String userid = "snow";
		String content = "test";
		
		userService.PostInsert(userid, content);
	}
	
	@Test
	public void Testfollow(){
		String userid = "white";
		String followerid = "red";
		
		userService.following(userid, followerid);
	}
}
