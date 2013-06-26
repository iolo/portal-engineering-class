package com.rillflow.memo.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.rillflow.memo.model.Reply;

@Repository
public interface ReplyDao {
	int insertReply(Reply reply);
	int deleteReply(int replyNo);
	List<Reply> selectReplyList();
	Reply selectReplyByNo(int no);
}
