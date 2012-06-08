package kr.ac.jejuuniv.controller;

import javax.servlet.http.HttpSession;


public class TweetRemoveController {

	public String removeTweetAction(HttpSession session, int tweetId) {
		return "redirect:/service/personalSns";
	}
}
