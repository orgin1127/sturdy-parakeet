package com.sesoc.web5.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sesoc.web5.dao.ReplyDAO;
import com.sesoc.web5.vo.Reply;

@Controller
public class ReplyController {
	
	Logger logger = LoggerFactory.getLogger(ReplyController.class);
	
	@Autowired
	ReplyDAO reDAO;
	
	//리플 작성
	@RequestMapping(value="/board/replyWrite", method=RequestMethod.POST)
	public String replyWrite(Reply re, HttpSession session) {
		String custid = (String) session.getAttribute("CustomerID");
		logger.debug(custid);
		re.setCustid(custid);
		reDAO.replyWrite(re);
		return "redirect:viewBoardContent?boardnum="+re.getBoardnum();
	}
	
	//리플 개별삭제
	@RequestMapping(value="/board/deleteReply", method=RequestMethod.GET)
	public String deleteReply(String boardnum, String replynum) {
		try {
			int bnum = 0;
			int rnum = 0;
			bnum = Integer.parseInt(boardnum);
			rnum = Integer.parseInt(replynum);
			Reply re = new Reply(rnum, bnum);
			reDAO.deleteContentReply(re);
		}
		catch (Exception e) {
			return "redirect:viewBoardContent?boardnum="+boardnum;
		}
		return "redirect:viewBoardContent?boardnum="+boardnum;
	}
	
	//리플 수정
	@RequestMapping(value="/board/editReply")
	public String editReply(Reply re, HttpSession session) {
		String custid = (String) session.getAttribute("CustomerID");
		re.setCustid(custid);
		reDAO.editReply(re);
		return "redirect:viewBoardContent?boardnum="+re.getBoardnum();
	}
}
