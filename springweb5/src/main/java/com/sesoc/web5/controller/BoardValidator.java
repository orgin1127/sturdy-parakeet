package com.sesoc.web5.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
@Component
public class BoardValidator {
	
	Logger logger = LoggerFactory.getLogger(BoardValidator.class);
	
	public String boardValidateCheck(String title, String content) {
		String errMSG = "";
		
		if (title.length() > 25 || title.length() < 2) {
			
			logger.debug(title);
			errMSG = "제목은 2자 이상 25자 이하여야 합니다.";
			return errMSG;
		}
		
		if (content.isEmpty()) {
			logger.debug("내용 체크");
			errMSG = "내용을 입력하여 주세요.";
			return errMSG;
		}
		return errMSG;
	}

}
