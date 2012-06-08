package kr.ac.jejuuniv.controller;



import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.ac.jejuuniv.model.TwitModel;
import kr.ac.jejuuniv.service.TwitService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndividualController {
	@Autowired
	TwitService twitService;
	
	@RequestMapping("Individual")
	public ModelAndView individual(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView modelView = new ModelAndView("individualPage");
		modelView.addObject("id", request.getSession().getAttribute("LoginId"));
		
		List<TwitModel> twitList = twitService.getListByWriter((String)request.getSession().getAttribute("LoginId"));
		
		modelView.addObject("twitList", twitList);
		
		return modelView;
	}
}