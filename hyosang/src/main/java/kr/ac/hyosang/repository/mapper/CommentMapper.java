package kr.ac.hyosang.repository.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import kr.ac.hyosang.model.Comment;
import kr.ac.hyosang.repository.CommentDao;

public interface CommentMapper extends CommentDao {
	
	Comment getComment(int id);
	
	int saveComment(Comment comment);
	
	List<Comment> getList(@Param("sortColumn") String sortColumn);

}
