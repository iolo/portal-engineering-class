package kr.ac.jejunu.repository;

import java.util.List;

import kr.ac.jejunu.model.Comment;

public interface CommentDao {
	
	int saveComment(Comment comment);
	
	Comment getComment(int id);

	List<Comment> getList(String string);

}
