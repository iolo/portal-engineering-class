package kr.ac.jejuuniv.twitter.service.test;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import kr.ac.jejuuniv.twitter.model.FollowModel;
import kr.ac.jejuuniv.twitter.model.FollowingModel;
import kr.ac.jejuuniv.twitter.model.TwittModel;
import kr.ac.jejuuniv.twitter.repository.TwitterRepository;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.AssertThrows;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/mybatis/repository.xml")
public class TwitterServiceTest {

	@Autowired
	private TwitterRepository twitterRepository;
	
	private TwittModel twittModel;
	
	@Before
	public void setTwitt(){
		twittModel = new TwittModel();
		twittModel.setId("juntheater");
		twittModel.setContent("asdfasdfadsf");
	}
	
	@Test
	public void writeTwitt(){
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
		String dateTime = dateFormat.format(new Date());
		twittModel.setWrite_date(dateTime);
		System.out.println(twittModel.getWrite_date());
		twitterRepository.writeTwitt(twittModel);
	}
	
	@Test
	public void getFollowingList(){
		List<FollowingModel> FollowingList = new ArrayList<FollowingModel>();
		
		FollowingList = twitterRepository.getFollowingById("juntheater");
		
		assertThat(FollowingList.get(0).getFollowing(), is("asdf"));
	}
}
