package kr.ac.hyosang.service;

import java.util.List;

import kr.ac.hyosang.model.Comment;
 
public interface CommentService {
	List<Comment> getCommentList();

	int write(Comment comment);
}
