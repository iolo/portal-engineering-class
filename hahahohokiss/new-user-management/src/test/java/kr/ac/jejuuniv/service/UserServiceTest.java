package kr.ac.jejuuniv.service;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import kr.ac.jejuuniv.model.User;

import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class UserServiceTest {
	/*
	 * User List 가져오기
	 * User 추가하기
	 * User 삭제하기
	 * User 수정하기
	 */
	UserService userService = new UserServiceImpl(); 
	
	
	
	@Test
	public void testUserList() {
		// UserList를 가져오고 list 에 값이 있는지, 첫번째 id 가 0인지 확인
		List<User> users = new ArrayList<User>();
		users = userService.list();
		assertTrue(users.size() > 0);
		assertThat(users.get(0).getId(), is("0"));
	}
}
