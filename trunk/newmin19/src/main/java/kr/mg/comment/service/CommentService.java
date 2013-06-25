package kr.mg.comment.service;

import java.util.List;

import kr.mg.comment.model.Comment;

public interface CommentService {

	int insertCommentData(Comment comment);
	
	List<Comment> getList();

}
