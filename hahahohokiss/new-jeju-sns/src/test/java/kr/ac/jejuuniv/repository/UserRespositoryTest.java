package kr.ac.jejuuniv.repository;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

import kr.ac.jejuuniv.model.Tweet;
import kr.ac.jejuuniv.model.User;

import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
		locations = {"classpath:/applicationContext-resources.xml",
					"classpath:/applicationContext-repository.xml",
					 "classpath:/hibernate.cfg.xml"
		})
@Transactional
public class UserRespositoryTest {
	private HibernateTemplate hibernateTemplate;
	
	@Autowired
	public void setSesstionFactory(SessionFactory sessionFactory) {
		hibernateTemplate = new HibernateTemplate(sessionFactory);
	}
	@Test
	public void testFindUserByUserId() {
		List<User> users = hibernateTemplate.find("from User where login_id = ?", "hahahohokiss");
		User user = users.get(0);
		assertThat(user.getLoginId(), is("hahahohokiss"));
	}
	
	@Test
	public void testFindPasswordByUserId() {
		List<User> users = hibernateTemplate.find("from User where login_id = ?", "hahahohokiss");
		User user = users.get(0);
		assertThat(user.getPassword(), is("password"));
	}
	
	@Test
	public void testFindTweetByUserId()	{
		List<User> users = hibernateTemplate.find("from User where login_id = ?", "hahahohokiss");
		User user = users.get(0);
		List<Tweet> tweets = user.getTweets();
		assertTrue(tweets.size() > 0);
	}
	
	@Test
	public void testFindFollowingUserByUserId() {
		List<User> users = hibernateTemplate.find("from User where login_id = ?", "hahahohokiss");
		User user = users.get(0);
		List<User> followingUser = user.getFollowing();
		assertTrue(followingUser.size() > 0);
	}
	
	@Test
	public void testFindFollowerUserByUserId() {
		List<User> users = hibernateTemplate.find("from User where login_id = ?", "hahahohokiss");
		User user = users.get(0);
		List<User> follower = user.getFollower();
		assertTrue(follower.size() > 0);
	}
	
	@Test
	public void testFindAllUser() {
		List<User> users = hibernateTemplate.find("from User");
		assertTrue(users.size() > 0);
	}
	
	@Test
	public void testFindFollowingUserTweetByFollowingUser() {
		List<User> users = hibernateTemplate.find("from User where login_id = ?", "hahahohokiss");
		User user = users.get(0);
		List<User> followingUser = user.getFollowing();
		List<Tweet> getTweets = new ArrayList<Tweet>();
		List<Tweet> resultTweets = new ArrayList<Tweet>();
		
		for(int i=0; i<followingUser.size(); i++) {
			getTweets = followingUser.get(i).getTweets();
			for(int j=0; j<getTweets.size(); j++) {
				resultTweets.add(getTweets.get(j));
			}
		}
		Collections.sort(resultTweets);
		Collections.reverse(resultTweets);
	}
	
	@Test
	public void testUpdateUser() {
		List<User> users = hibernateTemplate.find("from User where login_id = ?", "hahahohokiss");
		User user = users.get(0);
		user.setUsername("change");
		hibernateTemplate.merge(user);
	}
	
	@Test
	public void testInsertTweet() {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.KOREA);
		String date = simpleDateFormat.format(new Date());
		
		List<User> users = hibernateTemplate.find("from User where login_id = ?", "hahahohokiss");
		User user = users.get(0);
		Tweet tweet = new Tweet();
		tweet.setContents("AAA");
		tweet.setDate(date);
		tweet.setUser(user);
		hibernateTemplate.save(tweet);
	}
	
	@Test
	public void testInsertUser() {
		User user = new User();
		user.setLoginId("new-User");
		hibernateTemplate.save(user);
	}
	
	@Test
	public void tsetInsertFollowing() {
		User user1 = hibernateTemplate.get(User.class, 1);
		User user2 = hibernateTemplate.get(User.class, 2);
		User user3 = hibernateTemplate.get(User.class, 3);
		user1.getFollowing().add(user2);
		user1.getFollowing().add(user3);
		hibernateTemplate.merge(user1);
	}
	
	@Test
	public void testDeleteTweet() {
		int tweetId = 0;
		
		List<User> users = hibernateTemplate.find("from User where login_id = ?", "hahahohokiss");
		User user = users.get(0);
		List<Tweet> tweets = user.getTweets();
		for(Iterator i = tweets.iterator(); i.hasNext();) {
			Tweet tweet =(Tweet) i.next();
			if(tweet.getTweetId() == tweetId) {
				hibernateTemplate.delete(tweet);
			}
		}
		
	}
}
