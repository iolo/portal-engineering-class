package kr.ac.hyosang.repository;

import java.util.List;

import kr.ac.hyosang.model.Comment;

public interface CommentDao {
	
	int saveComment(Comment comment);
	
	Comment getComment(int id);

	List<Comment> getList(String string);

	void increaseLikeCount(int commentId);

}
