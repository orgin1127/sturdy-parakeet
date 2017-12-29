package com.sesoc.web4.Controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sesoc.web4.DAO.BbsDAO;
import com.sesoc.web4.vo.UserVO;

@Controller
public class RegistrationController {
	
	Logger logger = LoggerFactory.getLogger(RegistrationController.class);
	
	@Autowired
	BbsDAO dao;
	
	
	@RequestMapping(value = "regi", method = RequestMethod.GET)
	public String userRegistration() {
		logger.debug("go to registration Form");
		return "./JSP/registrationForm";
	}
	
	@RequestMapping(value = "regi", method = RequestMethod.POST)
	public String userRegistration(UserVO vo) {
		logger.debug("user registraion phase");
		logger.debug(vo.toString());
		dao.insertUser(vo);
		return "redirect:/";
	}
	
	@RequestMapping(value = "idcheck", method = RequestMethod.GET)
	public String idCheck() {
		return "./JSP/idCheckForm";
	}
	
	@RequestMapping(value = "idVaildCheck", method = RequestMethod.POST)
	public String idVaildCheck(String searchID, Model model) {
		logger.debug("입력받은 id:{}", searchID);
		UserVO vo = dao.searchUser(searchID);
		String afterSearch = searchID;
		model.addAttribute("searchID", vo);
		model.addAttribute("afterSearch", afterSearch);
		return "./JSP/idCheckForm";
	}
}
