package net.daum.springframework.openseminar2;

import net.daum.springframework.openseminar.Hello;
import net.daum.springframework.openseminar.HelloImpl;
import net.daum.springframework.openseminar.HelloPrinter;
import net.daum.springframework.openseminar.HelloPrinterImpl;

import org.junit.Test;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class GenericApplicationContextTest {
	@Test
	public void testApplicationContext() {
		GenericApplicationContext applicationContext = new GenericApplicationContext();
		XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(applicationContext);
		reader.loadBeanDefinitions("applicationContext.xml");
		applicationContext.refresh();
		Hello hello = applicationContext.getBean("hello", HelloImpl.class);
		System.out.println(hello.hello());
	}
	
	
	@Test
	public void testGenericXmlApplicationContext() {
		GenericApplicationContext applicationContext = new GenericXmlApplicationContext("applicationContext.xml");
		Hello hello = applicationContext.getBean("hello", HelloImpl.class);
		System.out.println(hello.hello());
	}
	
	@Test
	public void testGenericXmlApplicationContextDI() {
		GenericApplicationContext applicationContext = new GenericXmlApplicationContext("applicationContext.xml");
		HelloPrinter helloPrinter = applicationContext.getBean("helloPrinter", HelloPrinterImpl.class);
		helloPrinter.helloPrint();
	}
	
	
	@Test
	public void testGenericXmlApplicationContextDI2() {
		GenericApplicationContext applicationContext = new GenericXmlApplicationContext("applicationContext2.xml");
		HelloPrinter helloPrinter = applicationContext.getBean("helloPrinter", HelloPrinterImpl.class);
		helloPrinter.helloPrint();
	}
	
	@Test
	public void testGenericXmlApplicationContextDI3() {
		GenericApplicationContext applicationContext = new GenericXmlApplicationContext("applicationContext3.xml");
		HelloPrinter helloPrinter = applicationContext.getBean("helloPrinter", HelloPrinterImpl.class);
		helloPrinter.helloPrint();
	}
}
