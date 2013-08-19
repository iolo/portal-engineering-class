package net.daum.springframework.openseminar2;

import net.daum.springframework.openseminar.Hello;
import net.daum.springframework.openseminar.HelloImpl;
import net.daum.springframework.openseminar.HelloPrinter;
import net.daum.springframework.openseminar.HelloPrinterImpl;

import org.junit.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.RuntimeBeanReference;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.support.StaticApplicationContext;

public class StaticApplicationContextTest {
	@Test
	public void testApplicationContext() {
		StaticApplicationContext applicationContext = new StaticApplicationContext();
		applicationContext.registerSingleton("hello", HelloImpl.class);
		Hello hello = applicationContext.getBean("hello", HelloImpl.class);
		System.out.println(hello.hello());
	}
	
	@Test
	public void testApplicationContextUsingBeanDefinition() {
		StaticApplicationContext applicationContext = new StaticApplicationContext();
		BeanDefinition beanDefinition = new RootBeanDefinition(HelloPrinterImpl.class);
		beanDefinition.getPropertyValues().addPropertyValue("name", "허윤호");
		applicationContext.registerBeanDefinition("helloPrinter", beanDefinition);
		HelloPrinter helloPrinter = applicationContext.getBean("helloPrinter", HelloPrinter.class);
		helloPrinter.print();
	}
	
	@Test
	public void testApplicationContextUsingBeanDefinitionDI() {
		StaticApplicationContext applicationContext = new StaticApplicationContext();
		applicationContext.registerSingleton("hello", HelloImpl.class);
		BeanDefinition beanDefinition = new RootBeanDefinition(HelloPrinterImpl.class);
		beanDefinition.getPropertyValues().addPropertyValue("name", "허윤호");
		beanDefinition.getPropertyValues().addPropertyValue("hello", new RuntimeBeanReference("hello"));
		applicationContext.registerBeanDefinition("helloPrinter", beanDefinition);
		HelloPrinter helloPrinter = applicationContext.getBean("helloPrinter", HelloPrinter.class);
		helloPrinter.helloPrint();
	}
}
