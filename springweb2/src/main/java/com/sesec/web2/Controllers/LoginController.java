package com.sesec.web2.Controllers;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {
	
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	//로그인 폼으로 이동
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String loginStart () {
		logger.debug("login start");
		return "./JSP/loginPage";
	}
	
	//로그인 처리하고 메인화면으로 이동
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String loginStart (HttpSession session, String id, String password, String name) {
		logger.debug("login Success");
		//if-else 문으로 아이디 비밀번호 확인해 세션에 저장하고 메인으로
		if (id.equals("testacc1") && password.equals("1231")) {
			session.setAttribute("id", id);
			session.setAttribute("name", name);
			return "redirect:home";
		}
		else {
			return "./JSP/loginPage";
		}
		//틀릴경우 로그인 폼으로 되돌아감
		// return "redirect:/login"; 리다이렉트(매핑 경로로)
		// return "loginForm"; 포워딩(JSP)
		
		
	}
	
	//로그아웃하고 메인화면으로 이동
	@RequestMapping(value="/logout", method=RequestMethod.GET)
	public String logout(HttpSession session) {
		logger.debug("logout phase");
		session.invalidate();
		return "home";
	}
}
