package kr.ac.jejuuniv.twitter.service;

import kr.ac.jejuuniv.twitter.model.ArticleModel;
import kr.ac.jejuuniv.twitter.model.UserModel;

public interface UserService {
	void addUser(UserModel user);
	void writeArticle(ArticleModel article);
	void delUser(String id);
}
