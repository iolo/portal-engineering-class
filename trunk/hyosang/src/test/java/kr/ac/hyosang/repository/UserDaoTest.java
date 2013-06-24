package kr.ac.hyosang.repository;

import java.util.Random;

import kr.ac.hyosang.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value="classpath:spring/dao-context.xml")
public class UserDaoTest {
	
	@Autowired private UserDao userDao;
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
	public void testInsertUser() {
		User user = new User();
		user.setUserId(randomString);
		user.setPassword("qlalfqjsgh");
		user.setUserName("김효상");
		user.setUserInfo("tjfaud");
		user.setUserImagePath("test image path");
		userDao.insertUser(user);
	}
	
	@Test
	public void testUpdateUser() {
		User user = new User();
		user.setUserId("test");
		user.setPassword("qlalfqjsgh수정2");
		user.setUserName("김효상수정");
		user.setUserInfo("tjfaud수정");
		user.setUserImagePath("test image path수정");
		userDao.updateUser(user);
	}

	@Test
	public void testDeleteUser() {
		userDao.deleteUser("test");
	}
	
	@Test
	public void testSelectUser() {
		System.out.println(userDao.selectUser("cwockxap").getUserId());
		System.out.println(userDao.selectUser("cwockxap").getPassword());
		System.out.println(userDao.selectUser("cwockxap").getUserName());
		System.out.println(userDao.selectUser("cwockxap").getUserInfo());
		System.out.println(userDao.selectUser("cwockxap").getUserImagePath());
	}
}
