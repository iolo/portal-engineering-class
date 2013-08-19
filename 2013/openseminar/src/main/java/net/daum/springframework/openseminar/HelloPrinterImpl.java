package net.daum.springframework.openseminar;


public class HelloPrinterImpl implements HelloPrinter {

	private String name;
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

	@Override
	public HelloModel getModel() {
		HelloModel helloModel = new HelloModel();
		helloModel.setHello("Hello!!! (model) : ");
		helloModel.setHello(name);
		return helloModel;
	}
	
	@Override
	public HelloModel getModel(String name) {
		HelloModel helloModel = new HelloModel();
		helloModel.setHello("Hello!!! (model) : ");
		helloModel.setHello(name);
		return helloModel;
	}

}
