package kr.co.abc2;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	//외부에서 /input 경로로 요청이 들어왔을 때 실행될 메소드
	@RequestMapping(value = "/input", method = RequestMethod.GET)
	public String inputTest() {
		// src/main/resource에 있는 log4j.xml의 Application Loggers level value을 변경하면 아래의 출력이 달라진다
		logger.error("에러 출력 테스트");
		logger.warn("warn 출력 테스트");
		logger.info("inputTest() 실행됨"); //info 레벨에서는 위 두 개를 포함하여 출력됨
		logger.debug("디버그 출력 테스트"); //debug 레벨에서는 위 세 개를 포함
		logger.trace("트레이스 테스트"); //trace 레벨은 위 네 개를 포함
		return "inputTest"; //views 폴더에서 inputTest.jsp 찾아 포워딩
	}
	
	//외부에서 /output 경로로 요청이 들어왔을 때 실행될 메소드
	@RequestMapping(value = "/output", method = RequestMethod.GET)
	public String outputTest() {
		logger.info("outputTest() 실행됨");
		
		return "outputTest"; //views 폴더에서 outputTest.jsp 찾아 포워딩
	}
}
