package kr.ac.hyosang.service.implement;

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
		return commentDao.getList();
	}

	@Override
	public int write(Comment comment) {
		return commentDao.saveComment(comment);		
	}

}
