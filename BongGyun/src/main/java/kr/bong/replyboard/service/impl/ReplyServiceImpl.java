package kr.bong.replyboard.service.impl;

import java.util.List;

import kr.bong.replyboard.model.Reply;
import kr.bong.replyboard.repository.ReplyDao;
import kr.bong.replyboard.service.ReplyService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReplyServiceImpl implements ReplyService {

	@Autowired
	ReplyDao replyDao;
	
	@Override
	public List<Reply> getList() {
		return replyDao.selectReplyList();
	}

	@Override
	public Reply getByReplyNo(int replyNo) {
		return replyDao.selectReplyByReplyNo(replyNo);
	}

	@Override
	public int save(Reply reply) {
		return replyDao.insertReply(reply);
	}

	@Override
	public int delete(int replyNo) {
		return replyDao.deleteReply(replyNo);
	}

}
