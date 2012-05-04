package kr.ac.jejunu.rabbit.test;

import kr.ac.jejunu.rabbit.repository.UserRepositoryimpl;

import org.junit.Test;

public class UserRepositoryTest {
	@Test
	public void findAll() {
		UserRepositoryimpl userRepository = new UserRepositoryimpl();
		userRepository.findAll();
	}
}
