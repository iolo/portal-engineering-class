package kr.ac.test.repository;

import kr.ac.jejuuniv.model.User;
import kr.ac.jejuuniv.repository.UserRepository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("hibernate-data-access-context.xml")
public class UserRepositoryStudy4Hibernate {
	@Autowired
	private UserRepository repository;

	// @Test
	// public void testSelectUser() {
	// User user = repository.selectUserById("aaa");
	// for (User u : user.getFollowingUser()) {
	// System.out.println(u);
	// }
	// }
	//
	// @Test
	// public void testInsertUser() {
	// User user = repository.selectUserById("aaa");
	//
	// user.getFollowingUser().add(repository.selectUserById("ksb"));
	// repository.updateUser(user);
	//
	// User newUser = repository.selectUserById("aaa");
	// System.out.println(newUser);
	// for (User u : newUser.getFollowingUser()) {
	// System.out.println(u);
	// }
	//
	// assertThat(
	// newUser.getFollowingUser().contains(
	// repository.selectUserById("ksb")), is(true));
	// }

	@Test
	public void testModifyUser() {
		User user = repository.selectUserById("sens");
		user.setPassword("sens");

		repository.updateUser(user);
	}

	// @Test
	// public void testSelect() {
	// assertNull(repository.selectUserById("werwqerqwer"));
	// }

	// @Test
	// public void testFollower() {
	// User user = repository.selectUserById("sens");
	//
	// Set<User> userSet = user.getFallowerUser();
	//
	// System.out.println("---------------팔로워 들--------------");
	// assertThat(userSet.size(), is(1));
	// for (User u : userSet) {
	// System.out.println(u);
	// }
	// }
	//
	// @Test
	// public void testList() {
	// List<User> userList = repository.selectAllUser();
	// assertNotNull(userList);
	// assertThat(userList.size() >= 0, is(true));
	//
	// for (User user : userList) {
	// System.out.println(user);
	// }
	// }
}