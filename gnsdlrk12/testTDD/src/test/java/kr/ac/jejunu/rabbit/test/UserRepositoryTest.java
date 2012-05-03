package kr.ac.jejunu.rabbit.test;

import org.junit.Test;

import kr.ac.jejunu.rabbit.repository.UserRepository;
import kr.ac.jejunu.rabbit.repository.UserRepositoryimpl;

public class UserRepositoryTest {
	@Test
	public void findAll() {
		UserRepositoryimpl userRepository = new UserRepositoryimpl();
		userRepository.findAll();
	}
}
