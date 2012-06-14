package kr.ac.jejuuniv.test;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import kr.ac.jejuuniv.model.Post;
import kr.ac.jejuuniv.model.User;
import kr.ac.jejuuniv.repository.exception.PostNotFoundException;
import kr.ac.jejuuniv.repository.post.PostRepository;
import kr.ac.jejuuniv.repository.post.PostRepositoryHashMapImpl;

import org.junit.Before;
import org.junit.Test;

public class PostRepositoryTest {

	private PostRepository postRepository;

	@Before
	public void init() {
		postRepository = new PostRepositoryHashMapImpl();
	}
	
	@Test
	public void testSave() {
		User user = new User("jungmin", "1234", "김정민", "ssub", "c:\\fucku");
		Post post = new Post(PostRepository.NEW_POST_INDEX, user, "안녕하세요", new Date());
		postRepository.savePost(post);
		List<Post> posts = postRepository.getPosts(user.getId());
		
		assertEquals(1, postRepository.getLastPostIndex());
		assertEquals("안녕하세요", posts.get(0).getContent());
	}
	
	@Test(expected=PostNotFoundException.class)
	public void failTestGetPosts() {
		postRepository.getPosts("OMG");
	}
	
	@Test(expected=PostNotFoundException.class)
	public void testDelete() {
		User user = new User("jungmin", "1234", "김정민", "ssub", "c:\\fucku");
		Post post = new Post(PostRepository.NEW_POST_INDEX, user, "안녕하세요", new Date());
		postRepository.savePost(post);
		postRepository.deletePost(postRepository.getLastPostIndex());
		postRepository.getPosts("jungmin");
	}

}
