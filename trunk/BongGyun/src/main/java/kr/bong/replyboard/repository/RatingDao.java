package kr.bong.replyboard.repository;

import kr.bong.replyboard.model.Rating;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface RatingDao {
	int insertUpRating(Rating rating);

	int insertDownRating(Rating rating);
}
