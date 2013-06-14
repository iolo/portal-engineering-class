package kr.mg.comment.repository.mapper;

import java.util.List;

import kr.mg.comment.model.User;
import kr.mg.comment.repository.UserDao;

public interface UserMapper extends UserDao{

	int insertUser(User user);

	User getUser(String id);

	List<User> getList(String string);
}