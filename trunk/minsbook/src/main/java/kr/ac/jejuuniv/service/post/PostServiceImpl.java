package kr.ac.jejuuniv.service.post;

import java.util.List;

import kr.ac.jejuuniv.model.Post;
import kr.ac.jejuuniv.repository.post.PostRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements PostService {
	
	@Autowired
	PostRepository postRepository;

	@Override
	public List<Post> getPosts(String userId) {
		return postRepository.getPosts(userId);
	}

	@Override
	public void save(Post newPost) {
		postRepository.savePost(newPost);
	}

	@Override
	public void delete(int index) {
		postRepository.deletePost(index);
	}

}
