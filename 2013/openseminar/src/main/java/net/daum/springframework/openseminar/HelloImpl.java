package net.daum.springframework.openseminar;

import org.springframework.stereotype.Component;

public class HelloImpl implements Hello {

	@Override
	public String hello() {
		return "Hello!! ";
	}

}
