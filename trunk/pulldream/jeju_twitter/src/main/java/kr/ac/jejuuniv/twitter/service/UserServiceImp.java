package kr.ac.jejuuniv.twitter.service;


import kr.ac.jejuuniv.twitter.model.ArticleModel;
import kr.ac.jejuuniv.twitter.model.UserModel;
import kr.ac.jejuuniv.twitter.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImp implements UserService{
	@Autowired
	private UserRepository userRepository;

	public void addUser(UserModel user) {
		userRepository.addUser(user);
	}

	public void writeArticle(ArticleModel article) {
		CheckToday today = new CheckToday();
		article.setWritedate(today.Today());
		userRepository.writeArticle(article);
	}

	public void delUser(String id) {
		userRepository.delUser(id);
	}
}
