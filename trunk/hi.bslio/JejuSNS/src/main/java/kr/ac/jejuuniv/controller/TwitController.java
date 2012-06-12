package kr.ac.jejuuniv.controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;

import kr.ac.jejuuniv.model.TwitModel;
import kr.ac.jejuuniv.service.TwitService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TwitController {
	@Autowired
	private TwitService twitService;
	
	@RequestMapping("twitWrite_page")
	public ModelAndView writeSns() {
		return new ModelAndView("twitWrite_page");
	}
	
	@RequestMapping("twitWrite.do")
	public ModelAndView writeTwit_submit(TwitModel twit, HttpServletRequest request)
	{
		
		TwitModel insertTwit = new TwitModel();
		insertTwit.setWriter((String)request.getSession().getAttribute("LoginId"));
		insertTwit.setTwit_text(twit.getTwit_text());
		
		SimpleDateFormat simpleDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		insertTwit.setDate(simpleDate.format(Calendar.getInstance().getTime()));
		
		twitService.insertTwit(insertTwit);
		
		
		return new ModelAndView("redirect:" + (String)request.getSession().getAttribute("TwitPage"));
	}
	
	@RequestMapping("twitDelete.do")
	public ModelAndView deleteTwit(String id, HttpServletRequest request){
		// 로그인한 사람이 쓴 글일때 삭제
		if(twitService.findById(id).getWriter().equals(request.getSession().getAttribute("LoginId"))){
			twitService.deleteTwit(id);
			
		}
		
		return new ModelAndView("redirect:" + (String)request.getSession().getAttribute("TwitPage"));
	}
}
