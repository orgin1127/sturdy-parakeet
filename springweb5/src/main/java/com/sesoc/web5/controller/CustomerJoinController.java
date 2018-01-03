package com.sesoc.web5.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.sesoc.web5.dao.JoinDAO;
import com.sesoc.web5.vo.Customer;

@Controller
@SessionAttributes({"cu", "passwordValid"})
@RequestMapping("cust")
public class CustomerJoinController {
	Logger logger = LoggerFactory.getLogger(CustomerJoinController.class);
	
	@Autowired
	JoinDAO dao;
	@Autowired
	CustomerValidator cv;
	
	//회원가입 폼으로 이동
	@RequestMapping(value="joinForm", method=RequestMethod.GET)
	public String joinForm(Model model) {
		Customer cu = new Customer();
		/*SessionAttribute를 이용, 위 어노테이션에서 cu로 지정한 것과 같게
		  model을 만들어 model에 그 이름으로 자료를 넣으면 자동적으로 Session에 등록*/
		model.addAttribute("cu", cu);
		logger.debug("joinForm으로 이동");
		return "customer/joinForm";
	}
	
	//회원가입 폼에서 입력한 데이터 전달받아 가입 처리
	@RequestMapping(value="joinForm", method=RequestMethod.POST)
	public String joinForm(@ModelAttribute("cu") Customer cu
						,String passwordValid, Model model) {
		String msg = cv.validate(cu, passwordValid);
		if (msg != "") {
			model.addAttribute("errorMsg", msg);
			return "customer/joinForm";
		}
		int registResult = 0;
		logger.debug("Join Phase");
		logger.debug(cu.toString());
		registResult = dao.joinCustomer(cu);
		if (registResult == 1) {
			return "redirect:joinComplet";			
		}
		else {
			return "redirect:joinForm";
		}
	}
	
	//가입완료 시 가입완료 페이지로 이동
	@RequestMapping(value = "joinComplet", method = RequestMethod.GET)
	public String joinComplete(SessionStatus status, Model model, @ModelAttribute("cu") Customer cu) {
		model.addAttribute("id", cu.getCustid());
		status.setComplete();
		return "customer/joinCompletForm";
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
