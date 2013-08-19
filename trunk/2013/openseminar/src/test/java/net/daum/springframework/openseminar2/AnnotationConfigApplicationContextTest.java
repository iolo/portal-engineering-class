package net.daum.springframework.openseminar2;

import net.daum.springframework.openseminar.Hello;
import net.daum.springframework.openseminar.HelloPrinter;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AnnotationConfigApplicationContextTest {
	@Test
	public void testApplicationContext() {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext("net.daum.springframework");
		Hello hello = applicationContext.getBean(Hello.class);
		System.out.println(hello.hello());
	}
	
	@Test
	public void testApplicatoinContextDI() {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext("net.daum.springframework");
		HelloPrinter helloPrinter = applicationContext.getBean(HelloPrinter.class);
		helloPrinter.helloPrint();
	}
}
