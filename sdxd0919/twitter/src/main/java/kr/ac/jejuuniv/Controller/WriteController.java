package kr.ac.jejuuniv.Controller;

import javax.servlet.http.HttpSession;

import kr.ac.jejuuniv.Model.Tweet;
import kr.ac.jejuuniv.Model.User;
import kr.ac.jejuuniv.Service.TweetService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/write")
public class WriteController {

	@Autowired
	private TweetService tweetService;

	@RequestMapping
	public void action(HttpSession session, String message){
		int userNum = (Integer) session.getAttribute("userNum");

		if(message != null){
			Tweet tweet = new Tweet(userNum, message);
			tweetService.addTweet(tweet);
		}
	}
}