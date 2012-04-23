import static org.junit.Assert.*;

import java.util.List;

import kr.ac.jejuuniv.model.User;
import kr.ac.jejuuniv.repository.IdExistException;
import kr.ac.jejuuniv.repository.ListUserRepository;
import kr.ac.jejuuniv.repository.RowNotExistException;
import kr.ac.jejuuniv.repository.UserRepository;

import org.junit.Test;

public class ListUserRepositoryTest {
	@Test
	public void repositoryFindAndInsertSuccess() {
		UserRepository userRepository = new ListUserRepository();

		User testUser1 = new User("1", "111", "1234");
		User testUser2 = new User("2", "222", "1234");
		User testUser3 = new User("3", "333", "1234");

		userRepository.insertUser(testUser1);
		userRepository.insertUser(testUser2);
		userRepository.insertUser(testUser3);

		User user1 = userRepository.findUserById("1");
		User user2 = userRepository.findUserById("2");
		User user3 = userRepository.findUserById("3");

		equalUser(testUser1, user1);
		equalUser(testUser2, user2);
		equalUser(testUser3, user3);
	}

	@Test
	public void testFindFailTest() {
		UserRepository userRepository = new ListUserRepository();

		User testUser1 = new User("1", "111", "1234");
		User testUser2 = new User("2", "222", "1234");
		User testUser3 = new User("3", "333", "1234");

		userRepository.insertUser(testUser1);
		userRepository.insertUser(testUser2);
		userRepository.insertUser(testUser3);

		assertNull(userRepository.findUserById("4"));
	}

	@Test(expected = IdExistException.class)
	public void testInsertFailTest() {
		UserRepository userRepository = new ListUserRepository();

		User testUser1 = new User("1", "111", "1234");
		User testUser2 = new User("2", "222", "1234");
		User testUser3 = new User("3", "333", "1234");

		userRepository.insertUser(testUser1);
		userRepository.insertUser(testUser2);
		userRepository.insertUser(testUser3);

		User testUser4 = new User("3", "444", "1234");
		userRepository.insertUser(testUser4);
	}

	@Test(expected = RowNotExistException.class)
	public void deleteFailTest() {
		UserRepository repository = new ListUserRepository();

		User testUser1 = new User("1", "111", "1234");
		User testUser2 = new User("2", "222", "1234");
		User testUser3 = new User("3", "333", "1234");

		repository.insertUser(testUser1);
		repository.insertUser(testUser2);
		repository.insertUser(testUser3);

		repository.deleteUserById("4");
	}

	@Test
	public void userUpdateTest() {
		UserRepository repository = new ListUserRepository();

		String id = "1";
		User oldUser = new User(id, "양진원", "abcd");
		User newUser = new User(id, "양진용", "abcd");

		repository.insertUser(oldUser);
		repository.updateUser(newUser);

		equalUser(repository.findUserById(id), newUser);
	}

	@Test(expected = RowNotExistException.class)
	public void userUpdateTestFail() {
		UserRepository repository = new ListUserRepository();

		String id = "1";
		String newId = "3";
		User oldUser = new User(id, "양진원", "abcd");
		User newUser = new User(newId, "양진용", "abcd");

		repository.insertUser(oldUser);
		repository.updateUser(newUser);
	}

	@Test
	public void userFindAllTest() {
		UserRepository repository = new ListUserRepository();

		User user1 = new User("abc", "aaa", "bbb");
		User user2 = new User("def", "ccc", "ddd");
		User user3 = new User("ghi", "eee", "fff");
		User user4 = new User("jkl", "ggg", "hhh");
		User user5 = new User("mno", "iii", "jjj");

		List<User> users = repository.findAllUser();

		users.add(user1);
		users.add(user2);
		users.add(user3);
		users.add(user4);
		users.add(user5);
		
		assertEquals(users.size(), 5);

		equalUser(users.get(0), user1);
		equalUser(users.get(1), user2);
		equalUser(users.get(2), user3);
		equalUser(users.get(3), user4);
		equalUser(users.get(4), user5);
	}

	private void equalUser(User sourceUser, User targetUser) {
		assertEquals(sourceUser.getId(), targetUser.getId());
		assertEquals(sourceUser.getName(), targetUser.getName());
		assertEquals(sourceUser.getPassword(), targetUser.getPassword());
	}
}
