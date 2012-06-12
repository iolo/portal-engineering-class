package kr.ac.jejuuniv.controller;



import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.ac.jejuuniv.model.TwitModel;
import kr.ac.jejuuniv.service.TwitService;
import kr.ac.jejuuniv.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PrivatePageController {
	@Autowired
	TwitService twitService;
	
	@Autowired
	UserService userService;
	
	@RequestMapping("private_page")
	public ModelAndView private_page(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("private_page");
		
		request.getSession().setAttribute("TwitPage", "private_page");
		
		List<TwitModel> twitList = twitService.getListByWriter((String)request.getSession().getAttribute("LoginId"));
		
		mav.addObject("twitList", twitList);		
		mav.addObject("user", userService.getUser((String)request.getSession().getAttribute("LoginId")));
		
		return mav;
	}
}
