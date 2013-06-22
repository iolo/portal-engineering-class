package kr.mg.comment.service;

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
		return commentdao.getList();
	}
	
}
