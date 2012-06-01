package kr.ac.test.mapper;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.List;

import kr.ac.jejuuniv.mapper.SsiggleMapper;
import kr.ac.jejuuniv.model.ssiggle.Ssiggle;
import kr.ac.jejuuniv.model.ssiggle.SsiggleTransaction;

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
	}

	// @Test
	// public void testSsiggleInsert() {
	// Ssiggle ssiggle = new Ssiggle();
	// ssiggle.setText("안녕하세요?");
	// ssiggle.setUser("sens");
	//
	// ssiggleMapper.insertSsiggle(ssiggle);
	// }

	@Test
	public void testUpdateSsiggle() {
		Ssiggle ssiggle = new Ssiggle();
		ssiggle.setId(9);
		ssiggle.setText("반갑습니다.");

		ssiggleMapper.updateSsiggle(ssiggle);
	}

	@Test
	public void testDeleteSsiggle() {
		ssiggleMapper.deleteSsiggleById(10);
	}

	@Test
	public void testSelectAll() {
		List<Ssiggle> list = ssiggleMapper
				.selectSsiggleListByUserIdDescTime("sens");

		for (SsiggleTransaction s : list) {
			System.out.println(s);
		}
	}
}
