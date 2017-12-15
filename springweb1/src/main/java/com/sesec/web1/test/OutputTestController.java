package com.sesec.web1.test;

import java.util.ArrayList;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sesec.web1.VO.TestVO;


@Controller
public class OutputTestController {

	private static final Logger logger = LoggerFactory.getLogger(OutputTestController.class);
	
	@RequestMapping(value = "/output", method = RequestMethod.GET)
	public String outputTest(Locale locale, Model model) {
		logger.info("outputTest 단계");
		String str = "controller에서 보낸 문자열";
		int integer = 777;
		double dou = 124.02154;
		String[] array = {"이것은", "String", "배열입니다"};
		ArrayList<String> list = new ArrayList<String>();
		list.add("어레이");
		list.add("테스트");
		list.add("스트링");
		TestVO vo = new TestVO("홍길동", 23, "서울시 강남구", "honghong");
		ArrayList<TestVO> list2 = new ArrayList<TestVO>();
		list2.add(new TestVO("김모씨", 30, "서울시 마포구", "kim1"));
		list2.add(new TestVO("박모씨", 42, "서울시 용산구", "park2"));
		list2.add(new TestVO("최모씨", 17, "서울시 송파구", "choi3"));
		
		
		model.addAttribute("str",str);
		model.addAttribute("integer", integer);
		model.addAttribute("dou", dou);
		model.addAttribute("array", array);
		model.addAttribute("list", list);
		model.addAttribute("vo", vo);
		model.addAttribute("list2", list2);
		//view 폴더의 outputTest.jsp로 포워딩
		return "./JSP/outputTest";
	}
	
	@RequestMapping(value = "/input", method = RequestMethod.GET)
	public String inputTest(Locale locale, Model model) {
		logger.info("inputTest 단계");
		return "./JSP/inputTest";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	//parameter 안에 jsp에서 보낸 id명과 같은 이름으로 선언 해 놓으면 알아서 Spring이 값을 넣어준다
	//public String saveTest(String name, String phone, String address) <- 이렇게
	public String saveTest(TestVO vo, String idcheck) { 
		//<-관련 vo에 한번에 넣는 방법 알아서 한방에 vo에 넣어줌, vo에 있는것 말고 따로 받을 경우는 옆에 , 찍고 받을거 찍는다
		logger.info("saveTest 단계");
		
		logger.info("전달된 값: {}", vo);
		//logger.info("전달된 값: {}, {}, {}", name, phone, address);
		return "redirect:./";
	}
	
}
