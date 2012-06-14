package kr.ac.jejuuniv.service.post;

import java.util.List;

import kr.ac.jejuuniv.model.Post;

public interface PostService {
	List<Post> getPosts(String userId);
	
	void save(Post newPost);
		
	void delete(int index);
}
