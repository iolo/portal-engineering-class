package kr.ac.jejuuniv.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.ac.jejuuniv.model.User;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class SingInterceptor extends HandlerInterceptorAdapter{
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		HttpSession session = request.getSession(false);
		if(session == null) {
			response.sendRedirect("/");
			return false;
		}
		User user = (User) session.getAttribute("loginUser");
		if(user == null) {
			response.sendRedirect("/");
			return false;
		}
		return true;
	}
}
