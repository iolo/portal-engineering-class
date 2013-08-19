package net.daum.springframework.openseminar.controller.annotation;

import net.daum.springframework.openseminar.HelloModel;
import net.daum.springframework.openseminar.HelloPrinter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

//@RequestMapping("/sample")
@Controller
public class RequestMappingSample extends RequestMappingParent {

	@Autowired
	private HelloPrinter helloPrinter;

	@RequestMapping("/hello")
	public HelloModel hello1() {
		System.out.println("*******   hello1 ********");
		return helloPrinter.getModel();
	}

	@RequestMapping("/hello*")
	public HelloModel hello2() {
		System.out.println("*******   hello2 ********");
		return helloPrinter.getModel();
	}

	@RequestMapping("/hello/**/hello")
	public HelloModel hello3() {
		System.out.println("*******   hello3 ********");
		return helloPrinter.getModel();
	}

	@RequestMapping("/helloworld/{name}")
	public HelloModel hello4(@PathVariable("name") String name) {
		System.out.println("*******   hello4 ********");
		return helloPrinter.getModel(name);
	}
}
