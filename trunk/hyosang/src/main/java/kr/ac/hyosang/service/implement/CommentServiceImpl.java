package kr.ac.hyosang.service.implement;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.hyosang.model.Comment;
import kr.ac.hyosang.repository.CommentDao;
import kr.ac.hyosang.service.CommentService;

@Service
public class CommentServiceImpl implements CommentService {
	@Autowired
	CommentDao commentDao;

	@Override
	public List<Comment> getCommentList() {
		List<Comment> commentList = commentDao.getList();

		Calendar today = Calendar.getInstance();
		Calendar regDate = Calendar.getInstance();
		for (Comment comment : commentList) {
			regDate.setTime(comment.getRegdate());
			if(today.get(Calendar.YEAR) == regDate.get(Calendar.YEAR) && today.get(Calendar.MONTH) == regDate.get(Calendar.MONTH) && today.get(Calendar.DATE) == regDate.get(Calendar.DATE)){
				String strDate = String.format("%02d : %02d", regDate.get(Calendar.HOUR_OF_DAY), regDate.get(Calendar.MINUTE));
				comment.setRegdateToString(strDate);
			} else {
				String strDate = String.format("%04d. %02d. %02d", regDate.get(Calendar.YEAR), regDate.get(Calendar.MONTH), regDate.get(Calendar.DATE));
				comment.setRegdateToString(strDate);
			}
		}
		return commentList; 
	}

	@Override
	public int write(Comment comment) {
		return commentDao.saveComment(comment);		
	}

	@Override
	public int deleteComment(int id) {
		return commentDao.deleteComment(id);
	}
}
