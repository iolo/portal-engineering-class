package kr.bong.replyboard.service.impl;

import java.util.Calendar;
import java.util.Date;
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
		List<Reply> list = replyDao.selectReplyList();
		
		Calendar today = Calendar.getInstance();
		Calendar regiDate = Calendar.getInstance();
		for (Reply reply : list) {
			regiDate.setTime(reply.getRegiDate());
			
			// 오늘인지 확인
			if(today.get(Calendar.YEAR) == regiDate.get(Calendar.YEAR)
			&& today.get(Calendar.MONTH) == regiDate.get(Calendar.MONTH)
			&& today.get(Calendar.DATE) == regiDate.get(Calendar.DATE)){
				String strDate = String.format("%02d:%02d"
						, regiDate.get(Calendar.HOUR_OF_DAY)
						, regiDate.get(Calendar.MINUTE));
				reply.setStrRegiDate(strDate);
			} else {
				String strDate = String.format("%04d.%02d.%02d"
						, regiDate.get(Calendar.YEAR)
						, regiDate.get(Calendar.MONTH)
						, regiDate.get(Calendar.DATE));
				reply.setStrRegiDate(strDate);
			}
			
			// 특수문자 처리
			String content = reply.getContent();
			if(content != null)
				reply.setContent(content.replaceAll("\r\n", "<br>"));
		}
		
		return list;
	}

	@Override
	public Reply getByReplyNo(int replyNo) {
		return replyDao.selectReplyByReplyNo(replyNo);
	}

	@Override
	public int write(Reply reply) {
		return replyDao.insertReply(reply);
	}

	@Override
	public int delete(int replyNo) {
		return replyDao.deleteReply(replyNo);
	}

}
