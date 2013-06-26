package com.rillflow.memo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rillflow.memo.model.Reply;
import com.rillflow.memo.repository.ReplyDao;
import com.rillflow.memo.service.ReplyService;

@Service
public class ReplyServiceImpl implements ReplyService {

	@Autowired
	ReplyDao replyDao;
	
	@Override
	public int write(Reply reply) {
		return replyDao.insertReply(reply);
	}

	@Override
	public int delete(int no) {
		return replyDao.deleteReply(no);
	}
	
	@Override
	public List<Reply> getReplyList() {
		return replyDao.selectReplyList();
	}

	@Override
	public Reply getReplyByNo(int no) {
		return replyDao.selectReplyByNo(no);
	}
}
