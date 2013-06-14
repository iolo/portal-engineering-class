package kr.ac.jejunu.repositry;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.junit.runners.Parameterized.Parameter;

import kr.ac.jejunu.model.Comment;

public interface SqlMapper {

	@Select(value = { "SELECT * FROM comment.list;" })
	List<Comment> getList();

	
	@Insert(value = { "INSERT INTO comment.list (userUrl, writer, commentText, positive, negative, regTime) VALUES (#{userUrl}, #{writer}, #{commentText}, #{positive}, #{negative}, #{regTime});" })
	void insertComment(Comment comment);

}
