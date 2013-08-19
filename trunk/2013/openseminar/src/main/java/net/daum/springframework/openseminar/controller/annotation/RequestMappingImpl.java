package net.daum.springframework.openseminar.controller.annotation;

import net.daum.springframework.openseminar.HelloModel;
import net.daum.springframework.openseminar.HelloPrinter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class RequestMappingImpl implements RequestMappingInterface {
	
	@Autowired
	private HelloPrinter helloPrinter;

	@Override
	public HelloModel hello() {
		System.out.println("*******   helloimpl ********");
		return helloPrinter.getModel();
	}

}
