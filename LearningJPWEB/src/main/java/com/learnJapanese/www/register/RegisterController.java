package com.learnJapanese.www.register;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
import com.learnJapanese.www.Validator.UserInfoValidator;

@Controller
public class RegisterController {
	Logger logger = LoggerFactory.getLogger(RegisterController.class);
	
	@Autowired
	UserDAO userDAO;
	@Autowired
	UserInfoValidator userInfoValidator;
	
	@ResponseBody
	@RequestMapping(value = "register", method = RequestMethod.POST)
	public int register(UserVO vo, String userPasswordCheck) {
		logger.debug("register worked, go to RegisterDAO");
		logger.debug("입력값 : {}, {}", vo, userPasswordCheck);
		int result = 0;
		result = userDAO.userRegister(vo);
		return result;
	}
	
	//id 유효성 및 중복확인
	@ResponseBody
	@RequestMapping(value = "userIDCheck", method = RequestMethod.GET, produces = "application/text; charset=utf8")
	public String userIDCheck(String inputID, String inputPassword, HttpServletResponse response) {
		String IDSearchResult = "";
		String IDValidity = "";
		logger.debug("user ID validity Checker worked, go to RegisterDAO");
		logger.debug("input ID : {}", inputID);
		
		//ID 유효성을 검사
		IDValidity = userInfoValidator.userIDValidityChecker(inputID);
		if (!IDValidity.equals("")) {
			logger.debug("유효성 오류");
			logger.debug(IDValidity+1);
			return IDValidity;
		}
		
		//ID 중복을 검사
		IDSearchResult = userDAO.userIDDuplicateCheck(inputID);
		logger.debug("IDSearchResult : {}", IDSearchResult);
		response.setCharacterEncoding("UTF-8");
		//해당 값을 RETURN
		return IDSearchResult;			
	}
	
	//Password 유효성 검사
	@ResponseBody
	@RequestMapping(value="userPasswordCheck", method = RequestMethod.GET)
	public String userPasswordCheck(String inputPassword) {
		String passwordValidity = "";
		passwordValidity = userInfoValidator.userPasswordValidityChecker(inputPassword);
		return passwordValidity;
	}
	//Name 유효성 검사
	@ResponseBody
	@RequestMapping(value="userNameCheck", method = RequestMethod.GET)
	public String userNameCheck(String inputUserName) {
		String nameValidity = "";
		nameValidity = userInfoValidator.userNameValidityChecker(inputUserName);
		return nameValidity;
	}
}
