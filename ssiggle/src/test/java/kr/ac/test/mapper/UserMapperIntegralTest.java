package kr.ac.test.mapper;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.List;

import kr.ac.jejuuniv.mapper.UserMapper;
import kr.ac.jejuuniv.model.user.User;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("servlet-context.xml")
public class UserMapperIntegralTest {
	@Autowired
	private UserMapper userMapper;

	@Test
	public void testSelect() {
		User user = userMapper.selectUserById("sens");
		assertNotNull(user);
		System.out.println(user);
	}

	// @Test
	// public void testSelectUsePassword() {
	// IUser user = userMapper.selectUserById("sens", "sens");
	// assertNotNull(user);
	// System.out.println(user);
	// }

	// @Test
	public void testSelectFail() {
		User user = userMapper.selectUserById("wwwEQWERQWR");
		assertNull(user);
	}

	// @Test
	public void testAllUser() {
		List<User> list = userMapper.selectAllUser();
		assertThat(list.isEmpty(), is(false));
	}

	// @Test
	public void testInsert() {
		User user = new User();
		user.setId("test");
		user.setPassword("test");
		user.setIntroduce("eeee");
		user.setName("test");

		userMapper.insertUser(user);
	}

	// @Test
	public void testUpdate() {
		String name = "바뀐 이름";
		String intro = "바뀐 설명";

		User user = new User();
		user.setId("test");
		user.setPassword("test");
		user.setIntroduce(intro);
		user.setName(name);

		userMapper.updateUser(user);

		User newUser = userMapper.selectUserById("test");

		assertThat(newUser.getName(), is(name));
		assertThat(newUser.getIntroduce(), is(intro));
	}

	// @Test
	public void testDelete() {
		userMapper.deleteUser("test");
		assertNull(userMapper.selectUserById("test"));
	}

	@Test
	public void testFollowing() {
		List<User> userList = userMapper.selectAllFollowingUser("sens");

		System.out.println("-----------sens가 팔로잉 하는 사람들 --------------");
		for (User user : userList) {
			System.out.println(user);
		}
		System.out.println("----------------------------------------------");
	}

	@Test
	public void testFollower() {
		List<User> userList = userMapper.selectAllFollowerUser("hcj");

		System.out.println("-----------hcj를 팔로잉 하는 사람들 -------------");
		for (User user : userList) {
			System.out.println(user);
		}
		System.out.println("----------------------------------------------");
	}
}