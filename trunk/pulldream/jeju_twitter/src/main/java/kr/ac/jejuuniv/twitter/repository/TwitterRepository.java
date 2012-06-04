package kr.ac.jejuuniv.twitter.repository;

import kr.ac.jejuuniv.twitter.model.ArticleModel;

public interface TwitterRepository {
	void deleteArticle(String artid);
	void writeArticle(ArticleModel articleModel);
}
