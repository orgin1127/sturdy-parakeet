package com.sesoc.web5.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.sesoc.web5.dao.JoinDAO;
import com.sesoc.web5.vo.Customer;

@Controller
@SessionAttributes("cu")
public class CustomerInfoEditController {
	
	Logger logger = LoggerFactory.getLogger(CustomerInfoEditController.class);
	
	@Autowired
	JoinDAO dao;
	@Autowired
	CustomerValidator cv;
	
	@RequestMapping(value = "customerInfoEdit", method = RequestMethod.GET)
	public String customerInfoEdit(Model model, HttpSession session) {
		
		
		
		logger.debug(session.getAttribute("CustomerID").toString());
		logger.debug("수정폼으로 이동중");
		Customer cu = dao.searchCustomer(session.getAttribute("CustomerID").toString());
		logger.debug(cu.toString());
		model.addAttribute("cu", cu);
		return "customer/customerInfoEditForm";
	}
	
	@RequestMapping(value = "customerInfoEdit", method = RequestMethod.POST)
	public String customerInfoEdit(HttpSession session, @ModelAttribute("cu") Customer cu
									, String passwordValid, Model model) {
		String errorMsg = "";
		logger.debug(cu.toString());
		errorMsg = cv.validate(cu, passwordValid);
		if (!(errorMsg.equals(""))) {
			model.addAttribute("errorMsg", errorMsg);
			return "customer/customerInfoEditForm";
		}
		if (dao.updateCustomerInfo(cu)) {
			logger.debug("수정성공");
		}
		return "redirect:/";
	}
}
