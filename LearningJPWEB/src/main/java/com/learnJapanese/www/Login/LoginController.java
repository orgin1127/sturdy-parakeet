package com.learnJapanese.www.Login;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.learnJapanese.www.UserDAO.LoginDAO;
import com.learnJapanese.www.UserDAO.UserDAO;
import com.learnJapanese.www.VO.UserVO;
import com.learnJapanese.www.Validator.UserInfoValidator;

@Controller
public class LoginController {
	
	Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@Autowired
	LoginDAO loginDAO;
	@Autowired
	UserInfoValidator userInfoValidator;
	@Autowired
	UserDAO userDAO;
	
	@ResponseBody
	@RequestMapping(value="userLogin", method=RequestMethod.POST)
	public UserVO userLogin(UserVO vo, HttpServletRequest request, HttpSession session) {
		UserVO loginedVO = null;
		logger.debug("loginController worked, go to LoginDAO");
		
		loginedVO = loginDAO.userLogin(vo);
		if (loginedVO != null) {
			logger.debug("userLogin succeed, add userInfo to session");
			session.setAttribute("loginUserID", loginedVO.getUserID());
			session.setAttribute("loginUserName", loginedVO.getUserName());
			session.setAttribute("loginUser", loginedVO);
		}
		return loginedVO;
	}
	
	@RequestMapping(value="userLogout", method = RequestMethod.GET)
	public String userLogout(HttpSession session) {
		session.removeAttribute("loginUserID");
		session.removeAttribute("loginUserName");
		session.removeAttribute("loginUser");
		return "redirect:/";
	}
	
}
