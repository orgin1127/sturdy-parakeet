package com.sesec.web1.test;

import java.util.HashMap;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalcController {
	
	private static final Logger logger = LoggerFactory.getLogger(CalcController.class);
	
	//계산 폼으로 이동
	@RequestMapping(value="/calc", method= RequestMethod.GET) 
	public String calcTest(Locale locale, Model model) {
		return "./JSP/calcTest";
	}
	
	//폼에 입력한 데이터 받아서 계산
	@RequestMapping(value="/calc", method= RequestMethod.POST) 
						//@RequestParam을 이용하면 view 단에서 문자로 입력한 것을 자동으로 ParseInt 할때 
						//생길 에러를 막는다
	public String calc(@RequestParam(value="num1", defaultValue="0") int num1
						, @RequestParam(value="num2", defaultValue="0")int num2
						, String cal, Model model) {
		logger.info("가지고 온 값: {}, {}, {}", num1, cal, num2);
		int total = 0;
		//계산
		if (cal.equals("+")) {
			total = num1+num2;
		}
		else if (cal.equals("-")) {
			total = num1 - num2;
		}
		else if (cal.equals("*")) {
			total = num1 * num2;
		}
		else if (cal.equals("/")) {
			total = num1 / num2;
		}
		model.addAttribute("total", total);
		model.addAttribute("num1", num1);
		model.addAttribute("num2", num2);
		return "./JSP/calcTest";
	}
	
	//환산할 단위와 값을 받아 계산(1cm 기준)
	@RequestMapping(value="/calc2", method=RequestMethod.POST)
	public String calc2(@RequestParam(value="calnum", defaultValue="0") int calnum
						, String cal2, Model model) {
		logger.info("가지고 온 값: {}, {}", calnum, cal2);
		HashMap<String, Double> map = new HashMap<String, Double>();
		
		map.put("mm", (double) 10);
		map.put("m", 0.01);
		map.put("km", 0.00001);
		map.put("in", 0.393701);
		map.put("ft", 0.032808);
		map.put("yd", 0.010936);
		map.put("za", 0.033);
		map.put("gan", 0.0055);
		map.put("jeong", 0.000092);
		map.put("li", 0.000025);
		
		
		double calc = map.get(cal2);
		double result = calc * calnum;
		model.addAttribute("num1", calnum);
		model.addAttribute("result",result);
		
		return "./JSP/calcTest";
	}
	
}
