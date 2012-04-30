package kr.ac.jejuuniv.repository;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import kr.ac.jejuuniv.model.User;

import org.junit.Test;

public class UserRepositoryTest {
	UserRepository userRepository;
	
	@Test
	public void tsetFindAll() {
		userRepository = new UserRepositoryDummy();
		assertThat(userRepository.findAll().size(), is(6));
	}
	
	@Test
	public void testFindById() {
		userRepository = new UserRepositoryDummy();
		assertThat(userRepository.findById("0").getId(), is("0"));
	}
	
	@Test
	public void testInsert() {
		userRepository = new UserRepositoryDummy();
		User insertUser = new User("6", "테스트", "비밀번호");
		userRepository.insert(insertUser);
		assertThat(userRepository.findAll().size(), is(7));
	}
	
	@Test
	public void testUpdate() {
		userRepository = new UserRepositoryDummy();
		User user = userRepository.findById("0");
		user.setName("업데이트");
		user = userRepository.update(user);
		assertThat(user.getName(), is("업데이트"));
	}
	
	@Test
	public void testDelete() {
		userRepository = new UserRepositoryDummy();
		userRepository.delete("0");
		assertNull(userRepository.findById("0"));
	}
	
}
