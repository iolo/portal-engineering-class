package kr.ac.jejuuniv.twitter.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LoginSessionIntercepter implements HandlerInterceptor{

	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object obj, Exception arg3)
			throws Exception {

	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2, ModelAndView arg3) throws Exception {
		
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
			Object arg2) throws Exception {
		
		HttpSession session = request.getSession(false);
		
		//처음 로그인때문에 인터셉터 벗어나기 위함....
		//왜 다른걸로 안될까나요? 
		if(request.getRequestURI().equals("/login.do"))		return true;
		
		if(session==null){
			response.sendRedirect("/");
			return false;
		}
		
		String id = (String)session.getAttribute("loginID");
		if(id==null){
			response.sendRedirect("/");
			return false;
		}

		return true;
	}
}
