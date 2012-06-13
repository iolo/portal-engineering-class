package kr.ac.test.mapper;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.List;

import kr.ac.jejuuniv.mapper.SsiggleMapper;
import kr.ac.jejuuniv.model.ssiggle.Ssiggle;
import kr.ac.jejuuniv.model.user.User;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("servlet-context.xml")
public class SsiggleMapperIntegralTest {
	@Autowired
	private SsiggleMapper ssiggleMapper;

	@Test
	public void testSelectSsiggle() {
		Ssiggle ssiggle = ssiggleMapper.selectSsiggleById(1);
		assertThat(ssiggle.getId(), is(1L));
		assertThat(ssiggle.getUser() != null, is(true));
		System.out.println(ssiggle.getUser());
	}

	@Test
	public void testSsiggleInsert() {
		Ssiggle ssiggle = new Ssiggle();
		ssiggle.setText("Jnit 테스트 입니다.");
		ssiggle.setUser(new User().findUserById("sens"));

		ssiggleMapper.insertSsiggle(ssiggle);
	}

	// @Test
	public void testDeleteSsiggle() {
		ssiggleMapper.deleteSsiggleById(10);
	}

	@Test
	public void testSelectAll() {
		List<Ssiggle> list = ssiggleMapper
				.selectSsiggleListByUserIdDescTime("sens");

		for (Ssiggle s : list) {
			System.out.println(s);
			System.out.println(s.getUser().getImage());
		}
	}
}
