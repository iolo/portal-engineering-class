package net.daum.springframework.openseminar.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.daum.springframework.openseminar.HelloPrinter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class BeanNameController implements Controller {
	
	@Autowired
	private HelloPrinter helloPrinter;

	@Override
	public ModelAndView handleRequest(HttpServletRequest req,
			HttpServletResponse res) throws Exception {
		System.out.println("****************  bean name controller *****************");
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject(helloPrinter.getModel());
		return modelAndView;
	}

}
