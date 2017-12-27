package com.sesec.web3.Controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sesec.web3.DAO.PersonDAO;

@Controller
public class DeleteController {
	
	Logger logger = LoggerFactory.getLogger(DeleteController.class);
	
	@Autowired
	PersonDAO personDAO;
	
	
	@RequestMapping(value = "/deletePerson", method = RequestMethod.POST)
	public String deletePerson(String name) {
		personDAO.deletePerson(name);
		return "redirect: ./";
	}
}
