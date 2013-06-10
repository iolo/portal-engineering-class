package kr.ac.jejunu.service;

import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface CommentService {
	
	public void likeComment(int commentId);

}
