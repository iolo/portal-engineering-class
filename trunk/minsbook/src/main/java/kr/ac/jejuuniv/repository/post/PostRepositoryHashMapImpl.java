package kr.ac.jejuuniv.repository.post;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Repository;

import kr.ac.jejuuniv.model.Post;
import kr.ac.jejuuniv.repository.exception.PostNotFoundException;

@Repository
public class PostRepositoryHashMapImpl implements PostRepository {
	HashMap<Integer, Post> posts = new HashMap<Integer, Post>();
	private int lastIndexNo = 0;

	@Override
	public void savePost(Post post) {
		if(post.getIndex() == PostRepository.NEW_POST_INDEX) {
			lastIndexNo++;
			post.setIndex(lastIndexNo);
		}			
		posts.put(post.getIndex(), post);

	}

	@Override
	public void deletePost(int index) {
		posts.remove(index);
	}

	@Override
	public List<Post> getPosts(String id) {
		ArrayList<Post> foundPosts = new ArrayList<Post>();
		for (int index : posts.keySet()) {
			Post foundPost = posts.get(index);
			if (foundPost.getUser().getId().equals(id))
				foundPosts.add(foundPost);
		}

		if (foundPosts.size() <= 0)
			throw new PostNotFoundException(id);
		else
			return foundPosts;
	}

	@Override
	public int getLastPostIndex() {
		return lastIndexNo;
	}

}
