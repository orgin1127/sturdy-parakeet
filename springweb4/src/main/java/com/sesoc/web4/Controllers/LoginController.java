package com.sesoc.web4.Controllers;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sesoc.web4.DAO.BbsDAO;
import com.sesoc.web4.vo.UserVO;

@Controller
public class LoginController {
	
	Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@Autowired
	BbsDAO dao;
	
	@RequestMapping(value="login", method = RequestMethod.GET)
	public String login() {
		logger.debug("go to login");
		return "./JSP/loginForm";
	}
	
	@RequestMapping(value = "login", method = RequestMethod.POST)
	public String login(UserVO vo, HttpSession session) {
		logger.debug("login phase");
		UserVO afterVO = null;
		afterVO = dao.login(vo);
		session.setAttribute("afterLogin", afterVO);
		return "redirect:/";
	}
	
	@RequestMapping(value = "logout", method = RequestMethod.GET)
	public String logout(HttpSession session) {
		logger.debug("logout phase");
		session.removeAttribute("afterLogin");
		return "redirect:/";
	}

}
