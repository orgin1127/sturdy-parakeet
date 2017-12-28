package com.sesec.web3.Controllers;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sesec.web3.DAO.PersonDAO;
import com.sesec.web3.vo.Person;

@Controller
public class SearchPersonController {
	
	Logger logger = LoggerFactory.getLogger(SearchPersonController.class);
	
	@Autowired
	PersonDAO personDAO;
	
	@RequestMapping(value = "/showPersonList", method = RequestMethod.GET)
	public String showPersonList(Model model) {
		ArrayList<Person> list = personDAO.showPersonList();
		model.addAttribute("personList", list);
		return "home";
	}
	
	@RequestMapping(value = "/searchPerson", method = RequestMethod.POST)
	public String searchPerson(String name, Model model) {
		ArrayList<Person> personList = personDAO.searchPerson(name);
		model.addAttribute("searchList", personList);
		return "home";
	}
	
}
