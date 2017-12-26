package com.sesec.web2.Controllers;



import javax.net.ssl.SSLEngineResult.Status;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@SessionAttributes({"data1", "data2"})
public class SessionController2 {
	
	private static final Logger logger = LoggerFactory.getLogger(SessionController2.class);
	
	//첫번째 단계
	@RequestMapping(value ="/step1", method = RequestMethod.GET)
	public String step1() {
		logger.debug("step1");
		return "./JSP/step";
	}
	
	//두번째 단계
	@RequestMapping(value ="/step2", method = RequestMethod.GET)
	public String step2(Model model) {
		model.addAttribute("data1", "step2에서 저장한 값");
		logger.debug("step2");
		return "./JSP/step";
	}
	
	//세번째 단계
	@RequestMapping(value ="/step3", method = RequestMethod.GET)
	public String step3(Model model
						, @ModelAttribute("data1") String data1) {
		model.addAttribute("data2", "step3에서 저장한 값");
		logger.debug(data1);
		logger.debug("step3");
		return "./JSP/step";
	}
	
	//네번째 단계
	@RequestMapping(value ="/step4", method = RequestMethod.GET)
	public String step4(@ModelAttribute("data1") String data1
						, @ModelAttribute("data2") String data2
						, SessionStatus status) {
		logger.debug(data1);
		logger.debug(data2);
		logger.debug("step4");
		status.setComplete(); //초기화
		return "./JSP/step";
	}
	
	
}
