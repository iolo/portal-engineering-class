package kr.ac.jejuuniv.controller.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LoginInterceptor implements HandlerInterceptor {
	
	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse responce, Object controller, Exception exc)
			throws Exception {
		// TODO Auto-generated method stub
		
		
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse responce,
			Object controller, ModelAndView mav) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
			Object controller) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

}
