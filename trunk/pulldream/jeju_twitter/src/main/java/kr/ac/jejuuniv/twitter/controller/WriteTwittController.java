package kr.ac.jejuuniv.twitter.controller;

import javax.servlet.http.HttpServletRequest;

import kr.ac.jejuuniv.twitter.model.TwittModel;
import kr.ac.jejuuniv.twitter.repository.TwitterRepository;
import kr.ac.jejuuniv.twitter.service.TwitterService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WriteTwittController {

	@Autowired
	private TwitterService twitterService;
	
	@RequestMapping("writeform")
	public ModelAndView writeForm(TwittModel twittModel){
		return new ModelAndView("twitt/twitt");
	}
	
	@RequestMapping("write.do")
	public ModelAndView writeTwitt(TwittModel twittModel,HttpServletRequest request){
		String twittID = (String)request.getSession().getAttribute("loginID");
		System.out.println(twittID);
		twittModel.setId(twittID);
		twitterService.writeTwitt(twittModel);
		return null;
	}
}
