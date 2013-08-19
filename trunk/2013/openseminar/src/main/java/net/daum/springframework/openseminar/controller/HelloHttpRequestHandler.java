package net.daum.springframework.openseminar.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.HttpRequestHandler;

@Controller("hello_http_request_handler")
public class HelloHttpRequestHandler implements HttpRequestHandler {

	@Override
	public void handleRequest(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		System.out.println("**************   http request handler ******************");
		PrintWriter out = res.getWriter();
		out.println("<h2>Hello World(HttpRequestHandler)!!!</h2>");
		
	}

}
