package com.rillflow.memo.service;

import java.util.List;

import com.rillflow.memo.model.Reply;

public interface ReplyService {
	int write(Reply reply);
	int delete(int no);
	List<Reply> getReplyList();
	Reply getReplyByNo(int no);
}
