package kr.ac.jejuuniv.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LoginInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
				
		boolean isLogin = false;
		if(request.getSession().getAttribute("LoginId") != null)
			isLogin = true;
		
		if(isLogin) {
			if(request.getRequestURI().equals("/login_page")) {
				response.sendRedirect("public_page");
				return false;
			}
		}else{
			System.out.println(request.getRequestURI());
			
			if(!request.getRequestURI().equals("/login.do") && !request.getRequestURI().equals("/login_page")
					&& !request.getRequestURI().equals("/join_page") && !request.getRequestURI().equals("/join.do")
					&& !request.getRequestURI().equals("/images/interface/title")) {
				response.sendRedirect("/login_page");
				return false;
			}
		}
		
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {

	}

	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {

	}

}
