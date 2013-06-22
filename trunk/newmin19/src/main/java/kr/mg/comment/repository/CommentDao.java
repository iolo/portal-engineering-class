package kr.mg.comment.repository;

import java.util.List;

import kr.mg.comment.model.Comment;

import org.springframework.stereotype.Repository;

@Repository
public interface CommentDao {
	int insertComment(Comment comment);
	
	Comment getComment(int commentNum);
	
	List<Comment> getList();

}
