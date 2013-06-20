package kr.ac.jejunu.repositry;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import kr.ac.jejunu.model.Comment;

public interface SqlMapper {

	@Select(value = { "SELECT * FROM commentdb.list;" })
	List<Comment> getList();

	@Insert(value = { "INSERT INTO commentdb.list (userUrl, writer, commentText, positive, negative, regTime) VALUES (#{userUrl}, #{writer}, #{commentText}, #{positive}, #{negative}, #{regTime});" })
	void insertComment(Comment comment);

	@Delete(value = {"DELETE FROM commentdb.list WHERE listId = #{listId}"})
	void deleteComment(@Param("listId") int listId);

}
