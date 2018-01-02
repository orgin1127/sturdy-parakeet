package com.sesoc.web5.controller;

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
@RequestMapping("cust")
public class CustomerJoinController {
	Logger logger = LoggerFactory.getLogger(CustomerJoinController.class);
	
	@Autowired
	JoinDAO dao;
	
	
	//회원가입 폼으로 이동
	@RequestMapping(value="joinForm", method=RequestMethod.GET)
	public String joinForm() {
		logger.debug("joinForm으로 이동");
		return "customer/joinForm";
	}
	
	//회원가입 폼에서 입력한 데이터 전달받아 가입 처리
	@RequestMapping(value="joinForm", method=RequestMethod.POST)
	public String joinForm(Customer cu) {
		logger.debug("Join Phase");
		logger.debug(cu.toString());
		dao.joinCustomer(cu);
		return "redirect:/";
	}
	
	//id중복검사 팝업창 생성
	@RequestMapping(value = "idcheck", method = RequestMethod.GET)
	public String idCheck() {
		logger.debug("id중복검사 창으로 이동");
		return "./customer/idCheckForm";
	}
	
	//입력받은 후보 id를 db에서 검색
	@RequestMapping(value="idcheck", method = RequestMethod.POST)
	public String idCheck(String custid, Model model) {
		logger.debug("id 중복검사");
		logger.debug(custid);
		Customer cu = null;
		String searchID = ""; 
		cu = dao.searchCustomer(custid);
		if (cu == null ) {
			searchID = custid;
		}
		logger.debug(searchID);
		
		model.addAttribute("afterSearch", searchID);
		model.addAttribute("searchID", cu);
		return "customer/idCheckForm";
	}
}
