package kr.ac.test.mapper;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import kr.ac.jejuuniv.mapper.FollowingMapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("servlet-context.xml")
public class FollowMapperIntegralTest {
	@Autowired
	private FollowingMapper followingMapper;

	@Test
	public void testInsert() {
		followingMapper.insertFollowing("ksb", "hmj");
	}

	@Test
	public void testSelect() {
		assertThat(followingMapper.countFollowing("ksb", "hmj"), is(1));
	}

	@Test
	public void testDelete() {
		followingMapper.deleteFollowing("ksb", "hmj");
	}
}
