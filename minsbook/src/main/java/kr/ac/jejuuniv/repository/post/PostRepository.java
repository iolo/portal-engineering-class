package kr.ac.jejuuniv.repository.post;

import java.util.List;

import org.springframework.stereotype.Repository;

import kr.ac.jejuuniv.model.Post;

@Repository
public interface PostRepository {
	public final static int NEW_POST_INDEX = -1;
	
	void savePost(Post post);
	
	void deletePost(int index);
	
	List<Post> getPosts(String userId);

	int getLastPostIndex();
}
