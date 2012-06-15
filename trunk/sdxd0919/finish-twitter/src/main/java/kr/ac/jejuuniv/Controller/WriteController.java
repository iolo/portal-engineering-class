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

	@RequestMapping("/service/write") 
	public void loginpopup(){ 
	}


	@RequestMapping("/service/addTweet")
	public String action(HttpSession session, String message, String url) {
		int userNum = (Integer) session.getAttribute("userNum");
		
		int start = url.indexOf("twitter");
		url = url.substring(start + 8 , url.length());
		Tweet tweet = new Tweet(userNum, message);
		tweetService.addTweet(tweet);
		
		return "redirect:/" + url;
	}
}
