package com.sesec.web3.Controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sesec.web3.DAO.PersonDAO;
import com.sesec.web3.vo.Person;

@Controller
public class JoinController {
	
	Logger logger = LoggerFactory.getLogger(JoinController.class);
	
	@Autowired
	PersonDAO personDAO;
	
	//가입폼으로 이동
	@RequestMapping(value = "/join", method = RequestMethod.GET)
	public String join() {
		logger.debug("join start");
		return "./JSP/JoinForm";
	}
	
	//입력된 값 받아 DAO로 전송
	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public String join(Person p) {
		//전달된 값 확인 출력
		logger.debug("전달된 값 : {}", p);
		//DAO로 전달하여 DB에 저장
		personDAO.insertPerson(p);
		return "redirect:/";
	}
	
}
