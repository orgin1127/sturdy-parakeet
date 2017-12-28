package com.sesoc.web4.Controllers;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sesoc.web4.DAO.BbsDAO;
import com.sesoc.web4.vo.BbsVO;

@Controller
public class BbsController {
	
	Logger logger = LoggerFactory.getLogger(BbsController.class);
	
	@Autowired
	BbsDAO dao;
	
	
	@RequestMapping(value = "/goBbs", method = RequestMethod.GET)
	public String goBbs(Model model) {
		logger.debug("go to bbs");
		ArrayList<BbsVO> list = dao.showBBSList();
		if (!(list.isEmpty())) {
			model.addAttribute("list", list);
		}
		return "./JSP/bbs";
	}
	
	@RequestMapping(value = "goBBSForm", method = RequestMethod.GET)
	public String goBBSForm() {
		logger.debug("write Phase");
		return "./JSP/writeForm";
	}
	
	@RequestMapping(value = "writeBBS", method = RequestMethod.POST)
	public String writeBBS(BbsVO vo) {
		logger.debug("writeContent");
		dao.writeBBS(vo);
		return "redirect:./goBbs";
	}
	
	@RequestMapping(value = "deleteContent", method = RequestMethod.POST)
	public String deleteContent(BbsVO vo) {
		logger.debug("deleteContent");
		logger.debug(vo.toString());
		dao.deleteContent(vo);
		return "redirect:./goBbs";
	}
}
