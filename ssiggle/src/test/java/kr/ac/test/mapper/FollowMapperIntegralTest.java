package kr.ac.test.mapper;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.List;

import kr.ac.jejuuniv.mapper.FollowingMapper;
import kr.ac.jejuuniv.model.user.User;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;

//TODO : 여기에 대한 테스트 작성
public class FollowMapperIntegralTest {
	@Autowired
	private FollowingMapper followingMapper;

	@Test
	public void testName() {
		assertNotNull(followingMapper);
	}
}
