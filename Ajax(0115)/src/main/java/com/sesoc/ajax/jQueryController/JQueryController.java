package com.sesoc.ajax.jQueryController;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class JQueryController {
	
	Logger logger = LoggerFactory.getLogger(JQueryController.class);
	
	@RequestMapping(value="jQuery1", method = RequestMethod.GET)
	public String jQueryController1() {
		logger.debug("jQuery Controller 1");
		return "JQuery/jQuery1";
	}
	
	@RequestMapping(value="jQuery2", method = RequestMethod.GET)
	public String jQueryController2() {
		logger.debug("jQuery Controller 2");
		return "JQuery/jQuery2";
	}
	
	@RequestMapping(value="jQuery3", method = RequestMethod.GET)
	public String jQueryController3() {
		logger.debug("jQuery Controller 3");
		return "JQuery/jQuery3";
	}
}
