package kr.mg.comment.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.mg.comment.model.Comment;
import kr.mg.comment.repository.CommentDao;

@Service
public class CommentServiceImpl implements CommentService {

	@Autowired
	CommentDao commentdao;

	@Override
	public int insertCommentData(Comment comment) {
		return commentdao.insertComment(comment);
	}

}
