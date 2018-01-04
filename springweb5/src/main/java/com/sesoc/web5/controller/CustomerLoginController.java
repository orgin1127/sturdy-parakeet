package com.sesoc.web5.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sesoc.web5.dao.JoinDAO;
import com.sesoc.web5.vo.Customer;

@Controller
public class CustomerLoginController {
	
	Logger logger = LoggerFactory.getLogger(CustomerLoginController.class);
	@Autowired
	JoinDAO dao;
	
	//로그인 폼으로 이동
	@RequestMapping(value = "login", method = RequestMethod.GET)
	public String login() {
		logger.debug("login form으로 이동");
		return "/customer/loginForm";
	}
	
	//로그인 처리
	@RequestMapping(value = "login", method = RequestMethod.POST)
	public String login(Customer cu, HttpSession session, Model model) {
		Customer loginedCU = null;
		logger.debug("login중");
		loginedCU = dao.searchCustomer(cu.getCustid());
		String loginResultMsg = "";
		if (loginedCU == null) {
			loginResultMsg = "ID가 틀리거나 존재하지 않습니다";
			model.addAttribute("loginResultID", loginResultMsg);
			return "/customer/loginForm";
		}
		else if (loginedCU != null && !(loginedCU.getPassword().equals(cu.getPassword()))) {
			loginResultMsg = "비밀번호가 틀립니다.";
			model.addAttribute("loginResultPW", loginResultMsg);
			return "/customer/loginForm";
		}
		else {
			session.setAttribute("CustomerID", loginedCU.getCustid());
			session.setAttribute("CustomeName", loginedCU.getName());
			return "redirect:/";
		}
		//id, 비밀번호가 맞으면 세션에 id, 이름 저장 후 메인으로 redirect
		//틀리면 model에 에러메세지 (id가 틀린지 비밀번호가 틀린지 구분) 저장하고 jsp로 포워딩해 해당 항목에 출력
		
	}
	
	//로그아웃
	@RequestMapping (value="logout", method = RequestMethod.GET)
	public String logout(HttpSession session) {
		logger.debug("logout중");
		session.removeAttribute("CustomerID");
		session.removeAttribute("CustomerName");
		return "redirect:/";
	}
}
