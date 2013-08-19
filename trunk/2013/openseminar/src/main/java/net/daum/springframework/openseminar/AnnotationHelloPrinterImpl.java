package net.daum.springframework.openseminar;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Component
public class AnnotationHelloPrinterImpl implements HelloPrinter {

	@Value("허윤호")
	private String name;
	
	@Resource
	private Hello hello;

	@Override
	public void print() {
		System.out.println("Hello World " + name);
	}
	
	
	@Override
	public void helloPrint() {
		System.out.println(hello.hello() + name);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Hello getHello() {
		return hello;
	}

	public void setHello(Hello hello) {
		this.hello = hello;
	}
	
	
	public HelloModel getModel() {
		HelloModel helloModel = new HelloModel();
		helloModel.setHello("Hello World !!! (model) : ");
		helloModel.setName(name);
		return helloModel;
	}


	@Override
	public HelloModel getModel(String name) {
		HelloModel helloModel = new HelloModel();
		helloModel.setHello("Hello World !!! (model) : ");
		helloModel.setName(name);
		return helloModel;
	}

}
