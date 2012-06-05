package kr.ac.test.mapper;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.List;

import kr.ac.jejuuniv.mapper.SsiggleMapper;
import kr.ac.jejuuniv.model.Ssiggle;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

//TODO : 그 다음에는 도메인 주도 설계로 이 어플리케이션 싹 공사하기
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("servlet-context.xml")
public class SsiggleMapperIntegralTest {
	@Autowired
	private SsiggleMapper ssiggleMapper;

	@Test
	public void testSelectSsiggle() {
		Ssiggle ssiggle = ssiggleMapper.selectSsiggleById(1);
		assertThat(ssiggle.getId(), is((long) 1));
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

		for (Ssiggle s : list) {
			System.out.println(s);
		}
	}
}
