package kr.ac.jejuuniv.controller.interceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LoginInterceptor implements HandlerInterceptor {
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object controller) throws Exception {
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie c : cookies) {
				if (c.getName().equals("loginId")) {
					if (c.getValue() != null && !c.getValue().equals("")) {
						return true;
					}
				}
			}
		}

		response.sendRedirect("/ssiggle/login");
		return false;
	}

	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse responce, Object controller, ModelAndView mav)
			throws Exception {
	}

	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse responce, Object controller, Exception exc)
			throws Exception {
	}
}
