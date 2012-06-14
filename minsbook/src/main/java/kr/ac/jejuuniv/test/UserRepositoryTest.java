package kr.ac.jejuuniv.test;

import static org.junit.Assert.assertEquals;
import kr.ac.jejuuniv.model.User;
import kr.ac.jejuuniv.repository.exception.UserNotFoundException;
import kr.ac.jejuuniv.repository.user.UserRepository;
import kr.ac.jejuuniv.repository.user.UserRepositoryHashMapImpl;

import org.junit.Before;
import org.junit.Test;

public class UserRepositoryTest {
	
	UserRepository userRepository;
	
	//한번 실행할때 마다 초기화 해주는거
	@Before
	public void init() {
		userRepository = new UserRepositoryHashMapImpl();
		prepareData();
	}
	
	private void prepareData() {
		User user = new User("jungmin", "1234", "KimJungMin", "ssub", "c:\\fucku");
		userRepository.saveUser(user);
	}
	
	@Test
	public void testSave() {
		User user = new User("jungmin1", "1234", "KimJungMin", "ssub", "c:\\fucku");
		userRepository.saveUser(user);
		
		User foundUser = userRepository.findById("jungmin1");
		assertEquals("1234", foundUser.getPassword());
	}

	
	@Test
	public void testModify() {
		User user = userRepository.findById("jungmin");
		user.setNickname("미남");
		userRepository.saveUser(user);
		user = userRepository.findById("jungmin");
		assertEquals("미남", user.getNickname());
		
	}

}
