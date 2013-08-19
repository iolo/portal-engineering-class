package net.daum.springframework.openseminar;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

@Controller("hello_servlet")
public class HelloWorldServlet extends GenericServlet {
	

	@Override
	public void destroy() {
		System.out.println("**************   destroy() ********************");
		super.destroy();
	}

	@Override
	public void init() throws ServletException {
		System.out.println("**************   init() ********************");
		super.init();
	}

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		System.out.println("**************   service ******************");
		PrintWriter out = res.getWriter();
		out.println("<h2>Hello World!!!</h2>");
	}

}
