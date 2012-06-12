package kr.ac.jejuuniv.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.ac.jejuuniv.model.TwitModel;
import kr.ac.jejuuniv.model.UserModel;
import kr.ac.jejuuniv.service.TwitService;
import kr.ac.jejuuniv.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PublicPageController {
	@Autowired
	TwitService twitService;
	@Autowired
	UserService userSerivce;
	
	@RequestMapping("public_page")
	public ModelAndView public_page(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("public_page");
		mav.addObject("id", request.getSession().getAttribute("LoginId"));
		
		request.getSession().setAttribute("TwitPage", "public_page");
		
		List<TwitModel> twitList = twitService.getFollowingTwitList((String)request.getSession().getAttribute("LoginId"));
			
		UserModel my = userSerivce.getUser((String)request.getSession().getAttribute("LoginId"));

		List<String> imageHavingUser = userSerivce.getFollowingHaveImageList((String)request.getSession().getAttribute("LoginId"));
		
		for (TwitModel twit : twitList) {
			if(imageHavingUser.contains(twit.getWriter()))
				twit.setImage(twit.getWriter());
			else{
				if(twit.getWriter().equals(my.getId())) {
					twit.setImage(my.getImage());
				}else{
					twit.setImage("default");
				}
			}
		}		
		
		mav.addObject("twitList", twitList);
		
		return mav;
	}
}
