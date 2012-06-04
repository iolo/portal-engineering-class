package kr.ac.jejuuniv.twitter.repository.test;

import kr.ac.jejuuniv.twitter.model.ArticleModel;
import kr.ac.jejuuniv.twitter.model.UserModel;
import kr.ac.jejuuniv.twitter.repository.UserRepository;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/mybatis/repository.xml")
public class UserRepositoryTest {

	@Autowired
	private UserRepository userRepository;
	
	private UserModel user = new UserModel();
	
	@Before
	public void setUser(){
		user.setId("juntheater3");
		user.setName("Young");
		user.setPassword("asdf");
		user.setProfile("xc");
	}
	
	@Test
	public void addUserTest() {
		//사용자 넣기 테스트
		userRepository.addUser(user);
		userRepository.delUser(user.getId());
	}
	
	@Test
	//글쓰기를 위한 테스트
	public void wirteArticleTest(){
		ArticleModel article = new ArticleModel();
		article.setId("juntheater");
		article.setContent("Hello World");
		userRepository.writeArticle(article);
	}
}
