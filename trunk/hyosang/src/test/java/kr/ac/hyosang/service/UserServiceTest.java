package kr.ac.hyosang.service;

import java.util.Random;

import kr.ac.hyosang.model.User;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value="classpath:spring/servlet-context.xml")
public class UserServiceTest {
	
	@Autowired
	private UserService userService;
	
	private String randomString = getRandomString(8);
	
	private static String getRandomString(int length) {
		StringBuffer buffer = new StringBuffer();
		Random random = new Random();

		String chars[] = "a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y,z"
				.split(",");

		for (int i = 0; i < length; i++) {
			buffer.append(chars[random.nextInt(chars.length)]);
		}
		return buffer.toString();
	}
	
	@Test
	public void testUserJoin() {
		User user = new User();
		user.setUserId(randomString);
		user.setPassword("qlalfqjsghservice");
		user.setUserName("김효상service");
		user.setUserInfo("tjfaudservice");
		user.setUserImagePath("test image path service");
		userService.userJoin(user);
	}
}
