package kr.ac.jejunu.service;

import kr.ac.jejunu.model.Rating;
import kr.ac.jejunu.repository.CommentDao;
import kr.ac.jejunu.repository.RatingDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {
	
	@Autowired private CommentDao commentDao;
	@Autowired private RatingDao ratingDao;

	@Override
	public void likeComment(int commentId) {
		// 1. Rating table row 추가
		Rating rating = new Rating();
		rating.setCommentId(commentId);
		rating.setUserId("testId");
		
		ratingDao.addRating(rating);
		
		// 2. Comment row의 likeCount 1증가
		commentDao.increaseLikeCount(commentId);
	}

}
