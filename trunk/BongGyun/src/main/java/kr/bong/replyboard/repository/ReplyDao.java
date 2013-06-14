package kr.bong.replyboard.repository;

import java.util.List;

import kr.bong.replyboard.model.Reply;

import org.springframework.stereotype.Repository;

@Repository
public interface ReplyDao {
	int insertReply(Reply reply);

	Reply selectReplyByReplyNo(int replyNo);

	List<Reply> selectReplyList();

	int deleteReply(int replyNo);
}
