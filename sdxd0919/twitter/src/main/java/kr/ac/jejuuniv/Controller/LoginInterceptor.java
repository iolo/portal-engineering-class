package kr.ac.jejuuniv.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.ac.jejuuniv.Model.User;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginInterceptor extends HandlerInterceptorAdapter{

	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		
		HttpSession session = request.getSession(false);
		
		User user = (User) request.getSession().getAttribute("user");
		
		if("/twitter/login".equals(request.getRequestURI())) return true;
		
		if(session == null){
			response.sendRedirect("/twitter/login");
			return false;
		}
		
		if (user == null) {
			response.sendRedirect("/twitter/login");
			return false;
		}
		return true;
		
	}
	
}
