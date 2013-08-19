package net.daum.springframework.openseminar.controller;

import net.daum.springframework.openseminar.HelloModel;
import net.daum.springframework.openseminar.HelloPrinter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/annotation/hello")
public class AnnotationController {
	@Autowired
	private HelloPrinter helloPrinter;
	
	@RequestMapping
	public HelloModel hello() {
		System.out.println("****************  default annotation controller *****************");
		return helloPrinter.getModel();
	}
}
