package com.sesoc.web5.controller;

import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sesoc.web5.dao.JoinDAO;
import com.sesoc.web5.vo.Customer;
@Repository
public class CustomerValidator {
	
	Logger logger = LoggerFactory.getLogger(CustomerValidator.class);
	@Autowired
	JoinDAO dao;
	
	public String validate(Customer cu, String passwordValid) {
		
		String errMsg = "";
		
		//id null일때
		if (cu.getCustid().isEmpty()) {
			errMsg = "아이디를 입력하여 주세요";
			return errMsg;
		}
		//id 짧거나 길 때
		if (!(Pattern.matches("^[a-zA-Z0-9]{4,9}$", cu.getCustid()))) {
			errMsg = "아이디는 영문 혹은 숫자로 4자 이상 9자 이하여야 합니다.";
			return errMsg;
		}
		//password null일때
		if (cu.getPassword().isEmpty()) {
			errMsg = "비밀번호를 입력하여 주세요";
			return errMsg;
		}
		//password 짧거나 길 때
		if (!(Pattern.matches("^[a-zA-Z0-9]{5,12}$", cu.getPassword()))) {
			errMsg = "비밀번호는 영문 혹은 숫자로 5자 이상 12자 이하여야 합니다.";
			return errMsg;
		}
		//password 재입력 null일때
		if (passwordValid.isEmpty()) {
			errMsg = "비밀번호 재입력을 바르게 입력하여 주세요.";
			return errMsg;
		}
		//password 재입력 짧거나 길 때
		if (!(Pattern.matches("^[a-zA-Z0-9]{5,12}$", passwordValid))) {
			errMsg = "비밀번호 재입력을 바르게 입력하여 주세요.";
			return errMsg;
		}
		//password와 password재입력이 일치하지 않을 때
		if (!(cu.getPassword().equals(passwordValid))) {
			errMsg = "비밀번호 재입력이 일치하지 않습니다.";
			return errMsg;
		}
		//이름 null일때
		if (cu.getName().isEmpty()) {
			errMsg = "이름을 입력하여 주세요.";
			return errMsg;
		}
		//이름에 한글 영어 이외의 글자가 들어가거나 길 때
		if (!(Pattern.matches("^[a-zA-Z가-힣]{2,12}$", cu.getName()))) {
			errMsg = "이름은 한글 혹은 영어로 2글자 이상 12자 이하여야 합니다.";
			return errMsg;
		}
		//email 유효성 검사
		if (!(Pattern.matches("^[a-zA-Z0-9]+@[a-zA-Z0-9]+(.[0-9a-zA-Z]+)$", cu.getEmail()))) {
			logger.debug(cu.getEmail());
			errMsg = "올바른 이메일 주소를 입력하여 주세요.";
			return errMsg;
		}
		//고객구분 null 검사
		if (cu.getDivision() == null) {
			errMsg = "고객구분을 선택하여 주세요";
			return errMsg;
		}
		//식별번호 null 검사
		if (cu.getIdno() == null) {
			errMsg = "식별번호를 입력하여 주세요";
			return errMsg;
		}
		//고객 구분에 따른 식별번호의 유효성 검사
		if (cu.getDivision().equals("personal")) {
			if (!(Pattern.matches("\\d{6}\\-[1-4]\\d{6}", cu.getIdno())) || cu.getIdno().length() < 14) {
				logger.debug(cu.getDivision());
				logger.debug(cu.getIdno());
				errMsg = "올바른 식별번호를 입력하여 주세요.";
				return errMsg;
			}
		}
		else if (cu.getDivision().equals("company")) {
			if (!(Pattern.matches("\\d{3}\\-\\d{2}-\\d{5}", cu.getIdno())) || cu.getIdno().length() > 13) {
				logger.debug(cu.getDivision());
				logger.debug(cu.getIdno());
				errMsg = "올바른 식별번호를 입력하여 주세요.";
				return errMsg;
			}
		}
		//식별번호 중복 검사 
		logger.debug("식별번호 중복:" + cu.getIdno());
		Customer checkCU = dao.searchIDNo(cu.getIdno());
		if (checkCU != null) {
			errMsg = "이미 등록된 식별번호 입니다.";
			return errMsg;
		}
		
		return errMsg;
	}

}
