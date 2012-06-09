package kr.ac.jejuuniv.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/service/tweetWriteForm")
public class TweetWriteFormController {

	@RequestMapping
	public String action() {
		return "/service/tweetWriteForm";
	}

}
