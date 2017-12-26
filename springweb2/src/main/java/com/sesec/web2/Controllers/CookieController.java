package com.sesec.web2.Controllers;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CookieController {
	Logger logger = LoggerFactory.getLogger(CookieController.class);
	
	//쿠키 저장
	@RequestMapping(value = "/csave", method = RequestMethod.GET)
	public String csave(HttpServletResponse response) {
		//쿠키 생성
		Cookie c = new Cookie("id", "testacc1");
		Cookie c2 = new Cookie("num", "123");
		
		//유지 시간 설정
		c.setMaxAge(60 * 60 * 24 * 3);
		c2.setMaxAge(60 * 60);
		
		//response를 통해 클라이언트로 저장
		response.addCookie(c);
		response.addCookie(c2);
		
		logger.debug("쿠키 저장 : id:{}, num:{}", c.getValue(), c2.getValue());
		return "redirect:/";
	}
	
	//쿠키 삭제
	@RequestMapping(value ="/cdelete", method = RequestMethod.GET)
	public String cdelete(HttpServletResponse response) {
		Cookie c = new Cookie("id", "testacc1");
		c.setMaxAge(0);
		response.addCookie(c);
		return "redirect:/";
	}
	
	//쿠키 읽기 1 단순 읽기
	@RequestMapping(value = "/cread1", method = RequestMethod.GET)
	public String cread1(HttpServletRequest request) {
		//현재 클라이언트의 저장된 쿠키 모두 읽기
		Cookie[] clist = request.getCookies();
		String id = null;
		//반복문으로 찾는 이름의 쿠키 확인, 값 읽기
		if (clist != null && clist.length != 0) {
			for (Cookie cookie : clist) {
				if (cookie.getName().equals("id")) {
					id = cookie.getValue();
				}
			}
		}
		logger.debug("쿠키에서 읽은 값: id:{}", id);
		return "redirect:/";
	}
	
	//쿠키 읽기 2 어노테이션을 이용한 간편읽기
	@RequestMapping(value = "/cread2", method = RequestMethod.GET)
	public String cread2(@CookieValue(value="id", defaultValue="") String id
						, Model model) {
		logger.debug("어노테이션으로 쿠키 간단 읽기 : id:{}", id);
		model.addAttribute("id", id);
		return "redirect:/";
	}
}
