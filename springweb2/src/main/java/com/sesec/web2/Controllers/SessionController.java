package com.sesec.web2.Controllers;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SessionController {
	
	private static final Logger logger = LoggerFactory.getLogger(SessionController.class);
	
	@RequestMapping(value="/session1", method=RequestMethod.GET)
	public String sessionController1(HttpSession session, Model model) {
		logger.debug("session controller1");
		//request에 저장
		model.addAttribute("modelValue", "model에 저장한 값");
		
		//session에 저장
		session.setAttribute("sessionValue", "session에 저장한 값");
		
		return "./JSP/sessionTest";
	}
	
	//값 테스트
	@RequestMapping(value="/session2", method=RequestMethod.GET)
	public String sessionController2(HttpSession session, Model model) {
		logger.debug("session controller2");

		return "./JSP/sessionTest";
	}
	
	@RequestMapping(value="/session3", method=RequestMethod.GET)
	public String sessionController3(HttpSession session, Model model) {
		logger.debug("session controller3");
		// 1번 방법, session 내 특정 정보만 삭제
		session.removeAttribute("sessionValue");
		// 2번 방법, session 내 모든 정보 reset
		session.invalidate();
		return "./JSP/sessionTest";
	}

}
