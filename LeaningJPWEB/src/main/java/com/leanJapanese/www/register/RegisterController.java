package com.leanJapanese.www.register;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RegisterController {
	Logger logger = LoggerFactory.getLogger(RegisterController.class);
	
	@RequestMapping(value = "register", method = RequestMethod.GET)
	public String register() {
		return "";
	}
	
	@RequestMapping(value = "register", method = RequestMethod.POST)
	public String register(Model model) {
		return "";
	}
}
