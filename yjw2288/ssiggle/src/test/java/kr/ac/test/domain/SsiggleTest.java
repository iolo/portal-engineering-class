package kr.ac.test.domain;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import static org.mockito.Matchers.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import kr.ac.jejuuniv.mapper.SsiggleMapper;
import kr.ac.jejuuniv.model.ssiggle.NotFoundSsiggleException;
import kr.ac.jejuuniv.model.ssiggle.Ssiggle;
import kr.ac.jejuuniv.model.ssiggle.SsiggleDeleteException;
import kr.ac.jejuuniv.model.ssiggle.SsiggleExistException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;

@RunWith(MockitoJUnitRunner.class)
public class SsiggleTest {
	@Mock
	private SsiggleMapper ssiggleMapper;

	@Test
	public void testSsiggleList() {
		when(ssiggleMapper.selectSsiggleListByUserIdDescTime("sens"))
				.thenAnswer(new Answer<List<Ssiggle>>() {
					@Override
					public List<Ssiggle> answer(InvocationOnMock invocation)
							throws Throwable {
						List<Ssiggle> item = new ArrayList<>();
						Ssiggle ssiggleOne = new Ssiggle();
						Ssiggle ssiggleTwo = new Ssiggle();

						ssiggleOne.setId(0);
						ssiggleTwo.setId(1);

						item.add(ssiggleOne);
						item.add(ssiggleTwo);

						return item;
					}
				});

		List<Ssiggle> list = new Ssiggle(ssiggleMapper)
				.ssiggleListByUserIdDesTime("sens");

		assertThat(list.size(), is(2));
		assertThat(list.get(0).getId(), is(0L));
		assertThat(list.get(1).getId(), is(1L));
	}

	@Test(expected = SsiggleExistException.class)
	public void testSaveSsiggleFail() {
		when(ssiggleMapper.selectSsiggleById(0L)).thenReturn(new Ssiggle());

		Ssiggle ssiggle = new Ssiggle(ssiggleMapper);
		ssiggle.setId(0);
		ssiggle.save();
	}

	@Test
	public void testSaveSsiggle() {
		final Ssiggle repoSsiggle = new Ssiggle(ssiggleMapper);
		when(ssiggleMapper.selectSsiggleById(0)).thenAnswer(
				new Answer<Ssiggle>() {
					@Override
					public Ssiggle answer(InvocationOnMock invocation)
							throws Throwable {
						Ssiggle s = new Ssiggle(ssiggleMapper);
						s.setId(s.getId());
						s.setText(repoSsiggle.getText());

						return s;
					}
				});

		doAnswer(new Answer<Void>() {
			@Override
			public Void answer(InvocationOnMock invocation) throws Throwable {
				Ssiggle ssiggle = (Ssiggle) invocation.getArguments()[0];

				repoSsiggle.setId(ssiggle.getId());
				repoSsiggle.setText(ssiggle.getText());

				return null;
			}
		}).when(ssiggleMapper).insertSsiggle((Ssiggle) anyObject());

		Ssiggle ssiggle = new Ssiggle(ssiggleMapper);
		ssiggle.setId(1);
		ssiggle.setText("가나다라");

		ssiggle.save();

		assertThat(repoSsiggle.getId(), is(ssiggle.getId()));
		assertThat(repoSsiggle.getText(), is(ssiggle.getText()));
	}

	@Test(expected = SsiggleDeleteException.class)
	public void testDeleteFail() {
		Ssiggle ssiggle = new Ssiggle(ssiggleMapper);
		ssiggle.setId(0);

		ssiggle.delete();
	}

	@Test
	public void testDelete() {
		final Ssiggle ssiggleOne = new Ssiggle(ssiggleMapper);
		ssiggleOne.setId(0);

		when(ssiggleMapper.selectSsiggleById(0L)).thenReturn(ssiggleOne);

		doAnswer(new Answer<Void>() {
			@Override
			public Void answer(InvocationOnMock invocation) throws Throwable {
				ssiggleOne.setId(-1);
				return null;
			}
		}).when(ssiggleMapper).deleteSsiggleById(0L);

		ssiggleOne.delete();

		assertThat(ssiggleOne.getId(), is(-1L));
	}

	@Test(expected = NotFoundSsiggleException.class)
	public void testFindSsiggleFail() {
		new Ssiggle(ssiggleMapper).findSsiggleById(100);
	}

	@Test
	public void testFindSsiggle() {
		when(ssiggleMapper.selectSsiggleById(1L)).thenAnswer(
				new Answer<Ssiggle>() {
					@Override
					public Ssiggle answer(InvocationOnMock invocation)
							throws Throwable {
						Ssiggle s = new Ssiggle();
						s.setId(1);

						return s;
					}
				});

		Ssiggle ssiggle = new Ssiggle(ssiggleMapper).findSsiggleById(1);
		assertThat(ssiggle.getId(), is(1L));
	}
}