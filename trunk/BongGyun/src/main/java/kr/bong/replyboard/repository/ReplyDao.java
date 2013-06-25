package kr.bong.replyboard.repository;

import java.util.List;

import kr.bong.replyboard.model.Rating;
import kr.bong.replyboard.model.Reply;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface ReplyDao {
	int insertReply(Reply reply);

	Reply selectReplyByReplyNo(int replyNo);

	List<Reply> selectReplyList(int page);

	int selectReplyCount();
	
	int deleteReply(int replyNo);
	
	int updateUpCount(int replyNo);

	int updateDownCount(int replyNo);
}
