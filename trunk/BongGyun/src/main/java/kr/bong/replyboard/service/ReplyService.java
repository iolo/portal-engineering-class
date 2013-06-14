package kr.bong.replyboard.service;

import java.util.List;

import kr.bong.replyboard.model.Reply;

public interface ReplyService {
	List<Reply> getList();
	
	Reply getByReplyNo(int replyNo);
	
	int save(Reply reply);
	
	int delete(int replyNo);
}
