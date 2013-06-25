package kr.bong.replyboard.service;

import org.springframework.transaction.annotation.Transactional;

import kr.bong.replyboard.model.Rating;

@Transactional
public interface RatingService {

	int upRating(Rating rating);

	int downRating(Rating rating);
}
