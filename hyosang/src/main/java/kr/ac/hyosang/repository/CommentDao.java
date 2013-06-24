package kr.ac.hyosang.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import kr.ac.hyosang.model.Comment;

@Repository
public interface CommentDao {
	
	int saveComment(Comment comment);
	
	Comment getComment(int id);

	List<Comment> getList();
	
	int deleteComment(int id);
}
