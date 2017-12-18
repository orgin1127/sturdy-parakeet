package com.sesec.web2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ResourcesController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	/**
	 * 프로젝트 내의 리소스 사용 연습
	 */
	@RequestMapping(value="/res", method=RequestMethod.GET)
	public String resourcesControll() {
		logger.debug("resource 연습단계");
		return "/JSP/resTest";
	}
	
	@RequestMapping(value="test/res2", method=RequestMethod.GET)
	public String resourcesControll2() {
		logger.debug("resource 연습단계2");
		return "/JSP/resTest2";
	}

}
