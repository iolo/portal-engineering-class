package net.daum.springframework.openseminar.controller.annotation;

import java.util.HashMap;
import java.util.Map;

import net.daum.springframework.openseminar.HelloModel;
import net.daum.springframework.openseminar.HelloPrinter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.json.MappingJacksonJsonView;

@RequestMapping("/return")
@Controller
public class MethodReturnSample {

	@Autowired
	private HelloPrinter helloPrinter;

	@RequestMapping("/hello1")
	public ModelAndView hello1() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject(helloPrinter.getModel());
		modelAndView.setViewName("/annotation/hello");
//		modelAndView.setView(new MappingJacksonJsonView());
		return modelAndView;
	}
	
	@RequestMapping("/hello2")
	public HelloModel hello2() {
		return helloPrinter.getModel();
	}
	
	@RequestMapping("/hello3")
	public void hello3(Model model) {
		model.addAttribute(helloPrinter.getModel());
	}
	
	@RequestMapping("hello4")
	public String hello4(Model model) {
		model.addAttribute(helloPrinter.getModel());
		return "/annotation/hello";
	}
	
	@RequestMapping("hello5")
	public Map hello5() {
		Map map = new HashMap<String, Object>();
		map.put("helloPrinter", helloPrinter.getModel());
		return map;
	}
	
	@RequestMapping("hello6")
	public View hello6(Model model) {
		model.addAttribute(helloPrinter.getModel());
		return new MappingJacksonJsonView();
	}
	
	@RequestMapping("hello7")
	@ResponseBody
	public String hello7(Model model) {
		return "<h1> response body </h1>";
	}
	
}
