package kr.bong.replyboard.repository.mapper;

import java.util.List;

import kr.bong.replyboard.model.Reply;
import kr.bong.replyboard.repository.ReplyDao;

public interface ReplyMapper extends ReplyDao {
	int insertReply(Reply reply);

	Reply selectReplyByReplyNo(int replyNo);

	public List<Reply> selectReplyList();
}
