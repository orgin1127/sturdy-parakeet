package com.learnJapanese.www.Interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginInterceptor extends HandlerInterceptorAdapter {

	Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		logger.debug("Login Interceptor Working");
		HttpSession session = request.getSession();
		String loginID = (String) session.getAttribute("loginUserID");
		if (loginID == null) {
			response.sendRedirect(request.getContextPath()+"/login");
			return false;
		}
		return super.preHandle(request, response, handler);
	}
	
}
