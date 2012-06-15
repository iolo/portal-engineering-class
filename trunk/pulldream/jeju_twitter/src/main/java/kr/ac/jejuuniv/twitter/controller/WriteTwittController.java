package kr.ac.jejuuniv.twitter.controller;

import javax.servlet.http.HttpServletRequest;

import kr.ac.jejuuniv.twitter.model.TwittModel;
import kr.ac.jejuuniv.twitter.repository.TwitterRepository;
import kr.ac.jejuuniv.twitter.service.TwitterService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WriteTwittController {

	@Autowired
	private TwitterService twitterService;
	
	@RequestMapping("writeform")
	public ModelAndView writeForm(@ModelAttribute("twitt")TwittModel twittModel){
		return new ModelAndView("twitt/writetwitt");
	}
	
	@RequestMapping("write.do")
	public String writeTwitt(@ModelAttribute("twitt")TwittModel twittModel,HttpServletRequest request){
		String twittID = (String)request.getSession().getAttribute("loginID");
		String twittName = (String)request.getSession().getAttribute("loginName");
		twittModel.setId(twittID);
		twittModel.setName(twittName);
		twitterService.writeTwitt(twittModel);
		return "redirect:/index";
	}
}
