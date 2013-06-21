package kr.ac.jejunu.repositry;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import kr.ac.jejunu.model.Comment;
import kr.ac.jejunu.model.IndexList;
import kr.ac.jejunu.model.UserInfo;

public interface SqlMapper {
	//inset
	@Insert(value = { "INSERT INTO list (userUrl, writer, commentText, positive, negative, regTime) VALUES (#{userUrl}, #{writer}, #{commentText}, #{positive}, #{negative}, #{regTime});" })
	void insertComment(Comment comment);
	
	@Insert(value = {"INSERT INTO userJoinInfo (id, password, name, profile, profile_url) VALUES (#{id}, #{password}, #{name}, #{profile}, #{profile_url});"})
	void joinUser(UserInfo user);
	
	@Insert(value = {"INSERT INTO userlikecomment (id,listId) VALUES (#{id}, #{listId})"})
	void userLikeComment(@Param("id")String id,@Param("listId") int listId);

	//select
	@Select(value = { "SELECT * FROM list;" })
	List<Comment> getAllList();

	@Select(value = {"SELECT * FROM userJoinInfo WHERE id = #{id}"})
	UserInfo selectUser(@Param("id")String id);
	
	@Select(value = {"SELECT * FROM list WHERE listId = #{listId}"})
	Comment getComment(@Param("listId")int listId);

	@Select(value = {"SELECT * FROM userlikecomment WHERE listId = #{listId} AND listId = #{listId}"})
	boolean checkPositiveAndNegative(@Param("id")String id, @Param("listId")int listId);

	@Select(value = {"SELECT listId FROM list"})
	List<IndexList> indexlist();
	
	@Select(value = {"SELECT * FROM list WHERE listId >= #{selectPageLastListId} LIMIT 10"})
	List<Comment> getSelectPage(@Param("selectPageLastListId")int selectPageLastListId);
	
	//update
	@Update(value = {"UPDATE list SET positive = positive + 1 WHERE listId = #{listId}"})
	void positiveUser(@Param("listId")int listId);
	
	@Update(value = {"UPDATE list SET neagtive = neagtive + 1 WHERE listId = #{listId}"})
	void negativeUser(@Param("listId")int listId);

	//delete
	@Delete(value = {"DELETE FROM list WHERE listId = #{listId}"})
	void deleteComment(@Param("listId") int listId);
}
