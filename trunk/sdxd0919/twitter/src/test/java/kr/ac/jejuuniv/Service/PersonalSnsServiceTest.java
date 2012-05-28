package kr.ac.jejuuniv.Service;

import static org.hamcrest.CoreMatchers.*;
import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import kr.ac.jejuuniv.Model.User;
import kr.ac.jejuuniv.Repository.PersonalSnsRepository;

import org.aspectj.weaver.ArrayAnnotationValue;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;

@RunWith(MockitoJUnitRunner.class)
public class PersonalSnsServiceTest {
	@Mock
	PersonalSnsRepository personalSnsRepository;
	
	//userNum 받아서, name과 user의 tweet 정보 가져오기.
	@Test
	public void action(){
		PersonalSnsUserService personalSnsSerivce = new PersonalSnsServiceImpl(personalSnsRepository);
		
		when(personalSnsRepository.findByUserNum(1)).thenAnswer(new Answer<User>() {
			public User answer(InvocationOnMock invocation) throws Throwable {
				User user = new User();
				user.setUserNum(Integer.parseInt(invocation.getArguments()[0].toString()));
				user.setName("현소영");
				return user;
			}
		});
		
		
		User user = personalSnsSerivce.getUser(1);
		
		assertThat(user.getUserNum(), is(1));
		assertThat(user.getName(), is("현소영"));
	}
	
}
