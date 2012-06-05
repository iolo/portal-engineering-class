package kr.ac.test.repository;

import static org.junit.Assert.*;

import java.util.List;

import kr.ac.jejuuniv.model.Ssiggle;
import kr.ac.jejuuniv.repository.SsiggleRepository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("hibernate-data-access-context.xml")
public class SsiggleRepositoryIntegralTest {
	@Autowired
	private SsiggleRepository repository;

	@Test
	public void testSelectSsiggle() {
		Ssiggle s = repository.selectSsiggleById(1);
		assertNotNull(s);
	}

	@Test
	public void testSsiggleList() {
		List<Ssiggle> list = repository
				.selectSsiggleListByUserIdDescTime("sens");

		assertFalse(list.isEmpty());
		for (Ssiggle s : list) {
			System.out.println(s);
		}
	}
}
