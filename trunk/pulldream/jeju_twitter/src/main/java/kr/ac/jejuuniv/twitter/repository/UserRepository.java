package kr.ac.jejuuniv.twitter.repository;

import java.util.List;

import kr.ac.jejuuniv.twitter.model.ArticleModel;
import kr.ac.jejuuniv.twitter.model.UserModel;

public interface UserRepository {
	
	void addUser(UserModel user);
	void writeArticle(ArticleModel article);
	void delUser(String id);
	List<UserModel> getAllUsers();
	List<UserModel> getFollowers();
}
