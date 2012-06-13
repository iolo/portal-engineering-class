package kr.ac.jejuuniv.twitter.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("index")
public class MainViewController {
	
	@RequestMapping
	public ModelAndView IndexView(HttpServletRequest request){
		return new ModelAndView("main","pageType","/twittlist");
	}
}
