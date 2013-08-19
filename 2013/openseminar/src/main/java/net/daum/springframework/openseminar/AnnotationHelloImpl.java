package net.daum.springframework.openseminar;

import org.springframework.stereotype.Component;

@Component
public class AnnotationHelloImpl implements Hello {

	@Override
	public String hello() {
		return "Hello!! ";
	}

}
