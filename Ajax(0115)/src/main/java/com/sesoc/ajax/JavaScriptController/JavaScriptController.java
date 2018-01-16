package com.sesoc.ajax.JavaScriptController;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class JavaScriptController {
	
	Logger logger = LoggerFactory.getLogger(JavaScriptController.class);
	
	@RequestMapping(value="js1", method = RequestMethod.GET)
	public String javaScriptController1() {
		logger.debug("JS Controller 1");
		return "BasicJS/JS1";
	}
	
	@RequestMapping(value="js2", method = RequestMethod.GET)
	public String javaScriptController2() {
		logger.debug("JS Controller 2");
		return "BasicJS/JS2";
	}
	@RequestMapping(value="js3", method = RequestMethod.GET)
	public String javaScriptController3() {
		logger.debug("JS Controller 3");
		return "BasicJS/JS3";
	}
}
