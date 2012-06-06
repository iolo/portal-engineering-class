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
	
	@RequestMapping("writeSns")
	public ModelAndView writeSns() {
		return new ModelAndView("writeSns");
	}
	
	@RequestMapping("writeTwit.submit")
	public void writeTwit_submit(TwitModel twit, HttpServletRequest request)
	{
		
		TwitModel insertTwit = new TwitModel();
		insertTwit.setWriter((String)request.getSession().getAttribute("LoginId"));
		insertTwit.setTwit_text(twit.getTwit_text());
		
		SimpleDateFormat simpleDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		insertTwit.setDate(simpleDate.format(Calendar.getInstance().getTime()));
		
		twitService.insertTwit(insertTwit);

	}
}
