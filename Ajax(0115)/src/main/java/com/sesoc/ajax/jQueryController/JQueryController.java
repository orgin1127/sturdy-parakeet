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
}
