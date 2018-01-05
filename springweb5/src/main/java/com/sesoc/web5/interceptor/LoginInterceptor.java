package com.sesoc.web5.interceptor;

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
		logger.debug("Login Interceptor 실행");
		
		//세션의 로그인 정보 읽음
		//request.getSession().getAttribute("CustomerID");
		HttpSession session = request.getSession();
		String loginId = (String) session.getAttribute("CustomerID");
		//없으면 로그인 페이지로 리다이렉트
		if (loginId == null) {
			response.sendRedirect(request.getContextPath()+"/login");
			return false;
		}
		//있다면 가던 길(흐름)으로 되돌아간다
		return super.preHandle(request, response, handler);
	}
	
}
