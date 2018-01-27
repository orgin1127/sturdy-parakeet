package com.learnJapanese.www.register;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.learnJapanese.www.UserDAO.UserDAO;
import com.learnJapanese.www.VO.UserVO;

@Controller
public class RegisterController {
	Logger logger = LoggerFactory.getLogger(RegisterController.class);
	
	@Autowired
	UserDAO userDAO;
	
	@ResponseBody
	@RequestMapping(value = "register", method = RequestMethod.POST)
	public int register(UserVO vo, Model model) {
		logger.debug("register worked, go to RegisterDAO");
		logger.debug("입력값 : {}", vo);
		int result = 0;
		result = userDAO.userRegister(vo);
		return result;
	}
}
