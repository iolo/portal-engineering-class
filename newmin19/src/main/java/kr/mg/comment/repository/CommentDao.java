package kr.mg.comment.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import kr.mg.comment.model.Comment;

@Repository
public interface CommentDao {
	int insertComment(Comment comment);
	
	Comment getComment(int commentNum);
	
	List<Comment> getList(String string);

}
