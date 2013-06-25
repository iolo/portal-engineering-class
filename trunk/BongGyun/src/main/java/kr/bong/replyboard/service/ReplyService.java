package kr.bong.replyboard.service;

import java.util.List;

import kr.bong.replyboard.model.Reply;

public interface ReplyService {
	List<Reply> getList(int page);

	int getCount();
	
	Reply getByReplyNo(int replyNo);
	
	int write(Reply reply);
	
	int delete(int replyNo);
}
