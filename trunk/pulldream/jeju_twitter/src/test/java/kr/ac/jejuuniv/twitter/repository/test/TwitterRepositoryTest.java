package kr.ac.jejuuniv.twitter.repository.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.ac.jejuuniv.twitter.model.FollowingModel;
import kr.ac.jejuuniv.twitter.model.FollowModel;
import kr.ac.jejuuniv.twitter.model.TwittModel;
import kr.ac.jejuuniv.twitter.model.UserModel;
import kr.ac.jejuuniv.twitter.repository.FollowRepository;
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

	TwittModel article = new TwittModel();
	
	@Autowired
	private TwitterRepository twitterRepository;
	
	@Autowired
	private FollowRepository followRepository;
	
	@Before
	public void setWriteArticle(){
		article.setId("juntheater");
		article.setContent("안녕하세요 여러분  ㅋㅋ");
	}
	
	@Test
	//글쓰기를 위한 테스트
	public void wirteArticleTest(){
		twitterRepository.writeTwitt(article);
	}
	
	@Test//글삭제를 위한 테스트
	public void delelteArticleTest(){
		int artid=2;
		twitterRepository.deleteMyTwitt(artid);
	}
	
//	@Test//팔로잉 하기... 내가 추천하는것?
//	public void addFowllowingTest(){
//		FollowModel followModel = new FollowModel();
//		followModel.setId("asdf");
//		followModel.setFollowing("juntheater2");
//		twitterRepository.addFollowing(followModel);
//	}
	
	
	@Test//팔로워 가지고 오기
	public void getAllFollower(){
		String id = "juntheater";
		List<FollowModel> getFollower = new ArrayList<FollowModel>();
		System.out.println(getFollower.size());
		getFollower = followRepository.getAllFollower(id);
	}
	
	@Test
	public void getTwittList(){
		List<TwittModel> twittList = new ArrayList<TwittModel>();
		twittList = twitterRepository.getTwittListOderByDate("juntheater");
	}
	
	@Test
	public void getHashTest(){
//		List<HashMap> test = twitterRepository.getUserHash();
//		for (int i = 0; i < test.size(); i++) {
//			System.out.println(test.get(i).keySet().toString());
//		}
		List<FollowModel> getFollower = followRepository.getFollowerById("juntheater");
		List<String> test2 = followRepository.getFollowingList("juntheater");
		List<FollowModel> follower = new ArrayList<FollowModel>();
		
		for (FollowModel followerModel : getFollower) {
			if(test2.contains(followerModel.getId())){
				followerModel.setFollowing(true);
			}else followerModel.setFollowing(false);
			follower.add(followerModel);
		}
		
		for (int i = 0; i < follower.size(); i++) {
			System.out.println(follower.get(i).isFollowing());
		}
	}
}
