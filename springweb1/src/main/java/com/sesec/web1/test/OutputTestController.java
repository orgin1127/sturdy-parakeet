package com.sesec.web1.test;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class OutputTestController {

	private static final Logger logger = LoggerFactory.getLogger(OutputTestController.class);
	
	@RequestMapping(value = "/output", method = RequestMethod.GET)
	public String outputTest(Locale locale, Model model) {
		logger.info("outputTest 단계");
		return "./JSP/outputTest";
	}
	
	@RequestMapping(value = "/input", method = RequestMethod.GET)
	public String inputTest(Locale locale, Model model) {
		logger.info("outputTest 단계");
		return "./JSP/inputTest";
	}
	
}
