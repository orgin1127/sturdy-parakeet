package com.sesec.web2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GetAndPostController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping(value = "param", method = RequestMethod.GET)
	public String getController(String num) {
		logger.debug("전달된 num:" + num);
		return "redirect: ./";
	}
	
	@RequestMapping(value = "param2", method = RequestMethod.GET)
	public String postController1() {
		logger.debug("POST 작성단계 진입을 위한 GET");
		return "./JSP/param";
	}
	
	@RequestMapping(value = "param2", method = RequestMethod.POST)
	public String postController2(String name, String age, String address) {
		logger.debug("POST로 전달된 : {}, {}, {}", name, age, address);
		return "redirect:./";
	}
	
	

}
