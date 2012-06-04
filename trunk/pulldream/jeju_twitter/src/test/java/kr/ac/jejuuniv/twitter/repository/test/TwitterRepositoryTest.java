package kr.ac.jejuuniv.twitter.repository.test;

import kr.ac.jejuuniv.twitter.model.ArticleModel;
import kr.ac.jejuuniv.twitter.repository.TwitterRepository;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/mybatis/repository.xml")
public class TwitterRepositoryTest {

	ArticleModel article = new ArticleModel();
	
	@Autowired
	private TwitterRepository twitterRepository;
	
	@Before
	public void setWriteArticle(){
		article.setId("juntheater");
		article.setContent("안녕하세요 여러분  ㅋㅋ");
	}
	
	@Test
	//글쓰기를 위한 테스트
	public void wirteArticleTest(){
		twitterRepository.writeArticle(article);
	}
	
	@Test//글삭제를 위한 테스트
	public void delelteArticleTest(){
		String artid="8";
		twitterRepository.deleteArticle(artid);
	}
}
