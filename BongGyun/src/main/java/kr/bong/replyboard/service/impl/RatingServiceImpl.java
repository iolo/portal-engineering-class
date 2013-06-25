package kr.bong.replyboard.service.impl;

import kr.bong.replyboard.model.Rating;
import kr.bong.replyboard.repository.RatingDao;
import kr.bong.replyboard.repository.ReplyDao;
import kr.bong.replyboard.service.RatingService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

@Service
public class RatingServiceImpl implements RatingService {

	@Autowired
	RatingDao ratingDao;

	@Autowired
	ReplyDao replyDao;

	@Override
	public int upRating(Rating rating) {
		try {
			ratingDao.insertUpRating(rating);
			replyDao.updateUpCount(rating.getReplyNo());
		} catch (DuplicateKeyException e) {
			return -1; // 이미 한경우
		}
		return 1;
	}

	@Override
	public int downRating(Rating rating) {
		try {
			ratingDao.insertDownRating(rating);
			replyDao.updateDownCount(rating.getReplyNo());
		} catch (DuplicateKeyException e) {
			return -1; // 이미 한경우
		}
		return 1;
	}
}
