package kr.ac.jejuuniv.Controller;

import javax.servlet.http.HttpSession;

import kr.ac.jejuuniv.Model.Tweet;
import kr.ac.jejuuniv.Service.TweetService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WriteController {

	@Autowired
	private TweetService tweetService;

	@RequestMapping("/write") 
	public void loginpopup(){ 
	}


	@RequestMapping("/addTweet")
	public String action(HttpSession session, String message, String url) {
		int userNum = (Integer) session.getAttribute("userNum");
		
		url = url.substring(30, url.length());
		Tweet tweet = new Tweet(userNum, message);
		tweetService.addTweet(tweet);
		
		return "redirect:/" + url;
	}
}
