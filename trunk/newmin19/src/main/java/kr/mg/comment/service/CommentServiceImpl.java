package kr.mg.comment.service;

import java.util.Calendar;
import java.util.List;

import kr.mg.comment.model.Comment;
import kr.mg.comment.repository.CommentDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {

	@Autowired
	CommentDao commentdao;

	@Override
	public int insertCommentData(Comment comment) {
		return commentdao.insertComment(comment);
	}

	@Override
	public List<Comment> getList() {
		List<Comment> list = commentdao.getList();
		
		Calendar today = Calendar.getInstance();
		Calendar regiDate = Calendar.getInstance();
		for (Comment comment : list) {
			regiDate.setTime(comment.getRegdate());
			
			// 오늘인지 확인
			if(today.get(Calendar.YEAR) == regiDate.get(Calendar.YEAR)
			&& today.get(Calendar.MONTH) == regiDate.get(Calendar.MONTH)
			&& today.get(Calendar.DATE) == regiDate.get(Calendar.DATE)){
				String strDate = String.format("%02d:%02d"
						, regiDate.get(Calendar.HOUR_OF_DAY)
						, regiDate.get(Calendar.MINUTE));
				comment.setStrRegdate(strDate);
			} else {
				String strDate = String.format("%04d/%02d/%02d"
						, regiDate.get(Calendar.YEAR)
						, regiDate.get(Calendar.MONTH)
						, regiDate.get(Calendar.DATE));
				comment.setStrRegdate(strDate);
			}
		}
		return list;
	}
	
}
