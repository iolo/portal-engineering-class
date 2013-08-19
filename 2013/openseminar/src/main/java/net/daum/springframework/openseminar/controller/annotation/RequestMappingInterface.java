package net.daum.springframework.openseminar.controller.annotation;

import net.daum.springframework.openseminar.HelloModel;

import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/interface")
public interface RequestMappingInterface {
	@RequestMapping("/hello")
	public HelloModel hello();
}
