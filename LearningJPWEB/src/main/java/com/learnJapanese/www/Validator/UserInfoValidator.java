package com.learnJapanese.www.Validator;

import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.learnJapanese.www.VO.UserVO;

@Component
public class UserInfoValidator {
	
	Logger logger = LoggerFactory.getLogger(UserInfoValidator.class);
	
	public String userIDValidityChecker(String inputID) {
		String check = "";
		if(!(Pattern.matches("^[a-zA-Z0-9]{4,9}$", inputID))) {
			logger.debug("ID validator checked");
			check = "invalidity";
			logger.debug(check);
			return check;
		}
		return check;
	}
	
	public String userPasswordValidityChecker(String inputPassword) {
		String check = "";
		if (!(Pattern.matches("^[a-zA-Z0-9]{5,12}$", inputPassword))) {
			logger.debug("Password validator checked");
			logger.debug(check);
			check = "invalidity";
			return check;
		}
		return check;
	}
	
	public String userNameValidityChecker(String inputUserName) {
		String check = "";
		if (!(Pattern.matches("^[\\w가-힣ㄱ-ㅎ]{2,10}$", inputUserName))) {
			logger.debug("Name Validator Checked");
			logger.debug(check);
			check = "invalidity";
			return check;
		}
		return check;
	}
}
