package com.sesec.web2.Controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sesec.web2.HomeController;

@Controller
public class Ex1Controller {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping(value="/test/ex1", method=RequestMethod.GET)
	public String ex1Controller(Model model) {
		Random r = new Random();
		//((int)Math.random()*5+1);
		int n = r.nextInt(5)+1;
		logger.debug("ex1 controller 진입");
		model.addAttribute("num",n);
		return "./JSP/ex1";
	}
	
	@RequestMapping(value="test/ex2", method=RequestMethod.GET)
	public String ex2Controller(Model model) {
		
		logger.debug("ex2 controller 진입");
		
		int inum = 100;
		double dnum = 1.234;
		String str = "abcd";
		String array[] = {"aaa", "bbb", "ccc"};
		
		HashMap<String, String> map = new HashMap<>();
		map.put("one", "1");
		map.put("two", "2");
		map.put("three", "3");
		
		ArrayList<String> list = new ArrayList<>();
		list.add("arrayList");
		list.add("test");
		list.add("ing");
		
		model.addAttribute("list", list);
		model.addAttribute("inum", inum);
		model.addAttribute("dnum", dnum);
		model.addAttribute("str", str);
		model.addAttribute("array", array);
		model.addAttribute("map", map);

		return "./JSP/ex2";
	}
	
	@RequestMapping(value="/test/ex3", method=RequestMethod.GET)
	public String ex3Controller(Model model) {
		logger.debug("ex3 controller 진입");
		
		return "home";
	}
}
