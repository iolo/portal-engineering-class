package kr.ac.jejuuniv.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginInterceptor extends HandlerInterceptorAdapter{

	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		
		HttpSession session = request.getSession(false);
		
		String userId = (String) request.getSession().getAttribute("userId");
		
		if(session == null){
			response.sendRedirect("/twitter/login");
			return false;
		}
		
		if (userId == null) {
			response.sendRedirect("/twitter/login");
			return false;
		}
		return true;
		
	}
	
}
